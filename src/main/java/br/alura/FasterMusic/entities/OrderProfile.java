package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.enums.Gender;
import br.alura.FasterMusic.models.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table (name = "profile")
public class OrderProfile  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // esse cara permite fazer um ‘ID’ diferente do outro e também fazer isso automaticamente
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderLocation location;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderName name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderDateOfBirth birthDay;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderStreet street;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderPicture picture;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private OrderLogin login;

    private String nat;

    public OrderProfile(Results results){
        this.gender = Gender.toPortugues(results.gender());
        this.email = results.email();
        this.phone = results.phone();
        this.nat = results.nat();
        this.login = new OrderLogin(results);
        this.birthDay = new OrderDateOfBirth(results);
        this.picture = new OrderPicture(results);
        this.name = new OrderName(results);
        this.location = new OrderLocation(results);
        this.street = new OrderStreet(results);
    }

    public OrderProfile() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderLocation getLocation() {
        return location;
    }

    public void setLocation(OrderLocation location) {
        this.location = location;
    }

    public OrderName getName() {
        return name;
    }

    public void setName(OrderName name) {
        this.name = name;
    }

    public OrderDateOfBirth getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(OrderDateOfBirth birthDay) {
        this.birthDay = birthDay;
    }

    public OrderStreet getStreet() {
        return street;
    }

    public void setStreet(OrderStreet street) {
        this.street = street;
    }

    public OrderPicture getPicture() {
        return picture;
    }

    public void setPicture(OrderPicture picture) {
        this.picture = picture;
    }

    public OrderLogin getLogin() {
        return login;
    }

    public void setLogin(OrderLogin login) {
        this.login = login;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}