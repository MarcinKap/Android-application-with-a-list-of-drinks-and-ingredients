package com.example.drinkcreator.database.service;


import android.content.Context;

import androidx.fragment.app.FragmentActivity;

import com.example.drinkcreator.apiModels.DrinkModelFromApi;
import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.mapper.CoctailsMapper;

import java.util.ArrayList;
import java.util.List;

public class DrinkService {
    Context context;
    FragmentActivity fragmentActivity;


    AndroidDatabase androidDatabase;


    public DrinkService(AndroidDatabase androidDatabase) {
        this.androidDatabase = androidDatabase;
    }

    public DrinkService(Context context, FragmentActivity fragmentActivity, AndroidDatabase androidDatabase) {
        this.context = context;
        this.fragmentActivity = fragmentActivity;
        this.androidDatabase = androidDatabase;
    }

    public void saveDrinkEntity(DrinkModelFromApi drinkModelFromApi) {
        DrinkEntity drinkEntity = CoctailsMapper.mapToEntity(drinkModelFromApi);

        androidDatabase.getQueryExecutor().execute(() -> {
            androidDatabase.drinkEntityDAO().insert(drinkEntity);
        });
    }

    public List<DrinkEntity> getDrinkEntity(DrinkModelFromApi drinkModelFromApi) {
        String strDrink = drinkModelFromApi.getStrDrink();
        List<DrinkEntity> drinkEntityList = new ArrayList<>();

        androidDatabase.getQueryExecutor().execute(() -> {
            DrinkEntity drinkEntity2 = androidDatabase.drinkEntityDAO().getEntityByExternalId(strDrink);
            if (drinkEntity2!=null){
                drinkEntityList.add(drinkEntity2);
                System.out.println("Znalezniono drink:" + drinkEntity2.getStrDrink());
            }

        });

        return drinkEntityList;
    }

    public void deleteDrinkEntity(DrinkEntity drinkEntity){
        androidDatabase.getQueryExecutor().execute(() -> {
            androidDatabase.drinkEntityDAO().delete(drinkEntity);
        });
    }


}
