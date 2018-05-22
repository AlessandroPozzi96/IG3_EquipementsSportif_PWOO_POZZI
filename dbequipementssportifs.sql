drop table if exists lot;
drop table if exists fournisseur;
drop table if exists elementspanier;
drop table if exists typearticle;
drop table if exists image;
drop table if exists categoriearticle;
drop table if exists panier;
drop table if exists persistable_user;

CREATE TABLE `persistable_user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `authorities` varchar(500) NOT NULL,
  `non_expired` tinyint(1) NOT NULL,
  `non_locked` tinyint(1) NOT NULL,
  `credentials_non_expired` tinyint(1) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(320) NOT NULL,
  `localite` varchar(45) NOT NULL,
  `rue` varchar(45) NOT NULL,
  `codepostal` int(9) NOT NULL,
  `numtelephone` int(13) DEFAULT NULL,
  `dateNaissance` date NOT NULL,
  `isMale` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `fournisseur` (
  `numeroTVA` int(10) NOT NULL,
  `localite` varchar(50) NOT NULL,
  `rue` varchar(50) NOT NULL,
  `codePostal` int(9) NOT NULL,
  `nom` varchar(45) NOT NULL,
  PRIMARY KEY (`numeroTVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `image` (
  `url` varchar(200) NOT NULL,
  `description_fr` varchar(200) NOT NULL,
  `description_en` varchar(200) NOT NULL,
  PRIMARY KEY (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `categoriearticle` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `libelle_fr` varchar(50) NOT NULL,
  `libelle_en` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `panier` (
  `numTicket` int(9) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `username_fk` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numTicket`),
  KEY `fk_username` (`username_fk`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username_fk`) REFERENCES `persistable_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `typearticle` (
  `codeBarre` int(9) NOT NULL,
  `libelle_fr` varchar(50) NOT NULL,
  `libelle_en` varchar(50) NOT NULL,
  `description_fr` varchar(200) NOT NULL,
  `description_en` varchar(200) DEFAULT NULL,
  `prix` double NOT NULL,
  `existeEnPlusieursTailles` tinyint(1) not null, 
  `taille`	char(1) null,
  `id_categorie_fk` int(9) NOT NULL,
  `url_image_fk` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codeBarre`),
  KEY `fk_categorie` (`id_categorie_fk`),
  KEY `fk_image` (`url_image_fk`),
  CONSTRAINT `fk_categorie` FOREIGN KEY (`id_categorie_fk`) REFERENCES `categoriearticle` (`id`),
  CONSTRAINT `fk_image` FOREIGN KEY (`url_image_fk`) REFERENCES `image` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists lot;
CREATE TABLE `lot` (
  `id`				int(9) not null auto_increment, 
  `quantite`		int(10) not null, 
  `dateFourniture`	date null, 
  `dateCommande`	date not null, 
  `numeroTVA_fk` 	int(10) not null, 
  `codeBarre_fk`	int(9) not null,
  PRIMARY KEY (`id`),
  KEY `fk_numeroTVA` (`numeroTVA_fk`),
  KEY `fk_codeBarre_typearticle` (`codeBarre_fk`),
  CONSTRAINT `fk_numeroTVA` FOREIGN KEY (`numeroTVA_fk`) REFERENCES `fournisseur` (`numeroTVA`),
  CONSTRAINT `fk_codeBarre_typearticle` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8;

CREATE TABLE `elementspanier` (
  `quantite`		int(10) not null, 
  `prixReel`		double not null,
  `codeBarre_fk`	int(9) not null,
  `numTicket_fk`	int(9) not null,
  PRIMARY KEY (`codeBarre_fk`, `numTicket_fk`),
  KEY `fk_codeBarre` (`codeBarre_fk`),
  KEY `fk_numTicket` (`numTicket_fk`),
  CONSTRAINT `fk_codeBarre` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`),
  CONSTRAINT `fk_numTicket` FOREIGN KEY (`numTicket_fk`) REFERENCES `panier` (`numTicket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


