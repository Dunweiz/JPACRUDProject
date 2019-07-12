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
-- Table `pet_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pet_type` ;

CREATE TABLE IF NOT EXISTS `pet_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `species` VARCHAR(45) NOT NULL DEFAULT 'Null',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(50) NULL DEFAULT 'NULL',
  `state` VARCHAR(20) NULL DEFAULT 'NULL',
  `address` VARCHAR(45) NULL DEFAULT 'NULL',
  `zip` VARCHAR(10) NULL DEFAULT 'NULL',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `owner` ;

CREATE TABLE IF NOT EXISTS `owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_owner_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_owner_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pethouse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pethouse` ;

CREATE TABLE IF NOT EXISTS `pethouse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL DEFAULT 'no_name',
  `type_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pethouse_pet_species1_idx` (`type_id` ASC),
  INDEX `fk_pethouse_owner1_idx` (`owner_id` ASC),
  CONSTRAINT `fk_pethouse_pet_species1`
    FOREIGN KEY (`type_id`)
    REFERENCES `pet_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pethouse_owner1`
    FOREIGN KEY (`owner_id`)
    REFERENCES `owner` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `pet_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `petdb`;
INSERT INTO `pet_type` (`id`, `species`) VALUES (1, 'Canine');
INSERT INTO `pet_type` (`id`, `species`) VALUES (2, 'Feline');
INSERT INTO `pet_type` (`id`, `species`) VALUES (3, 'Bird');
INSERT INTO `pet_type` (`id`, `species`) VALUES (4, 'Rodent');
INSERT INTO `pet_type` (`id`, `species`) VALUES (5, 'Fish');
INSERT INTO `pet_type` (`id`, `species`) VALUES (6, 'Reptile');

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `petdb`;
INSERT INTO `address` (`id`, `city`, `state`, `address`, `zip`) VALUES (1, 'Rochester', 'New York', '9326 Illinois Ave. ', '33952');
INSERT INTO `address` (`id`, `city`, `state`, `address`, `zip`) VALUES (2, 'Plano', 'Texas', '572 George St.', '91768');
INSERT INTO `address` (`id`, `city`, `state`, `address`, `zip`) VALUES (3, 'Wichita', 'Kansas', '7534 E. Pierce Dr. ', '46321');
INSERT INTO `address` (`id`, `city`, `state`, `address`, `zip`) VALUES (4, 'Cleveland', 'Ohio', '824 Ann Street ', '22901');

COMMIT;


-- -----------------------------------------------------
-- Data for table `owner`
-- -----------------------------------------------------
START TRANSACTION;
USE `petdb`;
INSERT INTO `owner` (`id`, `first_name`, `last_name`, `phone`, `address_id`) VALUES (1, 'Rob', 'Charles', '344-555-9999', 1);
INSERT INTO `owner` (`id`, `first_name`, `last_name`, `phone`, `address_id`) VALUES (2, 'Alexander', 'Smith', '333-668-9990', 2);
INSERT INTO `owner` (`id`, `first_name`, `last_name`, `phone`, `address_id`) VALUES (3, 'Jack', 'Robinson', '987-654-1111', 3);
INSERT INTO `owner` (`id`, `first_name`, `last_name`, `phone`, `address_id`) VALUES (4, 'Carlos', 'Miller', '123-456-7899', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pethouse`
-- -----------------------------------------------------
START TRANSACTION;
USE `petdb`;
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (1, 2, 'Sprinkle', 1, 1);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (2, 1, 'Milk', 2, 4);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (3, 3, 'Paws', 1, 2);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (4, 1, 'Scooter', 3, 3);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (5, 2, 'Cheek', 4, 2);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (6, 1, 'Blue', 5, 1);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (7, 1, 'Squeek', 2, 4);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (8, 1, 'Blub', 5, 2);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (9, 3, 'Scratcher', 2, 2);
INSERT INTO `pethouse` (`id`, `age`, `name`, `type_id`, `owner_id`) VALUES (10, 5, 'Sniffer', 2, 1);

COMMIT;

