package com.example.mercadoesclavoasuarez.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mercadoesclavoasuarez.ProductDetailsViewPagerAdapter;
import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.model.pojo.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsideProductActivity extends AppCompatActivity {

    public static final String KEY_PRODUCT = "product";

    @BindView(R.id.productImageDetailFragment)
    ImageView productImage;
    @BindView(R.id.productNameTextView)
    TextView productName;
    @BindView(R.id.productPriceTextView)
    TextView productPrice;
    private Product product;
    @BindView(R.id.productDetailFragmentToolbar)
    Toolbar toolbar;
    @BindView(R.id.productFragmentViewPager)
    ViewPager pager;
    private ProductDetailsViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_product);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.product = (Product) bundle.getSerializable(KEY_PRODUCT);

        Glide.with(productImage)
                .load(product.getThumbnail())
                .into(productImage);
        productName.setText(product.getTitle());
        productPrice.setText(product.getPrice().toString());




    }
}
