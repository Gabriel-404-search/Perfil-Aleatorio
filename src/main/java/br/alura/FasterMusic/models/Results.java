package br.alura.FasterMusic.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(@JsonAlias("name") ApiForName name,

                      @JsonAlias("gender") String gender,

                      @JsonAlias ("location") ApiForLocation location,

                      @JsonAlias("email") String email,

                      @JsonAlias("login") ApiForLogin login,

                      @JsonAlias("dob") ApiForDateOfBirth dateOfBirth,

                      @JsonAlias("phone") String phone,

                      @JsonAlias("picture") ApiForPicture picture,

                      @JsonAlias("nat") String nat) {
    @Override
    public String toString() {
        return "Resultado: \n" +
                "Genero = " + gender +
                ", Nome = " + name +
                ", Localização = " + location +
                ", E-mail = " + email +
                ", Login = " + login +
                ", Data de nascimento = " + dateOfBirth +
                ", Telefone = " + phone +
                ", Foto de perfil = " + picture +
                ", Naturalização = " + nat;
    }
}