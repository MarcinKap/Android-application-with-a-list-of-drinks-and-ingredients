package com.example.drinkcreator.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingredients")
public class IngredientEntity {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String name;

}
