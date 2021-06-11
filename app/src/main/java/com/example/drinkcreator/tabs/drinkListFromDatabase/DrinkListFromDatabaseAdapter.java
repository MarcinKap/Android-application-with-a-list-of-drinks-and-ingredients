package com.example.drinkcreator.tabs.drinkListFromDatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkcreator.R;
import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.database.service.DrinkService;
import com.example.drinkcreator.tabs.drinkListFromApi.DrinkListFromApiFragment;

import java.util.List;

public class DrinkListFromDatabaseAdapter extends RecyclerView.Adapter<DrinkListFromDatabaseAdapter.DrinkModelViewHolder> {


    private List<DrinkEntity> drinkEntityList;
    private Context context;
    private RecyclerView.ViewHolder holder;
    private int position;

    public DrinkListFromDatabaseAdapter() {
    }

    public DrinkListFromDatabaseAdapter(List<DrinkEntity> drinkEntityList, Context context) {
        this.drinkEntityList = drinkEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_drink_from_database, parent, false);

        return new DrinkModelViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DrinkModelViewHolder holder, int position) {
        DrinkEntity drinkEntity = drinkEntityList.get(position);
        if (drinkEntity == null) {
            return;
        }
        holder.bind(holder.itemView.getContext(), drinkEntity);
    }


    @Override
    public int getItemCount() {
        return drinkEntityList.size();
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
        private Button deleteDrinkFromDatabaseButton;


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

            deleteDrinkFromDatabaseButton = itemView.findViewById(R.id.delete_coctail_button);

        }

        void bind(Context context, final DrinkEntity drinkEntity) {
            drinkName.setText(drinkEntity.getStrDrink());
            drinkCategory.setText("Kategoria: " + drinkEntity.getStrCategory());
            drinkAlcoholic.setText("Alkoholowy: " + drinkEntity.getStrAlcoholic());
            drinkInstruction.setText("Instrukcja: " + drinkEntity.getStrInstructions());

            drinkIngredient1.setText(drinkEntity.getStrIngredient1() + ": " + drinkEntity.getStrMeasure1());
            drinkIngredient2.setText(drinkEntity.getStrIngredient2() + ": " + drinkEntity.getStrMeasure2());
            drinkIngredient3.setText(drinkEntity.getStrIngredient3() + ": " + drinkEntity.getStrMeasure3());
            drinkIngredient4.setText(drinkEntity.getStrIngredient4() + ": " + drinkEntity.getStrMeasure4());
            drinkIngredient5.setText(drinkEntity.getStrIngredient5() + ": " + drinkEntity.getStrMeasure5());
            drinkIngredient6.setText(drinkEntity.getStrIngredient6() + ": " + drinkEntity.getStrMeasure6());
            drinkIngredient7.setText(drinkEntity.getStrIngredient7() + ": " + drinkEntity.getStrMeasure7());
            drinkIngredient8.setText(drinkEntity.getStrIngredient8() + ": " + drinkEntity.getStrMeasure8());
            drinkIngredient9.setText(drinkEntity.getStrIngredient9() + ": " + drinkEntity.getStrMeasure9());
            drinkIngredient10.setText(drinkEntity.getStrIngredient10() + ": " + drinkEntity.getStrMeasure10());
            drinkIngredient11.setText(drinkEntity.getStrIngredient11() + ": " + drinkEntity.getStrMeasure11());
            drinkIngredient12.setText(drinkEntity.getStrIngredient12() + ": " + drinkEntity.getStrMeasure12());
            drinkIngredient13.setText(drinkEntity.getStrIngredient13() + ": " + drinkEntity.getStrMeasure13());
            drinkIngredient14.setText(drinkEntity.getStrIngredient14() + ": " + drinkEntity.getStrMeasure14());
            drinkIngredient15.setText(drinkEntity.getStrIngredient15() + ": " + drinkEntity.getStrMeasure15());
            drinkService = new DrinkService(AndroidDatabase.getAndroidDatabase(context));

            hideDetails();

            singleDrinkFrame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (drinkIngredient1.getVisibility() == View.VISIBLE) {
                        hideDetails();
                    } else {
                        showDetails();
                    }
                    checkIsNull(drinkEntity);
                }
            });

            deleteDrinkFromDatabaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drinkService.deleteDrinkEntity(drinkEntity);
                    deleteDrinkFromDatabaseButton.setVisibility(View.GONE);

                    ((AppCompatActivity) context).recreate();

                }
            });


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

        void checkIsNull(DrinkEntity drinkEntity) {
            if (drinkEntity.getStrIngredient1() == null) {
                drinkIngredient1.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient2() == null) {
                drinkIngredient2.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient3() == null) {
                drinkIngredient3.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient4() == null) {
                drinkIngredient4.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient5() == null) {
                drinkIngredient5.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient6() == null) {
                drinkIngredient6.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient7() == null) {
                drinkIngredient7.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient8() == null) {
                drinkIngredient8.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient9() == null) {
                drinkIngredient9.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient10() == null) {
                drinkIngredient10.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient11() == null) {
                drinkIngredient11.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient12() == null) {
                drinkIngredient12.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient13() == null) {
                drinkIngredient13.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient14() == null) {
                drinkIngredient14.setVisibility(View.GONE);
            }
            if (drinkEntity.getStrIngredient15() == null) {
                drinkIngredient15.setVisibility(View.GONE);
            }

        }


    }


}