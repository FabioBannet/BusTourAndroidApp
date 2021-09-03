CREATE TABLE IF NOT EXISTS buyer(
    id SERIAL PRIMARY KEY,
    FIO VARCHAR(500) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket(
    id SERIAL PRIMARY KEY,

    direction VARCHAR(500) NOT NULL,
    date VARCHAR(6) NOT NULL,
    departure_time VARCHAR(6) NOT NULL,
    arrival_time VARCHAR(6) NOT NULL,
    seat VARCHAR(10) NOT NULL,
    price DOUBLE(13,2) NOT NULL,

    buyer_id INTEGER NULL
);