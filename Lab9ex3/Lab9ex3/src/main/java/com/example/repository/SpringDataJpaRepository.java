package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.Masini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SpringDataJpaRepository extends JpaRepository<Masini, Integer>{

   List<Masini> findByMarca(String marca);
   List<Masini> findByNrkmIsBefore(int nrkm);
    List<Masini> findByAnulfabricatieiIsAfter(int anulFabricatiei);
}