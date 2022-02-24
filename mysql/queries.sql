 create database if not exists flask_db;

 use flask_db;
 
 create table if not exists person(
    email varchar(100) primary key,
    name varchar(50),
    age integer,
    company varchar(50));

insert into person(email, name, age, company) values ('adithya@gmail.com', 'Adithya', 22, "TCS");
insert into person(email, name, age, company) values ('abhay@gmail.com', 'Abhaya', 25, "Agile Point");
