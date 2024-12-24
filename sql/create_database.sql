CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    account_holder VARCHAR(100),
    balance DOUBLE
);
