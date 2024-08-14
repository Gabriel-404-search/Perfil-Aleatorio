package br.alura.FasterMusic.entities;

import br.alura.FasterMusic.models.Results;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class OrderLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String passWord;

    @OneToOne
    OrderProfile login;
    public OrderLogin(Results results){
        this.userName = results.login().username();
        this.passWord = results.login().password();;
    }

    public OrderProfile getProfile() {
        return login;
    }

    public OrderProfile setProfile(OrderProfile login) {
        return this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}