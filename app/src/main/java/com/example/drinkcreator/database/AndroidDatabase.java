//package com.example.drinkcreator.database;
//
//import android.content.Context;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//@androidx.room.Database(entities = {}, version = 1, exportSchema = false)
//public abstract class AndroidDatabase extends RoomDatabase {
//
////    public abstract CurrencyEntityDAO currencyEntityDAO();
//
//    private static volatile AndroidDatabase INSTANCE;
//
//    public static AndroidDatabase getAndroidDatabase(final Context context) {
//        if(INSTANCE == null){
//            synchronized (AndroidDatabase.class){
//                if (INSTANCE == null){
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            AndroidDatabase.class, "android_database")
//                            .fallbackToDestructiveMigration() // !! nieprawidłowe rozwiązanie
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//
//
//}