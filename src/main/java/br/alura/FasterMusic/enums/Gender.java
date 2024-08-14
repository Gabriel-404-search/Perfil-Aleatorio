package br.alura.FasterMusic.enums;

public enum Gender {
    MULHER("female", "feminino"),

    HOMEM("male", "masculino");

    private String genderTranslacion;
    private String genderPortugues;

    Gender(String genderTranslacion, String genderPortugues) {
        this.genderTranslacion = genderTranslacion;
        this.genderPortugues = genderPortugues;
    }

    public static Gender toPortugues(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.genderTranslacion.equalsIgnoreCase(text)) {
                return gender;
            }
         }
        throw new IllegalArgumentException("Genero não reconhecido: " + text);
       }
    public static Gender fromPortugues(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.genderTranslacion.equalsIgnoreCase(text)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Genero não reconhecido: " + text);
    }
    }
