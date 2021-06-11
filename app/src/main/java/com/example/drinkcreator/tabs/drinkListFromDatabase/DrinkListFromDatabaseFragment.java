package com.example.drinkcreator.tabs.drinkListFromDatabase;

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
import com.example.drinkcreator.apiModels.ObjectModelWithListFromApi;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.tabs.WrapContentLinearLayoutManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DrinkListFromDatabaseFragment extends Fragment {


    private List<DrinkEntity> drinkEntityList;

    private RecyclerView.Adapter adapter;

    private Context context;

    public DrinkListFromDatabaseFragment() {
    }


    public DrinkListFromDatabaseFragment(Context context) {
        this.context = context;
    }
    public DrinkListFromDatabaseFragment(Context context, List<DrinkEntity> drinkEntityList) {
        this.context = context;
        this.drinkEntityList = drinkEntityList;
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

        View rootView = inflater.inflate(R.layout.fragment_drinks_from_database, container, false);

        if (drinkEntityList != null) {
            RecyclerView recyclerView = rootView.findViewById(R.id.drink_list_from_database_recycler_view);
            Context context = getContext();
            if (context != null) {
                recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(context));
            } else {
                return null;
            }
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(true);
            adapter = new DrinkListFromDatabaseAdapter(drinkEntityList, context);
            recyclerView.setAdapter(adapter);
        }
        buttonsListeners(rootView);

        return rootView;
    }

    private void buttonsListeners(View rootView) {

    }



}