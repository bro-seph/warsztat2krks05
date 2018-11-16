-- CREATE DATABASE warsztat2krks05
-- CHARACTER SET utf8
-- COLLATE utf8_general_ci;
-- już mamy stworzoną (zapisane ku pamięci)

CREATE TABLE users (
  id INT AUTO_INCREMENT,
  username VARCHAR (255) UNIQUE,
  email VARCHAR (255),
  password VARCHAR (255),
  PRIMARY KEY (id)
);