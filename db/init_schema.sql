

CREATE TABLE users(
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)
)
;

CREATE TABLE address(
  id_address INT PRIMARY KEY,
  id_user INT,
  address VARCHAR(255),
  CONSTRAINT FK_USER_IDUSER FOREIGN KEY (id_user) REFERENCES users (id_user)
)
;


