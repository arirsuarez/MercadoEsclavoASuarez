package com.example.mercadoesclavoasuarez.model.pojo;

import java.util.List;

public class ProductContainer {

    private List<Product> results;

    public ProductContainer(List<Product> results) {
        this.results = results;
    }

    public ProductContainer() {
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }
}
