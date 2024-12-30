Create table masini_DataJPA
(
    nrinmatriculare varchar(255) not null,
    marca            varchar(255) not null,
    anulfabricatiei int          not null,
    culoare          varchar(255) not null,
    nrkm            int          not null,
    primary key (nrinmatriculare)
);

INSERT INTO masini_DataJPA (nrinmatriculare, marca, anulfabricatiei, culoare, nrkm)
VALUES
    ('1', 'Dacia', 2018, 'Alb', 50000),
    ('2', 'BMW', 2020, 'Negru', 30000),
    ('3', 'Mercedes', 2015, 'Gri', 150000),
    ('4', 'Audi', 2017, 'Rosu', 80000),
    ('5', 'Volkswagen', 2019, 'Albastru', 60000);