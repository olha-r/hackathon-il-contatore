DROP TABLE IF EXISTS pizza;
DROP TABLE IF EXISTS orders;

CREATE TABLE pizza (
    id SERIAL,
    pizza_size VARCHAR(255),
    shape VARCHAR(255),
    base VARCHAR(255),
    ingredient_id INTEGER not null,
    oil INTEGER,
    constraint pk_pizza_id primary key(id)
);

CREATE TABLE orders (
	id SERIAL,
	order_number VARCHAR(255),
	order_status VARCHAR(255),
	pizza_id INTEGER NOT NULL,
    date_time TIMESTAMP NOT NULL,
	constraint pk_order_id primary key(id),
	constraint fk_pizza_id
			foreign key (pizza_id)
			references pizza(id)
			);
CREATE TABLE ingredient (
	id SERIAL,
	name VARCHAR(255),
	constraint pk_ingredient_id primary key(id)
			);


