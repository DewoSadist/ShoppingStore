-- DROP TABLE restaurant;
--
-- CREATE TABLE restaurant (
--   res_id INTEGER NOT NULL AUTO_INCREMENT,
--   title VARCHAR(100),
--   slug VARCHAR(100),
--   tags VARCHAR(50),
--   description TEXT,
--   logo_image_url VARCHAR(50),
--   header_image_url VARCHAR(50),
--   cover_image_url VARCHAR(50),
--   status VARCHAR(10),
--   country VARCHAR(20),
--   city VARCHAR(20),
--   address VARCHAR(100),
--   location VARCHAR(100),
--   fax VARCHAR(30),
--   phone VARCHAR(30),
--   postal_code VARCHAR(10),
--   open_id INTEGER,
--   ratings INTEGER,
--   PRIMARY KEY (res_id)
-- );
--
-- INSERT INTO restaurant(title, slug, tags, description, logo_image_url, header_image_url, cover_image_url, status, country, city, address, location, fax, phone, postal_code, open_id, ratings)
-- VALUES ('Cactus Club Cafe', 'cactus-club-cafe', 'STEAKS,CHICKEN,BURGERS,SALADS', 'description description description description ', '#', '#', '#', 'OPEN', 'CANADA', 'VANCOUVER', '1530 W Broadway', '49.2635278,-123.1418831', '789 4561234', '789 456 123 1233', 'BC V6J 5K9', 1, 100);
--
-- drop table category;
-- CREATE TABLE category(
--   cat_id INTEGER NOT NULL AUTO_INCREMENT  ,
--   name VARCHAR(100) NOT NULL ,
--   res_id INTEGER NOT NULL ,
--   PRIMARY KEY (cat_id),
-- INDEX f (res_id),
--   CONSTRAINT f FOREIGN KEY (res_id) REFERENCES restaurant(res_id)
-- );
-- INSERT INTO category (name, res_id)
-- VALUES
--   ("STARTERS","1"),
--   ("STEAKS","1"),
--   ("MAINS","1"),
--   ("SALADS","1"),
--   ("BURGERS AND SANDWICHES","1"),
--   ("CLASSICS","1"),
--   ("DESSERTS","1");
--
-- # /////////////////////////////////////////////////////////////////////////////////////
-- DROP  TABLE open_hour;
-- CREATE TABLE open_hour (
--   open_id INTEGER NOT NULL AUTO_INCREMENT  ,
--   day VARCHAR(100) NOT NULL ,
--   open_hour TIME,
--   close_hour TIME,
--   res_id INTEGER NOT NULL ,
--   PRIMARY KEY (open_id),
-- INDEX h (res_id),
--   CONSTRAINT h FOREIGN KEY (res_id) REFERENCES restaurant(res_id)
-- );
-- INSERT INTO open_hour (day, open_hour, close_hour, res_id)
-- VALUES ('EVERYDAY','11:00:00','24:00:00', 1);
-- SELECT * FROM open_hour;
--
-- # ///////////////////////////////////////////////////////////
-- CREATE TABLE product (
--   prod_id INTEGER NOT NULL AUTO_INCREMENT,
--   title VARCHAR(100) NOT NULL ,
--   img_url VARCHAR(100),
--   price DOUBLE(4,2),
--   description TEXT,
--   tags VARCHAR(100),
--   discount INTEGER,
--   cus_id INTEGER NOT NULL,
--   sup_id INTEGER NOT NULL,
--   type_id INTEGER NOT NULL,
--   cat_id INTEGER NOT NULL ,
--   PRIMARY KEY (prod_id),
--   INDEX p (cat_id),
--   CONSTRAINT p FOREIGN KEY (cat_id) REFERENCES category(cat_id)
-- );
-- INSERT INTO product(title, img_url, price, description, tags, discount, cus_id, sup_id, type_id, cat_id) VALUES
--   ('SZECHUAN CHICKEN LETTUCE WRAPS','#','16.50','sweet and spicy szechuan glaze, peanuts, wontons, korean chili sauce, spicy yogurt','spicy',NULL ,0,1,1,1);
--
-- # /////////////////////////////////////////////////////
--
-- DROP  TABLE customization;
-- CREATE TABLE customization (
--   cus_id INTEGER NOT NULL AUTO_INCREMENT  ,
--   name  VARCHAR(100) NOT NULL ,
--   price DOUBLE(4,2),
--   added BOOLEAN,
--   prod_id INTEGER NOT NULL ,
--   PRIMARY KEY (cus_id),
-- INDEX c (prod_id),
-- CONSTRAINT c FOREIGN KEY (prod_id) REFERENCES product(prod_id)
-- );
-- INSERT INTO open_hour (day, open_hour, close_hour, res_id)
-- VALUES ('EVERYDAY','11:00:00','24:00:00', 1);
-- SELECT * FROM open_hour;
--
-- # /////////////////////////////////////////////////////
--
-- DROP  TABLE customer;
-- CREATE TABLE customer (
--   customer_id INTEGER NOT NULL AUTO_INCREMENT,
--   name  VARCHAR(100) NOT NULL,
--   fname  VARCHAR(100) NOT NULL,
--   lname  VARCHAR(100) NOT NULL,
--   country VARCHAR(20),
--   city VARCHAR(20),
--   address VARCHAR(100),
--   location VARCHAR(100),
--   fax VARCHAR(30),
--   phone VARCHAR(30),
--   postal_code VARCHAR(10),
--   email VARCHAR(30),
--   PRIMARY KEY (customer_id)
-- );
-- INSERT INTO customer(name, fname, lname, country, city, address, location, fax, phone, postal_code, email) VALUES
--   ('Daulet','O','M','Kazakhstan','Almaty','Dostyk','48 -123','--','+77021028022','050028','orynbaidaulet@gmail.com');
-- # ////////////////////////////////////
-- DROP  TABLE orders;
--
-- CREATE TABLE orders (
--   order_id INTEGER NOT NULL AUTO_INCREMENT,
--   employee_id INTEGER,
--   order_day DATE,
--   order_time TIME,
--   req_time TIME,
--   req_day DATE,
--   ship_via VARCHAR(20),
--   order_amount  VARCHAR(10) NOT NULL,
--   customer_id INTEGER NOT NULL ,
--   PRIMARY KEY (order_id),
-- INDEX o (customer_id),
--   CONSTRAINT o FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
-- );
--
--
-- # /////////////////
--
-- CREATE TABLE order_details (
--   order_id INTEGER NOT NULL,
--   prod_id  INTEGER NOT NULL,
--   unit_price DOUBLE(4,2),
--   quantity INTEGER,
-- description TEXT
-- );

SELECT * FROM restaurant;


