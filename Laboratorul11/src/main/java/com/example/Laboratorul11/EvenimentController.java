package com.example.Laboratorul11;

import com.example.Laboratorul11.Entity.Evenimente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EvenimentController {

    @Autowired
    EvenimentRepository repository;

    @GetMapping("jpa/evenimente")
    public List<Evenimente> findAll() {
        return repository.findAll();
    }

//    @GetMapping("jpa/evenimente/{id}")
//    public Evenimente findById(@PathVariable Long id) {
//        Optional<Evenimente> OptionalEveniment = repository.findById(id);
//        if (OptionalEveniment.isPresent()) {
//            return OptionalEveniment.get();
//        } else throw new RuntimeException("Evenimentul cu id-ul " + id + " nu a fost găsit.");
//    }

    @GetMapping("jpa/evenimente/locatie/{locatie}")
    public Evenimente findByLocatie(@PathVariable String locatie) {
        Optional<Evenimente> OptionalEveniment = repository.findByLocatie(locatie);
        if (OptionalEveniment.isPresent()) {
            return OptionalEveniment.get();
        } else throw new RuntimeException("Evenimentul cu locatia " + locatie + " nu a fost găsita.");
    }

    @GetMapping("jpa/evenimente/data/{data}")
    public Evenimente findByData(@PathVariable LocalDate data) {
        Optional<Evenimente> OptionalEveniment = repository.findByData(data);
        if (OptionalEveniment.isPresent()) {
            return OptionalEveniment.get();
        } else throw new RuntimeException("Evenimentul cu data " + data + " nu a fost găsita.");
    }

    @PostMapping("jpa/evenimente")
    public void saveEveniment(@RequestBody Evenimente eveniment) {
         repository.save(eveniment);
    }

    @DeleteMapping("jpa/evenimente/{id}")
    public void deleteEvenimentById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
