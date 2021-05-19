create database huxassignment;
show databases;
use huxassignment;
create table movie(
show_id varchar(50) primary key,
type varchar(1000),
title varchar(1000),
director varchar(1000),
cast varchar(1000),
country varchar(1000),
date_added Date,
release_year varchar(1000),
rating varchar(1000),
duration varchar(1000),
listed_in varchar(1000),
description varchar(1000));
select * from movie;