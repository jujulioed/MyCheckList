CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(127),
    description VARCHAR(511),
    user_id BIGINT NOT NULL,
    done BOOL,
    created_date DATE,
    finished_at DATE,
    FOREIGN KEY (user_id) REFERENCES users(id)
)