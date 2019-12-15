package com.example.mercadoesclavoasuarez.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mercadoesclavoasuarez.MainActivity;
import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.controller.ProductController;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ResultListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mercadoesclavoasuarez.MainActivity.CATEGORY_KEY;

public class FavouriteProducts extends AppCompatActivity implements Adapter.BoxListener {

    @BindView(R.id.toolbarFavProducts)
    Toolbar toolbar;
    @BindView(R.id.favProductsRecyclerView)
    RecyclerView recyclerView;
    private List<Product> productList;
    private Adapter adapter;
    private Product product;
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_products);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        productList = new ArrayList<>();

        db.collection("FavProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // TODO create class with recycler of fav Products and make intent
                                Product product = document.toObject(Product.class);
                                productList.add(product);


                                adapter.refreshProduct(productList);
                            }
                        } else {
                            task.getException();
                        }
                    }
                });

        adapter = new Adapter(productList, this);
        this.recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void boxPicked(Product product) {

        Intent intent = new Intent(FavouriteProducts.this, InsideProductActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(InsideProductActivity.KEY_PRODUCT, product);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}
