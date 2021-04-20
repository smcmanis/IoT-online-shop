-- CREATE DATABASE iotbay;


CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    email text NOT NULL,
    -- password text,
    salt text,
    passhash text,
    active boolean DEFAULT FALSE,
    UNIQUE(email) 
);

CREATE TABLE IF NOT EXISTS access_logs (
    access_id SERIAL PRIMARY KEY,
    user_id_fk bigint(20) unsigned NOT NULL,
    FOREIGN KEY (user_id_fk) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id SERIAL PRIMARY KEY,
    user_id_fk bigint(20) unsigned NOT NULL,
    first_name text,
    last_name text,
    preferred_name text,
    phone_number char(10),
    contact_email text,
    currently_employed boolean DEFAULT TRUE,
    date_of_birth date,
    resdential_address text,
    city text,
    postcode varchar(10),
    state_abbreviation char(3),
    country text,
    FOREIGN KEY (user_id_fk) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS customers(
    customer_id SERIAL PRIMARY KEY,
    user_id_fk bigint(20) unsigned NOT NULL,
    first_name text,
    last_name text,
    preferred_name text,
    phone_number text,
    company_name text,
    date_of_birth date,
    shipping_address text,
    city text,
    postcode varchar(10),
    state_abbreviation char(3),
    country text,
    FOREIGN KEY (user_id_fk) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS categories(
    category_id SERIAL PRIMARY KEY,
    name text
);

CREATE TABLE IF NOT EXISTS items(
    item_id SERIAL PRIMARY KEY,
    category_id_fk bigint(20) unsigned DEFAULT 1,
    item_name text,
    title text,
    item_description text,
    base_price decimal(2) DEFAULT 0,
    current_price decimal(2),
    discounted boolean DEFAULT FALSE,
    shippable boolean DEFAULT TRUE,
    discount_start_date date,
    discount_end_date date,
    minimum_order_quantity int DEFAULT 1,
    maximum_order_quantity int DEFAULT -1,
    image_url text,
    FOREIGN KEY (category_id_fk) REFERENCES categories (category_id)
);

CREATE TABLE IF NOT EXISTS orders(
    order_id SERIAL PRIMARY KEY,
    user_id_fk bigint(20) unsigned NOT NULL,
    order_status_id bigint(20) unsigned DEFAULT 1,
    date_of_order timestamp,
    date_last_updated timestamp DEFAULT CURRENT_TIMESTAMP,
    total_price decimal(2) NOT NULL,
    FOREIGN KEY (user_id_fk) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS order_line_items(
    order_item_id SERIAL PRIMARY KEY,
    order_id_fk bigint(20) unsigned NOT NULL,
    item_id_fk bigint(20) unsigned NOT NULL,
    item_quantity int DEFAULT 1,
    item_price int,
    subtotal decimal(2),
    FOREIGN KEY (order_id_fk) REFERENCES orders (order_id),
    FOREIGN KEY (item_id_fk) REFERENCES items (item_id)
);

CREATE TABLE IF NOT EXISTS order_tracking(
    tracking_id SERIAL PRIMARY KEY,
    order_id_fk bigint(20) unsigned NOT NULL,
    FOREIGN KEY (order_id_fk) REFERENCES orders (order_id)
);

CREATE TABLE IF NOT EXISTS order_status_updates(
    order_status_update_id SERIAL PRIMARY KEY,
    order_id_fk bigint(20) unsigned NOT NULL,
    tracking_id_fk bigint(20) unsigned,
    order_status_id_fk bigint(20) unsigned,
    date_of_update timestamp DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id_fk) REFERENCES orders (order_id),
    FOREIGN KEY (tracking_id_fk) REFERENCES order_tracking (tracking_id),
    FOREIGN KEY (order_status_id_fk) REFERENCES order_status (order_status_id)
);

CREATE TABLE IF NOT EXISTS order_status(
    order_status_id SERIAL PRIMARY KEY,
    order_status text NOT NULL
);

CREATE TABLE IF NOT EXISTS order_status(
    order_status_id SERIAL PRIMARY KEY,
    order_status text
);

CREATE TABLE IF NOT EXISTS customer_paypal_details(
    customer_paypal_id SERIAL PRIMARY KEY,
    paypal_token text,
    customer_id_fk bigint(20) unsigned NOT NULL,
    FOREIGN KEY (customer_id_fk) REFERENCES customers (customer_id)
);

CREATE TABLE IF NOT EXISTS customer_credit_cards(
    customer_card_id SERIAL PRIMARY KEY,
    customer_id_fk bigint(20) unsigned NOT NULL,
    card_number text,
    card_validation_number text,
    expiration_month varchar(20),
    expiration_year varchar(20),
    card_owner text,
    card_type varchar(20),
    FOREIGN KEY (customer_id_fk) REFERENCES customers (customer_id)
);

CREATE TABLE IF NOT EXISTS payment_types(
    payment_type_id SERIAL PRIMARY KEY,
    payment_type_name text NOT NULL
);
CREATE TABLE IF NOT EXISTS customer_payment_methods(
    payment_method_id SERIAL PRIMARY KEY,    
    customer_id_fk bigint(20) unsigned NOT NULL,
    payment_type_id_fk bigint(20) unsigned NOT NULL,
    FOREIGN KEY (customer_id_fk) REFERENCES customers (customer_id),
    FOREIGN KEY (payment_type_id_fk) REFERENCES payment_types (payment_type_id)
);

CREATE TABLE IF NOT EXISTS transaction_types(
    transaction_type_id SERIAL PRIMARY KEY,
    transaction_type_name text NOT NULL
);

CREATE TABLE IF NOT EXISTS transactions(
    transaction_id SERIAL PRIMARY KEY,
    transaction_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type_id_fk bigint(20) unsigned DEFAULT 1,
    FOREIGN KEY (transaction_type_id_fk) REFERENCES transaction_types (transaction_type_id)
);

CREATE TABLE IF NOT EXISTS order_payments(
    order_payment_id SERIAL PRIMARY KEY,
    order_id_fk bigint(20) unsigned NOT NULL,
    transaction_id_fk bigint(20) unsigned,
    payment_type_id_fk bigint(20) unsigned,
    payment_amount decimal(2) NOT NULL,
    payment_token varchar(1000),
    FOREIGN KEY (order_id_fk) REFERENCES orders (order_id),
    FOREIGN KEY (transaction_id_fk) REFERENCES transactions (transaction_id),
    FOREIGN KEY (payment_type_id_fk) REFERENCES payment_types (payment_type_id)
);

CREATE TABLE IF NOT EXISTS order_shipments(
    shipment_id SERIAL PRIMARY KEY,
    order_id_fk bigint(20) unsigned NOT NULL,
    tracking_id_fk bigint(20) unsigned,
    payment_type_id_fk bigint(20) unsigned,
    shipping_fee decimal(2),
    shipping_address text,
    city text,
    state_abbreviation char(3),
    country varchar(20),
    expected_delivery_date date,
    recipient text,
    FOREIGN KEY (order_id_fk) REFERENCES orders (order_id),
    FOREIGN KEY (tracking_id_fk) REFERENCES order_tracking (tracking_id),
    FOREIGN KEY (payment_type_id_fk) REFERENCES payment_types (payment_type_id)
);