package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record ApiForLocation(@JsonAlias("street") ApiForStreet street,
                             @JsonAlias("city") String city,
                             @JsonAlias("state") String state,
                             @JsonAlias("country") String country,
                             @JsonAlias("postcode") Integer postcode) {
    @Override
    public String toString() {
        return
                "Rua = " + street +
                ", Cidade = " + city +
                ", Estado = " + state +
                ", País = " + country + "\n" +
                "Codigo Postal: " + postcode;
    }
}