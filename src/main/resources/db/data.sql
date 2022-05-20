
INSERT INTO 
    clients (name, email)
VALUES 
    ('Jeferson', 'jeferson@propaper.com'),
    ('William', 'william@ufcg.com');

INSERT INTO 
    products (name, price, category, description)
VALUES 
    ('Dell Inspiron', 55000.0, 'notebooks', 'ideal for working');

INSERT INTO 
    leads (name, email, sales_page)
VALUES 
    ('Jeferson', 'jeferson@propaper.com', 'notebooks'),
    ('William', 'william@ufcg.com', 'acessorios');

---------------------------------------------------------------------
-- LEADS
---------------------------------------------------------------------
INSERT INTO 
    sales (client_id, product_id)
VALUES 
    (1, 1),
    (2, 1);


INSERT INTO 
    dummies (name)
VALUES 
    ('Jeferson'),
    ('Monica'),
    ('Icaro'),
    ('William');