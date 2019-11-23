package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.DrawerMainActivity)
    DrawerLayout drawerLayoutMainActivity;
    @BindView(R.id.NavigationViewMenu)
    NavigationView navigationViewMenu;
    @BindView(R.id.toolbarMainActivity)
    Toolbar toolbar;
    @BindView(R.id.productListRecyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        navigationViewMenu.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMainActivity, toolbar, R.string.openNavigationView, R.string.closeNavigationView);

        drawerLayoutMainActivity.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);

        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getProducts();

        Adapter adapter = new Adapter(productList);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setHasFixedSize(true);




    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

         /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_action){
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Go to LinkedIn", Toast.LENGTH_SHORT).show();
        }
        return true;
    }*/

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
