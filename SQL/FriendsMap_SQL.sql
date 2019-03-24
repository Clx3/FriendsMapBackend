CREATE SCHEMA friendsmap;

USE friendsmap;

CREATE TABLE user (
	id BIGINT(20) NOT NULL,
    username VARCHAR(20) NOT NULL UNIQUE,
    latitude DECIMAL(50,30) NOT NULL,
    longitude DECIMAL(50,30) NOT NULL,
    locationInfo VARCHAR(500),
    PRIMARY KEY (id)
);

INSERT INTO user VALUES(1, 'teemu', 65.4324, 66.243252, '');