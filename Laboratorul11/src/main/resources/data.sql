
Create table evenimente
(
    id        INT auto_increment,
    denumire varchar(255) not null,
    locatie   varchar(255) not null,
    data      DATE         not null,
    timp       TIME         not null,
    pret      float        not null,
    primary key (id)
);

insert into evenimente(denumire, locatie, data, timp, pret) values('Concert', 'Sala Palatului', '2021-12-12', '19:00', 100);
insert into evenimente(denumire, locatie, data, timp, pret) values('Teatru', 'Teatrul National', '2021-12-13', '18:00', 50);
insert into evenimente(denumire, locatie, data, timp, pret) values('Concert', 'Sala', '2021-12-14', '19:00', 100);
insert into evenimente(denumire, locatie, data, timp, pret) values('Teatru', 'Teatrul', '2021-12-15', '18:00', 50);
insert into evenimente(denumire, locatie, data, timp, pret) values('Festival', 'Poli', '2021-12-16', '19:00', 80);

