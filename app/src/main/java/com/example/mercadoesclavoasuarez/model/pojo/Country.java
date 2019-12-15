package com.example.mercadoesclavoasuarez.model.pojo;

import java.io.Serializable;

class Country implements Serializable {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

