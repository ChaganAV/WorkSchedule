CREATE TABLE IF NOT EXISTS purchase(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product varchar(50) NOT NULL,
    price double NOT NULL
);
create table if not exists account(
    id int auto-increment primary key not null,
    name varchar(50) not null,
    amount double not null
);