create sequence n1 increment by 1 start with 1201; --user_details
create sequence n3 increment by 1 start with 1601; --restaurant_details
create sequence n2 increment by 1 start with 1401; --food_items
create sequence n4 increment by 1 start with 1801; --order_foods
drop sequence n1;
CREATE TABLE user_details ( user_id int default n1.nextval,  
                                user_name varchar2(30) not null,  
                                phone_no number not null, 
                                role varchar2(10) Default 'user',
                                address varchar2(100) not null, 
                                email_address varchar2(100) not null,  
                                password varchar2(20) not null, 
                                wallet int default 0,
                                constraint con_user_id primary key(user_id),  
                                unique(email_address), unique(phone_no));
                                
alter table user_details modify wallet int default 0;
 
INSERT INTO user_details(user_name, phone_no, role, address, email_address, password, wallet) values('jeyram', 9500727441, 'Admin', '153WestStreet,Melur,625106', 'jeyram@gmail.com','Jeyram1010', 0);                         

CREATE TABLE restaurant_details ( restaurant_id int default n3.nextval, 
                                  restaurant_name varchar2(30) not null,
                                  area varchar2(100) not null, 
                                  city varchar2(100) not null,  
                                  pincode number not null,  
                                  restaurant_landline_no number not null, 
                                  owner_name varchar2(30) not null, 
                                  operational_hours varchar2(20) not null,
                                  email varchar2(50) not null, 
                                  password varchar2(20) not null,
                                  image varchar2(50) not null,
                                  constraint con_restaurant_id primary key(restaurant_id), 
                                  unique(email),unique(restaurant_landline_no),
                                  restaurant_status varchar2(10) default 'active');
                                  
update food_items set price=70 where item_id =1423;                                  
update restaurant_details set restaurant_name='vjhotel' where restaurant_id=1661;
CREATE TABLE food_items(restaurant_id int not null,
                        item_id int default n2.nextval, 
                        food_name varchar2(30) not null,
                        cuisine_name varchar2(30) not null,
                        description varchar2(100) not null,  
                        price number not null,
                        image varchar2(50) not null,
                        constraint con_item_id primary key(item_id),
                        constraint con_restaurant_id1 foreign key(restaurant_id) references restaurant_details(restaurant_id)); 

insert into food_items(restaurant_id, food_name, cuisine_name, description, price, food_image)values(1716, 'chickenrice', 'Indian', 'meals', 60, 'restaurant1.jpg'); 

alter table food_items modify price number;

CREATE TABLE order_foods ( order_id int default n4.nextval, 
                           user_id int not null,
                           item_id int not null,  
                           quantity int not null, 
                           total_price decimal not null,
                           constraint con_orderfoodsid primary key(order_id), 
                           constraint con_userid foreign key(user_id) references user_details(user_id),
                           constraint con_orderitem_id foreign key(item_id) references food_items(item_id));

create table cart( cartid int generated always as identity(start with 1 increment by 1),
                   user_id int not null, 
                   item_id int not null,
                   foreign key(user_id) references user_details(user_id));

create table ratings(rating_id int generated always as identity(start with 1 increment by 1),
                     user_id int not null,
                     restaurant_id int not null,
                     rating number(2,1),
                     foreign key(restaurant_id) references restaurant_details(restaurant_id),
                     foreign key(user_id) references user_details(user_id));
commit;

alter table food_items rename column image to food_image;

desc order_foods;
insert into ratings(user_id, restaurant_id, rating) values(?,?,?)
insert into ratings(user_id, restaurant_id, rating) values(1207, 1681,3);
delete from ratings where user_id = 1225;
commit;
select restaurant_id from restaurant_details where email='temple@gmail.com';

drop table restaurant_details cascade constraints;

delete from food_items where item_id=1489;
select * from food_items where item_id in (select item_id from cart);
delete from cart where item_id in 1447;
commit;

update user_details set role='user' where user_id = 1203;

update user_details set role='user' where user_id=1203;
select item_id from food_items where restaurant_id = 1681  and food_name ='Dosa';
select food_items.item_id from food_items inner join restaurant_details on food_items.restaurant_id = restaurant_details.restaurant_id where restaurant_details.restaurant_id =1628;

ALTER TABLE restaurant_details ADD status varchar2(10);


ALTER TABLE restaurant_details DROP COLUMN status;
update user_details set role = 'user' where email_address='vishali@gmail.com';

desc ratings;
delete food_items where restaurant_id = 1632;

select * from user_details where email_address='meena@gmail.com'; 
select food_name, cuisine_name, description, price, food_image from food_items where restaurant_id =1717;

delete from order_foods where user_id = 1225;
ALTER TABLE order_foods ADD order_status varchar2(20) default 'Confirm';
update restaurant_details set restaurant_status = 'active' where email ='temple@gmail.com';

delete from cart where item_id = 1424 and user_id = 1203;

alter table drop food_status;
alter table food_items add food_status varchar2(20) default 'available';

update food_items set price = 250 where item_id=1521;
select * from restaurant_details where city='Madurai';


select order_status from order_foods where order_status='cancel';
truncate table order_foods;

select * from order_foods;
select * from order_foods where order_date like '___01_22%';
select * from restaurant_details where restaurant_status='active';
commit;
update user_details set password = 'Meena1013' where email_address='meena@gmail.com';
update user_details set password = ? where email_address=
select * from user_details where not role='Admin';

select * from user_details;
select * from restaurant_details;
select * from food_items;
select * from order_foods;
select * from cart;
select * from ratings;
select avg(rating) from ratings where restaurant_id=1717;

select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items;
select * from restaurant_details where city= 'Madurai';
select floor(avg(rating)) from ratings where restaurant_id = 1720;
select * from food_items where restaurant_id = 1716;

select * from restaurant_details where city='Madurai';
select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details from user_details where role='Admin' and email_address='jeyram@gmail.com' and password='Jeyram1010';
select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where role='user' and email_address='meena@gmail.com' and password='Meena1010';
