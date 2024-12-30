
 Create table masini
 (
     nr_inmatriculare varchar(255) not null,
     marca            varchar(255) not null,
     anul_fabricatiei int          not null,
     culoare          varchar(255) not null,
     nr_km            int          not null,
     primary key (nr_inmatriculare)
 );

    INSERT INTO masini (nr_inmatriculare, marca, anul_fabricatiei, culoare, nr_km)
    VALUES
        ('B123ABC', 'Dacia', 2018, 'Alb', 50000),
        ('CJ01XYZ', 'BMW', 2020, 'Negru', 30000),
        ('IS99YYY', 'Mercedes', 2015, 'Gri', 150000),
        ('BV22ZZZ', 'Audi', 2017, 'Rosu', 80000),
        ('TM33WWW', 'Volkswagen', 2019, 'Albastru', 60000);