package com.example.mercadoesclavoasuarez.model.dao;

import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ProductService;
import com.example.mercadoesclavoasuarez.util.ResultListener;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDao {

    private Retrofit retrofit;
    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";
    private ProductService productService;
    private String searchedProductQuery;

    public ProductDao() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productService = retrofit.create(ProductService.class);
    }

    public void categorytRequest(final ResultListener<List<Category>> controllerListener){
        Call<List<Category>> categoryListCall = productService.categoryApiRequest();
        productService.categoryApiRequest();
        categoryListCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> body = response.body();
                controllerListener.onFinish(body);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }

    public void productRequest(final ResultListener<ProductContainer> controllerListener){
        Call<ProductContainer> productContainerCall = productService.productApiRequest(searchedProductQuery);
        productService.productApiRequest(searchedProductQuery);
        productContainerCall.enqueue(new Callback<ProductContainer>() {
            @Override
            public void onResponse(Call<ProductContainer> call, Response<ProductContainer> response) {
                ProductContainer body = response.body();
                controllerListener.onFinish(body);
            }

            @Override
            public void onFailure(Call<ProductContainer> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

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
