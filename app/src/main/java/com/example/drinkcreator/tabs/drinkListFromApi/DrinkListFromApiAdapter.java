package com.example.drinkcreator.tabs.drinkListFromApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkcreator.R;
import com.example.drinkcreator.apiModels.DrinkModelFromApi;
import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.database.service.DrinkService;

import java.util.List;

public class DrinkListFromApiAdapter extends RecyclerView.Adapter<DrinkListFromApiAdapter.DrinkModelViewHolder> {


    private List<DrinkModelFromApi> drinkModelFromApiList;
    private List<String> drinkSavedId;
    private Context context;
    private RecyclerView.ViewHolder holder;
    private int position;

    public DrinkListFromApiAdapter() {
    }

    public DrinkListFromApiAdapter(List<DrinkModelFromApi> drinkModelFromApiList, Context context) {
        this.drinkModelFromApiList = drinkModelFromApiList;
        this.context = context;
    }

    public DrinkListFromApiAdapter(List<DrinkModelFromApi> drinkModelFromApiList, Context context, List<String> drinkSavedId) {
        this.drinkModelFromApiList = drinkModelFromApiList;
        this.context = context;
        this.drinkSavedId = drinkSavedId;
    }

    @NonNull
    @Override
    public DrinkListFromApiAdapter.DrinkModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_drink_from_api, parent, false);

        return new DrinkListFromApiAdapter.DrinkModelViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DrinkListFromApiAdapter.DrinkModelViewHolder holder, int position) {
        DrinkModelFromApi drinkModelFromApi = drinkModelFromApiList.get(position);
        if (drinkModelFromApi == null) {
            return;
        }
        holder.bind(holder.itemView.getContext(), drinkModelFromApi);
    }


    @Override
    public int getItemCount() {
        return drinkModelFromApiList.size();
    }

    class DrinkModelViewHolder extends RecyclerView.ViewHolder {
        DrinkService drinkService;

        private TextView drinkName, drinkCategory, drinkAlcoholic, drinkInstruction;
        //        private List<TextView> drinkIngredientList;
        private TextView drinkIngredient1, drinkIngredient2, drinkIngredient3, drinkIngredient4, drinkIngredient5,
                drinkIngredient6, drinkIngredient7, drinkIngredient8, drinkIngredient9, drinkIngredient10,
                drinkIngredient11, drinkIngredient12, drinkIngredient13, drinkIngredient14, drinkIngredient15;
        private TextView ingredients;

        private ConstraintLayout singleDrinkFrame;
        private Button addDrinkToDatabaseButton;


        public DrinkModelViewHolder(@NonNull View itemView) {
            super(itemView);


            drinkName = itemView.findViewById(R.id.drink_name);
            drinkCategory = itemView.findViewById(R.id.drink_category);
            drinkAlcoholic = itemView.findViewById(R.id.drink_alcoholic);
            drinkInstruction = itemView.findViewById(R.id.drink_instruction);
            ingredients = itemView.findViewById(R.id.ingredients);

            drinkIngredient1 = itemView.findViewById(R.id.drink_ingredient_1);
            drinkIngredient2 = itemView.findViewById(R.id.drink_ingredient_2);
            drinkIngredient3 = itemView.findViewById(R.id.drink_ingredient_3);
            drinkIngredient4 = itemView.findViewById(R.id.drink_ingredient_4);
            drinkIngredient5 = itemView.findViewById(R.id.drink_ingredient_5);
            drinkIngredient6 = itemView.findViewById(R.id.drink_ingredient_6);
            drinkIngredient7 = itemView.findViewById(R.id.drink_ingredient_7);
            drinkIngredient8 = itemView.findViewById(R.id.drink_ingredient_8);
            drinkIngredient9 = itemView.findViewById(R.id.drink_ingredient_9);
            drinkIngredient10 = itemView.findViewById(R.id.drink_ingredient_10);
            drinkIngredient11 = itemView.findViewById(R.id.drink_ingredient_11);
            drinkIngredient12 = itemView.findViewById(R.id.drink_ingredient_12);
            drinkIngredient13 = itemView.findViewById(R.id.drink_ingredient_13);
            drinkIngredient14 = itemView.findViewById(R.id.drink_ingredient_14);
            drinkIngredient15 = itemView.findViewById(R.id.drink_ingredient_15);

            singleDrinkFrame = itemView.findViewById(R.id.single_drink_frame);

            addDrinkToDatabaseButton = itemView.findViewById(R.id.add_coctail_button);

        }

        void bind(Context context, final DrinkModelFromApi drinkModelFromApi) {
            drinkName.setText(drinkModelFromApi.getStrDrink());
            drinkCategory.setText("Kategoria: " + drinkModelFromApi.getStrCategory());
            drinkAlcoholic.setText("Alkoholowy: " + drinkModelFromApi.getStrAlcoholic());
            drinkInstruction.setText("Instrukcja: " + drinkModelFromApi.getStrInstructions());

            drinkIngredient1.setText(drinkModelFromApi.getStrIngredient1() + ": " + drinkModelFromApi.getStrMeasure1());
            drinkIngredient2.setText(drinkModelFromApi.getStrIngredient2() + ": " + drinkModelFromApi.getStrMeasure2());
            drinkIngredient3.setText(drinkModelFromApi.getStrIngredient3() + ": " + drinkModelFromApi.getStrMeasure3());
            drinkIngredient4.setText(drinkModelFromApi.getStrIngredient4() + ": " + drinkModelFromApi.getStrMeasure4());
            drinkIngredient5.setText(drinkModelFromApi.getStrIngredient5() + ": " + drinkModelFromApi.getStrMeasure5());
            drinkIngredient6.setText(drinkModelFromApi.getStrIngredient6() + ": " + drinkModelFromApi.getStrMeasure6());
            drinkIngredient7.setText(drinkModelFromApi.getStrIngredient7() + ": " + drinkModelFromApi.getStrMeasure7());
            drinkIngredient8.setText(drinkModelFromApi.getStrIngredient8() + ": " + drinkModelFromApi.getStrMeasure8());
            drinkIngredient9.setText(drinkModelFromApi.getStrIngredient9() + ": " + drinkModelFromApi.getStrMeasure9());
            drinkIngredient10.setText(drinkModelFromApi.getStrIngredient10() + ": " + drinkModelFromApi.getStrMeasure10());
            drinkIngredient11.setText(drinkModelFromApi.getStrIngredient11() + ": " + drinkModelFromApi.getStrMeasure11());
            drinkIngredient12.setText(drinkModelFromApi.getStrIngredient12() + ": " + drinkModelFromApi.getStrMeasure12());
            drinkIngredient13.setText(drinkModelFromApi.getStrIngredient13() + ": " + drinkModelFromApi.getStrMeasure13());
            drinkIngredient14.setText(drinkModelFromApi.getStrIngredient14() + ": " + drinkModelFromApi.getStrMeasure14());
            drinkIngredient15.setText(drinkModelFromApi.getStrIngredient15() + ": " + drinkModelFromApi.getStrMeasure15());
            drinkService = new DrinkService(AndroidDatabase.getAndroidDatabase(context));

            addDrinkToDatabaseButton.setVisibility(View.VISIBLE);
            hideDetails();
            checkIsModelInDatabase(drinkModelFromApi);

            singleDrinkFrame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (drinkIngredient1.getVisibility() == View.VISIBLE) {
                        hideDetails();
                    } else {
                        showDetails();
                    }
                    checkIsNull(drinkModelFromApi);
                }
            });

            addDrinkToDatabaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drinkService.saveDrinkEntity(drinkModelFromApi);
                    addDrinkToDatabaseButton.setVisibility(View.GONE);
                }
            });
        }

        void checkIsModelInDatabase(DrinkModelFromApi drinkModelFromApi){
            for (String id: drinkSavedId
                 ) {
                if (drinkModelFromApi.getStrDrink().equals(id)){
                    System.out.println("checkismodelindatbase: " + id);
                    addDrinkToDatabaseButton.setVisibility(View.GONE);
                }

            }
        }


        void showDetails() {
            drinkCategory.setVisibility(View.VISIBLE);
            drinkInstruction.setVisibility(View.VISIBLE);
            drinkAlcoholic.setVisibility(View.VISIBLE);
            ingredients.setVisibility(View.VISIBLE);
            drinkIngredient1.setVisibility(View.VISIBLE);
            drinkIngredient2.setVisibility(View.VISIBLE);
            drinkIngredient3.setVisibility(View.VISIBLE);
            drinkIngredient4.setVisibility(View.VISIBLE);
            drinkIngredient5.setVisibility(View.VISIBLE);
            drinkIngredient6.setVisibility(View.VISIBLE);
            drinkIngredient7.setVisibility(View.VISIBLE);
            drinkIngredient8.setVisibility(View.VISIBLE);
            drinkIngredient9.setVisibility(View.VISIBLE);
            drinkIngredient10.setVisibility(View.VISIBLE);
            drinkIngredient11.setVisibility(View.VISIBLE);
            drinkIngredient12.setVisibility(View.VISIBLE);
            drinkIngredient13.setVisibility(View.VISIBLE);
            drinkIngredient14.setVisibility(View.VISIBLE);
            drinkIngredient15.setVisibility(View.VISIBLE);
        }
        void hideDetails() {
            drinkCategory.setVisibility(View.GONE);
            drinkInstruction.setVisibility(View.GONE);
            drinkAlcoholic.setVisibility(View.GONE);
            ingredients.setVisibility(View.GONE);

            drinkIngredient1.setVisibility(View.GONE);
            drinkIngredient2.setVisibility(View.GONE);
            drinkIngredient3.setVisibility(View.GONE);
            drinkIngredient4.setVisibility(View.GONE);
            drinkIngredient5.setVisibility(View.GONE);
            drinkIngredient6.setVisibility(View.GONE);
            drinkIngredient7.setVisibility(View.GONE);
            drinkIngredient8.setVisibility(View.GONE);
            drinkIngredient9.setVisibility(View.GONE);
            drinkIngredient10.setVisibility(View.GONE);
            drinkIngredient11.setVisibility(View.GONE);
            drinkIngredient12.setVisibility(View.GONE);
            drinkIngredient13.setVisibility(View.GONE);
            drinkIngredient14.setVisibility(View.GONE);
            drinkIngredient15.setVisibility(View.GONE);
        }

        void checkIsNull(DrinkModelFromApi drinkModelFromApi) {
            if (drinkModelFromApi.getStrIngredient1() == null) {
                drinkIngredient1.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient2() == null) {
                drinkIngredient2.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient3() == null) {
                drinkIngredient3.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient4() == null) {
                drinkIngredient4.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient5() == null) {
                drinkIngredient5.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient6() == null) {
                drinkIngredient6.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient7() == null) {
                drinkIngredient7.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient8() == null) {
                drinkIngredient8.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient9() == null) {
                drinkIngredient9.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient10() == null) {
                drinkIngredient10.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient11() == null) {
                drinkIngredient11.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient12() == null) {
                drinkIngredient12.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient13() == null) {
                drinkIngredient13.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient14() == null) {
                drinkIngredient14.setVisibility(View.GONE);
            }
            if (drinkModelFromApi.getStrIngredient15() == null) {
                drinkIngredient15.setVisibility(View.GONE);
            }

        }


    }


}