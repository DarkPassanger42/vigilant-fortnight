-- DROP DATABASE `webstoredb`


-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema WebStoreDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema WebStoreDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webstoredb` DEFAULT CHARACTER SET utf8 ;
USE `webstoredb` ;

-- -----------------------------------------------------
-- Table `WebStoreDB`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webstoredb`.`Products` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(100) NULL,
  `Category` VARCHAR(45) NULL,
  `Subcategory` VARCHAR(45) NULL,
  `Description` VARCHAR(200) NULL,
  `Price` VARCHAR(45) NULL,
  `ImageLocation` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`));


-- -----------------------------------------------------
-- Table `WebStoreDB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webstoredb`.`Users` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Category` VARCHAR(45) NULL,
    PRIMARY KEY (`ID`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Add data
-- -----------------------------------------------------
-- PC
INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('1', 'DELL Desktop Computer OptiPlex 5040', 'COMP', 'Desktop', 
		'Intel Core i7 6th Gen 6700 (3.4 GHz),8 GB DDR3L 500 GB HDD,Windows 7 Professional 64-Bit (Includes Windows 10 Pro License), No Screen, AMD Radeon R5 340X 2 GB', 
		'720.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-159-414_R01.jpg?w=660&h=500');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('2', 'Lenovo Desktop Computer IdeaCentre 300-20ish', 'COMP', 'Desktop', 
    'Intel Core i5 6th Gen 6400 (2.7 GHz),4 GB DDR4 1 TB HDD,Windows 10 Home,Intel HD Graphics 530,iJAS Exclusive', 
    '449.99', 'http://images10.newegg.com/productimage/83-798-810-18.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('3', 'HP All-in-One Computer ProOne 400 G2', 'COMP', 'Desktop', 
    'Intel Core i5 6th Gen 6500 (3.20 GHz),8 GB 128 GB SSD,20" 1600 x 900,Windows 10 Pro 64-Bit,Intel HD Graphics 530', 
    '449.99', 'http://images10.newegg.com/productimage/83-798-810-18.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('4', 'Lenovo All-in-One Computer IdeaCentre 510-23ISH ', 'COMP', 'Desktop', 
    'Intel Core i3 6th Gen 6100T (3.20 GHz),8 GB DDR4 1 TB HDD,23" Touchscreen 1920 x 1080,Windows 10 Home 64-Bit,Intel HD Graphics 530', 
    '619.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-795-359-01.jpg?w=660&h=500');

-- Laptop

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('5', 'ASUS Laptop Zenbook UX305CA-DHM4T Intel Core M3 6Y30', 'COMP', 'Laptop', 
    'Intel Core M3 6Y30 (0.90 GHz),8 GB Memory 256 GB SSD,Intel HD Graphics 515,Touchscreen,3200 x 1800,Windows 10 Home 64-Bit', 
    '779.99', 'http://images10.newegg.com/ProductImageCompressAll1280/34-232-789-01.jpg?w=660&h=500');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('6', 'MSI 15.6" GL62 6QF-628 Intel Core i5 6300HQ', 'COMP', 'Laptop', 
    'GeForce GTX 960M 2 GB,6th Generation Intel Core i5 6300HQ (2.30 GHz),8 GB Memory 1 TB HDD,15.6" Full HD 1920 x 1080,15.07" x 10.23" x 1.06" 5.29 lbs.,DVD Super Multi,Only at iJAS', 
    '979.99', 'http://images10.newegg.com/productimage/34-154-112-11.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('7', 'DELL Laptop Inspiron 15 5000 i5568-3746GRY Intel Core i5 6200U', 'COMP', 'Laptop', 
    'Intel Core i5 6200U (2.30 GHz),8 GB Memory 1 TB HDD,Intel HD Graphics 520,15.6" Touchscreen 1920 x 1080,Windows 10 Home 64-Bit,15.04" x 9.96" x 0.80" 5.07 lbs.', 
    '712.99', 'http://images10.newegg.com/productimage/34-296-995-09.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('8', 'DELL XPS 13 XPS9343-7273SLV Ultrabook Intel Core i7 5500U', 'COMP', 'Laptop', 
    'Intel Core i7 5500U (2.40 GHz),8 GB Memory 256 GB SSD,Intel HD Graphics 5500,13.3" Touchscreen 3200 x 1800,Windows 8.1 64-Bit', 
    '1,699.95', 'http://images10.newegg.com/productimage/34-299-327-10.jpg');

-- Tablet

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('9', 'Lenovo IdeaPad Miix 700 80QL0020US Intel Core M5 6Y54', 'COMP', 'Tablet', 
    'Intel Core M5 6Y54 (1.10 GHz),Windows 10 Pro 64-Bit,Touchscreen,Intel HD Graphics 515,keyboard and stylus included', 
    '529.99', 'http://images10.newegg.com/productimage/34-321-177-09.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('10', 'Microsoft Surface Pro 3 Tablet', 'COMP', 'Tablet', 
    '1.9GHz Intel Core i5-4300U Dual-Core CPU,4GB of RAM,12" ClearType Full HD Plus Touchscreen,2160 x 1440 Native Resolution,Integrated Intel HD Graphics 4200,128GB of Flash Storage,microSDXC Media', 
    '1,459.95', 'http://images10.newegg.com/productimage/A5E6_131194580536345203BC9Iu1UaPN.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('11', 'Lenovo Yoga Tab', 'COMP', 'Tablet', 
    'Qualcomm Snapdragon MSM8909 (1.1 GHz),Android 5.0 (Lollipop),Touchscreen,Integrated Graphics', 
    '169.99', 'http://images10.newegg.com/productimage/34-321-874-01.jpg');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`) 
VALUES ('12', 'Apple iPad Air 2', 'COMP', 'Tablet', 
    'A8X 1.5,iOS 7,Touchscreen', 
    '349.95', 'http://images10.newegg.com/productimage/A22A_1305960740826429054GSTBIyYiH.jpg');

