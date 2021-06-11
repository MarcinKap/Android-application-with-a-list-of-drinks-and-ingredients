package com.example.drinkcreator.tabs.drinkCreator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class DrinkCreatorFragment extends Fragment {


    private Context context;

    private int counter;

    private EditText drinkName, drinkCategory, drinkAlcoholic, drinkInstruction;


    private EditText drinkIngredient1, drinkIngredient2, drinkIngredient3, drinkIngredient4, drinkIngredient5,
            drinkIngredient6, drinkIngredient7, drinkIngredient8, drinkIngredient9, drinkIngredient10,
            drinkIngredient11, drinkIngredient12, drinkIngredient13, drinkIngredient14, drinkIngredient15;
    private EditText drinkMeasure1, drinkMeasure2, drinkMeasure3, drinkMeasure4, drinkMeasure5,
            drinkMeasure6, drinkMeasure7, drinkMeasure8, drinkMeasure9, drinkMeasure10,
            drinkMeasure11, drinkMeasure12, drinkMeasure13, drinkMeasure14, drinkMeasure15;
    private TextView ingredients;

    private List<EditText> drinkIngredientList;
    private List<EditText> drinkMeasureList;
    View rootView;

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
        rootView = inflater.inflate(R.layout.fragment_creator_drink, container, false);

        textViewDeclarations();


        buttonsListeners(rootView);


        return rootView;
    }

    private void textViewDeclarations() {
        drinkName = rootView.findViewById(R.id.editText_name);
        drinkCategory = rootView.findViewById(R.id.editText_category);
        drinkAlcoholic = rootView.findViewById(R.id.editText_alcoholic);
        drinkInstruction = rootView.findViewById(R.id.editText_instruction);
        ingredients = rootView.findViewById(R.id.ingredients);
        drinkIngredient1 = rootView.findViewById(R.id.editTextIngredient1);
        drinkIngredient2 = rootView.findViewById(R.id.editTextIngredient2);
        drinkIngredient3 = rootView.findViewById(R.id.editTextIngredient3);
        drinkIngredient4 = rootView.findViewById(R.id.editTextIngredient4);
        drinkIngredient5 = rootView.findViewById(R.id.editTextIngredient5);
        drinkIngredient6 = rootView.findViewById(R.id.editTextIngredient6);
        drinkIngredient7 = rootView.findViewById(R.id.editTextIngredient7);
        drinkIngredient8 = rootView.findViewById(R.id.editTextIngredient8);
        drinkIngredient9 = rootView.findViewById(R.id.editTextIngredient9);
        drinkIngredient10 = rootView.findViewById(R.id.editTextIngredient10);
        drinkIngredient11 = rootView.findViewById(R.id.editTextIngredient11);
        drinkIngredient12 = rootView.findViewById(R.id.editTextIngredient12);
        drinkIngredient13 = rootView.findViewById(R.id.editTextIngredient13);
        drinkIngredient14 = rootView.findViewById(R.id.editTextIngredient14);
        drinkIngredient15 = rootView.findViewById(R.id.editTextIngredient15);
        drinkMeasure1 = rootView.findViewById(R.id.editTextMeasure1);
        drinkMeasure2 = rootView.findViewById(R.id.editTextMeasure2);
        drinkMeasure3 = rootView.findViewById(R.id.editTextMeasure3);
        drinkMeasure4 = rootView.findViewById(R.id.editTextMeasure4);
        drinkMeasure5 = rootView.findViewById(R.id.editTextMeasure5);
        drinkMeasure6 = rootView.findViewById(R.id.editTextMeasure6);
        drinkMeasure7 = rootView.findViewById(R.id.editTextMeasure7);
        drinkMeasure8 = rootView.findViewById(R.id.editTextMeasure8);
        drinkMeasure9 = rootView.findViewById(R.id.editTextMeasure9);
        drinkMeasure10 = rootView.findViewById(R.id.editTextMeasure10);
        drinkMeasure11 = rootView.findViewById(R.id.editTextMeasure11);
        drinkMeasure12 = rootView.findViewById(R.id.editTextMeasure12);
        drinkMeasure13 = rootView.findViewById(R.id.editTextMeasure13);
        drinkMeasure14 = rootView.findViewById(R.id.editTextMeasure14);
        drinkMeasure15 = rootView.findViewById(R.id.editTextMeasure15);

        drinkIngredientList = new ArrayList<>();
        drinkIngredientList.add(drinkIngredient1);
        drinkIngredientList.add(drinkIngredient2);
        drinkIngredientList.add(drinkIngredient3);
        drinkIngredientList.add(drinkIngredient4);
        drinkIngredientList.add(drinkIngredient5);
        drinkIngredientList.add(drinkIngredient6);
        drinkIngredientList.add(drinkIngredient7);
        drinkIngredientList.add(drinkIngredient8);
        drinkIngredientList.add(drinkIngredient9);
        drinkIngredientList.add(drinkIngredient10);
        drinkIngredientList.add(drinkIngredient11);
        drinkIngredientList.add(drinkIngredient12);
        drinkIngredientList.add(drinkIngredient13);
        drinkIngredientList.add(drinkIngredient14);
        drinkIngredientList.add(drinkIngredient15);

        drinkMeasureList = new ArrayList<>();
        drinkMeasureList.add(drinkMeasure1);
        drinkMeasureList.add(drinkMeasure2);
        drinkMeasureList.add(drinkMeasure3);
        drinkMeasureList.add(drinkMeasure4);
        drinkMeasureList.add(drinkMeasure5);
        drinkMeasureList.add(drinkMeasure6);
        drinkMeasureList.add(drinkMeasure7);
        drinkMeasureList.add(drinkMeasure8);
        drinkMeasureList.add(drinkMeasure9);
        drinkMeasureList.add(drinkMeasure10);
        drinkMeasureList.add(drinkMeasure11);
        drinkMeasureList.add(drinkMeasure12);
        drinkMeasureList.add(drinkMeasure13);
        drinkMeasureList.add(drinkMeasure14);
        drinkMeasureList.add(drinkMeasure15);

        drinkMeasureList.get(0).setHint("Ilość " + 1);
        drinkIngredientList.get(0).setHint("Składnik " + 1);
        for (int i = 1; i < drinkMeasureList.size(); i++) {
            int number = i+1;
            drinkMeasureList.get(i).setVisibility(View.GONE);
            drinkIngredientList.get(i).setVisibility(View.GONE);
            drinkIngredientList.get(i).setHint("Składnik " + number);
            drinkMeasureList.get(i).setHint("Ilość " + number);

        }

        counter = 1;
    }

    private DrinkEntity getDrinkEntityFromForm() {
        DrinkEntity drinkEntity = new DrinkEntity(
                drinkName.getText().toString(),
                drinkCategory.getText().toString(),
                drinkAlcoholic.getText().toString(),
                drinkInstruction.getText().toString(),
                drinkIngredient1.getText().toString(),
                drinkIngredient2.getText().toString(),
                drinkIngredient3.getText().toString(),
                drinkIngredient4.getText().toString(),
                drinkIngredient5.getText().toString(),
                drinkIngredient6.getText().toString(),
                drinkIngredient7.getText().toString(),
                drinkIngredient8.getText().toString(),
                drinkIngredient9.getText().toString(),
                drinkIngredient10.getText().toString(),
                drinkIngredient11.getText().toString(),
                drinkIngredient12.getText().toString(),
                drinkIngredient13.getText().toString(),
                drinkIngredient14.getText().toString(),
                drinkIngredient15.getText().toString(),
                drinkMeasure1.getText().toString(),
                drinkMeasure2.getText().toString(),
                drinkMeasure3.getText().toString(),
                drinkMeasure4.getText().toString(),
                drinkMeasure5.getText().toString(),
                drinkMeasure6.getText().toString(),
                drinkMeasure7.getText().toString(),
                drinkMeasure8.getText().toString(),
                drinkMeasure9.getText().toString(),
                drinkMeasure10.getText().toString(),
                drinkMeasure11.getText().toString(),
                drinkMeasure12.getText().toString(),
                drinkMeasure13.getText().toString(),
                drinkMeasure14.getText().toString(),
                drinkMeasure15.getText().toString()
        );

        return drinkEntity;
    }
    private void setClearForm() {
        drinkName.setText("");
        drinkCategory.setText("");
        drinkAlcoholic.setText("");
        drinkInstruction.setText("");
        drinkIngredient1.setText("");
        drinkIngredient2.setText("");
        drinkIngredient3.setText("");
        drinkIngredient4.setText("");
        drinkIngredient5.setText("");
        drinkIngredient6.setText("");
        drinkIngredient7.setText("");
        drinkIngredient8.setText("");
        drinkIngredient9.setText("");
        drinkIngredient10.setText("");
        drinkIngredient11.setText("");
        drinkIngredient12.setText("");
        drinkIngredient13.setText("");
        drinkIngredient14.setText("");
        drinkIngredient15.setText("");
        drinkMeasure1.setText("");
        drinkMeasure2.setText("");
        drinkMeasure3.setText("");
        drinkMeasure4.setText("");
        drinkMeasure5.setText("");
        drinkMeasure6.setText("");
        drinkMeasure7.setText("");
        drinkMeasure8.setText("");
        drinkMeasure9.setText("");
        drinkMeasure10.setText("");
        drinkMeasure11.setText("");
        drinkMeasure12.setText("");
        drinkMeasure13.setText("");
        drinkMeasure14.setText("");
        drinkMeasure15.setText("");
            }

    private void buttonsListeners(View rootView) {
        Button addNewCoctail = rootView.findViewById(R.id.add_new_coctail);
        addNewCoctail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrinkEntity drinkEntity = getDrinkEntityFromForm();

                AndroidDatabase androidDatabase = AndroidDatabase.getAndroidDatabase(context);
                androidDatabase.getQueryExecutor().execute(() -> {
                    androidDatabase.drinkEntityDAO().insert(drinkEntity);

                    //nie działa
//                    setClearForm();
                });


            }
        });

        Button addNewIngredient = rootView.findViewById(R.id.nextIngredient);
        addNewIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 15) {
                    drinkMeasureList.get(counter).setVisibility(View.VISIBLE);
                    drinkIngredientList.get(counter).setVisibility(View.VISIBLE);
                    counter++;
                }
            }
        });


    }


}