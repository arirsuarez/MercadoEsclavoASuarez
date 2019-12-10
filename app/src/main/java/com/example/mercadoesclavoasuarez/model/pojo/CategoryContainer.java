package com.example.mercadoesclavoasuarez.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;

public class CategoryContainer {

    private Call<List<Category>> results;

    public CategoryContainer() {
    }

    public CategoryContainer(Call<List<Category>> results) {
        this.results = results;
    }

    public Call<List<Category>> getResults() {
        return results;
    }

    public void setResults(Call<List<Category>> results) {
        this.results = results;
    }
}
