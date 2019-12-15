package com.example.mercadoesclavoasuarez.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mercadoesclavoasuarez.ProductDetailsViewPagerAdapter;
import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class InsideProductActivity extends AppCompatActivity {

    public static final String KEY_PRODUCT = "product";

    @BindView(R.id.productImageDetailFragment)
    ImageView productImage;
    @BindView(R.id.productNameTextView)
    TextView productName;
    @BindView(R.id.productPriceTextView)
    TextView productPrice;
    @BindView(R.id.FavButton)
    FloatingActionButton favButton;
    private Product product;
//    @BindView(R.id.productDetailFragmentToolbar)
//    Toolbar toolbar;
    @BindView(R.id.tabLayoutProductDetails)
    TabLayout tabLayout;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @BindView(R.id.productViewPagerInActivity)
    ViewPager viewPager;
    ProductDetailsViewPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_product);
        ButterKnife.bind(this);

        // setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.product = (Product) bundle.getSerializable(KEY_PRODUCT);

        Glide.with(productImage)
                .load(product.getThumbnail())
                .into(productImage);
        productName.setText(product.getTitle());
        productPrice.setText("$ " +  product.getPrice().toString());

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        pagerAdapter = new ProductDetailsViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> productFaved = new HashMap<>();
                productFaved.put("title", product.getTitle());
                productFaved.put("price", product.getPrice());
                productFaved.put("thumbnail", product.getThumbnail());

                db.collection("FavProducts")
                        .add(productFaved)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                favButton.setSelected(true);
                                favButton.setImageResource(R.drawable.ic_favorite_black_24dp);

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                e.printStackTrace();
                            }
                        });
            }
        });

    }


}
