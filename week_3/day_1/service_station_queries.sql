CREATE DATABASE service_station;
CREATE TABLE `station` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`address` VARCHAR(200),
	`contact` VARCHAR(15),
	PRIMARY KEY (`id`)
);

CREATE TABLE `employee` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`age` INT,
	`contact` VARCHAR(15),
	PRIMARY KEY (`id`)
);

CREATE TABLE `customer` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100),
	`age` INT,
	`contact` VARCHAR(15),
	`emp_id` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`emp_id`) REFERENCES `employee`(`id`)
);

CREATE TABLE `vehicle` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type` VARCHAR(5) NOT NULL CHECK (`type` = car or `type` = bike or `type` = bus),
	`brand` VARCHAR(15),
	`color` VARCHAR(15),
	`service_charge` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `invoices` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`customer` INT NOT NULL,
	`vehicle` INT NOT NULL,
	`amount_total` INT NOT NULL,
	`employee_assigned` INT NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`customer`) REFERENCES `customer`(`id`),
	FOREIGN KEY(`vehicle`) REFERENCES `vehicle`(`id`),
	FOREIGN KEY(`employee_assigned`) REFERENCES `employee`(`id`)
);

DROP TABLE `invoices`;
DROP TABLE `vehicle`;
DROP TABLE `customer`;
DROP TABLE `employee`;
DROP TABLE `station`;
DROP DATABASE `service_station`;

-- CREATE TABLE `invoices` (
-- 	`id` INT NOT NULL AUTO_INCREMENT,
-- 	`name_of_owner` VARCHAR(100),
-- 	`vehicle` INT NOT NULL,
-- 	`amount_total` INT NOT NULL,
-- 	`employee_assigned` INT NOT NULL,
-- 	PRIMARY KEY (`id`),
-- 	FOREIGN KEY(`vehicle`) REFERENCES `vehicle`(`id`),
-- 	FOREIGN KEY(`employee_assigned`) REFERENCES `employee`(`id`),
-- );