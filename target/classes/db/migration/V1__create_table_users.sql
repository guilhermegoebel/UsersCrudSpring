CREATE TABLE users (
id bigint(20) NOT NULL AUTO_INCREMENT,
username varchar(100) DEFAULT NULL,
email varchar(30) DEFAULT NULL,
password varchar(20) DEFAULT NULL,
PRIMARY KEY (id)
);