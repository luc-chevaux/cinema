-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Creato il: Apr 23, 2018 alle 11:30
-- Versione del server: 5.7.21
-- Versione PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ccbill`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `approles`
--

DROP TABLE IF EXISTS `approles`;
CREATE TABLE IF NOT EXISTS `approles` (
  `idAppRole` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `appRoleAuthority` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`idAppRole`),
  KEY `fk_appRoles_Customers1_idx` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `approles`
--

INSERT INTO `approles` (`idAppRole`, `customerId`, `appRoleAuthority`) VALUES
(4, 6, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struttura della tabella `countries`
--

DROP TABLE IF EXISTS `countries`;
CREATE TABLE IF NOT EXISTS `countries` (
  `countryId` int(11) NOT NULL,
  `countryName` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `countryAcronym` varchar(4) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`countryId`),
  UNIQUE KEY `countryName_UNIQUE` (`countryName`),
  UNIQUE KEY `countryAcronym_UNIQUE` (`countryAcronym`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `countries`
--

INSERT INTO `countries` (`countryId`, `countryName`, `countryAcronym`) VALUES
(1, 'Afghanistan', 'AF'),
(2, 'Albania', 'AL'),
(3, 'Algeria', 'DZ'),
(4, 'Samoa Americane', 'AS'),
(5, 'Andorra', 'AD'),
(6, 'Angola', 'AO'),
(7, 'Anguilla', 'AI'),
(8, 'Antartide', 'AQ'),
(9, 'Antigua e Barbuda', 'AG'),
(10, 'Argentina', 'AR'),
(11, 'Armenia', 'AM'),
(12, 'Aruba', 'AW'),
(13, 'Australia', 'AU'),
(14, 'Austria', 'AT'),
(15, 'Azerbaijan', 'AZ'),
(16, 'Bahamas', 'BS'),
(17, 'Bahrein', 'BH'),
(18, 'Bangladesh', 'BD'),
(19, 'Barbados', 'BB'),
(20, 'Bielorussia', 'BY'),
(21, 'Belgio', 'BE'),
(22, 'Belize', 'BZ'),
(23, 'Benin', 'BJ'),
(24, 'Bermuda', 'BM'),
(25, 'Bhutan', 'BT'),
(26, 'Bolivia', 'BO'),
(27, 'Bosnia Erzegovina', 'BA'),
(28, 'Botswana', 'BW'),
(29, 'Isola Bouvet', 'BV'),
(30, 'Brasile', 'BR'),
(31, 'Oceano Indiano, territorio britannico', 'IO'),
(32, 'Brunei Darussalam', 'BN'),
(33, 'Bulgaria', 'BG'),
(34, 'Burkina Faso', 'BF'),
(35, 'Burundi', 'BI'),
(36, 'Cambogia', 'KH'),
(37, 'Camerun', 'CM'),
(38, 'Canada', 'CA'),
(39, 'Capo Verde', 'CV'),
(40, 'Isole Cayman', 'KY'),
(41, 'Repubblica Centrafricana', 'CF'),
(42, 'Ciad', 'TD'),
(43, 'Cile', 'CL'),
(44, 'Cina', 'CN'),
(45, 'Christmas Island', 'CX'),
(46, 'Cocos (Keeling) Islands', 'CC'),
(47, 'Colombia', 'CO'),
(48, 'Comore', 'KM'),
(49, 'Congo', 'CG'),
(50, 'Congo,Rep. Democratica', 'CD'),
(51, 'Isole di Cook', 'CK'),
(52, 'Costa Rica', 'CR'),
(53, 'Costa d\'Avorio', 'CI'),
(54, 'Croazia', 'HR'),
(55, 'Cuba', 'CU'),
(56, 'Cipro', 'CY'),
(57, 'Repubblica Ceca', 'CZ'),
(58, 'Danimarca', 'DK'),
(59, 'Gibuti', 'DJ'),
(60, 'Dominica', 'DM'),
(61, 'Repubblica Dominicana', 'DO'),
(62, 'Timor Est', 'TP'),
(63, 'Ecuador', 'EC'),
(64, 'Egitto', 'EG'),
(65, 'El Salvador', 'SV'),
(66, 'Guinea Equatoriale', 'GQ'),
(67, 'Eritrea', 'ER'),
(68, 'Estonia', 'EE'),
(69, 'Etiopia', 'ET'),
(70, 'Falkland Islands (Malvinas)', 'FK'),
(71, 'Isole Faroe', 'FO'),
(72, 'Figi', 'FJ'),
(73, 'Finlandia', 'FI'),
(74, 'Francia', 'FR'),
(75, 'Guiana Francese', 'GF'),
(76, 'Polinesia Francese', 'PF'),
(77, 'Territori Francesi del Sud', 'TF'),
(78, 'Gabon', 'GA'),
(79, 'Gambia', 'GM'),
(80, 'Georgia', 'GE'),
(81, 'Germania', 'DE'),
(82, 'Ghana', 'GH'),
(83, 'Gibilterra', 'GI'),
(84, 'Grecia', 'GR'),
(85, 'Groenlandia', 'GL'),
(86, 'Grenada', 'GD'),
(87, 'Guadalupa', 'GP'),
(88, 'Guam', 'GU'),
(89, 'Guatemala', 'GT'),
(90, 'Guinea', 'GN'),
(91, 'Guinea-Bissau', 'GW'),
(92, 'Guyana', 'GY'),
(93, 'Haiti', 'HT'),
(94, 'Isole Heard e McDonald', 'HM'),
(95, 'Holy See (Vatican City State)', 'VA'),
(96, 'Honduras', 'HN'),
(97, 'Hong Kong', 'HK'),
(98, 'Ungheria', 'HU'),
(99, 'Islanda', 'IS'),
(100, 'India', 'IN'),
(101, 'Indonesia', 'ID'),
(102, 'Iran', 'IR'),
(103, 'Iraq', 'IQ'),
(104, 'EIRE', 'IE'),
(105, 'Israele', 'IL'),
(106, 'Italia', 'IT'),
(107, 'Giamaica', 'JM'),
(108, 'Giappone', 'JP'),
(109, 'Giordania', 'JO'),
(110, 'Kazakistan', 'KZ'),
(111, 'Kenya', 'KE'),
(112, 'Kiribati', 'KI'),
(113, 'Corea del Nord', 'KP'),
(114, 'Corea del Sud', 'KR'),
(115, 'Kuwait', 'KW'),
(116, 'Kirgizistan', 'KG'),
(117, 'Laos', 'LA'),
(118, 'Lettonia', 'LV'),
(119, 'Libano', 'LB'),
(120, 'Lesotho', 'LS'),
(121, 'Liberia', 'LR'),
(122, 'Libia', 'LY'),
(123, 'Liechtenstein', 'LI'),
(124, 'Lituania', 'LT'),
(125, 'Lussemburgo', 'LU'),
(126, 'Macao', 'MO'),
(127, 'Macedonia', 'MK'),
(128, 'Madagascar', 'MG'),
(129, 'Malawi', 'MW'),
(130, 'Malaysia', 'MY'),
(131, 'Isole Maldive', 'MV'),
(132, 'Mali', 'ML'),
(133, 'Malta', 'MT'),
(134, 'Isole Marshall', 'MH'),
(135, 'Martinica', 'MQ'),
(136, 'Mauritania', 'MR'),
(137, 'Mauritius', 'MU'),
(138, 'Mayotte', 'YT'),
(139, 'Mexico', 'MX'),
(140, 'Micronesia', 'FM'),
(141, 'Moldova, Republic of', 'MD'),
(142, 'Monaco', 'MC'),
(143, 'Mongolia', 'MN'),
(144, 'Montserrat', 'MS'),
(145, 'Marocco', 'MA'),
(146, 'Mozambique', 'MZ'),
(147, 'Myanmar', 'MM'),
(148, 'Namibia', 'NA'),
(149, 'Nauru', 'NR'),
(150, 'Nepal', 'NP'),
(151, 'Paesi Bassi', 'NL'),
(152, 'Antille Olandesi', 'AN'),
(153, 'Nuova Caledonia', 'NC'),
(154, 'Nuova Zelanda', 'NZ'),
(155, 'Nicaragua', 'NI'),
(156, 'Niger', 'NE'),
(157, 'Nigeria', 'NG'),
(158, 'Niue', 'NU'),
(159, 'Isola di Norfolk', 'NF'),
(160, 'Isole Marianne del Nord', 'MP'),
(161, 'Norvegia', 'NO'),
(162, 'Oman', 'OM'),
(163, 'Pakistan', 'PK'),
(164, 'Palau', 'PW'),
(165, 'Panama', 'PA'),
(166, 'Nuova Guinea', 'PG'),
(167, 'Paraguay', 'PY'),
(168, 'Peru', 'PE'),
(169, 'Filippine', 'PH'),
(170, 'Pitcairn', 'PN'),
(171, 'Polonia', 'PL'),
(172, 'Portogallo', 'PT'),
(173, 'Porto Rico', 'PR'),
(174, 'Qatar', 'QA'),
(175, 'RE8union', 'RE'),
(176, 'Romania', 'RO'),
(177, 'Russia', 'RU'),
(178, 'Rwanda', 'RW'),
(179, 'Sant\'Elena', 'SH'),
(180, 'Saint Kitts e Nevis', 'KN'),
(181, 'Santa Lucia', 'LC'),
(182, 'Saint Pierre e Miquelon', 'PM'),
(183, 'Saint Vincent e le Grenadine', 'VC'),
(184, 'Samoa', 'WS'),
(185, 'San Marino', 'SM'),
(186, 'Sao Tome e Principe', 'ST'),
(187, 'Arabia Saudita', 'SA'),
(188, 'Senegal', 'SN'),
(189, 'Seychelles', 'SC'),
(190, 'Sierra Leone', 'SL'),
(191, 'Singapore', 'SG'),
(192, 'Slovacchia', 'SK'),
(193, 'Slovenia', 'SI'),
(194, 'Isole Solomone', 'SB'),
(195, 'Somalia', 'SO'),
(196, 'Sud Africa', 'ZA'),
(197, 'Sud Georgia e Isole Sandwich del Sud', 'GS'),
(198, 'Spagna', 'ES'),
(199, 'Sri Lanka', 'LK'),
(200, 'Sudan', 'SD'),
(201, 'Suriname', 'SR'),
(202, 'Svalbard e Jan Mayen', 'SJ'),
(203, 'Swaziland', 'SZ'),
(204, 'Svezia', 'SE'),
(205, 'Svizzera', 'CH'),
(206, 'Siria', 'SY'),
(207, 'Taiwan', 'TW'),
(208, 'Tagikistan', 'TJ'),
(209, 'Tanzania', 'TZ'),
(210, 'Thailand', 'TH'),
(211, 'Togo', 'TG'),
(212, 'Tokelau', 'TK'),
(213, 'Tonga', 'TO'),
(214, 'Trinidad e Tobago', 'TT'),
(215, 'Tunisia', 'TN'),
(216, 'Turchia', 'TR'),
(217, 'Turkmenistan', 'TM'),
(218, 'Isole Turks e Caicos', 'TC'),
(219, 'Tuvalu', 'TV'),
(220, 'Uganda', 'UG'),
(221, 'Ucraina', 'UA'),
(222, 'Emirati Arabi Uniti', 'AE'),
(223, 'Gran Bretagna', 'GB'),
(224, 'USA', 'US'),
(225, 'Isole Minor Outlying, USA', 'UM'),
(226, 'Isole Vergini, USA', 'UY'),
(227, 'Uruguay', 'UZ'),
(228, 'Uzbekistan', 'VU'),
(229, 'Vanuatu', 'VE'),
(230, 'Venezuela', 'VN'),
(231, 'Vietnam', 'VG'),
(232, 'Isole Vergini, GB', 'VI'),
(233, 'Wallis e Futuna', 'WF'),
(234, 'Sahara Occidentale', 'EH'),
(235, 'Yemen', 'YE'),
(236, 'Serbia e Montenegro', 'YU'),
(237, 'Zambia', 'ZM'),
(238, 'Zimbabwe', 'ZW'),
(239, 'Territori Palestinesi', 'PS');

-- --------------------------------------------------------

--
-- Struttura della tabella `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerUsername` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `customerEmail` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `customerPassword` varchar(255) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerUsername_UNIQUE` (`customerUsername`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `customers`
--

INSERT INTO `customers` (`customerId`, `customerUsername`, `customerEmail`, `customerPassword`) VALUES
(1, 'luca', 'luca.martini@yahoo.it', 'b9b69e31eda80031a492723664889ced'),
(2, 'chris', 'chris@ccbill.com', 'b9b69e31eda80031a492723664889ced'),
(3, 'mark', 'mark@ccbill.com', 'b9b69e31eda80031a492723664889ced'),
(4, 'john', 'john@ccbill.com', 'b9b69e31eda80031a492723664889ced'),
(6, 'luca.martini', 'luca.martini@extrasys.it', '173270b097c76f0de791b4e0b0ce9832');

-- --------------------------------------------------------

--
-- Struttura della tabella `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `movieId` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `movieRating` enum('1','2','3','4','5') COLLATE latin1_general_ci DEFAULT NULL,
  `movieGenre` enum('HORROR','THRILLER','DRAMA','WESTERN','COMEDY','ROMANTIC') COLLATE latin1_general_ci NOT NULL,
  `countryId` int(11) DEFAULT NULL,
  `moviePrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`movieId`),
  KEY `FK_MOVIE_1_idx` (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci COMMENT='In this table I will store the Movies that are showed';

--
-- Dump dei dati per la tabella `movies`
--

INSERT INTO `movies` (`movieId`, `movieName`, `movieRating`, `movieGenre`, `countryId`, `moviePrice`) VALUES
(1, 'Pulp Fiction', '5', 'THRILLER', 224, '10'),
(2, 'The Good The Bad and The Ugly', '5', 'WESTERN', 106, '8'),
(3, 'Independence Day', '3', 'DRAMA', 133, '15');

-- --------------------------------------------------------

--
-- Struttura della tabella `purchases`
--

DROP TABLE IF EXISTS `purchases`;
CREATE TABLE IF NOT EXISTS `purchases` (
  `purchaseId` int(11) NOT NULL AUTO_INCREMENT,
  `purchaseDate` datetime DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  `purchaseSitCode` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `purchaseCCNumber` varchar(45) COLLATE latin1_general_ci DEFAULT NULL,
  `purchasePrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`purchaseId`),
  KEY `FK_PURCHASES_1_idx` (`customerId`),
  KEY `FK_PURCHASE_2_idx` (`scheduleId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `purchases`
--

INSERT INTO `purchases` (`purchaseId`, `purchaseDate`, `customerId`, `scheduleId`, `purchaseSitCode`, `purchaseCCNumber`, `purchasePrice`) VALUES
(1, '2013-10-27 00:00:00', 1, 67, '12', '2389-2389-2939-2334', '10'),
(2, '2013-10-27 00:00:00', 1, 68, '12', '2389-2389-2939-2334', '12'),
(3, '2013-10-20 00:00:00', 1, 48, '12', '2389-2389-2939-2334', '10'),
(4, '2013-10-22 00:00:00', 1, 55, '12', '2389-2389-2939-2334', '12'),
(5, '2013-10-28 00:00:00', 1, 74, '12', '211233123', '12'),
(6, '2013-10-28 00:00:00', 1, 76, '10', '123123', '10'),
(7, '2013-10-28 00:00:00', 1, 73, '10', '123123', '10'),
(8, '2013-10-28 00:00:00', 1, 76, '10', 'sad', '10'),
(9, '2013-10-28 00:00:00', 1, 76, '10', '123123', '10'),
(10, '2013-10-28 00:00:00', 1, 69, '10', '123', '15');

-- --------------------------------------------------------

--
-- Struttura della tabella `schedules`
--

DROP TABLE IF EXISTS `schedules`;
CREATE TABLE IF NOT EXISTS `schedules` (
  `idSchedule` int(11) NOT NULL AUTO_INCREMENT,
  `theatreId` int(11) DEFAULT NULL,
  `slotId` int(11) DEFAULT NULL,
  `movieId` int(11) DEFAULT NULL,
  `scheduleDate` date DEFAULT NULL,
  PRIMARY KEY (`idSchedule`),
  KEY `FK_SCHEDULES_1_idx` (`theatreId`),
  KEY `FK_SCHEDULES_2_idx` (`slotId`),
  KEY `FK_SCHEDULES_3_idx` (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `schedules`
--

INSERT INTO `schedules` (`idSchedule`, `theatreId`, `slotId`, `movieId`, `scheduleDate`) VALUES
(1, 1, 1, 1, '2018-04-23'),
(2, 1, 2, 2, '2018-04-23'),
(3, 1, 3, 3, '2018-04-23'),
(4, 2, 1, 1, '2018-04-23'),
(5, 2, 2, 2, '2018-04-23'),
(6, 2, 3, 3, '2018-04-23'),
(7, 3, 1, 1, '2018-04-23'),
(8, 3, 2, 2, '2018-04-23'),
(9, 3, 3, 3, '2018-04-23'),
(10, 1, 1, 1, '2018-04-23'),
(11, 1, 2, 2, '2018-04-23'),
(12, 1, 3, 3, '2018-04-23'),
(13, 2, 1, 1, '2018-04-23'),
(14, 2, 2, 2, '2018-04-23'),
(15, 2, 3, 3, '2018-04-23'),
(16, 3, 1, 1, '2018-04-23'),
(17, 3, 2, 2, '2018-04-23'),
(18, 3, 3, 3, '2018-04-23'),
(19, 1, 1, 1, '2018-04-23'),
(20, 1, 2, 2, '2018-04-23'),
(21, 1, 3, 3, '2018-04-23'),
(22, 2, 1, 1, '2018-04-23'),
(23, 2, 2, 2, '2018-04-23'),
(24, 2, 3, 3, '2018-04-23'),
(25, 3, 1, 1, '2018-04-23'),
(26, 3, 2, 2, '2018-04-23'),
(27, 3, 3, 3, '2018-04-23'),
(28, 1, 1, 1, '2018-04-23'),
(29, 1, 2, 2, '2018-04-23'),
(30, 1, 3, 3, '2018-04-23'),
(31, 2, 1, 1, '2018-04-23'),
(32, 2, 2, 2, '2018-04-23'),
(33, 2, 3, 3, '2018-04-23'),
(34, 3, 1, 1, '2018-04-23'),
(35, 3, 2, 2, '2018-04-23'),
(36, 3, 3, 3, '2018-04-23'),
(37, 1, 1, 1, '2018-04-23'),
(38, 1, 2, 2, '2018-04-23'),
(39, 1, 3, 3, '2018-04-23'),
(40, 2, 1, 1, '2018-04-23'),
(41, 2, 2, 2, '2018-04-23'),
(42, 2, 3, 3, '2018-04-23'),
(43, 3, 1, 1, '2018-04-23'),
(44, 3, 2, 2, '2018-04-23'),
(45, 3, 3, 3, '2018-04-23'),
(46, 1, 1, 1, '2018-04-23'),
(47, 1, 2, 2, '2018-04-23'),
(48, 1, 3, 3, '2018-04-23'),
(49, 2, 1, 1, '2018-04-23'),
(50, 2, 2, 2, '2018-04-23'),
(51, 2, 3, 3, '2018-04-23'),
(52, 3, 1, 1, '2018-04-23'),
(53, 3, 2, 2, '2018-04-23'),
(54, 3, 3, 3, '2018-04-23'),
(55, 1, 1, 1, '2018-04-23'),
(56, 1, 2, 2, '2018-04-23'),
(57, 1, 3, 3, '2018-04-23'),
(58, 2, 1, 1, '2018-04-23'),
(59, 2, 2, 2, '2018-04-23'),
(60, 2, 3, 3, '2018-04-23'),
(61, 3, 1, 1, '2018-04-23'),
(62, 3, 2, 2, '2018-04-23'),
(63, 3, 3, 3, '2018-04-23'),
(64, 1, 1, 1, '2018-04-23'),
(65, 1, 2, 2, '2018-04-23'),
(66, 1, 3, 3, '2018-04-23'),
(67, 2, 1, 1, '2018-04-23'),
(68, 2, 2, 2, '2018-04-23'),
(69, 2, 3, 3, '2018-04-23'),
(70, 3, 1, 1, '2018-04-23'),
(71, 3, 2, 2, '2018-04-23'),
(72, 3, 3, 3, '2018-04-23'),
(73, 1, 1, 1, '2018-04-23'),
(74, 1, 2, 2, '2018-04-23'),
(75, 1, 3, 3, '2018-04-23'),
(76, 2, 1, 1, '2018-04-23'),
(77, 2, 2, 2, '2018-04-23'),
(78, 2, 3, 3, '2018-04-23'),
(79, 3, 1, 1, '2018-04-23'),
(80, 3, 2, 2, '2018-04-23'),
(81, 3, 3, 3, '2018-04-23'),
(82, 1, 1, 1, '2018-04-23'),
(83, 1, 2, 2, '2018-04-23'),
(84, 1, 3, 3, '2018-04-23'),
(85, 2, 1, 1, '2018-04-23'),
(86, 2, 2, 2, '2018-04-23'),
(87, 2, 3, 3, '2018-04-23'),
(88, 3, 1, 1, '2018-04-23'),
(89, 3, 2, 2, '2018-04-23'),
(90, 3, 3, 3, '2018-04-23'),
(91, 1, 1, 1, '2018-04-23'),
(92, 1, 2, 2, '2018-04-23'),
(93, 1, 3, 3, '2018-04-23'),
(94, 2, 1, 1, '2018-04-23'),
(95, 2, 2, 2, '2018-04-23'),
(96, 2, 3, 3, '2018-04-23'),
(97, 3, 1, 1, '2018-04-23'),
(98, 3, 2, 2, '2018-04-23'),
(99, 3, 3, 3, '2018-04-23'),
(100, 1, 1, 1, '2018-04-23'),
(101, 1, 2, 2, '2018-04-23'),
(102, 1, 3, 3, '2018-04-23'),
(103, 2, 1, 1, '2018-04-23'),
(104, 2, 2, 2, '2018-04-23'),
(105, 2, 3, 3, '2018-04-23'),
(106, 3, 1, 1, '2018-04-23'),
(107, 3, 2, 2, '2018-04-23'),
(108, 3, 3, 3, '2018-04-23'),
(109, 1, 1, 1, '2018-04-23'),
(110, 1, 2, 2, '2018-04-23'),
(111, 1, 3, 3, '2018-04-23'),
(112, 2, 1, 1, '2018-04-23'),
(113, 2, 2, 2, '2018-04-23'),
(114, 2, 3, 3, '2018-04-23'),
(115, 3, 1, 1, '2018-04-23'),
(116, 3, 2, 2, '2018-04-23'),
(117, 3, 3, 3, '2018-04-23'),
(118, 1, 1, 1, '2018-04-23'),
(119, 1, 2, 2, '2018-04-23'),
(120, 1, 3, 3, '2018-04-23'),
(121, 2, 1, 1, '2018-04-23'),
(122, 2, 2, 2, '2018-04-23'),
(123, 2, 3, 3, '2018-04-23'),
(124, 3, 1, 1, '2018-04-23'),
(125, 3, 2, 2, '2018-04-23'),
(126, 3, 3, 3, '2018-04-23');

-- --------------------------------------------------------

--
-- Struttura della tabella `slot`
--

DROP TABLE IF EXISTS `slot`;
CREATE TABLE IF NOT EXISTS `slot` (
  `slotId` int(11) NOT NULL AUTO_INCREMENT,
  `slotDescription` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `slotStartTime` varchar(10) COLLATE latin1_general_ci DEFAULT NULL,
  `slotEndTime` varchar(10) COLLATE latin1_general_ci DEFAULT NULL,
  `slotPaused` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`slotId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `slot`
--

INSERT INTO `slot` (`slotId`, `slotDescription`, `slotStartTime`, `slotEndTime`, `slotPaused`) VALUES
(1, 'Morning', '10:00', '12:00', 1),
(2, 'Afternoon', '16:00', '18:00', 1),
(3, 'Evening', '22:00', '24:00', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `theatres`
--

DROP TABLE IF EXISTS `theatres`;
CREATE TABLE IF NOT EXISTS `theatres` (
  `theatreId` int(11) NOT NULL AUTO_INCREMENT,
  `theatreShowsNumber` int(11) NOT NULL,
  `theatreRows` int(11) NOT NULL,
  `theatreColumns` int(11) NOT NULL,
  `theatreName` varchar(200) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`theatreId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dump dei dati per la tabella `theatres`
--

INSERT INTO `theatres` (`theatreId`, `theatreShowsNumber`, `theatreRows`, `theatreColumns`, `theatreName`) VALUES
(1, 4, 5, 5, 'Room One'),
(2, 4, 5, 5, 'Room Two'),
(3, 4, 5, 5, 'Room Three');

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `approles`
--
ALTER TABLE `approles`
  ADD CONSTRAINT `fk_appRoles_Customers1` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `FK_MOVIE_1` FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `purchases`
--
ALTER TABLE `purchases`
  ADD CONSTRAINT `FK_PURCHASES_1` FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PURCHASE_2` FOREIGN KEY (`scheduleId`) REFERENCES `schedules` (`idSchedule`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `FK_SCHEDULES_1` FOREIGN KEY (`theatreId`) REFERENCES `theatres` (`theatreId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SCHEDULES_2` FOREIGN KEY (`slotId`) REFERENCES `slot` (`slotId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SCHEDULES_3` FOREIGN KEY (`movieId`) REFERENCES `movies` (`movieId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
