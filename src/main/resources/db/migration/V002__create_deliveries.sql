CREATE TABLE deliveries(
    id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL,
    tax NUMERIC(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    request_date TIMESTAMP NOT NULL,
    completion_date TIMESTAMP,
    addresse_name VARCHAR(60) NOT NULL,
    addresse_public_place VARCHAR(255) NOT NULL,
    addresse_number VARCHAR(30) NOT NULL,
    addresse_complement VARCHAR(60) NOT NULL,
    addresse_district VARCHAR(255) NOT NULL
);

ALTER TABLE deliveries ADD CONSTRAINT fk_delivery_client
FOREIGN KEY(client_id) REFERENCES clients(id);