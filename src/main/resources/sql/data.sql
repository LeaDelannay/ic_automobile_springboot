
drop table if exists Contrat;
drop table if exists Client;
drop table if exists Article;


#------------------------------------------------------------
# Table: Contrat
#------------------------------------------------------------

CREATE TABLE Contrat(
        id_contrat Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        marge      Float NOT NULL
	,CONSTRAINT Contrat_PK PRIMARY KEY (id_contrat)
);

INSERT INTO `contrat` (`id_contrat`, `nom`, `marge`) VALUES
(NULL, 'cc5', '5'),
(NULL, 'cc10', '10'),
(NULL, 'cc15', '15'),
(NULL, 'cc20', '20'),
(NULL, 'cc25', '25');

#------------------------------------------------------------
# Table: Client
#------------------------------------------------------------

CREATE TABLE Client(
        id_client  Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        adresse    Varchar (255) NOT NULL ,
        email      Varchar (50) NOT NULL ,
        token      Varchar (255) NOT NULL ,
        id_contrat Int NOT NULL
	,CONSTRAINT Client_PK PRIMARY KEY (id_client)

	,CONSTRAINT Client_Contrat_FK FOREIGN KEY (id_contrat) REFERENCES Contrat(id_contrat)
);

INSERT INTO `client` (`id_client`, `nom`, `adresse`, `email`, `token`, `id_contrat`) VALUES
(NULL, 'client1', '2 rue de machin 33700 Mérignac', 'client1@ici.fr', 'token1', '1'),
(NULL, 'client2', '155 rue de bidule 75000 Paris', 'client2@ici.fr', 'token2', '2'),
(NULL, 'client3', '23 avenue du truc vert 64500 Saint-Jean-De-Luz', 'client3@ici.fr', 'token3', '3'),
(NULL, 'client4', 'adresse', 'client4@ici.fr', 'token4', '4'),
(NULL, 'client5', 'adresse', 'client5@ici.fr', 'token5', '5');

#------------------------------------------------------------
# Table: Article
#------------------------------------------------------------

CREATE TABLE Article(
        id_article Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        montant    Float NOT NULL
	,CONSTRAINT Article_PK PRIMARY KEY (id_article)
);

INSERT INTO `article` (`id_article`, `nom`, `montant`) VALUES
(NULL, 'Injecteur', '200'),
(NULL, 'Filtre à huile', '3'),
(NULL, 'Disque de frein', '25'),
(NULL, 'Radar de recul', '60'),
(NULL, 'Balai d essuie-glace avant', '15'),
(NULL, 'Moteur d essuie-glace avant', '85'),
(NULL, 'Poulie roue libre', '25'),
(NULL, 'Kit de réparation différentiel', '120'),
(NULL, 'Suspension, corps de l essieu', '18'),
(NULL, 'Rotule de suspension ', '30');



#------------------------------------------------------------
# Table: tva
#------------------------------------------------------------

CREATE TABLE tva(
        id_tva  Int  Auto_increment  NOT NULL ,
        montant Float NOT NULL
	,CONSTRAINT tva_PK PRIMARY KEY (id_tva)
);

INSERT INTO `tva` (`id_tva`, `montant`) VALUES
(NULL, '20'),
(NULL, '10'),
(NULL, '5.5'),
(NULL, '2.1');

#------------------------------------------------------------
# Table: client_article
#------------------------------------------------------------

CREATE TABLE client_article(
        id_article Int NOT NULL ,
        id_client  Int NOT NULL
	,CONSTRAINT client_article_PK PRIMARY KEY (id_article,id_client)

	,CONSTRAINT client_article_Article_FK FOREIGN KEY (id_article) REFERENCES Article(id_article)
	,CONSTRAINT client_article_Client0_FK FOREIGN KEY (id_client) REFERENCES Client(id_client)
);

INSERT INTO `client_article` (`id_article`, `id_client`) VALUES
('1', '1'),
('2', '2'),
('5', '1'),
('8', '1'),
('4', '2'),
('10', '2'),
('7', '2'),
('3', '3'),
('7', '3'),
('9', '4'),
('1', '5'),
('4', '5'),
('8', '5');
