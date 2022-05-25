CREATE TABLE IF NOT EXISTS client (
    id   serial PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    email VARCHAR ( 255 ) NOT NULL
);


CREATE TABLE IF NOT EXISTS product (
    id   serial PRIMARY KEY,
    name VARCHAR(128)  NOT NULL,
    price NUMERIC(8,2) NOT NULL,
    category VARCHAR(128) NOT NULL,
    description VARCHAR(1024) NOT NULL
);

CREATE TABLE IF NOT EXISTS sale (
  client_id INTEGER  NOT NULL,
  product_id INTEGER NOT NULL,
  timestamp TIMESTAMP,
  PRIMARY KEY (client_id, product_id),
  FOREIGN KEY (client_id)
      REFERENCES client (id),
  FOREIGN KEY (product_id)
      REFERENCES product (id)
);

CREATE TABLE IF NOT EXISTS lead (
    id   serial PRIMARY KEY,
    name VARCHAR(128)  NOT NULL,
    email VARCHAR(128) NOT NULL,
    sales_page VARCHAR(128) NOT NULL
);

TRUNCATE TABLE sale CASCADE;
TRUNCATE TABLE lead CASCADE;
TRUNCATE TABLE client CASCADE;
TRUNCATE TABLE product CASCADE;
