package com.example.drinkcreator.tabs.drinkCreator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkcreator.R;
import com.example.drinkcreator.api.ApiUtils;
import com.example.drinkcreator.apiModels.DrinkModelFromApi;
import com.example.drinkcreator.apiModels.ObjectModelWithListFromApi;
import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.tabs.WrapContentLinearLayoutManager;
import com.example.drinkcreator.tabs.drinkListFromApi.DrinkListFromApiAdapter;
import com.example.drinkcreator.tabs.drinkListFromApi.DrinkListFromApiFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DrinkCreatorFragment  extends Fragment {


    private List<DrinkModelFromApi> drinkModelFromApiList;
    private List<String> drinkSavedId;

    private RecyclerView.Adapter adapter;

    private Context context;

    public DrinkCreatorFragment() {
    }


    public DrinkCreatorFragment(Context context) {
        this.context = context;
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return null;
        }

        //API

        //
        View rootView = inflater.inflate(R.layout.fragment_find_drinks, container, false);

        if (drinkModelFromApiList != null) {
            RecyclerView recyclerView = rootView.findViewById(R.id.drink_list_recycler_view);
            Context context = getContext();
            if (context != null) {
                recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(context));
            } else {
                return null;
            }
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(true);
            adapter = new DrinkListFromApiAdapter(drinkModelFromApiList, context, drinkSavedId);
            recyclerView.setAdapter(adapter);
        }
        buttonsListeners(rootView);

        return rootView;
    }

    private void buttonsListeners(View rootView) {

        Button findDrinksListBySingleChar = rootView.findViewById(R.id.button_find_drinks_by_char);
        findDrinksListBySingleChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView inputSingleChar = rootView.findViewById(R.id.edit_text_input_char);

                String nameOfDrinks = inputSingleChar.getText().toString();

                ApiUtils.getApiService().getDrinkListFromApiBySingleChar(nameOfDrinks)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableObserver<Response<ObjectModelWithListFromApi>>() {
                            @Override
                            public void onNext(@NonNull Response<ObjectModelWithListFromApi> response) {
                                drinkModelFromApiList = response.body().getDrinks();

                                List<String> drinkEntityList = new ArrayList<>();
                                for (DrinkModelFromApi drinkModelFromApi: drinkModelFromApiList
                                ) {
                                    String strDrink = drinkModelFromApi.getStrDrink();
                                    AndroidDatabase androidDatabase = AndroidDatabase.getAndroidDatabase(context);
                                    androidDatabase.getQueryExecutor().execute(() -> {
                                        DrinkEntity drinkEntity2 = androidDatabase.drinkEntityDAO().getEntityByExternalId(strDrink);
                                        if (drinkEntity2!=null){
                                            drinkEntityList.add(drinkEntity2.getStrDrink());
                                            System.out.println("Znalezniono drink:" + drinkEntity2.getStrDrink());
                                        }
                                    });
                                }
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container_fragment, new DrinkListFromApiFragment(context, drinkModelFromApiList, drinkEntityList))
                                        .commit();


                            }
                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.e("API_CALL", e.getMessage(), e);
                            }
                            @Override
                            public void onComplete() {
                            }
                        });


            }
        });


    }



}