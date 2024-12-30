package com.example;

import com.example.repository.MasinaJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Lab9ex2Application implements CommandLineRunner {

	@Autowired
	MasinaJpaRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(Lab9ex2Application.class, args);
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
					long nrKm = sc.nextLong();
					Masini masina = new Masini(nrInmatriculare, marca, anulFabricatiei, culoare, nrKm);
					repository.insert(masina);
					//repository.update(masina);
					repository.findAll().forEach(System.out::println);
					//logger.info("Masina adaugata: " + masina);
					break;
				case 3:
					System.out.println("Introduceti nr inmatriculare masina de sters:");
					String nrInmatriculare1 = sc.next();
					repository.deleteById(nrInmatriculare1);
					repository.findAll().forEach(System.out::println);
					break;
				case 4:
					System.out.println("Introduceti nr inmatriculare masina de cautat:");
					String nrInmatriculare2 = sc.next();
					System.out.println(repository.findById(nrInmatriculare2));
					break;
				case 5:
					System.out.println("Lista masini:");
					List<Masini> m=repository.findAll().stream().toList();
					m.forEach(System.out::println);
					break;
				case 6:
					System.out.println("Introduceti marca masinii:");
					String marca1 = sc.next();
					System.out.println("Masini marca " + marca1 + ": "+
							repository.findAll()
							.stream()
							.filter(x -> x.getMarca().equals(marca1))
							.count());
					break;
				case 7:
					System.out.println("Nr masini <100k km: "+
				repository.findAll()
						.stream()
						.filter(x -> x.getNrKm() < 100000)
						.count());
					break;
				case 8:
					System.out.println("Masini <5 ani: ");
					repository.findAll()
							.stream()
							.filter(x -> x.getAnulFabricatiei()+5 >= LocalDate.now().getYear())
							.forEach(System.out::println);
					break;
				default:
					System.out.println("Optiune invalida");
					break;
			}
		}

	}
}
