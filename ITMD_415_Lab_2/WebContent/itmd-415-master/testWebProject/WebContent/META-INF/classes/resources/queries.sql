CREATE DATABASE IF NOT EXISTS testdb;

USE testdb;

--DROP TABLE IF EXISTS comment;
CREATE TABLE IF NOT EXISTS comment (
   comment_id 		INT 		NOT NULL AUTO_INCREMENT,
   name 			VARCHAR(64) NOT NULL,
   content			TEXT 		NOT NULL,
   date     		BIGINT 		NOT NULL,

   PRIMARY KEY (comment_id)
);

INSERT INTO comment VALUES(0, "name", "this comment system SUX >:(", -1);
INSERT INTO comment VALUES(0, "name_for_real", "this comment system ROX :)", -2);

DESCRIBE comment;
SELECT * FROM comment;

--DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
	user_id			INT			NOT NULL AUTO_INCREMENT,
	name			VARCHAR(64) NOT NULL,
	email			VARCHAR(64) NOT NULL,
	password		VARCHAR(64) NOT NULL,
	dob				BIGINT		NOT NULL,
	
	PRIMARY KEY (user_id)
);

INSERT INTO user VALUES(0, "Henry", "HenryFBP@gmail.com", "iamareallygoodpasswordlololol", -1);
INSERT INTO user VALUES(0, "Dennis", "dennisthemenace@hotbodshotrods.ru.co.uk", "help", -2);

DESCRIBE user
SELECT * FROM user;