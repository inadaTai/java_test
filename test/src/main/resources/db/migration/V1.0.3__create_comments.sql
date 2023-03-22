-- CREATE TABLE IF NOT EXISTS java_test.comments(
--     comment_id  int PRIMARY KEY AUTO_INCREMENT,
--     post_id INT NOT NULL,
--     user_id INT NOT NULL,
--     content TEXT NOT NULL,
--     INDEX(comment_id, post_id, user_id)
-- );

CREATE TABLE IF NOT EXISTS comments (
  comment_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  post_id INT NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE ON UPDATE CASCADE
);