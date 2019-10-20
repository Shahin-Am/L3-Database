{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf100
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- phpMyAdmin SQL Dump\
-- version 4.8.5\
-- https://www.phpmyadmin.net/\
--\
-- Host: localhost:8889\
-- Generation Time: May 12, 2019 at 03:49 PM\
-- Server version: 5.7.25\
-- PHP Version: 7.3.1\
\
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";\
SET time_zone = "+00:00";\
\
--\
-- Database: `Projet_BDD`\
--\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Admin`\
--\
\
CREATE TABLE `Admin` (\
  `Id` varchar(11) NOT NULL,\
  `password_admin` varchar(32) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `Admin`\
--\
\
INSERT INTO `Admin` (`Id`, `password_admin`) VALUES\
('admin', '123');\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Assister`\
--\
\
CREATE TABLE `Assister` (\
  `Code_Cours` int(11) NOT NULL,\
  `Matricule_Etudiant` int(11) NOT NULL,\
  `Note_DE` float NOT NULL,\
  `Note_TP` float NOT NULL,\
  `Note_Projet` float NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `Assister`\
--\
\
INSERT INTO `Assister` (`Code_Cours`, `Matricule_Etudiant`, `Note_DE`, `Note_TP`, `Note_Projet`) VALUES\
(3333, 1, 12, 13, 14);\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Contact`\
--\
\
CREATE TABLE `Contact` (\
  `Numero_Contact` char(10) NOT NULL,\
  `Nom_Contact` varchar(30) NOT NULL,\
  `Prenom_Contact` varchar(30) NOT NULL,\
  `Adresse_Contact` varchar(30) NOT NULL,\
  `Code_Postal_Contact` char(5) NOT NULL,\
  `Ville_Contact` varchar(30) NOT NULL,\
  `Telephone_Contact` char(10) NOT NULL,\
  `Email_Contact` varchar(10) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Contacter`\
--\
\
CREATE TABLE `Contacter` (\
  `Matricule_Etudiant` int(11) NOT NULL,\
  `Numero_Contact` char(10) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Cours`\
--\
\
CREATE TABLE `Cours` (\
  `Code_Cours` int(11) NOT NULL,\
  `Nom_Cours` varchar(30) NOT NULL,\
  `Description_Cours` text NOT NULL,\
  `Promo_Cours` int(11) NOT NULL,\
  `Coeff_Cours` float NOT NULL,\
  `Pourcentage_DE` float NOT NULL,\
  `Pourcentage_TP` float NOT NULL,\
  `Pourcentage_Projet` float NOT NULL,\
  `Matricule_Prof` int(11) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `Cours`\
--\
\
INSERT INTO `Cours` (`Code_Cours`, `Nom_Cours`, `Description_Cours`, `Promo_Cours`, `Coeff_Cours`, `Pourcentage_DE`, `Pourcentage_TP`, `Pourcentage_Projet`, `Matricule_Prof`) VALUES\
(1283, 'Systeme num\'e9rique', 'On dit num\'e9rique une information qui se pr\'e9sente sous forme de nombres associ\'e9s \'e0 une indication de la grandeur \'e0 laquelle ils s\\'appliquent, permettant les calculs, les statistiques, la v\'e9rification des mod\'e8les math\'e9matiques. Num\'e9rique s\\'oppose \'e0 analogique.', 2021, 2, 0.5, 0.3, 0.2, 1),\
(2222, 'Maths', 'alg\'e8bre', 2022, 3, 0.7, 0.2, 0.1, 1),\
(3333, 'Francais', 'PTDR', 2020, 2, 0.4, 0.2, 0.4, 1);\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Etudiant`\
--\
\
CREATE TABLE `Etudiant` (\
  `Matricule_Etudiant` int(11) NOT NULL,\
  `Nom_Etudiant` varchar(30) NOT NULL,\
  `Prenom_Etudiant` varchar(30) NOT NULL,\
  `Adresse` varchar(30) DEFAULT NULL,\
  `Code_Postale` char(5) DEFAULT NULL,\
  `Ville` varchar(30) DEFAULT NULL,\
  `Telephone` char(50) DEFAULT NULL,\
  `Email` varchar(50) DEFAULT NULL,\
  `Promo` int(10) DEFAULT NULL,\
  `password_Etudiant` int(11) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `Etudiant`\
--\
\
INSERT INTO `Etudiant` (`Matricule_Etudiant`, `Nom_Etudiant`, `Prenom_Etudiant`, `Adresse`, `Code_Postale`, `Ville`, `Telephone`, `Email`, `Promo`, `password_Etudiant`) VALUES\
(1, 'Guillaume', 'Heriksen', 'All\'e9e Victor Hugo', '34700', 'Lod\'e8ve', '0643987014', 'g.heriksen@outlook.com', 2023, 123),\
(2, 'Alice', 'abadi', '3 Boulevard Elancourt', '95500', 'Elancourt', '0943995436', 'abadi_@gmail.com', 2020, 123),\
(3, 'Jean', 'Dujardin', '44 Rue des \'e9toiles', '44390', 'Toucan', '0644234911', 'etoile@gmail.com', 2022, 123),\
(4, 'Alexandre', 'Da Costa', '29 Rue du printemps', '94300', 'Vitry', '0632495539', 'alex94@hotmail.com', 2021, 123),\
(5, 'Le Bricoleur', 'Bob', '32 Boulevard de la patinoire', '43900', 'Bouzol', '0788354129', 'bobi@gmail.com', 2022, 123),\
(6, 'Alberici', 'Ma\'ebva', '4 chemin du Moulin', '43000', 'Clermont', '0639548812', 'maeva_cl@gmail.com', 2023, 123),\
(7, 'Gener', 'Chlo\'e9', 'All\'e9e de la R\'e9publique', '77600', 'Bussy-Saint-George', '0634885621', 'gener_chloe@gmail.com', 2020, 123);\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Identite`\
--\
\
CREATE TABLE `Identite` (\
  `Date_Naissance` varchar(10) NOT NULL,\
  `Ville_Naissance` varchar(30) NOT NULL,\
  `Pays_Naissance` varchar(10) NOT NULL,\
  `Sexe` char(5) NOT NULL,\
  `Photo` blob NOT NULL,\
  `Matricule_Etudiant` int(11) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
-- --------------------------------------------------------\
\
--\
-- Table structure for table `Professeurs`\
--\
\
CREATE TABLE `Professeurs` (\
  `Matricule_Prof` int(11) NOT NULL,\
  `Nom_Prof` varchar(30) NOT NULL,\
  `Prenom_Prof` varchar(30) NOT NULL,\
  `Adresse_Prof` varchar(30) NOT NULL,\
  `Code_Postal_Prof` char(5) NOT NULL,\
  `Ville_Prof` varchar(30) NOT NULL,\
  `Telephone_Prof` char(10) NOT NULL,\
  `Email_Prof` varchar(254) NOT NULL,\
  `password` varchar(32) NOT NULL\
) ENGINE=InnoDB DEFAULT CHARSET=utf8;\
\
--\
-- Dumping data for table `Professeurs`\
--\
\
INSERT INTO `Professeurs` (`Matricule_Prof`, `Nom_Prof`, `Prenom_Prof`, `Adresse_Prof`, `Code_Postal_Prof`, `Ville_Prof`, `Telephone_Prof`, `Email_Prof`, `password`) VALUES\
(1, 'Nicolas', 'Thibaut', '15 Rue de Villejuif', '94800', 'Villejuif', '0632837492', 'nicolas@gmail.com', '123');\
\
--\
-- Indexes for dumped tables\
--\
\
--\
-- Indexes for table `Admin`\
--\
ALTER TABLE `Admin`\
  ADD PRIMARY KEY (`Id`);\
\
--\
-- Indexes for table `Assister`\
--\
ALTER TABLE `Assister`\
  ADD PRIMARY KEY (`Code_Cours`,`Matricule_Etudiant`),\
  ADD KEY `Assister_Etudiant1_FK` (`Matricule_Etudiant`);\
\
--\
-- Indexes for table `Contact`\
--\
ALTER TABLE `Contact`\
  ADD PRIMARY KEY (`Numero_Contact`);\
\
--\
-- Indexes for table `Contacter`\
--\
ALTER TABLE `Contacter`\
  ADD PRIMARY KEY (`Matricule_Etudiant`,`Numero_Contact`),\
  ADD KEY `Contacter_Contact1_FK` (`Numero_Contact`);\
\
--\
-- Indexes for table `Cours`\
--\
ALTER TABLE `Cours`\
  ADD PRIMARY KEY (`Code_Cours`),\
  ADD KEY `Cours_Professeurs0_FK` (`Matricule_Prof`);\
\
--\
-- Indexes for table `Etudiant`\
--\
ALTER TABLE `Etudiant`\
  ADD PRIMARY KEY (`Matricule_Etudiant`);\
\
--\
-- Indexes for table `Identite`\
--\
ALTER TABLE `Identite`\
  ADD PRIMARY KEY (`Matricule_Etudiant`);\
\
--\
-- Indexes for table `Professeurs`\
--\
ALTER TABLE `Professeurs`\
  ADD PRIMARY KEY (`Matricule_Prof`);\
\
--\
-- Constraints for dumped tables\
--\
\
--\
-- Constraints for table `Assister`\
--\
ALTER TABLE `Assister`\
  ADD CONSTRAINT `Assister_Cours0_FK` FOREIGN KEY (`Code_Cours`) REFERENCES `Cours` (`Code_Cours`),\
  ADD CONSTRAINT `Assister_Etudiant1_FK` FOREIGN KEY (`Matricule_Etudiant`) REFERENCES `Etudiant` (`Matricule_Etudiant`);\
\
--\
-- Constraints for table `Contacter`\
--\
ALTER TABLE `Contacter`\
  ADD CONSTRAINT `Contacter_Contact1_FK` FOREIGN KEY (`Numero_Contact`) REFERENCES `Contact` (`Numero_Contact`),\
  ADD CONSTRAINT `Contacter_Etudiant0_FK` FOREIGN KEY (`Matricule_Etudiant`) REFERENCES `Etudiant` (`Matricule_Etudiant`);\
\
--\
-- Constraints for table `Cours`\
--\
ALTER TABLE `Cours`\
  ADD CONSTRAINT `Cours_Professeurs0_FK` FOREIGN KEY (`Matricule_Prof`) REFERENCES `Professeurs` (`Matricule_Prof`);\
\
--\
-- Constraints for table `Identite`\
--\
ALTER TABLE `Identite`\
  ADD CONSTRAINT `Identite_Etudiant0_FK` FOREIGN KEY (`Matricule_Etudiant`) REFERENCES `Etudiant` (`Matricule_Etudiant`);\
}