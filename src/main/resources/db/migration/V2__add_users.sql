CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nom VARCHAR(50) NOT NULL,
                       prenom VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       role ENUM('ADMIN', 'MANAGER', 'AGENT') NOT NULL DEFAULT 'AGENT'
);