CREATE DATABASE IF NOT EXISTS java_test CHARACTER SET
utf8 COLLATE utf8_general_ci;

USE java_test;

CREATE TABLE IF NOT EXISTS java_test.users(
    id    int PRIMARY KEY AUTO_INCREMENT,
    email         varchar(50) NOT NULL,
    password      varchar(30) NOT NULL,
    user_name     varchar(30) NOT NULL,
    INDEX(id)
);

CREATE TABLE IF NOT EXISTS java_test.posts(
    id  int PRIMARY KEY AUTO_INCREMENT,
    content varchar(30) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT `fkey_users_table_id` FOREIGN KEY (`user_id`) REFERENCES  `users` (`id`),
    INDEX(id, user_id)
);

