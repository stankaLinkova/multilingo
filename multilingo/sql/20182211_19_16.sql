-- MySQL Workbench Synchronization
-- Generated: 2018-11-22 19:14
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Jiro

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `multilingo_project`.`Course` 
DROP FOREIGN KEY `fk_Course_School`;

ALTER TABLE `multilingo_project`.`Test` 
DROP FOREIGN KEY `fk_Test_School1`;

ALTER TABLE `multilingo_project`.`Question` 
DROP FOREIGN KEY `fk_Question_Test1`;

ALTER TABLE `multilingo_project`.`Course_has_Student` 
DROP FOREIGN KEY `fk_Course_has_Student_Course1`,
DROP FOREIGN KEY `fk_Course_has_Student_Student1`;

ALTER TABLE `multilingo_project`.`Student_has_Test` 
DROP FOREIGN KEY `fk_Student_has_Test_Student1`,
DROP FOREIGN KEY `fk_Student_has_Test_Test1`;

ALTER TABLE `multilingo_project`.`Sign_in` 
DROP FOREIGN KEY `fk_Sign_in_School1`,
DROP FOREIGN KEY `fk_Sign_in_Student1`;

ALTER TABLE `multilingo_project`.`Course` 
ADD CONSTRAINT `fk_Course_School`
  FOREIGN KEY (`School_idSchool`)
  REFERENCES `multilingo_project`.`School` (`idSchool`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `multilingo_project`.`Test` 
ADD CONSTRAINT `fk_Test_School1`
  FOREIGN KEY (`School_idSchool`)
  REFERENCES `multilingo_project`.`School` (`idSchool`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `multilingo_project`.`Question` 
ADD CONSTRAINT `fk_Question_Test1`
  FOREIGN KEY (`Test_idTest`)
  REFERENCES `multilingo_project`.`Test` (`idTest`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `multilingo_project`.`Course_has_Student` 
ADD CONSTRAINT `fk_Course_has_Student_Course1`
  FOREIGN KEY (`Course_idCourse`)
  REFERENCES `multilingo_project`.`Course` (`idCourse`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Course_has_Student_Student1`
  FOREIGN KEY (`Student_idStudent`)
  REFERENCES `multilingo_project`.`Student` (`idStudent`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `multilingo_project`.`Student_has_Test` 
ADD CONSTRAINT `fk_Student_has_Test_Student1`
  FOREIGN KEY (`Student_idStudent`)
  REFERENCES `multilingo_project`.`Student` (`idStudent`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Student_has_Test_Test1`
  FOREIGN KEY (`Test_idTest`)
  REFERENCES `multilingo_project`.`Test` (`idTest`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `multilingo_project`.`Sign_in` 
ADD CONSTRAINT `fk_Sign_in_School1`
  FOREIGN KEY (`School_idSchool`)
  REFERENCES `multilingo_project`.`School` (`idSchool`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Sign_in_Student1`
  FOREIGN KEY (`Student_idStudent`)
  REFERENCES `multilingo_project`.`Student` (`idStudent`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
