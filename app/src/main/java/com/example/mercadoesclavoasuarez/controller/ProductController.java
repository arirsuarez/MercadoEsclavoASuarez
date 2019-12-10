package com.example.mercadoesclavoasuarez.controller;

import com.example.mercadoesclavoasuarez.model.dao.ProductDao;
import com.example.mercadoesclavoasuarez.model.pojo.CategoryContainer;
import com.example.mercadoesclavoasuarez.model.pojo.ProductContainer;
import com.example.mercadoesclavoasuarez.util.ResultListener;

public class ProductController {

    private ProductDao dao;

    public ProductController() {
        dao = new ProductDao();
    }

    public void getCategoryRequest (final ResultListener<CategoryContainer> viewListener){
        dao.categorytRequest(new ResultListener<CategoryContainer>() {
            @Override
            public void onFinish(CategoryContainer results) {
                viewListener.onFinish(results);
            }
        });
    }

    public void getProductRequest (final ResultListener<ProductContainer> viewListener){
        dao.productRequest(new ResultListener<ProductContainer>() {
            @Override
            public void onFinish(ProductContainer results) {
                viewListener.onFinish(results);
            }
        });
    }
}
