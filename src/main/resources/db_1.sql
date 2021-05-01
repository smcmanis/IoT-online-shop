CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    email text NOT NULL,
    first_name text,
    last_name text,
    phone_number text,
    password_plaintext text,
    salt text,
    passhash text,
    active boolean DEFAULT TRUE,
    is_employee boolean,
    is_admin boolean DEFAULT FALSE,
    UNIQUE(email) 
);

CREATE TABLE access_logs(
    id SERIAL PRIMARY KEY,
    access_timestamp timestamp,
    user_id int NOT NULL REFERENCES users (id)
);

CREATE TABLE user_address(
    id SERIAL PRIMARY KEY,
    street_address text,
    city text,
    postcode text,
    state_abbreviation text,
    country text,
    user_id int NOT NULL REFERENCES users (id)
);


CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    item_name text,
    quantity int NOT NULL,
    price decimal(11,2),
    image_url text,
    category text
);

CREATE TABLE carts(
    id SERIAL PRIMARY KEY,
    user_id int DEFAULT NULL REFERENCES users (id)
);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    order_date date DEFAULT NULL,
    order_status text,
    total_price decimal(11,2),
    cart_id int DEFAULT NULL REFERENCES carts (id),
    user_id int DEFAULT NULL REFERENCES users (id)
);


CREATE TABLE cart_items(
    id SERIAL PRIMARY KEY,
    quantity int NOT NULL,
    price decimal(11,2),
    subtotal decimal(11,2),    
    item_id int NOT NULL REFERENCES items (id),
    cart_id int NOT NULL REFERENCES carts (id),
    UNIQUE(cart_id, item_id)
);


CREATE TABLE credit_cards(
    id SERIAL PRIMARY KEY,
    card_number text,
    card_validation_number text,
    expiration_date text,
    card_owner text,
    user_id int REFERENCES users (id)
);


CREATE TABLE order_payments(
    id SERIAL PRIMARY KEY,
    payment_amount decimal(11,2) NOT NULL,
    card_number text,
    card_expiration_date text,
    order_id int REFERENCES orders (id)
);


CREATE TABLE shipping(
    id SERIAL PRIMARY KEY,
    shipping_address text,
    city text,
    state_abbreviation text,
    postcode text,
    country text,
    expected_delivery_date date,
    recipient text,
    tracking_number text,
    order_id int REFERENCES orders (id)
);


INSERT INTO users (email, first_name, last_name, phone_number, password_plaintext, is_employee, is_admin, active) VALUES
    ('admin.sam@gmail.com', 'Sam', 'Smith', '0404456123', 'abc123', TRUE, TRUE, TRUE),
    ('employee.jane@gmail.com', 'Jane', 'Smath', '0404123456', 'abc123', TRUE, FALSE, TRUE),
    ('employee.wilson@gmail.com', 'Wilson', 'Smeth', '040445614', 'abc123', TRUE, FALSE, TRUE),
    ('brad@gmail.com', 'Brad', 'Smoth', '0404456125', 'abc123', FALSE, FALSE, TRUE),
    ('john@gmail.com', 'John', 'Smuth', '0404456126', 'abc123', FALSE, FALSE, TRUE),
    ('Bill@gmail.com', 'Bill', 'Sooth', '0404458226', 'abc123', FALSE, FALSE, TRUE);



INSERT INTO access_logs(access_timestamp, user_id) VALUES 
    (TIMESTAMP '2021-01-16 10:23:54', 1),
    (TIMESTAMP '2021-01-29 10:23:54', 1),
    (TIMESTAMP '2021-02-01 10:23:54', 2),
    (TIMESTAMP '2021-02-05 10:56:54', 3),
    (TIMESTAMP '2021-03-02 10:23:54', 3),
    (TIMESTAMP '2021-03-22 10:23:54', 4),
    (TIMESTAMP '2021-03-12 10:23:54', 5),
    (TIMESTAMP '2021-04-24 10:23:54', 2),
    (TIMESTAMP '2021-04-27 10:23:54', 1);

INSERT INTO user_address (street_address, city, postcode, state_abbreviation, country, user_id) VALUES
    ('123 Fake Street', 'Sydney', '2000', 'NSW', 'Australia', '2'),
    ('32 Real Street', 'Brisbane', '4000', 'QLD', 'Australia', '3'),
    ('22 Pacific Road', 'Chatswood', '2067', 'NSW', 'Australia', '4');



INSERT INTO items (item_name, quantity, price, image_url, category) VALUES
    ('Arduino Nano IoT Interface Adapter', 10, 11.95, 'https://dcubestore.com/wp-content/uploads/2018/10/AN_A_1_1-e1540884379272.png', 'Adapter'),
    ('CCS811 Air Quality Sensor', 10, 30.00, 'https://dcubestore.com/wp-content/uploads/2019/09/CCS81-500x500.png', 'Sensors'),
    ('ESP32 IoT WiFi BLE Module with Integrated USB', 10, 16.95, 'https://dcubestore.com/wp-content/uploads/2019/10/ESP32_1-500x500.png', ''),
    ('Industrial IoT RS485 To Wireless Converter', 5, 168.95, 'https://dcubestore.com/wp-content/uploads/2019/11/RS485_1-500x500.jp', 'Communications'),
    ('Industrial IoT Wireless Linear Displacement Sensor', 5, 196.95, 'https://dcubestore.com/wp-content/uploads/2019/11/Linear-Disp-Sensor_1-500x500.jpg', 'Sensors'),
    ('Industrial IoT Wireless Vibration & Temperature Sensor V2 MEMS', 3, 258.95, 'https://dcubestore.com/wp-content/uploads/2019/11/PR52-33N_1-500x500.jpg', 'Sensors'),
    ('Industrial IoT Wireless Temperature Humidity Sensor', 10, 198.95, 'https://dcubestore.com/wp-content/uploads/2019/09/Temp_Humidity2-1-500x500.jpg', 'Controllers'),
    ('I2C Shield for Raspberry Pi with Inward Facing I2C Port', 30, 10.95, 'https://dcubestore.com/wp-content/uploads/2018/10/INPI2_4-500x500.png', 'Raspberry Pi'),
    ('I2C Shield for Raspberry Pi with Outward Facing I2C Port', 50, 10.95, 'https://dcubestore.com/wp-content/uploads/2018/10/RASP_ADAP7_1-1-500x500.png', 'Raspberry Pi'),
    ('Dual I2C Shield for Arduino Due with Modular Communications Interface', 50, 12.95, 'https://dcubestore.com/wp-content/uploads/2019/11/PR37-10_1-500x500.png', 'Adapters'),
    ('Arduino Nano', 10, 11.95, 'https://dcubestore.com/wp-content/uploads/2019/09/207-2079543_arduino-nano-arduino-nano-board1_2_700x667-500x500.png', 'Adapters'),
    ('ADT75 Temperature Sensor ±1°C 12-Bit with 3 Address Lines I2C Mini Module', 21, 24.95, 'https://dcubestore.com/wp-content/uploads/2019/09/ADT75_I2CS_A_1-600x393_1000x667-500x500.png', 'Sensors'),
    ('8-Channel DC Current Monitor with I2C Interface', 10, 84.95, 'https://dcubestore.com/wp-content/uploads/2018/10/ADS7828_I2CCM8-500x500.png', 'Controllers'),
    ('IoT Training Controller Light Sound Sensor Action', 10, 63.95, 'https://dcubestore.com/wp-content/uploads/2018/09/PR51-18-w-OLED_1-1-500x500.png', 'Convertors'),
    ('Long Range IoT Wireless RTD Temperature Sensor', 5, 188.95, 'https://dcubestore.com/wp-content/uploads/2019/11/3-Wire-RTD-WIreless-Transmitter-500x500.jpg', 'Sensors'),
    ('MG-811 CO2 Gas Sensor with I2C Interface', 10, 68.95, 'https://dcubestore.com/wp-content/uploads/2019/09/PR51-19_1-600x400_800x667-500x500.png', 'Sensors'),
    ('Particle Photon', 10, 11, 'https://dcubestore.com/wp-content/uploads/2018/10/Photon2-autoxauto-800x800-500x500.jpg', ''),
    ('Raspberry Pi Model B RASP-PI-3', 10, 47.83, 'https://dcubestore.com/wp-content/uploads/2018/10/INPI2_3-500x500.png', 'Raspberry Pi'),
    ('Raspberry Pi Model 3 B + I2C Adapter + I2C Cable + I2C Sensor', 5, 105.51, 'https://dcubestore.com/wp-content/uploads/2018/10/44670760_2173331872880195_6023066916761894912_n-500x500.png', 'Raspberry Pi'),
    ('SI1132 UV Index Ambient Light Sensor I2C Mini Module', 10, 26.95, 'https://dcubestore.com/wp-content/uploads/2018/09/SI1132_I2CS_A_1-e1541141298185-500x500.png', 'Sensors'),
    ('Temperature Sensor Thermistor 10K OHM ±3% PROBE', 10, 15.95, 'https://dcubestore.com/wp-content/uploads/2018/10/0_1-500x500.jpeg', 'Sensors'),
    ('TCS3472 Very High Sensitivity Color Light-to-Digital Converter with IR Filter I2C Mini Module', 15, 28.95, 'https://dcubestore.com/wp-content/uploads/2018/09/TMP007_I2CS_A_1-e1541142323284-500x500.png', 'Sensors'),
    ('Water Detection Sensor with Buzzer', 10, 24.95, 'https://dcubestore.com/wp-content/uploads/2018/09/PCA9536_WDBZ_I2CS_1-500x500.png', 'Sensors'),
    ('Water Level Sensor with Analog to Digital Converter ADC121C021', 10, 24.95, 'https://dcubestore.com/wp-content/uploads/2018/09/ADC121C021-WL-I2CS_1-500x500.png', 'Converters'),
    ('Wireless 0-10V 4-Channel Input USB endNode', 3, 248.95, 'https://dcubestore.com/wp-content/uploads/2019/11/endNode_ASM1-6_1-500x500.jpg', 'Converters');

INSERT INTO carts (user_id) VALUES 
    (2), (4), (4), (5);

INSERT INTO orders (order_date, order_status, total_price, cart_id, user_id) VALUES
    ('2021-02-01', 'Delivered', 41.95, 1, 2),
    ('2021-09-04', 'Shipped', 60.00, 2, 4),
    ('2021-08-03', 'Delivered', 16.95, 3, 4),
    ('2021-09-04', 'Submitted', 168.95, 4, 5);




INSERT INTO cart_items (item_id, quantity, price, subtotal, cart_id) VALUES
    (1, 1, 11.95, 11.95, 1),
    (2, 1, 30.00, 30.00, 1),
    (2, 2, 30.00, 60.00, 2),
    (3, 1, 16.95, 16.95, 3),
    (4, 1, 168.95, 168.95, 4);



INSERT INTO credit_cards (card_number, expiration_date, card_owner, user_id) VALUES
    ('1234-5678-1234-1234', '01-23', 'Jane Smath', 2),
    ('1234-5678-1234-5678', '09-22', 'Brad Smoth', 4);


INSERT INTO order_payments (payment_amount, card_number, card_expiration_date, order_id) VALUES
    (41.95, '1234-5678-1234-1234', '01-23', '1'),
    (60.00, '1234-5678-1234-5678', '09-22', '2'),
    (16.95, '6666-1234-1234-5678', '10-21', '3'),
    (168.95, '1234-1234-1234-5678', '10-22', '4');



INSERT INTO shipping (shipping_address, city, state_abbreviation, postcode, country, tracking_number, order_id) VALUES
    ('123 Fake Street', 'Sydney', 'NSW', '2000', 'Australia', 'S0230HGTY', 1),
    ('22 Pacific Road', 'Chatswood', 'NSW', '2067','Australia', 'Y000GH1', 2),
    ('22 Pacific Road', 'Chatswood', 'NSW', '2067', 'Australia', 'S00001', 3);