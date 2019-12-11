package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.mercadoesclavoasuarez.controller.ProductController;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ResultListener;
import com.example.mercadoesclavoasuarez.view.Adapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Adapter.BoxListener {

    public static final String CATEGORY_KEY = "Category";


    @BindView(R.id.DrawerMainActivity)
    DrawerLayout drawerLayoutMainActivity;
    @BindView(R.id.NavigationViewMenu)
    NavigationView navigationViewMenu;
    @BindView(R.id.toolbarMainActivity)
    Toolbar toolbar;
    @BindView(R.id.productListRecyclerView)
    RecyclerView recyclerView;
    private List<Product> productList = new ArrayList<>();
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        navigationViewMenu.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMainActivity, toolbar, R.string.openNavigationView, R.string.closeNavigationView);
        drawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorAccent));

        drawerLayoutMainActivity.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Category category = (Category) bundle.getSerializable(CATEGORY_KEY);
        String categorySearched = category.getName();

        ProductController productController = new ProductController();
        productController.getProductRequest(new ResultListener<ProductContainer>() {
            @Override
            public void onFinish(ProductContainer results) {
                productList = results.getResults();
                adapter.refreshProduct(productList);
            }
        }, categorySearched);

        /*productController.getProductRequest(new ResultListener<ProductContainer>() {
            @Override
            public void onFinish(ProductContainer results) {
                productList = results.getResults();
                adapter.refreshProduct(productList);
            }
        });*/

        adapter = new Adapter(productList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String title = item.getTitle().toString();

        Toast.makeText(this, "Button: " + title, Toast.LENGTH_SHORT).show();

        switch (item.getItemId()){
            case R.id.filter_button_main_toolbar:
                break;
            case R.id.search_button_main_toolbar:
                break;
        }

            return true;
        }


    @Override
    public void boxPicked(Product product) {
        Toast.makeText(this, product.getTitle(), Toast.LENGTH_SHORT).show();

    }
}
