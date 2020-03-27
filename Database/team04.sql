-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Gegenereerd op: 27 mrt 2020 om 11:54
-- Serverversie: 5.7.29-0ubuntu0.18.04.1
-- PHP-versie: 7.2.28-3+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `team04`
--
CREATE DATABASE IF NOT EXISTS `team04` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `team04`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bezienswaardigheid`
--

CREATE TABLE `bezienswaardigheid` (
  `bezienswaardigheid_id` int(10) NOT NULL,
  `stad` varchar(75) NOT NULL,
  `bezienswaardigheid` varchar(100) NOT NULL,
  `foto` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `bezienswaardigheid`
--

INSERT INTO `bezienswaardigheid` (`bezienswaardigheid_id`, `stad`, `bezienswaardigheid`, `foto`) VALUES
(1, 'Roosendaal', 'Treinstation', 'https://img-brabant.rgcdn.nl/917b4c0de8ca48c9b194cc164da4aa10/opener/Het-treinstation-in-Roosendaal.jpg'),
(2, 'Roosendaal', 'Markt', 'https://monumentje.files.wordpress.com/2012/02/markt-roosendaal.jpg'),
(3, 'Roosendaal', 'Skydiving', 'https://weekend.knack.be/medias/15132/7747881.jpg'),
(4, 'Roosendaal', 'Roselaar', 'https://www.scn.today/wp-content/uploads/2018/03/NL-RO-2016-entree-anvers.jpg');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `boek`
--

CREATE TABLE `boek` (
  `boek_isbn` varchar(20) NOT NULL,
  `boek_naam` varchar(100) NOT NULL,
  `boek_prijs_nieuw` varchar(10) NOT NULL,
  `boek_prijs_oud` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `boek`
--

INSERT INTO `boek` (`boek_isbn`, `boek_naam`, `boek_prijs_nieuw`, `boek_prijs_oud`) VALUES
('9780500513750', 'Manufacturing processes for design professionals', '72,50', NULL),
('9789001712228', 'Zelfmanagement', '29,28', NULL),
('9789001811235', 'E-business', '47,45', '35,71'),
('9789001833961', 'Onderzoek doen! Kwantitatief en kwalitatief onderzoek', '-', NULL),
('9789001836764', 'Elektrotechniek', '66,45', NULL),
('9789001850210', 'Projectmanagement incl. toegang tot Prepzone', '40,80', NULL),
('9789001850241', 'Een praktijkgerichte benadering van organisatie en management incl. toegang tot Prepzone', '89,25', '67,17'),
('9789001863005', 'Salesvaardigheden', '38,90', '29,28'),
('9789001865443', 'De complete professional', '33,20', '24,99'),
('9789001868758', 'Bedrijfskunde de basis incl. toegang tot Prepzone', '68,35', '51,44'),
('9789001868796', 'Zo organiseer je een event', '24,65', '18,55'),
('9789001876746', 'Inleiding administratieve organisatie', '50.30', '37.86'),
('9789001876777', 'Ondernemen met informatie', '49,88', NULL),
('9789001876838', 'Maatschappelijk verantwoord ondernemen', '46,50', '35,00'),
('9789001877156', 'Basisboek interviewen', '27,50', NULL),
('9789001878269', 'Leerboek HRM', '65,50', '49,30'),
('9789001878436', 'Boekhouden geboekstaafd 1', '75,95', '57,16'),
('9789001878450', 'Boekhouden geboekstaafd 1 opgaven', '47.54', '35.71'),
('9789001880590', 'Ontwerpen van technische innovaties', '50,30', '37,86'),
('9789001886271', 'Praktisch fiscaalrecht editie 2018-2019', '52.55', NULL),
('9789001887971', 'Organiseren & managen', '48,40', '36,43'),
('9789001888183', 'Basisboek kwalitatief onderzoek', '56,76', NULL),
('9789001889159', 'Basisboek bedrijfseconomie opgaven', '47.45', '35.71'),
('9789001889173', 'Basisboek bedrijfseconomie', '75.95', '60.06'),
('9789001889654', 'Analyse van de bedrijfsomgeving', '56,06', '41,44'),
('9789001891589', 'Projectmanagement', '37,00', NULL),
('9789001898977', 'Procesmanagement', '47,75', NULL),
('9789001899769', 'Hoofdstukken Sociaal Recht 2019', '52,20', NULL),
('9789001899912', 'Werken met logistiek', '69,30', NULL),
('9789006489224', 'Industriële automatiseringstechnieken', '69,64', NULL),
('9789006950984', 'Bouwproducten', '91,30', '68,72'),
('9789006952407', 'Basisboek communiceren', '63,08', NULL),
('9789013152364', 'Arbeidswetgeving 2019/2020', '26,60', NULL),
('9789024407149', 'Talentenwijzer', '18,95', '14,26'),
('9789024415663', 'Aan de slag met Java en JavaFX', '46,50', '35,00'),
('9789040107528', 'Duikers en sluizen', '-', NULL),
('9789043016735', 'Basisboek wiskunde', '38,90', NULL),
('9789043023283', 'Succesvol studeren communiceren en onderzoeken', '31,30', NULL),
('9789043030229', 'Statica met MyLab NL toegangscode', '68,35', NULL),
('9789043032889', 'Dynamica met MyLab NL toegangscode', '68,35', NULL),
('9789043033602', 'Recruitment', '37,95', '28,56'),
('9789043034067', 'Sterkteleer met MyLab NL', '62,23', NULL),
('9789058754196', 'Producttekenen en -documenteren van 3D naar 2D', '47,98', '36,11'),
('9789058756121', 'Product modelleren met SolidWorks', '46,50', '35,00'),
('9789059316317', 'Mensen, arbeid en organisatie een oriëntatie in de arbeids- en organisatiepsychologie', '52,20', NULL),
('9789059319240', 'Onderzoeken doe je zo!', '28,48', '21,41'),
('9789065623058', 'Materiaalkunde voor ontwerpers en constructeurs', '33,44', NULL),
('9789462156258', 'Het grote gesprekkenboek: een praktische leidraad voor HR-professionals en leidinggevenden', '37,95', NULL),
('9789492095329', 'Stedelijke vraagstukken, veerkrachtige oplossingen', '26,13', NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `boek_opleiding`
--

CREATE TABLE `boek_opleiding` (
  `opleiding_id` int(10) NOT NULL,
  `boek_isbn` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `boek_opleiding`
--

INSERT INTO `boek_opleiding` (`opleiding_id`, `boek_isbn`) VALUES
(5, '9780500513750'),
(7, '9789001712228'),
(9, '9789001712228'),
(3, '9789001811235'),
(3, '9789001833961'),
(5, '9789001836764'),
(9, '9789001850210'),
(2, '9789001850241'),
(9, '9789001850241'),
(3, '9789001863005'),
(3, '9789001865443'),
(3, '9789001868758'),
(9, '9789001868796'),
(2, '9789001876746'),
(3, '9789001876777'),
(3, '9789001876838'),
(7, '9789001877156'),
(7, '9789001878269'),
(2, '9789001878436'),
(2, '9789001878450'),
(5, '9789001880590'),
(2, '9789001886271'),
(3, '9789001887971'),
(9, '9789001888183'),
(2, '9789001889159'),
(2, '9789001889173'),
(3, '9789001889654'),
(3, '9789001891589'),
(9, '9789001891589'),
(3, '9789001898977'),
(7, '9789001899769'),
(8, '9789001899912'),
(5, '9789006489224'),
(4, '9789006950984'),
(9, '9789006952407'),
(7, '9789013152364'),
(7, '9789024407149'),
(1, '9789024415663'),
(4, '9789040107528'),
(5, '9789043016735'),
(4, '9789043023283'),
(5, '9789043023283'),
(5, '9789043030229'),
(5, '9789043032889'),
(7, '9789043033602'),
(5, '9789043034067'),
(5, '9789058754196'),
(5, '9789058756121'),
(7, '9789059316317'),
(7, '9789059319240'),
(5, '9789065623058'),
(7, '9789462156258'),
(4, '9789492095329');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(10) NOT NULL,
  `feedback` int(3) NOT NULL,
  `feedback_opmerking` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `feedback`, `feedback_opmerking`) VALUES
(1, 100, ''),
(2, 25, 'Opmerking moet verplicht'),
(3, 85, 'hallo'),
(4, 75, 'Wat een mooie tekst'),
(5, 75, 'Wat een mooie tekst'),
(6, 75, 'Wat een mooie tekst'),
(7, 75, 'Wat een mooie tekst'),
(8, 80, 'mag ok get invullen'),
(9, 12, 'Bind deserve pagination well druk'),
(10, 82, '');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `opleiding`
--

CREATE TABLE `opleiding` (
  `opleiding_id` int(10) NOT NULL,
  `opleiding_naam` varchar(50) NOT NULL,
  `boeken_link` varchar(510) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `opleiding`
--

INSERT INTO `opleiding` (`opleiding_id`, `opleiding_naam`, `boeken_link`) VALUES
(1, 'Informatica', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079169/Ad-Informatica-leerjaar-1'),
(2, 'Accountancy', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079170/Ad-Accountancy-leerjaar-1'),
(3, 'Bedrijfskunde', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079174/Ad-Bedrijfskunde-leerjaar-1-'),
(4, 'Built Environment', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL088447/Built-Environment-leerjaar-1'),
(5, 'Engineering', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079173/Ad-Engineering-leerjaar-1'),
(6, 'Health & Social Work', 'geen'),
(7, 'Human Resources Management', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079166/Ad-Human-Resource-Management-leerjaar-1'),
(8, 'Logistiek', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079171/Ad-Logistiek-leerjaar-1'),
(9, 'Management', 'https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079172/Ad-Management-leerjaar-1');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `student`
--

CREATE TABLE `student` (
  `studentnummer` int(10) NOT NULL,
  `student_voornaam` varchar(50) NOT NULL,
  `student_achternaam` varchar(100) NOT NULL,
  `opleiding_id` int(10) DEFAULT NULL,
  `start_datum` date NOT NULL,
  `gegevens_correct` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `student`
--

INSERT INTO `student` (`studentnummer`, `student_voornaam`, `student_achternaam`, `opleiding_id`, `start_datum`, `gegevens_correct`) VALUES
(1, 'Marvin', 'Vissers', 1, '2020-09-25', 1),
(2, 'Stan', 'Begthel', 1, '2020-08-24', 2);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `bezienswaardigheid`
--
ALTER TABLE `bezienswaardigheid`
  ADD PRIMARY KEY (`bezienswaardigheid_id`);

--
-- Indexen voor tabel `boek`
--
ALTER TABLE `boek`
  ADD PRIMARY KEY (`boek_isbn`);

--
-- Indexen voor tabel `boek_opleiding`
--
ALTER TABLE `boek_opleiding`
  ADD PRIMARY KEY (`opleiding_id`,`boek_isbn`),
  ADD KEY `boekBSN` (`boek_isbn`);

--
-- Indexen voor tabel `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexen voor tabel `opleiding`
--
ALTER TABLE `opleiding`
  ADD PRIMARY KEY (`opleiding_id`),
  ADD UNIQUE KEY `opleiding_naam` (`opleiding_naam`),
  ADD UNIQUE KEY `boeken_link` (`boeken_link`);

--
-- Indexen voor tabel `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentnummer`),
  ADD KEY `studentOpleiding` (`opleiding_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `bezienswaardigheid`
--
ALTER TABLE `bezienswaardigheid`
  MODIFY `bezienswaardigheid_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT voor een tabel `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT voor een tabel `opleiding`
--
ALTER TABLE `opleiding`
  MODIFY `opleiding_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `boek_opleiding`
--
ALTER TABLE `boek_opleiding`
  ADD CONSTRAINT `boekBSN` FOREIGN KEY (`boek_isbn`) REFERENCES `boek` (`boek_isbn`),
  ADD CONSTRAINT `boekOpleiding` FOREIGN KEY (`opleiding_id`) REFERENCES `opleiding` (`opleiding_id`);

--
-- Beperkingen voor tabel `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `studentOpleiding` FOREIGN KEY (`opleiding_id`) REFERENCES `opleiding` (`opleiding_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
