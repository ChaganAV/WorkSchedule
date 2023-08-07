CREATE TABLE IF NOT EXISTS purchase(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product varchar(50) NOT NULL,
    price double NOT NULL
);