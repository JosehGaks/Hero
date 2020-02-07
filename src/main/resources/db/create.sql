SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes(
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR,
    age int,
    specialPowers VARCHAR,
    weakness VARCHAR,


);
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('superman',7,'fly','kryptonium');
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('ironman',8,'iron','steel');
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('spiderman',9,'webs','sound');
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('batwoman',2,'tech','bats');
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('beast',1,'power','water');
INSERT INTO heroes(name,age,specialPowers,weakness)
VALUES ('thor',8,'hummer','thunder');


CREATE TABLE IF NOT EXISTS squads(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY kEY,
    name VARCHAR
);
INSERT INTO squads(name)
VALUES('sexism');
INSERT INTO squads(name)
VALUES('computer illiteracy');
INSERT INTO squads(name)
VALUES('not covering your mouth when you sneeze');
INSERT INTO squads(name)
VALUES('hogging bus seats with your backpack');
INSERT INTO squads(name)
VALUES('passive-aggressive post-it notes');