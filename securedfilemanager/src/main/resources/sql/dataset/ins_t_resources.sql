-- phpMyAdmin SQL Dump
-- version 3.3.9.2
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Mer 29 Juin 2011 à 00:17
-- Version du serveur: 5.5.10
-- Version de PHP: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `sfm_dev`
--

--
-- Contenu de la table `t_resources`
--

INSERT INTO `t_resources` (`ID`, `CREATION_DATE`, `MODIFICATION_DATE`, `TYPE`, `NAME`, `ACCESSIBILITY`, `PARENT_ID`, `EXTENSION`, `SIZE`) VALUES
(1, '2011-06-29 00:07:55', '2011-06-29 00:07:55', 'DIRECTORY', 'public', 'OPEN', NULL, NULL, 0),
(2, '2011-06-29 00:09:50', '2011-06-29 00:09:50', 'DIRECTORY', 'blog', 'OPEN', 1, NULL, 0),
(3, '2011-06-29 00:09:50', '2011-06-29 00:09:50', 'DIRECTORY', 'works', 'OPEN', 1, NULL, 0),
(4, '2011-06-29 00:11:01', '2011-06-29 00:11:01', 'DIRECTORY', 'spring', 'OPEN', 3, NULL, 0),
(5, '2011-06-29 00:11:44', '2011-06-29 00:11:44', 'FILE', 'pom.xml', 'OPEN', 4, 'XML', 10),
(6, '2011-06-29 00:12:46', '2011-06-29 00:12:46', 'DIRECTORY', 'private', 'CLOSED', NULL, NULL, 0),
(7, '2011-06-29 00:13:29', '2011-06-29 00:13:29', 'DIRECTORY', 'loan', 'CLOSED', 6, NULL, 0),
(8, '2011-06-29 00:15:18', '2011-06-29 00:15:18', 'FILE', 'sample_file.txt', 'CLOSED', 7, 'TXT', 0),
(9, '2011-06-29 00:15:42', '2011-06-29 00:15:42', 'FILE', 'README', 'CLOSED', 7, 'OTHER', 0),
(10, '2011-06-29 00:17:00', '2011-06-29 00:17:03', 'DIRECTORY', 'admin', 'CLOSED', NULL, NULL, 0);
