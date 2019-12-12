package com.example.mercadoesclavoasuarez.model.pojo;

import android.content.Intent;

import java.io.Serializable;

public class Product implements Serializable {

        private String id;
        private String title;
        private Integer price;
        private String condition;
        private String thumbnail;

    public Product() {
    }

    public Product(String id, String title, Integer price, String condition, String thumbnail) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.condition = condition;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
