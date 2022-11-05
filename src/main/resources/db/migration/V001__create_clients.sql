create table clients(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) not null,
    email VARCHAR(255) not null,
    phone VARCHAR(20) not null
);