CREATE OR REPLACE VIEW user_posts (user_id, username,email,title,content) AS
SELECT 
    u.user_id as user_id, 
    u.username as username,
    u.email as email,
    p.title as title, 
    p.content as content
FROM users u
LEFT JOIN posts p ON u.user_id = p.user_id
WHERE p.post_id IS NOT NULL;