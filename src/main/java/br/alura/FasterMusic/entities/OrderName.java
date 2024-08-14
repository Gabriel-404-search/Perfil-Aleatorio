package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.models.Results;
import jakarta.persistence.*;

@Entity
@Table(name = "Nome")
public class OrderName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String first;
    private String last;

    public OrderName(Results results){
        this.title = results.name().title();
        this.first = results.name().first();
        this.last = results.name().last();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
