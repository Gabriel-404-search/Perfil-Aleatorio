package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiForName(@JsonAlias("title") String title,

                           @JsonAlias("first") String first,

                           @JsonAlias ("last") String last) {
    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }
}
