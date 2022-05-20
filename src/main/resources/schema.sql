/*CREATE TABLE IF NOT EXISTS public.client
(
    "ID" integer,
    "NAME" "char"[],
    "EMAIL" "char"[]
);*/

CREATE TABLE client (
    id   INTEGER       NOT NULL AUTO_INCREMENT,
    name VARCHAR(128)  NOT NULL,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product (
    id   INTEGER       NOT NULL AUTO_INCREMENT,
    name VARCHAR(128)  NOT NULL,
    price NUMERIC(8,2) NOT NULL,
    category VARCHAR(128) NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE sale (
  client_id INTEGER  NOT NULL,
  product_id INTEGER NOT NULL,
  timestamp TIMESTAMP,
  PRIMARY KEY (client_id, product_id),
  FOREIGN KEY (client_id)
      REFERENCES client (id),
  FOREIGN KEY (product_id)
      REFERENCES product (id)
);

CREATE TABLE lead (
    id   INTEGER       NOT NULL AUTO_INCREMENT,
    name VARCHAR(128)  NOT NULL,
    email VARCHAR(128) NOT NULL,
    sales_page VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

