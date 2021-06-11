package com.example.drinkcreator;

import android.os.Bundle;

//import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.AndroidDatabase;
import com.example.drinkcreator.database.entity.DrinkEntity;
import com.example.drinkcreator.tabs.drinkCreator.DrinkCreatorFragment;
import com.example.drinkcreator.tabs.drinkListFromApi.DrinkListFromApiFragment;
import com.example.drinkcreator.tabs.drinkListFromDatabase.DrinkListFromDatabaseFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView pageTitle;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String pressedButton;
    private AndroidDatabase androidDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        pressedButton = "homePage";

        androidDatabase = AndroidDatabase.getAndroidDatabase(getApplicationContext());

        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        pageTitle = findViewById(R.id.toolbar_selected_item_menu_drawer_txt);


        initNavigationDrawer();
        viewManagement(savedInstanceState);
        buttonsListeners();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("pressedButton", pressedButton);
        super.onSaveInstanceState(outState);
    }

    private void viewManagement(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            pressedButton = savedInstanceState.getString("pressedButton");

            if (pressedButton != null) {
                switch (pressedButton) {
                    case "drinkListFromApiButton":
                        runDrinkListFromApiFragment();
                        pageTitle.setText(R.string.drink_list_from_api_title);
                        break;
                    case "drinkListFromDatabaseButton":
                        runDrinkListFromDatabaseFragment();
                        pageTitle.setText(R.string.drink_list_from_database_title);
                        break;
                    case "createOwnDrinks":
                        runCreatorDrinkFragment();
                        pageTitle.setText(R.string.create_own_drinks_title);
                        break;
                }
            }

        } else {
            pageTitle.setText("Main menu");
            pressedButton = "mainButton";
        }
    }

    private void initNavigationDrawer() {

    }

    public void closeOrOpenNavigationDrawer(View view) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    private void buttonsListeners() {

        Button drinkListFromApiButton = findViewById(R.id.drink_list_from_api);
        drinkListFromApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pressedButton = "drinkListFromApiButton";
                pageTitle.setText(R.string.drink_list_from_api_title);
                drawerLayout.closeDrawer(GravityCompat.START);
                runDrinkListFromApiFragment();

            }
        });

        Button drinkListFromDatabaseButton = findViewById(R.id.drink_list_from_database);
        drinkListFromDatabaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageTitle.setText(R.string.drink_list_from_database_title);
                pressedButton = "drinkListFromDatabaseButton";
                drawerLayout.closeDrawer(GravityCompat.START);
                runDrinkListFromDatabaseFragment();

            }
        });

        Button createOwnDrinks = findViewById(R.id.your_own_drink);
        createOwnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pressedButton = "createOwnDrinks";
                pageTitle.setText(R.string.create_own_drinks_title);
                drawerLayout.closeDrawer(GravityCompat.START);
                runCreatorDrinkFragment();

            }
        });



    }

    private void runCreatorDrinkFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new DrinkCreatorFragment(getApplicationContext()))
                .commit();
    }

    private void runDrinkListFromApiFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new DrinkListFromApiFragment(getApplicationContext()))
                .commit();
    }

    private void runDrinkListFromDatabaseFragment() {
        androidDatabase.getQueryExecutor().execute(() -> {
            //usuwanie przestarzałego tokena wraz z użytkownikiem
            List<DrinkEntity> drinkEntityList = androidDatabase.drinkEntityDAO().getAll();
            System.out.println("wielkosc bazy: " + drinkEntityList.size());
            //przejscie do aktywnosci start
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, new DrinkListFromDatabaseFragment(getApplicationContext(), drinkEntityList))
                    .commit();
        });


    }



}