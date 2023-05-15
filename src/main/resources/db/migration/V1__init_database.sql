drop table if exists book;
drop table if exists book_seq;
drop table if exists actor;
drop table if exists actor_seq;

create table book(
id bigint not null,
isbn varchar(255),
publisher varchar(225),
title varchar(225),
primary key (id)
);

create table book_seq(
next_val bigint
);

insert into book_seq values(1);

create table actor(
id bigint not null,
name varchar(255),
latestMovie varchar(255)
);

create table actor_seq(
next_val bigint
);

insert into actor_seq values(1);