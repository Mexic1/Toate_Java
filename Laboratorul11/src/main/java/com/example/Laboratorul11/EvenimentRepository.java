package com.example.Laboratorul11;

import com.example.Laboratorul11.Entity.Evenimente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EvenimentRepository extends JpaRepository<Evenimente, Long> {
    Optional<Evenimente> findByLocatie(String locatie);

    Optional<Evenimente> findByData(LocalDate data);
}
