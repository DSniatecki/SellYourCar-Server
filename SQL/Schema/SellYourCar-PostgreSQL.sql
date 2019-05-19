
CREATE TABLE cars(
	id BIGSERIAL PRIMARY KEY,
	brand VARCHAR(80),
    model VARCHAR(80),
    production_year INTEGER,
	mileage INTEGER,
    engine_power INTEGER,
    fuel_type VARCHAR(20),
    car_details_id BIGINT,
    
	CONSTRAINT fk_car_details_id
    FOREIGN KEY (car_details_id) 
	REFERENCES cars_details (id)
    
);

CREATE TABLE locations(
	id BIGSERIAL PRIMARY KEY,
	country VARCHAR(80),
    province VARCHAR(80),
	city VARCHAR(80)
);

CREATE TABLE owners(
	id BIGSERIAL PRIMARY KEY,
	username VARCHAR(80),
    telephone_number VARCHAR(80),
    email VARCHAR(80)
);



CREATE TABLE auctions(
	id BIGSERIAL PRIMARY KEY,
    title VARCHAR(80),
    price INTEGER,
    car_id BIGINT,
    owner_id BIGINT,
    location_id BIGINT,
    is_premium BOOLEAN,
    is_deleted BOOLEAN NOT NULL,
    creation_date TIMESTAMP,
    modification_date TIMESTAMP,
    
    CONSTRAINT fk_car_id
    FOREIGN KEY (car_id) 
	REFERENCES cars (id),
    
	CONSTRAINT fk_owner_id
    FOREIGN KEY (owner_id) 
	REFERENCES owners (id),
    
    CONSTRAINT fk_location_id
    FOREIGN KEY (location_id) 
	REFERENCES locations (id)
);