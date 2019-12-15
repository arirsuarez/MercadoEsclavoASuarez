package com.example.mercadoesclavoasuarez.model.pojo;

import java.io.Serializable;

class Address implements Serializable {

    private String state_name;
    private String city_name;

    public Address() {
    }

    public Address(String state_name, String city_name) {
        this.state_name = state_name;
        this.city_name = city_name;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
