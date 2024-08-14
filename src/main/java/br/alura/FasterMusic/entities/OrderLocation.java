package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.models.Results;
import jakarta.persistence.*;

@Entity
@Table(name = "Localização")
public class OrderLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String state;
    private String contry;
    private Integer postcode;

    public Long getId() {
        return id;
    }

    public OrderLocation(Results results) {
        this.city = results.location().city();
        this.state = results.location().state();
        this.contry = results.location().country();
        this.postcode = results.location().postcode();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }
}
