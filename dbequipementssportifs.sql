drop table if exists lignecommande;
drop table if exists image;
drop table if exists disponible;
drop table if exists disponibleEnCouleur;
drop table if exists TranslationArticle;
drop table if exists TranslationCategorie;
drop table if exists TranslationCouleur;
drop table if exists Taille;
drop table if exists Langage;
drop table if exists Couleur;
drop table if exists typearticle;
drop table if exists categoriearticle;
drop table if exists commande;
drop table if exists client;

CREATE TABLE `client` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `authorities` varchar(500) NOT NULL,
  `non_expired` tinyint(1) NOT NULL,
  `non_locked` tinyint(1) NOT NULL,
  `credentials_non_expired` tinyint(1) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(320) NOT NULL unique,
  `localite` varchar(45) NOT NULL,
  `rue` varchar(45) NOT NULL,
  `codepostal` int(9) NOT NULL,
  `numtelephone` int(13) DEFAULT NULL,
  `dateNaissance` date NOT NULL,
  `isMale` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`),
  check (`codePostal` > 0)
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
	`ID`	INT(9) not null auto_increment,
    primary key (`ID`)
) ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=utf8;

CREATE TABLE `Langage` (
	`langageID`		varchar(6) not null,
    primary key (`langageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `commande` (
  `numTicket` int(9) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL,
  `username_fk` varchar(50) NOT NULL,
  PRIMARY KEY (`numTicket`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username_fk`) REFERENCES `client` (`username`)
) ENGINE=InnoDB auto_increment=1 DEFAULT CHARSET=utf8;

CREATE TABLE `typearticle` (
  `codeBarre` int(9) NOT NULL auto_increment,
  `prix` double NOT NULL,
  `id_categorie_fk` int(9) NOT NULL,
  PRIMARY KEY (`codeBarre`),
  CONSTRAINT `fk_categorie` FOREIGN KEY (`id_categorie_fk`) REFERENCES `categoriearticle` (`id`),
  check (`prix` >=0)
) ENGINE=InnoDB auto_increment=1 CHARSET=utf8;

CREATE TABLE `image` (
  `url` 			varchar(200) NOT NULL,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`url`),
  CONSTRAINT `FK_CodeBarre_img` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Disponible` (
  `Id`	int(9) NOT NULL AUTO_INCREMENT,
  `taille_fk`		varchar(4) not null,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_taille` FOREIGN KEY (`taille_fk`) REFERENCES `Taille` (`tailleArticle`),
  CONSTRAINT `fk_codeBarre_Dispo` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `DisponibleEnCouleur` (
  `Id`	int(9) not null AUTO_INCREMENT,
  `couleur_fk`		INT(9) not null,
  `codeBarre_fk`	INT(9) not null,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_couleur` FOREIGN KEY (`couleur_fk`) REFERENCES `Couleur` (`id`),
  CONSTRAINT `fk_codeBarre_DispoCouleur` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB auto_increment=1 default CHARSET=utf8;

CREATE TABLE `TranslationArticle` (
	`langageID_FK`	varchar(6) not null,
    `codeBarre_FK` 	INT(9) not null,
    `libelle`		varchar(200) not null,
    `description`	varchar(400) not null,
    primary key (`langageID_FK`, `codeBarre_FK`),
	CONSTRAINT `fk_langageID_Article` FOREIGN KEY (`langageID_FK`) REFERENCES `Langage` (`langageID`),
	CONSTRAINT `fk_codeBarre_TranslationArticle` FOREIGN KEY (`codeBarre_FK`) REFERENCES `typearticle` (`codeBarre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TranslationCategorie` (
	`langageID_FK`	varchar(6) not null,
    `idCategorie_FK` 	INT(9) not null,
    `libelle`		varchar(200) not null,
    primary key (`langageID_FK`, `idCategorie_FK`),
	CONSTRAINT `fk_langageID_Categorie` FOREIGN KEY (`langageID_FK`) REFERENCES `Langage` (`langageID`),
	CONSTRAINT `fk_idCategorie_TranslationArticle` FOREIGN KEY (`idCategorie_FK`) REFERENCES `categoriearticle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `TranslationCouleur` (
	`langageID_FK`	varchar(6) not null,
    `idCouleur_FK` 	INT(9) not null,
    `libelle`		varchar(200) not null,
    primary key (`langageID_FK`, `idCouleur_FK`),
	CONSTRAINT `fk_langageID_Couleur` FOREIGN KEY (`langageID_FK`) REFERENCES `Langage` (`langageID`),
	CONSTRAINT `fk_idCouleur_TranslationCouleur` FOREIGN KEY (`idCouleur_FK`) REFERENCES `Couleur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lignecommande` (
  `quantite`		int(9) not null,
  `prixReel`		double not null,
  `codeBarre_fk`	int(9) not null,
  `numTicket_fk`	int(9) not null,
  `taille_fk`		varchar(4),
  `couleur_fk`		int(9),
  PRIMARY KEY (`codeBarre_fk`, `numTicket_fk`),
  CONSTRAINT `fk_codeBarre_commande` FOREIGN KEY (`codeBarre_fk`) REFERENCES `typearticle` (`codeBarre`),
  CONSTRAINT `fk_numTicket` FOREIGN KEY (`numTicket_fk`) REFERENCES `commande` (`numTicket`),
  CONSTRAINT `fk_taille_ligneCommande` FOREIGN KEY (`taille_fk`) REFERENCES `taille` (`tailleArticle`),
  CONSTRAINT `fk_couleur_ligneCommande` FOREIGN KEY (`couleur_fk`) REFERENCES `couleur` (`ID`),
  check (`quantite` > 0),
  check (`prixReel` >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dbequipementssportifs`.`client`
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

INSERT INTO `dbequipementssportifs`.`langage`
(`langageID`)
VALUES
('fr'), ('en');

INSERT INTO `dbequipementssportifs`.`categoriearticle`
(`id`,
`url_image`)
VALUES
(null, '/images/categories/musculation.jpg'),
(null, '/images/categories/course.jpg'),
(null, '/images/categories/velo.jpg'),
(null, '/images/categories/randonnee.jpg'),
(null, '/images/categories/football.jpg'),
(null, '/images/categories/boxeAnglaise.jpg'),
(null, '/images/categories/natation.jpg'),
(null, '/images/categories/tennis.jpeg'),
(null, '/images/categories/yoga.jpg'),
(null, '/images/categories/kayak.jpg'),
(null, '/images/categories/escrime.jpg'),
(null, '/images/categories/airsoft.jpg');

INSERT INTO `dbequipementssportifs`.`commande`
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
(null, 5.99, 6),
(null, 19.99, 1),
(null, 23.59, 7),
(null, 27.59, 7),
(null, 75.99, 8),
(null, 19.99, 8),
(null, 9.99, 9),
(null, 4.99, 9),
(null, 269.99, 10),
(null, 7.99, 10),
(null, 49.99, 11),
(null, 29.99, 11),
(null, 249.99, 12),
(null, 4.99, 12),
(null, 4.99, 12),
(null, 49.99, 4),
(null, 39.99, 6),
(null, 29.99, 1),
(null, 59.99, 1),
(null, 44.99, 1),
(null, 7.99, 1),
(null, 249.99, 11),
(null, 109.99, 11),
(null, 4.99, 9),
(null, 29.99, 9),
(null, 14.99, 10),
(null, 23.99, 10),
(null, 59.99, 8),
(null, 19.99, 8),
(null, 21.99, 7),
(null, 14.99, 7),
(null, 1.99, 5),
(null, 6.99, 5),
(null, 24.99, 6),
(null, 39.99, 6),
(null, 169.99, 4),
(null, 79.99, 4),
(null, 24.99, 3),
(null, 39.99, 3),
(null, 19.99, 2),
(null, 17.99, 2),
(null, 129.99, 12),
(null, 69.99, 12);

INSERT INTO `dbequipementssportifs`.`image`
(`url`,
`codeBarre_fk`)
VALUES
('/images/articles/t-shirtHomme.jpg', 2),
('/images/articles/t-shirtHomme_Bleu.jpg', 2),
('/images/articles/benchPress.jpg', 1),
('/images/articles/basicbenchPress.jpg', 3),
('/images/articles/chaussureCourse.jpg', 4),
('/images/articles/vttNoir.png', 5),
('/images/articles/vttBlanc.jpg', 5),
('/images/articles/veloRoute.png', 6),
('/images/articles/chaussureMarche.jpg', 7),
('/images/articles/balle.jpg', 8),
('/images/articles/chaussureCrampons.jpg', 9),
('/images/articles/casqueBoxeNoir.jpg', 10),
('/images/articles/casqueBoxeRouge.jpg', 10),
('/images/articles/bandesBoxe.jpg', 11),
('/images/articles/veloRouteV2.jpg', 6),
('/images/articles/haltere20Kg.jpg', 12),
('/images/articles/maillotHomme.jpg', 13),
('/images/articles/maillotFemme.jpg', 14),
('/images/articles/raquette.jpg', 15),
('/images/articles/lotBalles.jpg', 16),
('/images/articles/tapisYoga.jpg', 17),
('/images/articles/briqueYoga.jpg', 18),
('/images/articles/kayakRivière.jpg', 19),
('/images/articles/pagaie.jpg', 20),
('/images/articles/pagaieEntière.jpg', 20),
('/images/articles/fleuret.jpg', 21),
('/images/articles/casqueEscrime.jpg', 22),
('/images/articles/FNScarHNoir.jpg', 23),
('/images/articles/FNScarHNoirV2.jpg', 23),
('/images/articles/billesBio.jpg', 24),
('/images/articles/billes.jpg', 25),
('/images/articles/batonMarcheNoir.jpg', 26),
('/images/articles/batonMarcheRose.jpg', 26),
('/images/articles/gantsBoxeRouge.jpg', 27),
('/images/articles/gantsBoxeBleu.jpg', 27),
('/images/articles/tapisDomyosNoir.jpg', 28),
('/images/articles/barreDeTraction.jpg', 29),
('/images/articles/barresParalleles.jpg', 30),
('/images/articles/DebardeurCrossTrainingBlanc.jpg', 31),
('/images/articles/DebardeurCrossTrainingBleu.jpg', 31),
('/images/articles/vesteAllstarEcostarHomme.jpg', 32),
('/images/articles/chaussuresAdidaDartagnan.jpg', 33),
('/images/articles/SangleYogaEnCotonÉcru.jpg', 34),
('/images/articles/LeggingRéversibleYOGAFemmeNoir.jpg', 35),
('/images/articles/LeggingRéversibleYOGAFemmeOlive.jpg', 35),
('/images/articles/ShortKayak.jpg', 36),
('/images/articles/ShortyDébardeurFemmeNopreneBleu.jpg', 37),
('/images/articles/ShortyDébardeurFemmeNopreneGris.jpg', 37),
('/images/articles/sacSportRaquetteWilson.jpg', 38),
('/images/articles/ChaussuresTennisBleuMarinne.jpg', 39),
('/images/articles/ChaussuresTennisBleu.jpg', 39),
('/images/articles/ChaussuresTennisNoir.jpg', 39),
('/images/articles/ChaussuresTennisBlanc.jpg', 39),
('/images/articles/lunetteNatation.jpg', 40),
('/images/articles/BonnetNatation.jpg', 41),
('/images/articles/chaussetteFootballBlanches.jpg', 42),
('/images/articles/chaussetteFootballBleues.jpg', 42),
('/images/articles/gantGardienOrange.jpg', 43),
('/images/articles/gantGardienBleu.jpg', 43),
('/images/articles/PattesD_OursBoxe.jpg', 44),
('/images/articles/SacDeFrappe.jpg', 45),
('/images/articles/TenteTrekRandonnee.jpg', 46),
('/images/articles/SacADosTreckingRandonnee.jpg', 47),
('/images/articles/CasqueVTTJaune.jpg', 48),
('/images/articles/CasqueVTTNoir.jpg', 48),
('/images/articles/lunetteVéloNoir.jpg', 49),
('/images/articles/lunetteVéloBlanches.jpg', 49),
('/images/articles/CuissardCourseNoir.jpg', 50),
('/images/articles/VesteCourse.jpg', 51),
('/images/articles/vesteCamouflageAirsoft.jpg', 52),
('/images/articles/pantalonCamouflageAirsoft.jpg', 53);

INSERT INTO `dbequipementssportifs`.`taille`
(`tailleArticle`)
VALUES
('S'), ('M'), ('L'), ('XL'), ('XXL'), ('38'),('39'),('40'), ('41'), ('42'), ('43'), ('44'), ('45');

INSERT INTO `dbequipementssportifs`.`couleur`
(`id`)
VALUES
(null), (null), (null), (null), (null), (null), (null), (null), (null), (null);

INSERT INTO `dbequipementssportifs`.`TranslationCouleur`
(`langageID_FK`,
`idCouleur_FK`,
`libelle`)
values
('fr', 1, 'Rouge'), ('en', 1, 'Red'),
('fr', 2, 'Bleu'), ('en', 2, 'Blue'),
('fr', 3, 'Blanc'), ('en', 3, 'White'),
('fr', 4, 'Bleu foncé'), ('en', 4, 'Dark blue'),
('fr', 5, 'Rose'), ('en', 5, 'Pink'),
('fr', 6, 'Noir'), ('en', 6, 'Black'),
('fr', 7, 'Olive'), ('en', 7, 'Olive'),
('fr', 8, 'Gris'), ('en', 8, 'Grey'),
('fr', 9, 'Orange'), ('en', 9, 'Orange'),
('fr', 10, 'Jaune'), ('en', 10, 'Jaune');

INSERT INTO `dbequipementssportifs`.`disponible`
(`Id`,
`taille_fk`,
`codeBarre_fk`)
VALUES
(null, 'S', 2), (null,'M', 2), (null,'L', 2),
(null,'38', 9),(null,'39', 9),(null,'40', 9),(null,'41', 9),(null,'42', 9), (null,'43', 9), (null,'44', 9), (null,'45', 9),
(null,'38', 4),(null,'39', 4),(null,'40', 4),(null,'41', 4),(null,'42', 4), (null,'43', 4), (null,'44', 4), (null,'45', 4),
(null,'S', 10), (null,'M', 10), (null,'L', 10),
(null,'38', 7),(null,'39', 7),(null,'40', 7),(null,'41', 7),(null,'42', 7), (null,'43', 7), (null,'44', 7), (null,'45', 7),
(null,'S', 13), (null,'M', 13), (null,'L', 13),
(null,'S', 14), (null,'M', 14), (null,'L', 14),
(null,'S', 22), (null,'M', 22),
(null,'S', 27), (null,'M', 27),
(null,'S', 30), (null,'M', 30), (null,'L', 30),
(null,'S', 31), (null,'M', 31), (null,'L', 31),
(null,'43', 32), (null,'44', 32), (null,'45', 32),
(null,'38', 33), (null,'39', 33), (null,'40', 33),
(null,'S', 35), (null,'M', 35), (null,'L', 35),
(null,'S', 36), (null,'M', 36), (null,'L', 36),
(null,'S', 37), (null,'M', 37), (null,'L', 37),
(null,'38', 39), (null,'39', 39), (null,'40', 39), (null,'41', 39), (null,'42', 39), (null,'43', 39), (null,'44', 39), (null,'45', 39),
(null,'M', 41), (null,'L', 41),
(null,'S', 42), (null,'M', 42), (null,'L', 42),
(null,'S', 43), (null,'M', 43), (null,'L', 43),
(null,'S', 47), (null,'M', 47), (null,'L', 47),
(null,'M', 48), (null,'L', 48),
(null,'S', 50), (null,'M', 50), (null,'L', 50),
(null,'S', 51), (null,'M', 51), (null,'L', 51),
(null,'S', 52), (null,'M', 52), (null,'L', 52), (null,'XL', 52), (null,'XXL', 52),
(null,'S', 53), (null,'M', 53), (null,'L', 53), (null,'XL', 53), (null,'XXL', 53);

INSERT INTO `dbequipementssportifs`.`disponibleencouleur`
(`Id`,
`couleur_fk`,
`codeBarre_fk`)
VALUES
(null, 4, 2), (null, 2, 2),
(null, 1, 10), (null, 6, 10),
(null, 6, 5), (null, 3, 5),
(null, 1, 11), (null, 2, 11), (null, 6, 11),
(null, 5, 26), (null, 6, 26),
(null, 1, 27), (null, 2, 27),
(null, 3, 31), (null, 2, 31),
(null, 6, 35), (null, 7, 35),
(null, 2, 37), (null, 8, 37),
(null, 4, 39), (null, 2,39), (null, 6,39), (null, 3, 39),
(null, 3, 42), (null, 4, 42),
(null, 9, 43), (null, 2, 43),
(null, 10, 48), (null, 6, 48),
(null, 6, 49), (null, 3, 49);


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
('fr', 6, 'Boxe anglaise'), ('en', 6, 'Boxing'),
('fr', 7, 'Natation'), ('en', 7, 'Swimming'),
('fr', 8, 'Tennis'), ('en', 8, 'Tennis'),
('fr', 9, 'Yoga'), ('en', 9, 'Yoga'),
('fr', 10, 'Kayak'), ('en', 10, 'Kayak'),
('fr', 11, 'Escrime'), ('en', 11, 'Fencing'),
('fr', 12, 'Airsoft'), ('en', 12, 'Airsoft');

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
('fr', 11, 'Bande poignet', 'Bandes pour poignet élastiques protégeant efficacement les poignets et les phalanges. Attention : Combatre n\'est pas un jeu.'), ('en', 11, 'Wrist bands', 'Elastic wrist bands effectively protect wrists and knuckles. Warning: Combatre is not a game'),
('fr', 12, 'Haltere 20Kg', 'Conçu pour la musculation et les entraînements fonctionnels type cross training. Idéal pour la préparation physique. L\'haltère polyvalent, pour les mouvements de musculation et les exercices fonctionnels (type pompe).'), ('en', 12, 'Dumbbell', 'Designed for weight training and functional training like cross training. Ideal for physical preparation. The versatile dumbbell, for bodybuilding movements and functional exercises (pump type).'),
('fr', 13, 'Maillot homme', 'Conçu pour Le nageur confirmé qui progresse et qui a besoin de maintien et de liberté de mouvements. Maillot très résistant au chlore. Sa doublure et son cordon de serrage intérieurs offriront un confort maximal et un ajustement parfait.'), ('en', 13, 'Man swimsuit', 'Designed for advanced swimmers who are progressing and in need of support and freedom of movement. Jersey very resistant to chlorine. The interior lining and drawcord provide maximum comfort and a perfect fit.'),
('fr', 14, 'Maillot femme', 'Conçu pour la nageuse confirmée qui progresse et qui a besoin de maintien et de liberté de mouvements. Un maillot de bain de natation très résistant au chlore, avec une coupe dégagée pour une grande liberté de mouvements.'), ('en', 14, 'Women swimsuit', 'Designed for the advanced swimmer who is progressing and in need of support and freedom of movement. A swimsuit swimming very resistant to chlorine, with a clear cut for a great freedom of movement.'),
('fr', 15, 'Raquette', 'Conçu pour le joueur de tennis expert à la recherche de puissance et de maniabilité. Jouer en puissance, maîtriser le jeu. Raquette à la fois puissante et plus légère pour une meilleure maniabilité.'), ('en', 15, 'Racket', 'Designed for the expert tennis player looking for power and maneuverability. Play power, master the game. Racket both powerful and lighter for better maneuverability.'),
('fr', 16, 'Lot de balles', 'Conçu pour le joueur de tennis recherchant une balle d\'entraînement convenant aussi en compétition. Balles munies d\'un colorant spécial donnant un jaune plus visible.'), ('en', 16, 'Batch of balls', 'Designed for the tennis player looking for a suitable training ball also in competition. Balls with a special dye giving a more visible yellow.'),
('fr', 17, 'Tapis', 'Le tapis de yoga premier prix pour débuter un yoga doux, léger et facile à transporter, sans PVC.'), ('en', 17, 'Mat', 'The first price yoga mat to start a soft, light and easy to carry yoga, without PVC.'),
('fr', 18, 'Brique', 'Une aide précieuse aux postures ! Légère et douce , pratique à emmener au cours de yoga , pour l\'assise ou les postures.'), ('en', 18, 'Brick', 'A precious help to postures! Light and gentle, convenient to take to yoga class, for sitting or postures.'),
('fr', 19, 'Kayak de rivière', 'Conçu spécialement pour la vitesse ce kayak vous amènera où bon vous semble ! Robuste et élancé vous serez maitre de l\'eau. (Pour nageur aguerri seulement). Uniquement pour les rivières, lacs ou en mer douce.'), ('en', 19, 'River kayak', 'Designed specifically for speed this kayak will take you wherever you want! Robust and slender you will be master of the water. (For experienced swimmer only). Only for rivers, lakes or in the fresh sea.'),
('fr', 20, 'Pagaie', 'Pagaie séparable en 2 destiné aux kayaks de rivière, lac ou de mer douce.'), ('en', 20, 'Paddle', 'Separable paddle in 2 for kayaks of river, lake or soft sea.'),
('fr', 21, 'Fleuret', 'Le fleuret est une arme d’estoc (on touche avec la pointe) et de convention (c’est à dire qu\'il y a un système de priorité dans l\'attribution d’une touche) avec la caractéristique d\'une lame à base carrée.'), ('en', 21, 'Foil', 'The foil is a thrust weapon (one touches with the tip) and conventional (ie there is a priority system in the assignment of a key) with the characteristic of a blade to square base.'),
('fr', 22, 'Masque', 'Indispensable à l\'escrime, le masque vous garantira une protection total de la tête jusqu\'au cou. Disponible en taille enfant ou adulte.'), ('en', 22, 'Mask', 'Essential to fencing, the mask will guarantee total protection from head to neck. Available in child or adult size.'),
('fr', 23, 'FN Scar H Noir', 'Réplique livrée avec une batterie 8.4V/1100mAh, un chargeur de batterie, un chargeur supplémentaire de billes.'), ('en', 23, 'FN Scar H Black', 'Replica comes with a 8.4V / 1100mAh battery, a battery charger, an additional charger of balls.'),
('fr', 24, 'Billes BIO 0.25g', 'Redécouvrez le plaisir de jouer avec une bille airsoft biodégradable haut de gamme dont la finition est étudiée pour toutes les répliques. Elles possèdent une homogénéité élevée dans leurs dimensions et sont adaptées à tous les répliques d\'armes Spring et les AEG standards (800 billes disponibles).'), ('en', 24, 'BIO balls 0.25g', 'Rediscover the pleasure of playing with a premium airsoft biodegradable ball whose finish is studied for all replicas. They have high homogeneity in their dimensions and are suitable for all Spring weapon replicas and standard AEGs (800 balls availables).'),
('fr', 25, 'Billes 0.25g', 'Redécouvrez le plaisir de jouer avec une bille airsoft haut de gamme dont la finition est étudiée pour toutes les répliques. Elles possèdent une homogénéité élevée dans leurs dimensions et sont adaptées à tous les répliques d\'armes Spring et les AEG standards(800 billes disponibles).'), ('en', 25, 'Balles 0.25g', 'Rediscover the pleasure of playing with a high-end airsoft ball whose finish is studied for all replicas. They have high homogeneity in their dimensions and are suitable for all Spring weapon replicas and standard AEGs (800 balls availables).'),
('fr', 26, 'Baton de marche', 'Conçu pour marcher 3 fois par semaine ou plus par tout temps. Performez avec les bâtons de marche nordique Newfeel Propulse Walk 900 qui allient propulsion et légèreté. '), ('en', 26, 'Walking stick', 'Designed for walking 3 times a week or more in any weather. Perform with the Newfeel Propulse Walk 900 Nordic walking sticks that combine propulsion and lightness.'),
('fr', 27, 'Gants de boxe', 'Conçu pour le boxeur expert recherchant un gant en cuir naturel. Le gant en cuir qui résiste aux entraînements intensifs. '), ('en', 27, 'Boxing gloves', 'Designed for the expert boxer looking for a natural leather glove. The leather glove that resists intensive training.'),
('fr', 28, 'Tapis Domyos', 'Tapis de protection à mettre sous votre matériel de fitness cardio pour protèger efficacement votre sol et diminuer le bruit lors de votre pratique.'), ('en', 28, 'Domyos mat', 'Protective mats to put under your cardio fitness equipment to effectively protect your floor and reduce noise during your practice.'),
('fr', 29, 'Barre de traction', 'Conçu pour se muscler le haut du corps. Variez l\'écartement et la position des mains pour les tractions en pronation ou en supination, prises larges, serrés et marteau. Pour une stabilité maximum, ancrez le produit sur un mur porteur.'), ('en', 29, 'Pull up bar', 'Designed to build your upper body. Vary the spacing and position of the hands for pronation or supine pulls, wide, tight grips and hammer. For maximum stability, anchor the product on a load-bearing wall.'),
('fr', 30, 'Barres parallèles', 'Station d\'entraînement : nomade, compact et complète qui permet de travailler l\'ensemble des muscles au poids, en statique ou en dynamique.'), ('en', 30, 'Parallel bars', 'Training station: nomadic, compact and complete that allows all muscles to work on weight, static or dynamic.'),
('fr', 31, 'Débardeur cross training', 'Débardeur femme de Crosstraining ultra léger et résistant. Il vous permettra d\'être en confort lors de la réalisation de vos WODs et de vos entraînements.'), ('en', 31, 'cross training tank top', 'Crosstraining women\'s tank top ultra light and resistant. It will allow you to be comfortable during the realization of your WODs and your training.'),
('fr', 32, 'Veste Ecostar', 'La veste "Ecostar" FIE 800N vous apportera tout le confort dont vous aurez besoin lors de vos assauts à l\'entrainement ou en compétition, cette veste alliant souplesse et résistance est totalement élastiss. Composition 80% Polyamide 20% Polyester. Lavage Facile'), ('en', 32, 'jacket Ecostar', 'The jacket "Ecostar" FIE 800N will bring you all the comfort that you will need during your assaults in training or in competition, this jacket combining flexibility and resistance is fully elastiss. Composition 80% Polyamide 20% Polyester. Easy wash'),
('fr', 33, 'CHAUSSURES ADIDAS DARTAGNAN IV', 'Une nouvelle version des chaussures d\'escrime classiques avec un design léger et flexible. Allège la chaussure, la semelle extérieure présente une haute résistance à l’usure.'), ('en', 33, 'SHOES ADIDAS DARTAGNAN IV', 'A new version of classic fencing shoes with a lightweight and flexible design. Lighten the shoe, the outsole has a high resistance to wear.'),
('fr', 34, 'Sangle Yoga en coton écru', 'Conçu pour la pratique du yoga. Une aide précieuse à la recherche de souplesse ! Taille : 2,5 mètres - largeur 3,5 cm.'), ('en', 34, 'Yoga strap in ecru cotton', 'Designed for yoga practice. A precious help in search of flexibility! Size: 2.5 meters - width 3.5 cm.'),
('fr', 35, 'Legging Réversible YOGA', 'Envie de changer de legging entre 2 séances de yoga ? Nos yogis l\'ont conçu réversible (uni / imprimé) sans oublier ses autres qualités : opaque, respirant, et maintien de la sangle abdominale !'), ('en', 35, 'YOGA Reversible Legging', 'Want to change leggings between 2 yoga sessions? Our yogis have designed reversible (plain / printed) without forgetting its other qualities: opaque, breathable, and maintaining the abdominal strap!'),
('fr', 36, 'Short Kayak', 'Ce short à la coupe allongée dans le dos permet d’avoir le bas du dos couvert même en position assise. La souplesse du néoprène assure un confort optimal même pour une longue durée de pratique'), ('en', 36, 'Kayak Shorts', 'These shorts with the elongated cut in the back allows to have the lower back covered even in sitting position. The softness of the neoprene ensures optimal comfort even for a long period of practice'),
('fr', 37, 'SHORTY Débardeur KAYAK', 'Ce modèle est conçu pour les sports de pagaie. Il libère les épaules pour faciliter la rame, apporter la thermicité nécessaire en mi saison et disposer d\'une poche zippée.'), ('en', 37, 'Shortly KAYAK Tank', 'This model is designed for paddle sports. It frees the shoulders to facilitate paddling, provide the necessary warmth in mid season and have a zipped pocket.'),
('fr', 38, 'Sac de sport Wilson', 'Ce sac de tennis Wilson FEDERER rouge a la particularité d\'être très léger et propose un design épuré et une bonne protection de vos raquettes et de votre matériel. Il est aussi facile à transporter.'), ('en', 38, 'Wilson sports bag', 'This Wilson FEDERER red tennis bag has the distinction of being very light and offers a clean design and good protection of your rackets and your equipment. It is also easy to carry.'),
('fr', 39, 'Chaussures de tennis homme', 'Chaussure de tennis conçue pour le joueur Débutant, apportant un maximum de confort grâce à sa tige en PU synthétique souple et mesh, et de la résistance sur tout type de terrain grâce à sa semelle.'), ('en', 39, 'Men\'s tennis shoes', 'Tennis shoe designed for the beginner player, providing maximum comfort thanks to its flexible synthetic PU and mesh upper, and resistance on any type of terrain thanks to its sole.'),
('fr', 40, 'Lunettes de natation', 'Lunettes d\'entrainement polyvalentes issues de la technologie Speedo BioFUSE offrant confort maximal, parfaite ergonomie et visibilité.'), ('en', 40, 'Swimming goggles', 'Versatile training goggles from Speedo BioFUSE technology offering maximum comfort, perfect ergonomics and visibility.'),
('fr', 41, 'Bonnet de natation', 'Le bonnet en néoprène pour garder la tête au chaud pendant les sessions de natation en eau libre.'), ('en', 41, 'Swimming cap', 'The neoprene cap to keep your head warm during open water swimming sessions.'),
('fr', 42, 'Chausette de football', 'Pour accompagner les premiers pas de votre enfant sur les terrains de foot, nous avons développé ces chaussettes de football F100 dont le tissage aéré permet au pied de respirer.'), ('en', 42, 'Football sock', 'To accompany the first steps of your child on the football field, we have developed these football socks F100 whose airy weave allows the foot to breathe.'),
('fr', 43, 'Gant de gardien', 'Vous recherchez un gant résistant ? Nous avons développé le gant First avec un revêtement en latex synthétique pour qu\'il s\'abîme moins vite lors des plongeons.'), ('en', 43, 'Guardian\'s glove', 'Looking for a resistant glove? We have developed the First glove with a synthetic latex coating so that it does not go down as quickly as possible when diving.'),
('fr', 44, 'Pattes d\'ours', 'Le parfait accessoire pour le travail des combinaisons de coups ( crochet , direct , uppercut) . Développez votre vitesse et votre précision !'), ('en', 44, 'Bear paws', 'The perfect accessory for working combinations of strokes (hook, direct, uppercut). Develop your speed and accuracy!'),
('fr', 45, 'Sac de frappe', 'Le sac de frappe idéal pour le débutant en boxe anglaise. Sa toile très résistante et ses sangles d’attache permettent de débuter la boxe dans les meilleures conditions sans se blesser.'), ('en', 45, 'Punching bag', 'The ideal punching bag for the beginner in boxing. Its highly resistant canvas and tether straps allow you to start boxing in the best conditions without hurting yourself.'),
('fr', 46, 'Tente trek', 'La plus compacte et légère des tentes de bivouac Quechua pour 3 personnes, montage et démontage rapides. 2 portes. Grande abside frontale (espace de rangement). Ventilation facile et efficace.'), ('en', 46, 'Trekking tent', 'The most compact and lightweight Quechua bivouac tents for 3 people, quick assembly and disassembly. 2 doors. Large frontal apse (storage space). Easy and efficient ventilation.'),
('fr', 47, 'Sac à dos trekking', 'Le sac à dos conçu pour prévenir le risque de pickpocket avec son large zip cadenassable, placé près du dos. Le chapeau se transforme en besace détachable pour amener partout avec vous vos documents.'), ('en', 47, 'Trekking backpack', 'The backpack designed to prevent the risk of pickpocket with its large zip lockable, placed near the back. The hat is transformed into a detachable bag to bring with you your documents everywhere.'),
('fr', 48, 'Casque VTT', 'Ce casque VTT 500 s\'adapte et se laisse oublier grâce à ses mousses intérieures pour plus de confort, ses 21 aérations et sa molette de réglage. Conforme à la norme EN 1078 pour les casques.'), ('en', 48, 'MTB helmet', 'This MTB 500 helmet fits and can be forgotten thanks to its inner foams for comfort, its 21 vents and its adjustment wheel. Complies with the EN 1078 standard for helmets.'),
('fr', 49, 'Lunettes de Vélo', 'Grâce au système de changement rapide de verres et les 4 verres fournies vous pourrez rouler par tous les temps avec la ROADR 900 PACK. Mono écran très large pour un excellent champ de vision.'), ('en', 49, 'Cycling Glasses', 'Thanks to the quick lens change system and the 4 lenses provided you can ride in any weather with the ROADR 900 PACK. Mono very wide screen for an excellent field of vision.'),
('fr', 50, 'Short course', 'Une véritable seconde peau que vous finirez par oublier. Les irritations ne seront plus qu\'un mauvais souvenir avec ce cuissard de running innovant qui n\'a pas de couture à l\'entrejambe.'), ('en', 50, 'Running shorts', 'A real second skin that you will end up forgetting. The irritation will be a bad memory with this innovative running shorts that has no seam in the crotch.'),
('fr', 51, 'Veste de jogging', 'Une veste chaude et respirante grâce à ses empiècements sous les bras. Deux poches zippées pour emmener vos effets personnels.'), ('en', 51, 'Jogging jacket', 'A warm and breathable jacket thanks to its underarm panels. Two zipped pockets to take your belongings.'),
('fr', 52, 'Veste de camouflage', 'Veste imperméable, respirante et chaude. Tissu silencieux et résistant. Veste idéale pour les sorties en fin de saison, de 10° à 0°C en statique et jusqu\'à -5 / -10°C en situation active.'), ('en', 52, 'Camouflage jacket', 'Waterproof jacket, breathable and warm. Silent and resistant fabric. Ideal jacket for late-season outings, from 10 ° to 0 ° C in static and up to -5 / -10 ° C in active situation.'),
('fr', 53, 'Pantalon de camouflage', 'Ce pantalon de combinaison de chasse arbore le nouveau camouflage exclusif Cressi. Il apporte mimétisme, discrétion et confort sous l\'eau, avec sa coupe préformée et ses renforts sur les genoux.'), ('en', 53, 'Camouflage trousers', 'These hunting overalls sport the new Cressi exclusive camouflage. It brings mimicry, discretion and comfort under water, with its preformed cut and reinforcements on the knees.');

INSERT INTO `dbequipementssportifs`.`lignecommande`
(`quantite`,
`prixReel`,
`codeBarre_fk`,
`numTicket_fk`)
VALUES
(20, 130.99, 1, 1);


