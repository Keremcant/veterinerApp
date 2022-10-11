package com.example.veterinerApp.repository;

import com.example.veterinerApp.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository <Pet, Long> {

    @Query("SELECT p from Pet p where p.name like %?1%")
    public List<Pet> search(String keyword);


}
