package com.example.veterinerApp.service;


import com.example.veterinerApp.model.Owner;
import com.example.veterinerApp.model.Pet;

import java.util.List;

public interface PetService {

    void store(Owner owner, Pet pet);

    Pet getById(Long id);

    void delete(Long id);

    List<Pet> search(String keyword);

    List<Pet> getAll();

    Long count();
}
