-- CREATE TABLE IF NOT EXISTS java_test.users(
--     id    int PRIMARY KEY AUTO_INCREMENT,
--     email         varchar(50) NOT NULL,
--     password      varchar(30) NOT NULL,
--     user_name     varchar(30) NOT NULL,
--     INDEX(id)
-- );

CREATE TABLE IF NOT EXISTS users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);



