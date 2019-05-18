DROP DATABASE IF EXISTS sell_your_car;
CREATE DATABASE sell_your_car;
USE sell_your_car;

CREATE TABLE cars_details(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    additional_features VARCHAR(200),
	long_description VARCHAR(500)
);

CREATE TABLE cars(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	brand VARCHAR(80),
    model VARCHAR(80),
    production_year INTEGER,
	mileage INTEGER,
    engine_power INTEGER,
    fuel_type VARCHAR(20),
    car_details_id BIGINT,
    
	CONSTRAINT `fk_car_details_id`
    FOREIGN KEY (`car_details_id`) 
	REFERENCES `cars_details` (`id`)
    
);

CREATE TABLE locations(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	country VARCHAR(80),
    province VARCHAR(80),
	city VARCHAR(80)
);

CREATE TABLE owners(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(80),
    telephone_number VARCHAR(80),
    email VARCHAR(80)
);



CREATE TABLE auctions(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(80),
    price INTEGER,
    car_id BIGINT,
    owner_id BIGINT,
    location_id BIGINT,
    is_premium BOOLEAN,
    is_deleted BOOLEAN NOT NULL,
    creation_date DATETIME,
    modification_date DATETIME,
    
    CONSTRAINT `fk_car_id`
    FOREIGN KEY (`car_id`) 
	REFERENCES `cars` (`id`),
    
	CONSTRAINT `fk_owner_id`
    FOREIGN KEY (`owner_id`) 
	REFERENCES `owners` (`id`),
    
    CONSTRAINT `fk_location_id`
    FOREIGN KEY (`location_id`) 
	REFERENCES `locations` (`id`)
);

