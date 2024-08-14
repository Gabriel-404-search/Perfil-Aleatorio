package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.models.Results;
import jakarta.persistence.*;

import javax.xml.transform.Result;

@Entity
@Table(name = "Foto De Perfil")
public class OrderPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medium;

    public OrderPicture(Results results){
        this.medium = results.picture().medium();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
