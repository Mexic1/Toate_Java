package com.example;

import com.example.jdbc.Masina;
import com.example.jdbc.MasinaJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Lab9ex1Application implements CommandLineRunner {

	@Autowired
	MasinaJdbcDao dao;
	public static void main(String[] args) {

		SpringApplication.run(Lab9ex1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Logger logger= LoggerFactory.getLogger(this.getClass());
		Scanner sc=new Scanner(System.in);
		while(true)
		{
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
			int opt=sc.nextInt();
			switch (opt)
			{
				case 0:
					sc.close();
					System.exit(0);
					break;
				case 1:
					//System.out.println("Toate masinile:");
					//dao.findAll().forEach(System.out::println);
					logger.info("Toate masinile: "+dao.findAll());
					break;
				case 2:
					System.out.println("Introduceti datele masinii:");
					System.out.println("Nr inmatriculare:");
					String nrInmatriculare=sc.next();
					System.out.println("Marca:");
					String marca=sc.next();
					System.out.println("Anul fabricatiei:");
					int anulFabricatiei=sc.nextInt();
					System.out.println("Culoare:");
					String culoare=sc.next();
					System.out.println("Nr km:");
					Long nrKm=sc.nextLong();
					System.out.println("Adauga masina cu nr inmatriculare "+nrInmatriculare+", numarul de randuri adaugate: "
							+ dao.insert(new Masina(nrInmatriculare,marca,anulFabricatiei,culoare,nrKm)));
					dao.update(new Masina(nrInmatriculare,marca,anulFabricatiei,culoare,nrKm));
					break;
				case 3:
					System.out.println("Introduceti nr inmatriculare masina de sters:");
					String nrInmatriculare1=sc.next();
					System.out.println("Sterge masina cu nr inmatriculare "+nrInmatriculare1+", numarul de randuri sterse: "
							+dao.deleteById(nrInmatriculare1));
					break;
				case 4:
					System.out.println("Introduceti nr inmatriculare masina de cautat:");
					String nrInmatriculare2=sc.next();
					System.out.println("Masina cu nr inmatriculare "+nrInmatriculare2+": "+dao.findById(nrInmatriculare2));
					break;
				case 5:
					List<Masina> m =dao.findAll();
					m.forEach(System.out::println);
					break;
				case 6:
					System.out.println("Introduceti marca masinii:");
					String marca1=sc.next();
					System.out.println("Nr masini marca "+marca1+": "
							+dao.findAll()
							.stream()
							.filter(x->x.getMarca().equals(marca1))
							.count());
					break;
				case 7:
					System.out.println("Nr masini cu <100k km: "
							+dao.findAll()
							.stream()
							.filter(x->x.getNrKm()<100000)
							.count());
					break;
				case 8:
					System.out.println("Masini cu <5 ani:");
					dao.findAll()
							.stream()
							.filter(x->x.getAnulFabricatiei()+5>= LocalDate.now().getYear())
							.forEach(System.out::println);
					break;
			}
		}

	}

}
