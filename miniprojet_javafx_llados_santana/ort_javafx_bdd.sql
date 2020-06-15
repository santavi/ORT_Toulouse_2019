create database ort_javafx;
use ort_javafx;

create table if not exists Client (
idClient int,
nom varchar(100),
prenom varchar(100),
adresse varchar(100),
mail varchar(100),
telephone varchar(100),
sexe varchar(50),
age varchar(10),
primary key (idClient)
);

create table if not exists Produit (
idProduit int,
nomProduit varchar(100),
produitQte int,
prix int,
primary key (idProduit)
);

create table if not exists Devis (
idDevis int,
dateDevis datetime,
Quantite int,
idCli int,
idProd int,
primary key (idDevis),
constraint fk_client foreign key (idCli) references Client(idClient),
constraint fk_produit foreign key (idProd) references Produit(idProduit)
);