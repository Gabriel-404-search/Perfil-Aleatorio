package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.models.Results;
import jakarta.persistence.*;

@Entity
@Table (name = "Dia_do_aniversario")
public class OrderDateOfBirth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private Integer age;

    public OrderDateOfBirth(Results results){
        this.date = results.dateOfBirth().date();
        this.age = results.dateOfBirth().age();
    }

    public OrderDateOfBirth() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}