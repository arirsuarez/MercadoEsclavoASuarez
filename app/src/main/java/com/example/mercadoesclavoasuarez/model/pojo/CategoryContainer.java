package com.example.mercadoesclavoasuarez.model.pojo;

import java.util.List;

public class CategoryContainer {


    private List<Category> results;

    public CategoryContainer() {
    }

    public CategoryContainer(List<Category> results) {
        this.results = results;
    }

    public List<Category> getResults() {
        return results;
    }

    public void setResults(List<Category> results) {
        this.results = results;
    }
}
