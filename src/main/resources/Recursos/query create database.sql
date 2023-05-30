SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema amolaberinto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amolaberinto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amolaberinto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `amolaberinto` ;

-- -----------------------------------------------------
-- Table `amolaberinto`.`lugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`lugar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clase_asignada` VARCHAR(255) NULL DEFAULT NULL,
  `alineacion_asignada` VARCHAR(255) NULL DEFAULT NULL,
  `tipo` ENUM('Casa', 'Cementerio', 'Taberna', 'Pueblo', 'Bosque', 'Costa', 'Plaza', 'Mercado', 'Cripta', 'Cueva', 'Desconocido') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `amolaberinto`.`personaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`personaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `clase` VARCHAR(255) NOT NULL,
  `alineamiento` VARCHAR(255) NOT NULL,
  `imagen` VARCHAR(400) NULL DEFAULT NULL,
  `nivel` INT NOT NULL,
  `clase_armadura` INT NOT NULL,
  `vida` INT NOT NULL,
  `experiencia` INT NOT NULL,
  `lugar_id` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_personaje_lugar1_idx` (`lugar_id` ASC) VISIBLE,
  CONSTRAINT `fk_personaje_lugar1`
    FOREIGN KEY (`lugar_id`)
    REFERENCES `amolaberinto`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `amolaberinto`.`habilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`habilidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `interpretativas` TINYINT NOT NULL,
  `personaje_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_habilidad_personaje1_idx` (`personaje_id` ASC) VISIBLE,
  CONSTRAINT `fk_habilidad_personaje1`
    FOREIGN KEY (`personaje_id`)
    REFERENCES `amolaberinto`.`personaje` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `amolaberinto`.`Objetos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`objetos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  `valor` INT NOT NULL,
  `peso` DOUBLE NOT NULL,
  `consumible` TINYINT NULL,
  `personaje_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Objetos_personaje1_idx` (`personaje_id` ASC) VISIBLE,
  CONSTRAINT `fk_Objetos_personaje1`
    FOREIGN KEY (`personaje_id`)
    REFERENCES `amolaberinto`.`personaje` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `amolaberinto`.`mision`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`mision` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `recompensa` VARCHAR(255) NOT NULL,
  `objetivos` VARCHAR(255) NOT NULL,
  `estado` ENUM('EN_CURSO', 'PENDIENTE', 'COMPLETADO', 'FALLADO') NOT NULL,
  `tiempo_restante` INT NOT NULL,
  `lugar_id` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_mision_lugar1_idx` (`lugar_id` ASC) VISIBLE,
  CONSTRAINT `fk_mision_lugar1`
    FOREIGN KEY (`lugar_id`)
    REFERENCES `amolaberinto`.`lugar` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `amolaberinto`.`moneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amolaberinto`.`moneda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bronce` INT NOT NULL DEFAULT 0,
  `plata` INT NOT NULL DEFAULT 0,
  `oro` INT NOT NULL DEFAULT 0,
  `platino` INT NOT NULL DEFAULT 0,
  `personaje_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_moneda_personaje_id` (`personaje_id`), -- Agregado: Restricción de unicidad
  CONSTRAINT `fk_moneda_personaje1`
    FOREIGN KEY (`personaje_id`)
    REFERENCES `amolaberinto`.`personaje` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;