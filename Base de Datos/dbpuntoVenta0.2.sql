-- MySQL Script generated by MySQL Workbench
-- Sun Feb  9 20:57:59 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema puntoVenta2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema puntoVenta2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `puntoVenta2` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `puntoVenta2` ;

-- -----------------------------------------------------
-- Table `puntoVenta2`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`Categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `estado` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`Articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`Articulo` (
  `idArticulo` INT NOT NULL AUTO_INCREMENT,
  `categoria_id` INT NOT NULL,
  `codigo` VARCHAR(50) NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `precio_venta` DECIMAL(11,2) NULL,
  `stock` INT NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `imagen` VARCHAR(100) NULL,
  `estado` BIT(1) NULL DEFAULT 1,
  PRIMARY KEY (`idArticulo`),
  UNIQUE INDEX `Articulocol_UNIQUE` (`codigo` ASC) VISIBLE,
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  INDEX `fk_articulo_categoria_idx` (`categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_categoria`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `puntoVenta2`.`Categoria` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`usuario` (
  `id` INT NOT NULL,
  `rol_id` INT NOT NULL,
  `nombre` VARCHAR(75) NOT NULL,
  `tipo_documento` VARCHAR(25) NULL,
  `num_documento` VARCHAR(25) NULL,
  `direccion` VARCHAR(150) NULL,
  `telefono` VARCHAR(15) NULL,
  `email` VARCHAR(100) NOT NULL,
  `clave` VARCHAR(128) NOT NULL,
  `activo` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  INDEX `fk_usuario_rol_idx` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `puntoVenta2`.`rol` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_persona` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo_documento` VARCHAR(25) NULL,
  `num_documento` VARCHAR(25) NULL,
  `direccion` VARCHAR(150) NULL,
  `telefono` VARCHAR(15) NULL,
  `email` VARCHAR(100) NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`ingreso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`ingreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `persona_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `tipoComprobante` VARCHAR(30) NOT NULL,
  `serie_comprobante` VARCHAR(10) NULL,
  `num_comprobante` VARCHAR(410) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `impuesto` DECIMAL(4,2) NOT NULL,
  `total` DECIMAL(11,2) NOT NULL,
  `estado` VARCHAR(30) NOT NULL DEFAULT 'Aceptado',
  PRIMARY KEY (`id`),
  INDEX `fk_ingreso_persona_idx` (`persona_id` ASC) VISIBLE,
  INDEX `fk_ingreso_usuario_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_ingreso_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `puntoVenta2`.`persona` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingreso_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `puntoVenta2`.`usuario` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`detalle_ingreso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`detalle_ingreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingreso_id` INT NOT NULL,
  `articulo_id` INT NOT NULL,
  `cantidad_id` INT NOT NULL,
  `precio` DECIMAL(11,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalleIngreso_ingreso_idx` (`ingreso_id` ASC) VISIBLE,
  INDEX `fk_detalleIngreso_articulo_idx` (`articulo_id` ASC) VISIBLE,
  CONSTRAINT `fk_detalleIngreso_ingreso`
    FOREIGN KEY (`ingreso_id`)
    REFERENCES `puntoVenta2`.`ingreso` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleIngreso_articulo`
    FOREIGN KEY (`articulo_id`)
    REFERENCES `puntoVenta2`.`Articulo` (`idArticulo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `persona_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `tipo_comprobante` VARCHAR(30) NOT NULL,
  `serie_comprobante` VARCHAR(10) NULL,
  `num_comprobante` VARCHAR(410) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `impuesto` DECIMAL(4,2) NOT NULL,
  `total` DECIMAL(11,2) NOT NULL,
  `estado` VARCHAR(30) NOT NULL DEFAULT 'Aceptado',
  PRIMARY KEY (`id`),
  INDEX `fk_venta_persona_idx` (`persona_id` ASC) VISIBLE,
  INDEX `fk_venta_usuario_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_venta_persona`
    FOREIGN KEY (`persona_id`)
    REFERENCES `puntoVenta2`.`persona` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `puntoVenta2`.`usuario` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta2`.`detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta2`.`detalle_venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venta_id` INT NOT NULL,
  `articulo_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DECIMAL(11,2) NOT NULL,
  `descuento` DECIMAL(11,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalleVenta_venta_idx` (`venta_id` ASC) VISIBLE,
  INDEX `fk_detalleVenta_articulo_idx` (`articulo_id` ASC) VISIBLE,
  CONSTRAINT `fk_detalleVenta_venta`
    FOREIGN KEY (`venta_id`)
    REFERENCES `puntoVenta2`.`venta` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_detalleVenta_articulo`
    FOREIGN KEY (`articulo_id`)
    REFERENCES `puntoVenta2`.`Articulo` (`idArticulo`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
