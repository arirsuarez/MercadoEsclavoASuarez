package com.example.mercadoesclavoasuarez.model.pojo;

import java.io.Serializable;

class Location implements Serializable {

    private Neighborhood neighborhood;
    private City city;
    private Country country;

    public Location() {
    }

    public Location(Neighborhood neighborhood, City city, Country country) {
        this.neighborhood = neighborhood;
        this.city = city;
        this.country = country;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
