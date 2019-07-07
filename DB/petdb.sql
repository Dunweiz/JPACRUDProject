-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema petdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `petdb` ;

-- -----------------------------------------------------
-- Schema petdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petdb` DEFAULT CHARACTER SET utf8 ;
USE `petdb` ;

-- -----------------------------------------------------
-- Table `pethouse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pethouse` ;

CREATE TABLE IF NOT EXISTS `pethouse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `age` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL DEFAULT 'no_name',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS petuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'petuser'@'localhost' IDENTIFIED BY 'Dzheng8157';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'petuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `pethouse`
-- -----------------------------------------------------
START TRANSACTION;
USE `petdb`;
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (1, 'dog', 2, 'sprinkles');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (2, 'cat', 1, 'milk');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (3, 'cat', 3, 'garfield');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (4, 'dog', 1, 'max');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (5, 'bird', 2, 'jet');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (6, 'fish', 1, 'blue');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (7, 'hamster', 1, 'sqeek');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (8, 'fish', 1, 'trapper');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (9, 'cat', 3, 'fluffer');
INSERT INTO `pethouse` (`id`, `type`, `age`, `name`) VALUES (10, 'dog', 5, 'sparkle');

COMMIT;

