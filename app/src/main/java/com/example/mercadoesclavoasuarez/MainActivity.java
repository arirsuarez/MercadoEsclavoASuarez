package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.DrawerMainActivity)
    DrawerLayout drawerLayoutMainActivity;
    @BindView(R.id.NavigationViewMenu)
    NavigationView navigationViewMenu;
    @BindView(R.id.toolbarMainActivity)
    Toolbar toolbar;
    @BindView(R.id.AppInfoTextView)
    TextView appInfoTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);
        navigationViewMenu.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMainActivity, toolbar, R.string.openNavigationView, R.string.closeNavigationView);

        drawerLayoutMainActivity.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String itemName = (String) menuItem.getTitle();

        Toast.makeText(this, "Opción Seleccionada: " + itemName, Toast.LENGTH_SHORT).show();

        closeNavigationView();

        switch (menuItem.getItemId()){
            case R.id.HomeNavigationViewMenu:
                break;
            case R.id.SearchNavigationViewMenu:
                break;
            case R.id.NotificationNavigationViewMenu:
                break;
            case R.id.FavoritesNavigationViewMenu:
                break;
            case R.id.UserAccountNavigationViewMenu:
                break;
        }

        return true;
    }

    private void closeNavigationView() {

        drawerLayoutMainActivity.closeDrawer(GravityCompat.START);
    }

    private void openNavigationView(){
        drawerLayoutMainActivity.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayoutMainActivity.isDrawerOpen(GravityCompat.START)){
            closeNavigationView();
        }
        super.onBackPressed();
    }
}
