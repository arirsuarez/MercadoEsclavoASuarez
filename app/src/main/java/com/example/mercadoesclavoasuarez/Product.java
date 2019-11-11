package com.example.mercadoesclavoasuarez;

import android.content.Intent;

public class Product {

        private Integer imageProduct;
        private String nameProduct;
        private String priceProduct;

    public Product() {
    }

    public Product(Integer imageProduct, String nameProduct, String priceProduct) {
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public Integer getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(Integer imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }
}
