package com.example.mercadoesclavoasuarez.util;

import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductService {

    @GET("search")
    Call<ProductContainer> productApiRequest(@Query("q") String requestedSearch);

    @GET("categories")
    Call<List<Category>> categoryApiRequest();
}
