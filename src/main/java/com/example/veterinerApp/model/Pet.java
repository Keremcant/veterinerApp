package com.example.veterinerApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    @NotEmpty(message = "Lütfen hayvanın adını giriniz!")
    private String name;

    @Column(nullable = false, name = "age")
    @NotNull(message = "Yaş rakam olmalıdır!")
    private Integer age;

    @Column(nullable = false, name = "breed")
    @NotEmpty(message = "Lütfen hayvanın cinsini giriniz!")
    private String breed;

    @Column(nullable = false, name = "type")
    @NotEmpty(message = "Lütfen hayvanın türünü giriniz!")
    private String type;


    @Column(nullable = false, name = "description")
    @NotEmpty(message = "Lütfen açıklama giriniz!")
    private String description;


    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity = Owner.class, fetch = FetchType.EAGER)
    private Owner owner;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
