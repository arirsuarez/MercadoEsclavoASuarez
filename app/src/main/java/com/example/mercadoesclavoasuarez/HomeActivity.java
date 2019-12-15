package com.example.mercadoesclavoasuarez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mercadoesclavoasuarez.controller.ProductController;
import com.example.mercadoesclavoasuarez.model.dao.ProductDao;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.example.mercadoesclavoasuarez.util.ProductService;
import com.example.mercadoesclavoasuarez.util.ResultListener;
import com.example.mercadoesclavoasuarez.view.Adapter;
import com.example.mercadoesclavoasuarez.view.CategoryAdapter;
import com.example.mercadoesclavoasuarez.view.FavouriteProducts;
import com.example.mercadoesclavoasuarez.view.InsideProductActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CategoryAdapter.BoxListener {


    @BindView(R.id.DrawerActivityHome)
    DrawerLayout drawerLayoutMainActivity;
    @BindView(R.id.NavigationViewMenuHome)
    NavigationView navigationView;
    @BindView(R.id.toolbarHomeActivity)
    Toolbar toolbar;
    @BindView(R.id.categoryListRecyclerView)
    RecyclerView recyclerView;
    private List<Category> categories;
    private CategoryAdapter categoryAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        this.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String itemName = (String) menuItem.getTitle();
                Toast.makeText(HomeActivity.this, "Opción: " + itemName, Toast.LENGTH_SHORT).show();

                closeNavigationView();

                switch (menuItem.getItemId()) {
                    case R.id.HomeNavigationViewMenu:
                        break;
                    case R.id.SearchNavigationViewMenu:
                        break;
                    case R.id.NotificationNavigationViewMenu:
                        break;
                    case R.id.FavoritesNavigationViewMenu:
                        Intent intent = new Intent(HomeActivity.this, FavouriteProducts.class);
                        startActivity(intent);
                        break;
                    case R.id.UserAccountNavigationViewMenu:
                        break;
                }

                return true;
            }

            private void closeNavigationView() {

                drawerLayoutMainActivity.closeDrawer(GravityCompat.START);
            }
        });

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayoutMainActivity, toolbar, R.string.openNavigationView, R.string.closeNavigationView);
        drawerToggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorAccent));

        drawerLayoutMainActivity.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);

        this.categories = new ArrayList<>();

        ProductController productController = new ProductController();
        productController.getCategoryRequest(new ResultListener<List<Category>>() {
            @Override
            public void onFinish(List<Category> results) {
                categories = results;
                categoryAdapter.refreshList(categories);
            }
        });

        categoryAdapter = new CategoryAdapter(categories, this);
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

    @Override
    public void boxPicked(Category category) {

        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.CATEGORY_KEY, category);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
