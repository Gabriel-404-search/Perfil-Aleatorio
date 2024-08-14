package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record ApiForProfile(@JsonAlias ("results") List<Results> results)

{
    @Override
    public String toString() {
        return results.toString();
    }
}
