CREATE SCHEMA friendsmap;

USE friendsmap;

CREATE TABLE user (
	id BIGINT(20) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE location (
	id BIGINT(20) NOT NULL,
    userId BIGINT(20) NOT NULL,
    longitude DECIMAL(10,10) NOT NULL,
    latitude DECIMAL(10,10) NOT NULL,
    PRIMARY KEY (id)
);