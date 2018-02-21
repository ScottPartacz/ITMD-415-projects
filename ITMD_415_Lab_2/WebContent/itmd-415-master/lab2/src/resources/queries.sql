--USING testdb;

CREATE DATABASE IF NOT EXISTS testdb;


--DROP TABLE comment;

CREATE TABLE IF NOT EXISTS comment (
   comment_id 		INT 		NOT NULL UNIQUE AUTO_INCREMENT,
   name 			VARCHAR(64) NOT NULL,
   content			TEXT 		NOT NULL,
   date     		BIGINT 		NOT NULL,
   PRIMARY KEY (comment_id)
);

DESCRIBE comment;
SELECT * FROM comment;

-- DROP TABLE state;

CREATE TABLE IF NOT EXISTS state (
	state_id		INT			NOT NULL UNIQUE AUTO_INCREMENT,
	abbreviation	VARCHAR(64) NOT NULL UNIQUE,	
	name			VARCHAR(64) NOT NULL UNIQUE,
	PRIMARY KEY (state_id)
);

DESCRIBE state;
SELECT * FROM state;

INSERT INTO state VALUES(0, "AL", "Alabama");
INSERT INTO state VALUES(0, "AK", "Alaska");
INSERT INTO state VALUES(0, "AZ", "Arizona");
INSERT INTO state VALUES(0, "AR", "Arkansas");
INSERT INTO state VALUES(0, "CA", "California");
INSERT INTO state VALUES(0, "CO", "Colorado");
INSERT INTO state VALUES(0, "CT", "Connecticut");
INSERT INTO state VALUES(0, "DE", "Delaware");
INSERT INTO state VALUES(0, "FL", "Florida");
INSERT INTO state VALUES(0, "GA", "Georgia");
INSERT INTO state VALUES(0, "HI", "Hawaii");
INSERT INTO state VALUES(0, "ID", "Idaho");
INSERT INTO state VALUES(0, "IL", "Illinois");
INSERT INTO state VALUES(0, "IN", "Indiana");
INSERT INTO state VALUES(0, "IA", "Iowa");
INSERT INTO state VALUES(0, "KS", "Kansas");
INSERT INTO state VALUES(0, "KY", "Kentucky");
INSERT INTO state VALUES(0, "LA", "Louisiana");
INSERT INTO state VALUES(0, "ME", "Maine");
INSERT INTO state VALUES(0, "MD", "Maryland");
INSERT INTO state VALUES(0, "MA", "Massachusetts");
INSERT INTO state VALUES(0, "MI", "Michigan");
INSERT INTO state VALUES(0, "MN", "Minnesota");
INSERT INTO state VALUES(0, "MS", "Mississippi");
INSERT INTO state VALUES(0, "MO", "Missouri");
INSERT INTO state VALUES(0, "MT", "Montana");
INSERT INTO state VALUES(0, "NE", "Nebraska");
INSERT INTO state VALUES(0, "NV", "Nevada");
INSERT INTO state VALUES(0, "NH", "New Hampshire");
INSERT INTO state VALUES(0, "NJ", "New Jersey");
INSERT INTO state VALUES(0, "NM", "New Mexico");
INSERT INTO state VALUES(0, "NY", "New York");
INSERT INTO state VALUES(0, "NC", "North Carolina");
INSERT INTO state VALUES(0, "ND", "North Dakota");
INSERT INTO state VALUES(0, "OH", "Ohio");
INSERT INTO state VALUES(0, "OK", "Oklahoma");
INSERT INTO state VALUES(0, "OR", "Oregon");
INSERT INTO state VALUES(0, "PA", "Pennsylvania");
INSERT INTO state VALUES(0, "RI", "Rhode Island");
INSERT INTO state VALUES(0, "SC", "South Carolina");
INSERT INTO state VALUES(0, "SD", "South Dakota");
INSERT INTO state VALUES(0, "TN", "Tennessee");
INSERT INTO state VALUES(0, "TX", "Texas");
INSERT INTO state VALUES(0, "UT", "Utah");
INSERT INTO state VALUES(0, "VT", "Vermont");
INSERT INTO state VALUES(0, "VA", "Virginia");
INSERT INTO state VALUES(0, "WA", "Washington");
INSERT INTO state VALUES(0, "WV", "West Virginia");
INSERT INTO state VALUES(0, "WI", "Wisconsin");
INSERT INTO state VALUES(0, "WY", "Wyoming");

