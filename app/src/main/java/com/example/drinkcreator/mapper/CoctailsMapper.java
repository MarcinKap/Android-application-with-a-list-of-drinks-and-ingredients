package com.example.drinkcreator.mapper;


import com.example.drinkcreator.apiModels.DrinkModelFromApi;
import com.example.drinkcreator.database.entity.DrinkEntity;

public class CoctailsMapper {

    public static DrinkEntity mapToEntity(DrinkModelFromApi from) {
        if(from == null){
            return null;
        }
        DrinkEntity drinkEntity = new DrinkEntity(from.getIdDrink(),
                from.getStrDrink(),
                from.getStrCategory(),
                from.getStrAlcoholic(),
                from.getStrInstructions(),
                from.getStrIngredient1(),
                from.getStrIngredient2(),
                from.getStrIngredient3(),
                from.getStrIngredient4(),
                from.getStrIngredient5(),
                from.getStrIngredient6(),
                from.getStrIngredient7(),
                from.getStrIngredient8(),
                from.getStrIngredient9(),
                from.getStrIngredient10(),
                from.getStrIngredient11(),
                from.getStrIngredient12(),
                from.getStrIngredient13(),
                from.getStrIngredient14(),
                from.getStrIngredient15(),
                from.getStrMeasure1(),
                from.getStrMeasure2(),
                from.getStrMeasure3(),
                from.getStrMeasure4(),
                from.getStrMeasure5(),
                from.getStrMeasure6(),
                from.getStrMeasure7(),
                from.getStrMeasure8(),
                from.getStrMeasure9(),
                from.getStrMeasure10(),
                from.getStrMeasure11(),
                from.getStrMeasure12(),
                from.getStrMeasure13(),
                from.getStrMeasure14(),
                from.getStrMeasure15()
                );

        return drinkEntity;
    }

    public static DrinkModelFromApi mapFromEntity(DrinkEntity to) {
        if(to == null){
            return null;
        }
        DrinkModelFromApi drinkModelFromApi = new DrinkModelFromApi(to.getIdDrink(),
                to.getStrDrink(),
                to.getStrCategory(),
                to.getStrAlcoholic(),
                to.getStrInstructions(),
                to.getStrIngredient1(),
                to.getStrIngredient2(),
                to.getStrIngredient3(),
                to.getStrIngredient4(),
                to.getStrIngredient5(),
                to.getStrIngredient6(),
                to.getStrIngredient7(),
                to.getStrIngredient8(),
                to.getStrIngredient9(),
                to.getStrIngredient10(),
                to.getStrIngredient11(),
                to.getStrIngredient12(),
                to.getStrIngredient13(),
                to.getStrIngredient14(),
                to.getStrIngredient15(),
                to.getStrMeasure1(),
                to.getStrMeasure2(),
                to.getStrMeasure3(),
                to.getStrMeasure4(),
                to.getStrMeasure5(),
                to.getStrMeasure6(),
                to.getStrMeasure7(),
                to.getStrMeasure8(),
                to.getStrMeasure9(),
                to.getStrMeasure10(),
                to.getStrMeasure11(),
                to.getStrMeasure12(),
                to.getStrMeasure13(),
                to.getStrMeasure14(),
                to.getStrMeasure15() );


        return drinkModelFromApi;

    }
}
