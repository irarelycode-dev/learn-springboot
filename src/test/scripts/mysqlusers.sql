drop database if exists bookdb;
drop user if exists `bookadmin`@`localhost`;
drop user if exists `bookuser`@`localhost`;
create database if not exists bookdb character set utf8mb4 collate utf8mb4_unicode_ci;
create user if not exists `bookadmin`@`localhost` identified with mysql_native_password by 'Vigneshcse-15';
grant select,insert,update,delete,create,drop,references,index,alter,execute,create view,show view,create routine,alter routine,event,trigger on `bookbd`.* to `bookadmin`@`localhost`;
create user if not exists `bookuser`@`localhost` identified with mysql_native_password by 'Vigneshcse-15';
grant select,insert,update,delete,show view on `bookbd`.* to `bookuser`@`localhost`;
flush privileges;