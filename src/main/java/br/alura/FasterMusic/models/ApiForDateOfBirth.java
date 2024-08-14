package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiForDateOfBirth(@JsonAlias ("date") String date,
                                @JsonAlias("age") Integer age) {
    @Override
    public String toString() {
        return
                "Data = " + date +
                ", Idade = " + age;
    }
}