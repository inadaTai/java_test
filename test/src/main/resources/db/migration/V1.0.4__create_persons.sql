CREATE TABLE IF NOT EXISTS java_test.persons(
    person_id  int PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    INDEX(person_id)
);