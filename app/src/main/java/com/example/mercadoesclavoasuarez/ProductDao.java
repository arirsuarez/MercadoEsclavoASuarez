package com.example.mercadoesclavoasuarez;

import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ProductService;
import com.example.mercadoesclavoasuarez.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDao {

    private Retrofit retrofit;
    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";
    private ProductService productService;

    public ProductDao() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productService = retrofit.create(ProductService.class);
    }

    public void productRequest(ResultListener<ProductContainer> controllerListener)

    /*public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        productList.add(new Product(R.drawable.background_abstract, "Product 1", "$2500"));
        return productList;
    }*/
}
