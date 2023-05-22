--drop table if exists person ;
--
--CREATE TABLE person (
--   id INT NOT NULL,
--   first_name VARCHAR(50) NOT NULL,
--   last_name VARCHAR(20) NOT NULL,
--   dob DATE
--);
--
--insert into person values(1001,'vignesh','pugaz',current_date());
--insert into person values(1002,'john','doe',current_date());
--insert into person values(1003,'foo','bar',current_date());
--insert into person values(1004,'bar','foo',current_date());



--jpa in depth
insert into course(id,name,created_date,last_updated_date) values(10001,'JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date) values(10002,'Spring in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id,name,created_date,last_updated_date) values(10003,'Spring Boot in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into Passport(id,number) values (40001,'Ranga');
insert into Passport(id,number) values (40002,'John');
insert into Passport(id,number) values (40003,'Doe');

insert into Student(id,name,passport_id) values (20001,'Ranga',40001);
insert into Student(id,name,passport_id) values (20002,'John',40002);
insert into Student(id, name,passport_id) values(20003,'Doe',40003);

insert into Review(id,rating,description) values (50001,'5','Great course');
insert into Review(id,rating,description) values (50002,'4','Wonderful course');
insert into Review(id,rating,description) values (50003,'5','Awesome course');
