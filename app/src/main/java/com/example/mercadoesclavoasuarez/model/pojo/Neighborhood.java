package com.example.mercadoesclavoasuarez.model.pojo;

import java.io.Serializable;

class Neighborhood implements Serializable {

    private String name;

    public Neighborhood() {
    }

    public Neighborhood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
