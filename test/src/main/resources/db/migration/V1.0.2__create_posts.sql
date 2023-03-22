-- CREATE TABLE IF NOT EXISTS java_test.posts(
--     id  int PRIMARY KEY AUTO_INCREMENT,
--     content  TEXT NOT NULL,
--     user_id INT NOT NULL,
--     CONSTRAINT `fkey_users_table_id` FOREIGN KEY (`user_id`) REFERENCES  `users` (`id`),
--     INDEX(id, user_id)
-- );



CREATE TABLE IF NOT EXISTS posts (
  post_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  title VARCHAR(100) NOT NULL,
  content TEXT,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);
