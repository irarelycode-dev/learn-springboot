drop table if exists book;
drop table if exists book_seq;

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

create table actor(
id bigint not null,
name varchar(255),
latestMovie varchar(255)
);

create table actor_seq(
next_val bigint
);