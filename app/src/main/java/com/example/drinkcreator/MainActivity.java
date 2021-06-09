package com.example.drinkcreator;

import android.os.Bundle;

//import com.example.drinkcreator.database.AndroidDatabase;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.drinkcreator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Optional;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String pressedButton;
//    private AndroidDatabase androidDatabase;

    TextView tabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        pressedButton = "homePage";

//        androidDatabase = AndroidDatabase.getAndroidDatabase(getApplicationContext());


        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigation_view);

        toolbar = findViewById(R.id.toolbar);

        tabName = navigationView.findViewById(R.id.toolbar_selected_menu);


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
                    case "":
                        break;
                }
            }

        } else {
            pressedButton = "mainButton";
        }
    }

    private void initNavigationDrawer() {




//        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer_menu, R.string.close_drawer_menu);
//        drawerLayout.addDrawerListener(mActionBarDrawerToggle);
//        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//        mActionBarDrawerToggle.syncState();


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

    }



}