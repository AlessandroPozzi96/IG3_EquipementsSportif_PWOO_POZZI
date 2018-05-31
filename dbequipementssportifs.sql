drop table if exists lot;
drop table if exists fournisseur;
drop table if exists elementspanier;
drop table if exists image;
drop table if exists disponible;
drop table if exists disponibleEnCouleur;
drop table if exists TranslationArticle;
drop table if exists TranslationCategorie;
drop table if exists Taille;
drop table if exists Langage;
drop table if exists Couleur;
drop table if exists typearticle;
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

CREATE TABLE `categoriearticle` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `url_image`	varchar(200) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8;

CREATE TABLE `Taille` (
  `tailleArticle`		varchar(4) not null,
  PRIMARY KEY (`tailleArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Couleur` (
	`couleurArticle`	varchar(40) not null,
    `libelle_en`		varchar(40) not null,
    primary key (`couleurArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Langage` (
	`langageID`		varchar(6) not null,
    primary key (`langageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `panier` (
  `numTicket` int(9) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `username_fk` varchar(50) NOT NULL,
  PRIMARY KEY (`numTicket`),
  KEY `fk_username` (`username_fk`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username_fk`) REFERENCES `persistable_user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `typearticle` (
  `codeBarre` int(9) NOT NULL auto_increment,
  `prix` double NOT NULL,
  `id_categorie_fk` int(9) NOT NULL,
  PRIMARY KEY (`codeBarre`),
  KEY `fk_categorie` (`id_categorie_fk`),
  CONSTRAINT `fk_categorie` FOREIGN KEY (`id_categorie_fk`) REFERENCES `categoriearticle` (`id`),
  check (`prix` >=0)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8;

CREATE TABLE `image` (
  `url` 			varchar(200) NOT NULL,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`url`),
  KEY `FK_CodeBarre_img` (`codeBarre_fk`),
  CONSTRAINT `FK_CodeBarre_img` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Disponible` (
  `taille_fk`		char(4) not null,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`taille_fk`, `codeBarre_fk`),
  KEY `fk_taille` (`taille_fk`),
  KEY `fk_codeBarre_Dispo` (`codeBarre_fk`),
  CONSTRAINT `fk_taille` FOREIGN KEY (`taille_fk`) REFERENCES `Taille` (`tailleArticle`),
  CONSTRAINT `fk_codeBarre_Dispo` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `DisponibleEnCouleur` (
  `couleur_fk`		char(40) not null,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`couleur_fk`, `codeBarre_fk`),
  KEY `fk_couleur` (`couleur_fk`),
  KEY `fk_codeBarre_DispoCouleur` (`codeBarre_fk`),
  CONSTRAINT `fk_couleur` FOREIGN KEY (`couleur_fk`) REFERENCES `Couleur` (`couleurArticle`),
  CONSTRAINT `fk_codeBarre_DispoCouleur` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TranslationArticle` (
	`langageID_FK`	varchar(6) not null,
    `codeBarre_FK` 	INT(9) not null,
    `libelle`		varchar(200) not null,
    `description`	varchar(400) not null,
    primary key (`langageID_FK`, `codeBarre_FK`),
	KEY `fk_langageID_Article` (`langageID_FK`),
	KEY `fk_codeBarre_TranslationArticle` (`codeBarre_FK`),
	CONSTRAINT `fk_langageID_Article` FOREIGN KEY (`langageID_FK`) REFERENCES `Langage` (`langageID`),
	CONSTRAINT `fk_codeBarre_TranslationArticle` FOREIGN KEY (`codeBarre_FK`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TranslationCategorie` (
	`langageID_FK`	varchar(6) not null,
    `idCategorie_FK` 	INT(9) not null,
    `libelle`		varchar(200) not null,
    primary key (`langageID_FK`, `idCategorie_FK`),
	KEY `fk_langageID_Categorie` (`langageID_FK`),
	KEY `fk_idCategorie_TranslationArticle` (`idCategorie_FK`),
	CONSTRAINT `fk_langageID_Categorie` FOREIGN KEY (`langageID_FK`) REFERENCES `Langage` (`langageID`),
	CONSTRAINT `fk_idCategorie_TranslationArticle` FOREIGN KEY (`idCategorie_FK`) REFERENCES `categoriearticle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lot` (
  `id`				int(9) not null auto_increment,
  `quantite`		int(10) not null,
  `dateFourniture`	date null,
  `dateCommande`	date not null,
  `numeroTVA_fk` 	int(10) not null,
  `codeBarre_fk`	int(9) not null,
  PRIMARY KEY (`id`),
  KEY `fk_numeroTVA` (`numeroTVA_fk`),
  KEY `fk_codeBarre_lot` (`codeBarre_fk`),
  CONSTRAINT `fk_numeroTVA` FOREIGN KEY (`numeroTVA_fk`) REFERENCES `fournisseur` (`numeroTVA`),
  CONSTRAINT `fk_codeBarre_lot` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`),
  check (`quantite` >= 0)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8;

CREATE TABLE `elementspanier` (
  `quantite`		int(9) not null,
  `prixReel`		double not null,
  `codeBarre_fk`	int(9) not null,
  `numTicket_fk`	int(9) not null,
  PRIMARY KEY (`codeBarre_fk`, `numTicket_fk`),
  KEY `fk_codeBarre_panier` (`codeBarre_fk`),
  KEY `fk_numTicket` (`numTicket_fk`),
  CONSTRAINT `fk_codeBarre_panier` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`),
  CONSTRAINT `fk_numTicket` FOREIGN KEY (`numTicket_fk`) REFERENCES `panier` (`numTicket`),
  check (`quantite` >= 0),
  check (`prixReel` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dbequipementssportifs`.`persistable_user`
(`username`,
`password`,
`authorities`,
`non_expired`,
`non_locked`,
`credentials_non_expired`,
`enabled`,
`nom`,
`prenom`,
`mail`,
`localite`,
`rue`,
`codepostal`,
`numtelephone`,
`dateNaissance`,
`isMale`)
VALUES
('Aless', '$2a$10$Y8dfdYBpUaJwWyPeyZxczOdJ6tIuIMm5Rss7.FVTZ5eRM8uNUBifS', 'ROLE_ADMIN', 1, 1, 1, 1, 'POZZI', 'Alessandro', 'alessandro.pozzi72@gmail.com', 'Falmagne', 'Place du bati', 5500, 473227085, '1996-07-14', 1),
('ConstentinDu06', '$2a$10$NsXhCQOsLGt8x6zZiHKWZuOMah4pWOHHN2B6a5btHOwAx3vT4HuB2', 'ROLE_USER', 1, 1, 1, 1, 'PENEURE', 'Constentin', 'constentin@gmail.com', 'Grenoble', 'Rue du mimosa', 7413, NULL, '2003-07-05', 1);

INSERT INTO `dbequipementssportifs`.`fournisseur`
(`numeroTVA`,
`localite`,
`rue`,
`codePostal`,
`nom`)
VALUES
(0112569874, 'Namur', 'Boulevard du nord', 5000, 'Futur Computer');

INSERT INTO `dbequipementssportifs`.`categoriearticle`
(`id`,
`url_image`)
VALUES
(null, '/images/categories/musculation.jpg'),
(null, '/images/categories/course.jpg'),
(null, '/images/categories/velo.jpg'),
(null, '/images/categories/randonnee.jpg'),
(null, '/images/categories/football.jpg'),
(null, '/images/categories/combat.jpg');

INSERT INTO `dbequipementssportifs`.`panier`
(`numTicket`,
`date`,
`username_fk`)
VALUES
(null, sysdate(), 'Aless');

INSERT INTO `dbequipementssportifs`.`typearticle`
(`codeBarre`,
`prix`,
`id_categorie_fk`)
VALUES
(null, 149.99, 1),
(null, 29.99, 2),
(null, 99.99, 1),
(null, 49.99, 2),
(null, 529.99, 3),
(null, 349.99, 3),
(null, 69.99, 4),
(null, 9.99, 5),
(null, 59.99, 5),
(null, 39.99, 6),
(null, 5.99, 6);

INSERT INTO `dbequipementssportifs`.`image`
(`url`,
`codeBarre_fk`)
VALUES
('/images/articles/t-shirt.jpg', 2),
('/images/articles/benchPress.jpg', 1),
('/images/articles/basicbenchPress.jpg', 3),
('/images/articles/chaussureCourse.jpg', 4),
('/images/articles/vtt.png', 5),
('/images/articles/veloRoute.png', 6),
('/images/articles/chaussureMarche.jpg', 7),
('/images/articles/balle.jpg', 8),
('/images/articles/chaussureCrampons.jpg', 9),
('/images/articles/casque.jpg', 10),
('/images/articles/bandesPoignet.jpg', 11),
('/images/articles/veloRouteV2.jpg', 6);

INSERT INTO `dbequipementssportifs`.`taille`
(`tailleArticle`)
VALUES
('S'), ('M'), ('L'), ('XL'), ('XXL'), ('38'),('39'),('40'), ('41'), ('42'), ('43'), ('44'), ('45');

INSERT INTO `dbequipementssportifs`.`couleur`
(`couleurArticle`,
`libelle_en`)
VALUES
('Rouge', 'Red'), ('Bleu', 'Blue'), ('Noir', 'Black'), ('Blanc', 'White'), ('Vert', 'Green'), ('Jaune', 'Yellow'), ('Brun', 'Brown');


INSERT INTO `dbequipementssportifs`.`disponible`
(`taille_fk`,
`codeBarre_fk`)
VALUES
('S', 2), ('M', 2), ('L', 2),
('38', 9),('39', 9),('40', 9),('41', 9),('42', 9), ('43', 9), ('44', 9), ('45', 9),
('38', 4),('39', 4),('40', 4),('41', 4),('42', 4), ('43', 4), ('44', 4), ('45', 4),
('S', 10), ('M', 10), ('L', 10),
('38', 7),('39', 7),('40', 7),('41', 7),('42', 7), ('43', 7), ('44', 7), ('45', 7);

INSERT INTO `dbequipementssportifs`.`disponibleencouleur`
(`couleur_fk`,
`codeBarre_fk`)
VALUES
('Rouge', 2), ('Bleu', 2), ('Blanc', 2),
('Rouge', 10), ('Bleu', 10),
('Noir', 5), ('Blanc', 5),
('Bleu', 11), ('Rouge', 11);

INSERT INTO `dbequipementssportifs`.`langage`
(`langageID`)
VALUES
('fr'), ('en');


INSERT INTO `dbequipementssportifs`.`translationcategorie`
(`langageID_FK`,
`idCategorie_FK`,
`libelle`)
VALUES
('fr', 1, 'Musculation'), ('en', 1, 'Bodybuilding'),
('fr', 2, 'Course'), ('en', 2, 'Running'),
('fr', 3, 'Vélo'), ('en', 3, 'Bike'),
('fr', 4, 'Randonnée'), ('en', 4, 'Hiking'),
('fr', 5, 'Football'), ('en', 5, 'Soccer'),
('fr', 6, 'Combat'), ('en', 6, 'Fight');

INSERT INTO `dbequipementssportifs`.`translationarticle`
(`langageID_FK`,
`codeBarre_FK`,
`libelle`,
`description`)
VALUES
('fr', 1, 'Banc de développer coucher premium', 'Fait en cuir de haute qualité avec un aspect premium'), ('en', 1, 'Premium bench press', 'Made of high quality leather with a premium look'),
('fr', 2, 'T-shirt sport haute intensité', 'Créer spécialement pour la course, ne se déchire pas après 3 jours'), ('en', 2, 'T-shirt high intensity sport', 'Create especially for the crossfit, do not tear after 3 trainings'),
('fr', 3, 'Banc de développer coucher basique', 'Simple banc de DC pour débutants'), ('en', 3, 'Basic bench press', 'Simple bench press for beginners'),
('fr', 4, 'Chaussures', 'Chaussures de course qui vous permettra de courir plus vite grâce à l\'adhérence de ses semelles !'), ('en', 4, 'Shoes', 'Running shoes that will allow you to run faster thanks to the grip of its soles!'),
('fr', 5, 'VTT', 'VTT conçu pour être robuste, fiable et rapide. Aussi léger qu\'une plume et aussi réisitant que l\'acier !'), ('en', 5, 'ATV', 'ATV designed to be robust, reliable and fast. As light as a plum and as reisiting as steel!'),
('fr', 6, 'Vélo de route', 'Vélo destiné à un public adulte cherchant à pratiquer du vélo de temps en temps ou encore pour se rendre à son lieu de travail'), ('en', 6, 'Road bike', 'Bike for an adult audience seeking to cycle from time to time or to get to their place of work'),
('fr', 7, 'Chaussures de marche', 'Envie d\'une petite balade en montagne ? N\'attendez plus, ces chaussures sont fait pour vous !'), ('en', 7, 'Walking shoes', 'Want a little ride in the mountains? Do not wait, these shoes are for you!'),
('fr', 8, 'Balle', 'Simple balle de foot pour s\'amuser entre amis'), ('en', 8, 'Ball', 'Simple soccer ball to have fun with friends'),
('fr', 9, 'Chaussures à crampons', 'Chaussures destiné à des joueurs de foot aguerri, une fois qu\'on a des crampons, ça ne rigole plus !'), ('en', 9, 'Stud shoes', 'Shoes for seasoned football players, once you have crampons, it does not laugh anymore!'),
('fr', 10, 'Casque', 'Casque de combat protégeant efficacement le nez, les joues, les yeux et le front. Attention : Combattre n\'est pas un jeu.'), ('en', 10, 'Helmet', 'Combat helmet effectively protects the nose, cheeks, eyes and forehead. Warning: Fighting is not a game.'),
('fr', 11, 'Bande poignet', 'Bandes pour poignet élastiques protégeant efficacement les poignets et les phalanges. Attention : Combatre n\'est pas un jeu.'), ('en', 11, 'Wrist bands', 'Elastic wrist bands effectively protect wrists and knuckles. Warning: Combatre is not a game');


INSERT INTO `dbequipementssportifs`.`lot`
(`id`,
`quantite`,
`dateFourniture`,
`dateCommande`,
`numeroTVA_fk`,
`codeBarre_fk`)
VALUES
(null, 1500, null, '2018-02-25', 0112569874, 1);

INSERT INTO `dbequipementssportifs`.`elementspanier`
(`quantite`,
`prixReel`,
`codeBarre_fk`,
`numTicket_fk`)
VALUES
(20, 130.99, 1, 1);


select *
from  persistable_user;


