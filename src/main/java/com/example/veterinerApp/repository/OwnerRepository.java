package com.example.veterinerApp.repository;

import com.example.veterinerApp.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository <Owner, Long> {
    @Query("SELECT o from Owner o where o.name like %?1%")
    public List<Owner> search(String keyword);
}
