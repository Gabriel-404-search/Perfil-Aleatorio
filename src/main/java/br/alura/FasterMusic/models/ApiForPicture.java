package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiForPicture(@JsonAlias("medium") String medium) {
    @Override
    public String toString() {
        return medium;
    }
}
