CREATE SCHEMA friendsmap;

USE friendsmap;

CREATE TABLE user (
	id BIGINT(20) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);