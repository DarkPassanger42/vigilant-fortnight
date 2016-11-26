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

-- Gaming console

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('13', '500GB XBOX 1S', 'GAMING', 'Console',
    'Battlefield 1 Bundle',
    '299.99', 'http://images10.newegg.com/productimage/68-105-191-02.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('14', '500GB Playstation 4', 'GAMING', 'Console',
    'Includes: 500GB PlayStation 4 System, 1 DualShock 4 Wireless Controller, AC Power Cable, HDMI Cable, USB 2.0 Cable, Mono Wired Headset.',
    '279.99', 'http://images10.newegg.com/productimage/68-110-152-06.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('15', 'PlayStation Vita WiFi', 'GAMING', 'Console',
    'Designed for Superior Gameplay: The slim, sleek, and light design of the PS Vita makes it comfortable to hold and the dual analog controls provide a deeply immersive gameplay experience.',
    '229.69', 'http://images10.newegg.com/productimage/68-110-158-08.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('16', 'Nintendo Nintendo New 3DS XL', 'GAMING', 'Console',
    'Open a "New" world of gaming',
    '209.99', 'http://images10.newegg.com/ProductImageCompressAll1280/68-100-168_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('17', 'Nintendo Mario Kart 8 Wii U 32GB Deluxe Edition', 'GAMING', 'Console',
    '32GB Black Wii U Consol',
    '299.99', 'http://images10.newegg.com/productimage/68-100-178-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('18', 'PRE-OWNED FIFA 14 PS4', 'GAMING', 'Console',
    'ESRB Rating E - Everyone',
    '19.99', 'http://images10.newegg.com/productimage/79-204-036-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('19', 'Pre-owned LEGO Marvel Super Heroes 3DS', 'GAMING', 'Console',
    'ESRB Rating E10+ for Everyone 10+',
    '14.99', 'http://images10.newegg.com/productimage/78-330-145-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('20', 'PRE-OWNED Thief Xbox One', 'GAMING', 'Console',
    'ESRB Rating M - Mature',
    '14.99', 'http://images10.newegg.com/productimage/74-165-067-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('21', 'PRE-OWNED Need for Speed: Rivals PS4', 'GAMING', 'Console',
    'ESRB Rating E for Everyone 10+',
    '24.99', 'http://images10.newegg.com/productimage/79-204-035-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('22', 'PRE-OWNED Zumba Fitness: World Party Xbox One', 'GAMING', 'Console',
    'ESRB Rating E - Everyone',
    '27.99', 'http://images10.newegg.com/productimage/74-152-034-01.jpg?ex=2');

-- Gaming Computer

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('23', 'DELL Desktop Computer Alienware', 'GAMING', 'PC',
    'ASM100-980 Intel Core i3 4170T (3.20 GHz) 4 GB DDR3 500 GB HDD',
    '311.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/83-159-274_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('24', 'Lenovo Desktop Computer', 'GAMING', 'PC',
    'Intel Core i7 6700 (3.4 GHz) 8 GB DDR4 2 TB + 8 GB SSHD + 120 GB SSD',
    '1149.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-798-522_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('25', 'HP Desktop Computer ENVY Phoenix', 'GAMING', 'PC',
    'Intel Core i7 6th Gen 6700K (4.00 GHz) 16 GB DDR4 2 TB HDD 128 GB SSD',
    '1442.00', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/83-283-618_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('26', 'DELL Desktop Computer XPS', 'GAMING', 'PC',
    'Intel Core i7 6th Gen 6700 (3.4 GHz) 16 GB DDR4 2 TB HDD',
    '949.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-158-721-23.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('27', 'iBUYPOWER Desktop Computer', 'GAMING', 'PC',
    'Intel Core i7 5th Gen 5820K (3.30 GHz) 16 GB DDR4 1 TB HDD 120 GB SSD',
    '1399.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-227-625_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('28', 'Call of Duty Black Ops III - PC', 'GAMING', 'PC',
    'M - Mature',
    '49.99', 'http://images10.newegg.com/productimage/32-133-404-10.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('29', 'XCOM 2 - PC', 'GAMING', 'PC',
    'Configure and build rooms on the Avenger to give XCOM new capabilities on the battlefield.',
    '59.99', 'http://images10.newegg.com/productimage/32-205-273-07.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('30', 'Fallout 4 - PC', 'GAMING', 'PC',
    'Next generation of open-world gaming',
    '49.99', 'http://images10.newegg.com/productimage/32-136-062-02.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('31', 'Star Wars: Battlefront - Standard Edition - PC', 'GAMING', 'PC',
    'Pilot a diverse set of ground-based vehicles including nimble speeder bikes, massive AT-ATs, and more',
    '19.99', 'http://images10.newegg.com/productimage/32-130-345-18.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('32', 'NBA 2K16', 'GAMING', 'PC',
    '10+ - Everyone 10+',
    '59.99', 'http://images10.newegg.com/productimage/32-205-275-03.jpg?ex=2');

-- TV Video

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('33', 'HP Pavilion 27c Curved LCD Monitor', 'ELECTRONICS', 'TV/Video',
        'Built-in Speakers with DTS Audio Technology, Control Simplicity and Open-Wedge Designed Stand, VGA',
        '299.99', 'http://images10.newegg.com/ProductImageCompressAll1280/24-276-204_R01.jpg?w=660&h=500');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('34', 'Acer K242HQL 23.6 LCD Monitor', 'ELECTRONICS', 'TV/Video',
        'Widescreen LED/LCD Monitor 1920x1080 Resolution at 60Hz Refresh Rate',
        '99.99', 'http://images10.newegg.com/ProductImageCompressAll1280/24-011-066_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('35', 'HP Pavilion Black 32', 'ELECTRONICS', 'TV/Video',
        '60HZ Ultrawide LED Backlight LCD Monitors, 2560 x 1080 (2K), W/ Anti-Glare',
        '329.99', 'http://images10.newegg.com/productimage/24-276-433-06.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('36', 'BenQ GL2460HM Black 24-Inch Monitor', 'ELECTRONICS', 'TV/Video',
        'LCD/LED Monitor, 250 cd/m2 DCR 12,000,000:1 (1000:1), Built-in Speakers, VESA Mountable, HDMI DVI',
        '139.99', 'http://images10.newegg.com/ProductImageCompressAll1280/24-014-377-09.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('37', 'LG 25UM56-P 25-Inch Monitor', 'ELECTRONICS', 'TV/Video',
        'Gaming Monitor 5ms 2560 x 1080 5ms GTG 60Hz 5,000,000:1 Contrast Ratio with Black Stabilizer',
        '199.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/24-025-212-10.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('38', 'TCL 32S3800 32Inch Style Series 720p Smart LED', 'ELECTRONICS', 'TV/Video',
        'Personalized Home Screen',
        '169.99', 'http://images10.newegg.com/productimage/A1CZ_1307713514729498951crRVtIo8S.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('39', 'Samsung UN40J6200AFXZA 40-Inch 1080p HD Smart LED TV - Black', 'ELECTRONICS', 'TV/Video',
        'Full HD 1080p - Enjoy a viewing experience that is 2X the clarity of standard HD TVs.',
        '277.99', 'http://images10.newegg.com/ProductImageCompressAll1280/89-354-955-05.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('40', 'Rosewill RC-6-HDM-MM-BK-3 6 ft. Black High Speed HDMI Cable M-M', 'ELECTRONICS', 'TV/Video',
        'Noise Prevention with Bronze Case Shielding Plus 2 Extra Layers of Shielding',
        '3.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/82-021-128-12.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('41', 'Coboc Model EA-CL2-VGA-15-BK 15 ft.', 'ELECTRONICS', 'TV/Video',
        '2 Connector Number',
        '4.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/12-423-009-02.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('42', 'SAPPHIRE 14-999-201 DVI to VGA adapter', 'ELECTRONICS', 'TV/Video',
        'Converts LCD/ DVI port into VGA port, works with most video cards (will not work with DVI-D and DVIS ports)
DVI male to VGA Female',
        '7.49', 'http://images10.newegg.com/NeweggImage/productimage/14-999-201-02.jpg?ex=2');

-- Audio

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('43', 'BOSE Companion 2 Series III Multimedia Speaker System', 'ELECTRONICS', 'Audio',
        'Digital Signal Processing',
        '99.00', 'http://images10.newegg.com/ProductImageCompressAll1280/36-627-006-04.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('44', 'HP Pavilion 27c Curved LCD Monitor', 'ELECTRONICS', 'Audio',
        'Built In Headphone Jack',
        '99.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/36-121-048-07.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('45', 'Corsair Gaming Audio Series SP2500 High-power 2.1 PC Speaker System', 'ELECTRONICS', 'Audio',
        '2.1 High Performance 232 Watts RMS',
        '299.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/36-852-001-11.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('46', 'Logitech S120 2.30 Watts (RMS) 2.0 Speaker System', 'ELECTRONICS', 'Audio',
        '2.30 Watts RMS (1.15 Watts x 2)',
        '12.99', 'http://images10.newegg.com/NeweggImage/productimage/36-121-013-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('47', 'Logitech Z130 5W Speakers', 'ELECTRONICS', 'TV/Video',
        'Convenient on-speaker controls',
        '23.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/36-121-042_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('48', 'Gear Head SP1500USB', 'ELECTRONICS', 'Audio',
        '3W 2.0 Speaker',
        '10.99', 'http://images10.newegg.com/productimage/A0FU_1_20120703_9835941.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('49', 'Logitech Z906 500W 5.1 Speakers', 'ELECTRONICS', 'Audio',
        'THX Certified 5.1 Speakers 500 Watts RMS',
        '329.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/36-121-050-09.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('50', 'Genius GX Gaming SW-G2.1 1250 38 Watts RMS 2.1 Speaker System', 'ELECTRONICS', 'Audio',
        'Ultra-rigid MDF cabinet subwoofer',
        '49.00', 'http://images10.newegg.com/ProductImageCompressAll1280/36-110-059-04.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('51', 'Razer Leviathan Mini Bluetooth Speaker', 'ELECTRONICS', 'Audio',
        'Powerful lows and crystal clear highs in an ultra-portable speaker',
        '199.99', 'http://images10.newegg.com/ProductImageCompressAll1280/36-556-006_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('52', 'Audioengine A2+ Limited Edition Premium Powered Desktop Speakers - Pair (Red)', 'ELECTRONICS', 'Audio',
        'Versatile connections including USB digital audio and subwoofer output',
        '249.00', 'http://images10.newegg.com/productimage/A1J7_1_201608202016249112.jpg?ex=2');

-- More PC

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('53', 'HP All-in-One Computer ProOne 400 G2', 'COMP', 'Desktop',
        'Intel Core i5 6th Gen 6500 (3.20 GHz) 8 GB 128 GB SSD 20" Windows 10 Pro 64-Bit',
        '549.99', 'http://images10.newegg.com/productimage/83-285-620-02.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('54', 'Lenovo All-in-One Computer IdeaCentre 510-23ISH', 'COMP', 'Desktop',
        'Intel Core i3 6th Gen 6100T (3.20 GHz) 8 GB DDR4 1 TB HDD 23" Touchscreen Windows 10 Home 64-Bit',
        '619.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-795-359-01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('55', 'ASUS All-in-One Computer Z240-C2', 'COMP', 'Desktop',
        '16 GB DDR4 1 TB HDD 512 GB SSD NVIDIA GeForce GTX 960M 2 GB 23.8" IPS 3840 x 2160 Touchscreen Windows 10 Home 64-Bit',
        '1889.99', 'http://images10.newegg.com/productimage/83-221-198-22.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('56', 'Acer All-in-One Computer Aspire U5 AU5-620-UR53', 'COMP', 'Desktop',
        'Intel Core i5 4200M (2.50 GHz) 8 GB DDR3 1 TB HDD 23" Touchscreen Windows 10 Home',
        '760.99', 'http://images10.newegg.com/productimage/83-101-250-29.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('57', 'MSI Gaming All-in-One Computer 24 6QE-022US', 'COMP', 'Desktop',
        'Intel Core i7 6700HQ (2.6 GHz) 12 GB DDR4 1 TB HDD NVIDIA GeForce GTX 960M 4 GB GDDR5 23.6" 1920 x 1080 Windows 10 Home 64-Bit',
        '899.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-152-135_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('58', 'DELL All-in-One Computer Inspiron', 'COMP', 'Desktop',
        '8 GB DDR3 1 TB HDD 23" Touchscreen Windows 10 Home 64-Bit',
        '1699.99', 'http://images10.newegg.com/productimage/83-158-307-11.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('59', 'ABS Vortex Harbinger ALI109 Desktop PC ', 'COMP', 'Desktop',
        'Intel Core i5-6402P (2.80 GHz) 8 GB DDR4 1 TB HDD RX 480 4 GB Windows 10 Home 64-Bit',
        '699.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/83-102-250-Z01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('60', 'CyberpowerPC Desktop PC GXS111', 'COMP', 'Desktop',
        'Core i5 6th Gen 6402P (2.80 GHz) 8 GB DDR4 1 TB HDD NVIDIA GeForce GTX 1060 Windows 10 Home 64-Bit',
        '799.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/83-230-146-01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('61', 'DELL Desktop Computer OptiPlex 3040', 'COMP', 'Desktop',
        'Intel Core i5 6th Gen 6500 (3.20 GHz) 4 GB DDR3L 500 GB HDD Intel HD Graphics 530 Windows 7 Professional 64-Bit (Includes Windows 10 Pro License)',
        '514.99', 'http://images10.newegg.com/ProductImageCompressAll1280/83-159-482_R01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('62', 'Intel Mini PC NUC', 'COMP', 'Desktop',
        '2 GB DDR3 32 GB eMMC SSD Intel HD Graphics Windows 10 Home 64-Bit',
        '234.99', 'http://images10.newegg.com/productimage/83-800-009-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('63', 'Apple Mac Mini ', 'COMP', 'Desktop',
        'Intel Core i5 1.4GHz, 4GB DDR3 500GB HDD, Mac OS X Yosemite',
        '569.95', 'http://images10.newegg.com/productimage/A6V6_1306894174163148647kCVnGfCYS.jpg?ex=2');

-- More Laptop

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('64', 'HP Spectre x360 13.3', 'COMP', 'Laptop',
    'Full HD 2-in-1 Touchscreen Notebook - Intel Core i7-5500U, 8GB RAM, 256GB SSD - Windows 8.1 - Silver',
    '799.99', 'http://images10.newegg.com/productimage/1TS-000D-00WN5-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('65', 'Lenovo IdeaPad Y700', 'COMP', 'Laptop',
    'Intel Core i7 6700HQ 16 GB Memory 1 TB HDD 256 GB PCIE SSD GeForce GTX 960M 4 GB 15.6 FHD Windows 10 Home 64-Bit',
    '999.99', 'http://images10.newegg.com/productimage/34-331-907-04.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('66', 'MSI 15.6 GL62', 'COMP', 'Laptop',
    'Intel Core i5 6300HQ (2.30 GHz) NVIDIA GeForce GTX 960M 8 GB Memory 1 TB HDD Windows 10 Home 64-Bit Gaming Laptop',
    '699.99', 'http://images10.newegg.com/productimage/34-154-112-11.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('67', 'Acer Laptop Aspire E E5-774G-570J', 'COMP', 'Laptop',
    'ntel Core i5 6200U (2.30 GHz) 8 GB Memory 1 TB HDD NVIDIA GeForce 940MX 17.3" Windows 10 Home',
    '599.99', 'http://images10.newegg.com/NeweggImage/productimage/34-315-446-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('68', 'Apple MMGF2LL/A MacBook Air 13.3-Inch Laptop', 'COMP', 'Laptop',
    '1.6 GHz dual-core Intel Core i5 (Turbo Boost up to 2.7 GHz) with 3 MB shared L3 cache, 8 GB of 1600 MHz LPDDR3 RAM; 128 GB PCIe-based flash storage',
    '894.99', 'http://images10.newegg.com/productimage/2SN-0001-003M4-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('69', 'Apple MacBook Pro MF839LL/A 13.3-Inch Laptop with Retina Display', 'COMP', 'Laptop',
    'Intel Core i5 2.70 GHz, 8 GB Memory, Mac OS X v10.10 Yosemite',
    '1186.49', 'http://images10.newegg.com/productimage/A4HM_130743657530531889km7IPQln1E.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('70', 'GIGABYTE Aero 14K-BKNE1', 'COMP', 'Laptop',
    'Intel Core i7 6700HQ (2.60 GHz) 16 GB Memory 256 GB SSD NVIDIA GeForce GTX 965M 2 GB GDDR5 14.0" QHD 3K IPS 94.24Wh (10 hours) Huge Battery Capacity Windows 10 Home 64-Bit',
    '1229.00', 'http://images10.newegg.com/ProductImageCompressAll1280/34-233-174-01.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('71', 'HP Laptop 250 G5', 'COMP', 'Laptop',
    'Intel Core i3 5005U (2.0 GHz) 4 GB Memory 500 GB HDD Intel HD Graphics 5500 15.6" Windows 10 Pro 64-Bit',
    '384.99', 'http://images10.newegg.com/productimage/34-265-794-01.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('72', 'Apple Laptop MacBook Pro MJLQ2LL', 'COMP', 'Laptop',
    'Intel Core i7 2.20 GHz 16 GB Memory 256 GB SSD 15.4',
    '1775.59', 'http://images10.newegg.com/productimage/A4HM_130798240823236259SFH3WXu4cg.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('73', 'Aorus X3 Plus v5-CF3', 'COMP', 'Laptop',
    'Generation Intel Core i7 6700HQ (2.60 GHz) 16 GB Memory 1 TB SSD NVIDIA GeForce GTX 970M 6 GB GDDR5 13.9" Windows 10 Home',
    '1499.00', 'http://images10.newegg.com/productimage/34-233-154-05.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('74', 'Apple Laptop MacBook MK4M2LL', 'COMP', 'Laptop',
    'Intel Core M 1.10 GHz 8 GB Memory 256 GB SSD Intel HD Graphics 5300 12.0" Mac OS X v10.10 Yosemite',
    '1239.00', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/34-100-408-01.jpg?ex=2');

-- More Tablet

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('75', 'ASUS Z500M-C1-GR MTK', 'COMP', 'Tablet',
    '4 GB LPDDR3 Memory 64 GB eMMC 9.7" Touchscreen Tablet Android 6.0 (Marshmallow)',
    '299.99', 'http://images10.newegg.com/productimage/34-234-280-07.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('76', 'Lenovo Yoga 3', 'COMP', 'Tablet',
    'Qualcomm Snapdragon 1 GB Memory 16 GB eMMC 10.0" IPS Tablet Android 5.0 (Lollipop)',
    '198.99', 'http://images10.newegg.com/productimage/34-321-875-03.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('77', 'Microsoft Surface Pro 3', 'COMP', 'Tablet',
    'Tablet Core i5-4300U 8GB 256GB Windows 10 Pro',
    '799.99', 'http://images10.newegg.com/productimage/A5E6_131224167734162772xQogQYbv0u.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('78', 'Vulcan JOURNEY', 'COMP', 'Tablet',
    'Intel Atom 1 GB Memory 16 GB eMMC 7" Touchscreen Tablet Windows 10 Home',
    '59.99', 'http://images10.newegg.com/ProductImageCompressAll1280/34-734-022-04.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('79', 'DigiLand DL718M', 'COMP', 'Tablet',
    'ARM Cortex-A7 1 GB Memory 8 GB Flash Storage 7" Touchscreen Tablet Android 5.1 (Lollipop)',
    '44.99', 'http://images10.newegg.com/productimage/34-618-003-02.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('80', 'Apple iPad Air 2', 'COMP', 'Tablet',
    'A8X 1.5, iOS 7, Touchscreen',
    '365.99', 'http://images10.newegg.com/productimage/A22A_1305960740826429054GSTBIyYiH.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('81', 'Apple iPad Mini', 'COMP', 'Tablet',
    'A7 chip with 64-bit architecture and M7 motion coprocessor 1GB Memory 16GB',
    '256.50', 'http://images10.newegg.com/productimage/58-753-324-03.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('82', 'Apple iPad Pro', 'COMP', 'Tablet',
    'Apple A9X 128 GB Flash Storage 9.7 Touchscreen Tablet iOS 9',
    '649.99', 'http://images10.newegg.com/productimage/A378_131048806155085214pyDKQpy7qT.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('83', 'Nvidia Shield Tegra k-1', 'COMP', 'Tablet',
    '8.0 inch 16GB Tablet Bundle (with Cover)',
    '339.99', 'http://images10.newegg.com/productimage/A6V6_131178473502281920j1ThmMdmYg.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('84', 'Samsung Galaxy Tab', 'COMP', 'Tablet',
    '16 GB Tablet - 10.1 - Plane to Line (PLS) Switching - Wireless LAN - Samsung Exynos 4210 Octa-core (8 Core) 1.60 GHz - Pearl White',
    '239.99', 'http://images10.newegg.com/productimage/A3FA_1_201607261272569459.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('85', 'Microsoft Surface 2', 'COMP', 'Tablet',
    '32 GB - Touch Screen with Windows 10',
    '149.99', 'http://images10.newegg.com/productimage/AAKK_1_201604201978517072.jpg?ex=2');

-- More TV Video

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('86', 'Dell S2240T Black 21.5 inch', 'ELECTRONICS', 'TV/Video',
        'Projected Capacitive LED Backlight Touch Monitor Multi-touch 8,000,000:1',
        '298.99', 'http://images10.newegg.com/NeweggImage/ProductImageCompressAll1280/24-260-139-09.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('87', 'Acer T272HLbmjjz 27 inch', 'ELECTRONICS', 'TV/Video',
        'Touchscreen 10-pt Capacitive Touch Widescreen Monitor 300 cd/m2 5000:1 Built-in Speakers',
        '499.99', 'http://images10.newegg.com/ProductImageCompressAll1280/24-009-591-08.jpg?w=660&h=500&ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('88', 'PLANAR Helium PCT2785 Black 27 inch', 'ELECTRONICS', 'TV/Video',
        'USB Projected Capacitive HDMI Multi-Touch Edge LED LCD Monitor 264 cd/m2 5000:1 w/webcam& Microphone',
        '509.99', 'http://images10.newegg.com/productimage/24-016-310-03.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('89', 'ViewSonic TD3240 TD3240 32 inch', 'ELECTRONICS', 'TV/Video',
        'Large productsFormat Monitor - IPS - Multi-touch 315 cd/m2 3000:1 Built-in Speakers',
        '2999.99', 'http://images10.newegg.com/productimage/24-116-651-03.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('90', 'Sharp LL-S201A 20 inch', 'ELECTRONICS', 'TV/Video',
        'Edge LED LCD Touchscreen Monitor - 16:9 - 5 ms',
        '641.74', 'http://images10.newegg.com/productimage/A91N_1_20160401660340116.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('91', 'HElo 1590L 15 inch', 'ELECTRONICS', 'TV/Video',
        'LED Open-frame LCD Touchscreen Monitor - 4:3 - 16 ms',
        '439.99', 'http://images10.newegg.com/NeweggImage/productimage/V069_1_201604171249869534.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('92', 'TruTouch 650 - 65 inch', 'ELECTRONICS', 'TV/Video',
        'Full-HD (1080p) Multi-Touchscreen LED Display from Newline Interactive',
        '6418.93', 'http://images10.newegg.com/productimage/A3EM_1302927231681831858WwvIFGWpa.jpg?ex=2');

INSERT INTO `webstoredb`.`products` (`ID`, `Name`, `Category`, `Subcategory`, `Description`, `Price`, `ImageLocation`)
VALUES ('93', '3M M2767PW Black 27 inch', 'ELECTRONICS', 'TV/Video',
        'USB Projected Capacitive 40-finger Multi-touch Monitor 250 cd/m2 5000:1 Built-in Speakers',
        '1791.99', 'http://images10.newegg.com/NeweggImage/productimage/24-227-093-02.jpg?ex=2');
