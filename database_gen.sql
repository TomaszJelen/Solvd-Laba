-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`Rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Rooms` ;

CREATE TABLE IF NOT EXISTS `library`.`Rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `purpose` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Bookshelves`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Bookshelves` ;

CREATE TABLE IF NOT EXISTS `library`.`Bookshelves` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rooms_id` BIGINT NOT NULL,
  `avg_capacity` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bookshelves_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_bookshelves_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `library`.`Rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Books` ;

CREATE TABLE IF NOT EXISTS `library`.`Books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bookshelves_id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_books_bookshelves_idx` (`bookshelves_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_bookshelves`
    FOREIGN KEY (`bookshelves_id`)
    REFERENCES `library`.`Bookshelves` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Authors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Authors` ;

CREATE TABLE IF NOT EXISTS `library`.`Authors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Librarians`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Librarians` ;

CREATE TABLE IF NOT EXISTS `library`.`Librarians` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Shifts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Shifts` ;

CREATE TABLE IF NOT EXISTS `library`.`Shifts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `librarians_id` BIGINT NOT NULL,
  `from` TIME NOT NULL,
  `to` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shifts_librarians1_idx` (`librarians_id` ASC) VISIBLE,
  CONSTRAINT `fk_shifts_librarians1`
    FOREIGN KEY (`librarians_id`)
    REFERENCES `library`.`Librarians` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Readers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Readers` ;

CREATE TABLE IF NOT EXISTS `library`.`Readers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Computers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Computers` ;

CREATE TABLE IF NOT EXISTS `library`.`Computers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rooms_id` BIGINT NOT NULL,
  `operating_system` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_computers_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_computers_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `library`.`Rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`BorrowingsReservations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`BorrowingsReservations` ;

CREATE TABLE IF NOT EXISTS `library`.`BorrowingsReservations` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `readers_id` BIGINT NOT NULL,
  `books_id` BIGINT NOT NULL,
  `librarians_id` BIGINT NOT NULL,
  `from` DATE NOT NULL,
  `to` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_borrowings_readers1_idx` (`readers_id` ASC) VISIBLE,
  INDEX `fk_borrowings_books1_idx` (`books_id` ASC) VISIBLE,
  INDEX `fk_borrowings_librarians1_idx` (`librarians_id` ASC) VISIBLE,
  CONSTRAINT `fk_borrowings_readers1`
    FOREIGN KEY (`readers_id`)
    REFERENCES `library`.`Readers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrowings_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `library`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrowings_librarians1`
    FOREIGN KEY (`librarians_id`)
    REFERENCES `library`.`Librarians` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Books_has_authors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Books_has_authors` ;

CREATE TABLE IF NOT EXISTS `library`.`Books_has_authors` (
  `books_id` BIGINT NOT NULL,
  `authors_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `authors_id`),
  INDEX `fk_books_has_authors_authors1_idx` (`authors_id` ASC) VISIBLE,
  INDEX `fk_books_has_authors_books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_has_authors_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `library`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_has_authors_authors1`
    FOREIGN KEY (`authors_id`)
    REFERENCES `library`.`Authors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Genres` ;

CREATE TABLE IF NOT EXISTS `library`.`Genres` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Books_has_Genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Books_has_Genres` ;

CREATE TABLE IF NOT EXISTS `library`.`Books_has_Genres` (
  `books_id` BIGINT NOT NULL,
  `genres_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `genres_id`),
  INDEX `fk_Books_has_Genres_Genres1_idx` (`genres_id` ASC) VISIBLE,
  INDEX `fk_Books_has_Genres_Books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_Books_has_Genres_Books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `library`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Books_has_Genres_Genres1`
    FOREIGN KEY (`genres_id`)
    REFERENCES `library`.`Genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
