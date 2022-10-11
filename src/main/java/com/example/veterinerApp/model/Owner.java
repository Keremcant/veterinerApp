package com.example.veterinerApp.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    @NotEmpty(message = "Lütfen isim giriniz!")
    private String name;

    @Column(nullable = false, name = "surname")
    @NotEmpty(message = "Lütfen soyisim giriniz!")
    private String surname;

    @Column(nullable = false, name = "address")
    @NotEmpty(message = "Lütfen adres bilgisi giriniz!")
    private String address;

    @Column(nullable = false, name = "phoneNumber")
    @NotEmpty(message = "Lütfen telefon numarası giriniz!")
    private String phoneNumber;

    @Column(nullable = false, name = "mail")
    @NotEmpty(message = "Lütfen email giriniz!")
    @Email(message = "Lütfen gerçerli bir email giriniz!")
    private String mail;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
