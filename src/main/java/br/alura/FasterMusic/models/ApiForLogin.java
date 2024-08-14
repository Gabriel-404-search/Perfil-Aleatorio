package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiForLogin(@JsonAlias("username") String username,
                          @JsonAlias("password") String password) {
    @Override
    public String toString() {
        return
                "Username -> " + username +
                ", Password ->" + password;
    }
}
