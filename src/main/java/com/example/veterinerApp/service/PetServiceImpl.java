package com.example.veterinerApp.service;


import com.example.veterinerApp.model.Owner;
import com.example.veterinerApp.model.Pet;
import com.example.veterinerApp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("petService")
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public void store(Owner owner, Pet pet){
        pet.setOwner(owner);
        petRepository.save(pet);
    }

    @Override
    public Pet getById(Long id){ return petRepository.getById(id); }

    @Override
    public void delete(Long id) { petRepository.delete(petRepository.getById(id)); }

    @Override
    public List<Pet> search(String keyword) {
        if (keyword != null && keyword.length() > 2){
            return petRepository.search(keyword);
        }
        return null;
    }

    @Override
    public List<Pet> getAll() { return petRepository.findAll(); }

    @Override
    public Long count() { return petRepository.count(); }
}
