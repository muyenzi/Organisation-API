SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 info VARCHAR,
 empNumber INTEGER
);

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 post VARCHAR,
 role VARCHAR,
 departName VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 topic VARCHAR,
 news  VARCHAR,
);




