insert into  tbl_admins(name,phone,email,username,password) values ('Sam','1234567','sam@email.com','sam','pw');
insert into  tbl_admins(name,phone,email,username,password) values ('Georgie','1234567','georgi@email.com','geor','pw');
insert into  tbl_admins(name,phone,email,username,password) values ('Puck','1234567','puckles@email.com','puck','pw');

insert into  tbl_customers(name,phone,email,username,password) values ('SamC','1234567','sam@email.com','sam','pw');
insert into  tbl_customers(name,phone,email,username,password) values ('GeorgieC','1234567','georgi@email.com','geor','pw');
insert into  tbl_customers(name,phone,email,username,password) values ('PuckC','1234567','puckles@email.com','puck','pw');

insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Dude 1','Mens shoe 1','39.99','/img/1m.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Dude 2','Mens shoe 2','49.99','/img/2m.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Dude 3','Mens shoe 3','59.99','/img/3m.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Lady 1','Womens shoe 1','39.99','/img/1w.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Lady 2','Womens shoe 2','49.99','/img/2w.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Lady 3','Womens shoe 3','59.99','/img/3w.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Kid 1','Childrens shoe 1','39.99','/img/1c.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Kid 2','Childrens shoe 2','49.99','/img/2c.jpg');
insert into  tbl_products(product_name,product_description,product_price,img_url) values ('Kid 3','Childrens shoe 3','59.99','/img/3c.jpg');

insert into  tbl_categories(product_product_id,category_name) values (1,'mens');
insert into  tbl_categories(product_product_id,category_name) values (2,'mens');
insert into  tbl_categories(product_product_id,category_name) values (3,'mens');
insert into  tbl_categories(product_product_id,category_name) values (4,'womens');
insert into  tbl_categories(product_product_id,category_name) values (5,'womens');
insert into  tbl_categories(product_product_id,category_name) values (6,'womens');
insert into  tbl_categories(product_product_id,category_name) values (7,'kids');
insert into  tbl_categories(product_product_id,category_name) values (8,'kids');
insert into  tbl_categories(product_product_id,category_name) values (9,'kids');

insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (9,1,'2020-11-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (8,1,'2020-11-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (1,1,'2020-11-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (4,2,'2020-06-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (5,2,'2020-06-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (6,3,'2020-06-10');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (9,1,'2020-02-11');
insert into  tbl_purchases(product_product_id,customer_id,purchase_date) values (8,2,'2020-01-11');


