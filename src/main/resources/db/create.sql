SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes(
    id int auto_increment,
    name VARCHAR,
    age int,
    specialPowers VARCHAR,
    weakness VARCHAR,
    PRIMARY KEY (id),
);
CREATE TABLE IF NOT EXISTS categories(
    id int PRIMARY kEY auto_increment;
    name VARCHAR
);
