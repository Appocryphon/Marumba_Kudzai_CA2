DROP DATABASE IF EXISTS `manga_database`;
CREATE DATABASE `manga_database`;
USE `manga_database`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `MANGA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MANGA_NAME` varchar(50) NOT NULL,
  `YEAR_MANGA_STARTED` int(5) NOT NULL,
  `YEAR_ANIME_STARTED` int(5) NOT NULL,
  PRIMARY KEY  (`MANGA_ID`)
  );

INSERT INTO user VALUES (null, "Date A Live", "2012", "2013"),
(null, "Jobless Reincarnation", "2014", "2021"),
(null, "Goblin Slayer", "2016", "2018"),
(null, "Shingeki no Kyojin", "2009", "2013"),
(null, "Dragon Ball Z", "1986", "1988"),
(null, "Fairy Tail", "2012", "2013"),
(null, "Bleach", "2001", "2004"),
(null, "Kimetsu no Yaiba", "2016", "2019"),
(null, "Tokyo Ghoul", "2011", "2014"),
(null, "Akame ga Kill", "2010", "2014");
