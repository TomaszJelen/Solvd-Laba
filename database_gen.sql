-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `purpose` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bookshelves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Bookshelves` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rooms_id` BIGINT NOT NULL,
  `avg_capacity` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bookshelves_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_bookshelves_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `mydb`.`Rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bookshelves_id` BIGINT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_books_bookshelves_idx` (`bookshelves_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_bookshelves`
    FOREIGN KEY (`bookshelves_id`)
    REFERENCES `mydb`.`Bookshelves` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Authors` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Librarians`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Librarians` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Shifts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Shifts` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `librarians_id` BIGINT NOT NULL,
  `from` TIME NOT NULL,
  `to` TIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shifts_librarians1_idx` (`librarians_id` ASC) VISIBLE,
  CONSTRAINT `fk_shifts_librarians1`
    FOREIGN KEY (`librarians_id`)
    REFERENCES `mydb`.`Librarians` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Readers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Readers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Computers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Computers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `rooms_id` BIGINT NOT NULL,
  `operating_system` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_computers_rooms1_idx` (`rooms_id` ASC) VISIBLE,
  CONSTRAINT `fk_computers_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `mydb`.`Rooms` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Borrowings&Reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Borrowings&Reservations` (
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
    REFERENCES `mydb`.`Readers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrowings_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `mydb`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrowings_librarians1`
    FOREIGN KEY (`librarians_id`)
    REFERENCES `mydb`.`Librarians` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Books_has_authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Books_has_authors` (
  `books_id` BIGINT NOT NULL,
  `authors_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `authors_id`),
  INDEX `fk_books_has_authors_authors1_idx` (`authors_id` ASC) VISIBLE,
  INDEX `fk_books_has_authors_books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_has_authors_books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `mydb`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_has_authors_authors1`
    FOREIGN KEY (`authors_id`)
    REFERENCES `mydb`.`Authors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Genres` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Books_has_Genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Books_has_Genres` (
  `books_id` BIGINT NOT NULL,
  `genres_id` BIGINT NOT NULL,
  PRIMARY KEY (`books_id`, `genres_id`),
  INDEX `fk_Books_has_Genres_Genres1_idx` (`genres_id` ASC) VISIBLE,
  INDEX `fk_Books_has_Genres_Books1_idx` (`books_id` ASC) VISIBLE,
  CONSTRAINT `fk_Books_has_Genres_Books1`
    FOREIGN KEY (`books_id`)
    REFERENCES `mydb`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Books_has_Genres_Genres1`
    FOREIGN KEY (`genres_id`)
    REFERENCES `mydb`.`Genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
