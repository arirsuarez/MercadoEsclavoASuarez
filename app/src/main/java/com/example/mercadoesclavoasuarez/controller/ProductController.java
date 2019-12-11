package com.example.mercadoesclavoasuarez.controller;

import com.example.mercadoesclavoasuarez.model.dao.ProductDao;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.Product;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ResultListener;

import java.util.List;

public class ProductController {

    private ProductDao dao;

    public ProductController() {
        dao = new ProductDao();
    }

    public void getCategoryRequest (final ResultListener<List<Category>> viewListener){
        dao.categorytRequest(new ResultListener<List<Category>>() {
            @Override
            public void onFinish(List<Category> results) {
                viewListener.onFinish(results);
            }
        });
    }

    public void getProductRequest(final ResultListener<ProductContainer> viewListener, String searchRequest){
        dao.productRequest(new ResultListener<ProductContainer>() {
            @Override
            public void onFinish(ProductContainer results) {
                viewListener.onFinish(results);
            }
        },searchRequest);
    }
}
