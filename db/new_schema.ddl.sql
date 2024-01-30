DROP TABLE IF EXISTS new_order;

CREATE TABLE new_order (
    id SERIAL,
    order_number VARCHAR(255),
	order_status VARCHAR(255),
    pizza_size VARCHAR(255),
    shape VARCHAR(255),
    base VARCHAR(255),
    ingredients text [][],
    oil boolean,
    price numeric
);
