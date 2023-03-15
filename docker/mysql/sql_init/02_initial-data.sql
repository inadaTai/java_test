INSERT INTO java_test.users (id, email, password, user_name) VALUES
(1,'mng@hoge', 'mngpass', 'manager'),
(2,'user1@hoge', 'user1pass', 'MR.user1'),
(3,'user2@hoge', 'user2pass', 'MR.user2')
;

INSERT INTO java_test.posts (id, content, user_id) VALUES
(1, 'ユーザー１の投稿内容物', 1),
(2, 'ユーザー３番目の投稿内容1', 3),
(3, 'ユーザー３番目の投稿内容2', 3)
;

