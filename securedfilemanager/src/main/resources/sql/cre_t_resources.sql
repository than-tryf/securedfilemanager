CREATE TABLE  `sfm_dev`.`t_resources` (
`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`CREATION_DATE` DATETIME NULL DEFAULT NULL ,
`MODIFICATION_DATE` DATETIME NULL DEFAULT NULL ,
`TYPE` VARCHAR( 10 ) NOT NULL DEFAULT  'FILE' ,
`NAME` TEXT NOT NULL ,
`PARENT_ID` INT NULL DEFAULT NULL ,
`EXTENSION` VARCHAR( 10 ) NULL DEFAULT NULL ,
`SIZE` INT NOT NULL DEFAULT  '0'
) ENGINE = INNODB;