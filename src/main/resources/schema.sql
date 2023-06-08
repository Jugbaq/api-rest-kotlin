CREATE TABLE IF NOT EXISTS student (
    id serial not null primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    address varchar(255) not null
    );