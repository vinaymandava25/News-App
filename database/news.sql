SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `news` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `news` ;

-- -----------------------------------------------------
-- Table `news`.`article`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `news`.`article` (
  `ar_id` INT NOT NULL AUTO_INCREMENT ,
  `ar_title` VARCHAR(500) NULL ,
  `ar_content` VARCHAR(5000) NULL ,
  `ar_desc` VARCHAR(1000) NULL ,
  `ar_date` DATETIME NULL ,
  `ar_source` VARCHAR(500) NULL ,
  `ar_author` VARCHAR(45) NULL ,
  `ar_url` VARCHAR(200) NULL ,
  PRIMARY KEY (`ar_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news`.`language`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `news`.`language` (
  `ln_id` INT NOT NULL AUTO_INCREMENT ,
  `ln_code` VARCHAR(45) NULL ,
  `ln_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`ln_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `news`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(70) NULL ,
  `us_email` VARCHAR(255) NULL ,
  `us_password` VARCHAR(128) NULL ,
  `us_ln_id` INT NULL ,
  `us_isadmin` TINYINT NULL ,
  `us_active` TINYINT NULL ,
  PRIMARY KEY (`us_id`) ,
  INDEX `us_ln_fk` (`us_ln_id` ASC) ,
  CONSTRAINT `us_ln_fk`
    FOREIGN KEY (`us_ln_id` )
    REFERENCES `news`.`language` (`ln_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news`.`favourite_article`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `news`.`favourite_article` (
  `fav_id` INT NOT NULL AUTO_INCREMENT ,
  `fav_us_id` INT NULL ,
  `fav_ar_id` INT NULL ,
  PRIMARY KEY (`fav_id`) ,
  INDEX `fav_us_fk` (`fav_us_id` ASC) ,
  INDEX `fav_ar_fk` (`fav_ar_id` ASC) ,
  CONSTRAINT `fav_us_fk`
    FOREIGN KEY (`fav_us_id` )
    REFERENCES `news`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fav_ar_fk`
    FOREIGN KEY (`fav_ar_id` )
    REFERENCES `news`.`article` (`ar_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
