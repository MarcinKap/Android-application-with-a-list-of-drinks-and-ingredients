package com.example.drinkcreator.database.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.drinkcreator.database.entity.DrinkEntity;

import java.util.List;

@Dao
public interface DrinkEntityDAO {

    @Query("SELECT * FROM Coctails")
    List<DrinkEntity> getAll();

    @Insert
    void insert(DrinkEntity... drinkEntities);

    @Update
    public void update(DrinkEntity... drinkEntities);

    @Delete
    public void delete(DrinkEntity drinkEntity);

    @Query("SELECT * FROM Coctails where strDrink= :strDrink")
    DrinkEntity getEntityByExternalId(String strDrink);

}
