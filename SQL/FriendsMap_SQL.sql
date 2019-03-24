CREATE SCHEMA friendsmap;

USE friendsmap;

CREATE TABLE user (
	id BIGINT(20) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    latitude DECIMAL(10,10) NOT NULL,
    longitude DECIMAL(10,10) NOT NULL,
    locationInfo VARCHAR(500),
    PRIMARY KEY (id)
);