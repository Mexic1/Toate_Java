package com.example;

import com.example.repository.SpringDataJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaMySQLApplication implements  CommandLineRunner {
    @Autowired
    SpringDataJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaMySQLApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Afisare masini");
            System.out.println("2. Adaugare masina");
            System.out.println("3. Stergere masina");
            System.out.println("4. Cautare masina dupa nr_inmatriculare");
            System.out.println("5. Lista masini");
            System.out.println("6. Nr masini anumita marca");
            System.out.println("7. Nr masini <100k km");
            System.out.println("8. Extragere masini <5ani");
            System.out.println("0. Exit");
            System.out.println("Introduceti optiunea: ");
            int opt = sc.nextInt();
            switch (opt) {

                case 0:
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Toate masinile:");
                    repository.findAll().forEach(System.out::println);
                    System.out.println("\n");
                    logger.info("Toate masinile: " + repository.findAll());
                    break;
                case 2:
                    System.out.println("Introduceti datele masinii:");
                    System.out.println("Nr inmatriculare:");
                    String nrInmatriculare = sc.next();
                    System.out.println("Marca:");
                    String marca = sc.next();
                    System.out.println("Anul fabricatiei:");
                    int anulFabricatiei = sc.nextInt();
                    System.out.println("Culoare:");
                    String culoare = sc.next();
                    System.out.println("Nr km:");
                    int nrKm = sc.nextInt();
                    repository.save(new Masini(nrInmatriculare, marca, anulFabricatiei, culoare, nrKm));
                    break;
                case 3:
                    System.out.println("Introduceti nr inmatriculare:");
                    String nrInmatriculare1 = sc.next();
                    repository.deleteById(Integer.valueOf(nrInmatriculare1));
                    break;
                case 4:
                    System.out.println("Introduceti nr inmatriculare:");
                    String nrInmatriculare2 = sc.next();
                    System.out.println(repository.findById(Integer.valueOf(nrInmatriculare2)));
                    break;
                case 5:
                    System.out.println("Toate masinile:");
                   List<Masini> m= repository.findAll().stream().toList();
                    break;
                case 6:
                    System.out.println("Introduceti marca:");
                    String marca1 = sc.next();
                    System.out.println("Nr masini marca " + marca1 + ": " + repository.findByMarca(marca1).size());
                    break;
                case 7:
                    System.out.println("Nr masini <100k km: " + repository.findByNrkmIsBefore(100000).size());
                    break;
                case 8:
                    int anulFabricatiei1 = LocalDate.now().getYear()-5;
                    System.out.println("Masini <5ani: " + repository.findByAnulfabricatieiIsAfter(anulFabricatiei1).size());
                    break;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }
}
