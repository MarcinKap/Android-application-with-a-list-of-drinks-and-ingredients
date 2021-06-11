package com.example.drinkcreator.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.database.repository.DrinkEntityDAO;

@androidx.room.Database(entities = {DrinkEntity.class}, version = 1, exportSchema = false)
public abstract class AndroidDatabase extends RoomDatabase {

    public abstract DrinkEntityDAO drinkEntityDAO();

    private static volatile AndroidDatabase INSTANCE;

    public static AndroidDatabase getAndroidDatabase(final Context context) {
        if(INSTANCE == null){
            synchronized (AndroidDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AndroidDatabase.class, "android_database")
                            .fallbackToDestructiveMigration() // !! nieprawidłowe rozwiązanie
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}