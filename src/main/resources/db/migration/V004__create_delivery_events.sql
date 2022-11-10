create table delivery_events(
    id SERIAL PRIMARY KEY,
    delivery_id INTEGER NOT NULL,
    description TEXT NOT NULL,
    date_time TIMESTAMP NOT NULL
);

alter table delivery_events add constraint fk_delivery_id foreign key (delivery_id) references deliveries(id);