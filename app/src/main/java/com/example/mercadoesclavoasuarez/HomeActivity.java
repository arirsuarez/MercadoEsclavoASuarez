package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mercadoesclavoasuarez.controller.ProductController;
import com.example.mercadoesclavoasuarez.model.dao.ProductDao;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.example.mercadoesclavoasuarez.util.ResultListener;
import com.example.mercadoesclavoasuarez.view.CategoryAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.DrawerMainActivity)
    DrawerLayout drawerLayoutMainActivity;
    @BindView(R.id.toolbarMainActivity)
    Toolbar toolbar;
    @BindView(R.id.categoryListRecyclerView)
    RecyclerView recyclerView;
    private List<Category> categories = new ArrayList<>();
    private Adapter adapter;
    private CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMainActivity, toolbar, R.string.openNavigationView, R.string.closeNavigationView);
        drawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorAccent));

        drawerLayoutMainActivity.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);


        ProductController productController = new ProductController();
        productController.getCategoryRequest(new ResultListener<List<Category>>() {
            @Override
            public void onFinish(List<Category> results) {
                categories = results;
                categoryAdapter.refreshList(categories);
            }
        });

        categoryAdapter = new CategoryAdapter(categories);
        this.recyclerView.setAdapter(categoryAdapter);
        this.recyclerView.setHasFixedSize(true);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String itemName = (String) menuItem.getTitle();

        Toast.makeText(this, "Opción Seleccionada: " + itemName, Toast.LENGTH_SHORT).show();

        closeNavigationView();

        switch (menuItem.getItemId()) {
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

    private void openNavigationView() {
        drawerLayoutMainActivity.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayoutMainActivity.isDrawerOpen(GravityCompat.START)) {
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

        switch (item.getItemId()) {
            case R.id.filter_button_main_toolbar:
                break;
            case R.id.search_button_main_toolbar:
                break;
        }

        return true;
    }


}
