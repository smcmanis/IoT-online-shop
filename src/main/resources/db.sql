CREATE DATABASE iotbay;


CREATE TABLE users(
    user_id SERIAL PRIMARY KEY,
    email text NOT NULL,
    first_name text,
    last_name text,
    password text,
    preferred_name text,
    salt text,
    passhash text,
    active boolean DEFAULT FALSE,
    UNIQUE(email) 
);

CREATE TABLE access_logs(
    access_id SERIAL PRIMARY KEY,
    
    user_id int REFERENCES users (user_id)
);

CREATE TABLE employees(
    employee_id SERIAL PRIMARY KEY,
    phone_number char(10),
    contact_email text,
    currently_employed boolean DEFAULT TRUE,
    date_of_birth date,
    resdential_address text,
    city text,
    postcode varchar(10),
    state_abbreviation char(3),
    country text,
    user_id int REFERENCES users (user_id)
);

CREATE TABLE customers(
    customer_id SERIAL PRIMARY KEY,
    phone_number text,
    company_name text,
    date_of_birth date,
    shipping_address text,
    city text,
    postcode varchar(10),
    state_abbreviation char(3),
    country text,
    user_id int REFERENCES users (user_id)
);

CREATE TABLE categories(
    category_id SERIAL PRIMARY KEY,
    name text
);

CREATE TABLE items(
    item_id SERIAL PRIMARY KEY,
    item_name text,
    title text,
    item_description text,
    base_price text,
    current_price text,
    discounted boolean DEFAULT FALSE,
    shippable boolean DEFAULT TRUE,
    discount_start_date date,
    discount_end_date date,
    minimum_order_quantity int DEFAULT 1,
    maximum_order_quantity int DEFAULT -1,
    image_url text,
    category_id int REFERENCES categories (category_id)
);

CREATE TABLE orders(
    order_id SERIAL PRIMARY KEY,
    order_status text,
    date_of_order timestamp,
    date_last_updated timestamp DEFAULT CURRENT_TIMESTAMP,
    total_price decimal(2) NOT NULL,
    user_id int REFERENCES users (user_id)
);

CREATE TABLE order_line_items(
    order_item_id SERIAL PRIMARY KEY,
    item_quantity int NOT NULL,
    item_price int,
    subtotal decimal(2),
    order_id int REFERENCES orders (order_id),
    item_id int REFERENCES items (item_id)
);

CREATE TABLE order_tracking(
    tracking_id SERIAL PRIMARY KEY,
    order_id int REFERENCES orders (order_id)
);

CREATE TABLE order_status_updates(
    order_status_update_id SERIAL PRIMARY KEY,
    date_of_update timestamp DEFAULT CURRENT_TIMESTAMP,
    order_id int REFERENCES orders (order_id),
    tracking_id int REFERENCES order_tracking (tracking_id),
    order_status_id int REFERENCES order_status (order_status_id)
);

CREATE TABLE order_status(
    order_status_id SERIAL PRIMARY KEY,
    order_status text NOT NULL
);

CREATE TABLE order_status(
    order_status_id SERIAL PRIMARY KEY,
    order_status text NOT NULL
);

CREATE TABLE customer_paypal_details(
    customer_paypal_id SERIAL PRIMARY KEY,
    paypal_token text NOT NULL,
    customer_id int REFERENCES customers (customer_id)
);

CREATE TABLE customer_credit_cards(
    customer_card_id SERIAL PRIMARY KEY,
    card_number text NOT NULL,
    card_validation_number text NOT NULL,
    expiration_month varchar(20) NOT NULL,
    expiration_year varchar(20) NOT NULL,
    card_owner text NOT NULL,
    card_type varchar(20),
    customer_id int REFERENCES customers (customer_id)
);

CREATE TABLE payment_types(
    payment_type_id SERIAL PRIMARY KEY,
    payment_type_name text NOT NULL
);
CREATE TABLE customer_payment_methods(
    payment_method_id SERIAL PRIMARY KEY,
    customer_id int REFERENCES customers (customer_id),
    payment_type_id int REFERENCES payment_types (payment_type_id)
);

CREATE TABLE transaction_types(
    transaction_type_id SERIAL PRIMARY KEY,
    transaction_type_name text NOT NULL
);

CREATE TABLE transactions(
    transaction_id SERIAL PRIMARY KEY,
    transaction_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    transaction_type_id int REFERENCES transaction_types (transaction_type_id)
);

CREATE TABLE order_payments(
    order_payment_id SERIAL PRIMARY KEY,
    payment_amount decimal(2) NOT NULL,
    payment_token varchar(1000),
    order_id int REFERENCES orders (order_id),
    transaction_id int REFERENCES transactions (transaction_id),
    payment_type_id int REFERENCES payment_types (payment_type_id)
);

CREATE Table Shipment (
    shipment_id int NOT NULL 
    GENERATED ALWAYS AS IDENTITY,
    tracking_number varchar (30),
    shipment_date date,
    shipment_status varchar (20),
    shipment_details_id int,
    order_id int,
    PRIMARY KEY (shipment_id),
    FOREIGN KEY (shipment_details_id) REFERENCES shipment_details(shipment_details_id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE Shipment_Details (
    shipment_details_id int NOT NULL 
    GENERATED ALWAYS AS IDENTITY,
    country varchar(20)
    address_line_1 varchar(200),
    address_line_2 varchar(200),
    postcode int,
    suburb varchar(20),
    state char(3),
    user_id int,
    PRIMARY KEY (shipment_details_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);