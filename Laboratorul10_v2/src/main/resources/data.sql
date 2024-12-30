
Create table carti(
                      id INT  auto_increment,
                      Autorul varchar(255) not null,
                      Titlul varchar(255) not null,
                      primary key (id)
);

insert into carti(Autorul, Titlul) values('Mihai Eminescu', 'Luceafarul');
insert into carti(Autorul, Titlul) values('Ion Creanga', 'Povestea porcului');
insert into carti(Autorul, Titlul) values('Mihai Eminescu', 'Dorinta');
insert into carti(Autorul, Titlul) values('Ion Creanga', 'Capra cu trei iezi');
insert into carti(Autorul, Titlul) values('Mihai Eminescu', 'Scrisoarea III');