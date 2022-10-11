package com.example.veterinerApp.service;

import com.example.veterinerApp.model.Owner;
import com.example.veterinerApp.model.Pet;
import com.example.veterinerApp.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OwnerService {

    void store(Owner owner);

    List<Owner> getAll();

    Owner getById(long id);

    List<Pet> getOwnerPets(Owner owner);

    void delete(long id);

    List<Owner> search(String keyword);

    Long count();
}
