CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    email text NOT NULL,
    firstName text,
    lastName text,
    passwordPlaintext text,
    salt text,
    passhash text,
    isActive boolean DEFAULT TRUE,
    isAdmin boolean DEFAULT FALSE,
    customerType text,
    UNIQUE(email) 
);

CREATE TABLE access_logs(
    id SERIAL PRIMARY KEY,
    accessTimestamp timestamp DEFAULT CURRENT_TIMESTAMP,
    userId int NOT NULL REFERENCES users (id)
);

CREATE TABLE employees(
    id SERIAL PRIMARY KEY,
    employeeRole text,
    userId int NOT NULL REFERENCES users (id),
    UNIQUE(userId)
);

CREATE TABLE addresses(
    id SERIAL PRIMARY KEY,
    address text,
    city text,
    postcode text,
    region text,
    country text,
    isPrimary boolean,
    userId int NOT NULL REFERENCES users (id)
);

CREATE TABLE suppliers(
    id serial PRIMARY KEY,
    supplierName TEXT,
    company TEXT,
    email TEXT
);

CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    itemName text,
    price decimal(11,2),
    quantity int,
    imageUrl text,
    category text,
    supplierId int REFERENCES suppliers (id)
);

CREATE TABLE carts(
    id SERIAL PRIMARY KEY,
    totalPrice decimal(11,2), 
    userId int DEFAULT NULL REFERENCES users (id),
    httpSessionId text,
    dateCreated timestamp DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(httpSessionId)
);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    orderDate date,
    orderTime time,
    orderTimestamp timestamp default current_timestamp,
    orderStatus text,
    isPaid boolean DEFAULT TRUE,
    totalPrice decimal(11,2),
    cartId int NOT NULL REFERENCES carts (id),
    userId int DEFAULT NULL REFERENCES users (id)
);

CREATE TABLE cart_items(
    id SERIAL PRIMARY KEY,
    itemId int NOT NULL REFERENCES items (id),
    cartId int NOT NULL REFERENCES carts (id),
    quantity int NOT NULL,
    itemPrice decimal(11,2),
    UNIQUE(cartId, itemId)
);

CREATE TABLE credit_cards(
    id SERIAL PRIMARY KEY,
    cardNumber text,
    expirationMonth text,
    expirationYear text,
    cardOwner text,
    userId int NOT NULL REFERENCES users (id),
    isPrimary boolean,
    UNIQUE(cardNumber)
);

CREATE TABLE credit_card_payments(
    id SERIAL PRIMARY KEY,
    cardNumber TEXT,
    paymentAmount decimal(11,2),
    orderId int NOT NULL REFERENCES orders (id)
);

CREATE TABLE shipping(
    id SERIAL PRIMARY KEY,
    address text,
    city text,
    postcode text,
    region text,
    country text,
    recipient text,
    trackingNumber text,
    orderId int NOT NULL REFERENCES orders (id)
);

CREATE UNIQUE INDEX primary_address_index ON addresses (userId) WHERE isPrimary is true;
CREATE UNIQUE INDEX primary_card_index ON credit_cards (userId) WHERE isPrimary is true;

INSERT INTO users (email, firstName, lastName, passwordPlaintext, isAdmin, isActive) VALUES
    ('admin.sam@gmail.com', 'Sam', 'Smith', 'abc123', TRUE, TRUE),
    ('jane@gmail.com', 'Jane', 'Smath', 'abc123', FALSE, TRUE),
    ('wilson@gmail.com', 'Wilson', 'Smeth', 'abc123', FALSE, TRUE),
    ('brad@gmail.com', 'Brad', 'Smoth', 'abc123', FALSE, TRUE),
    ('john@gmail.com', 'John', 'Smuth', 'abc123', FALSE, TRUE),
    ('Bill@gmail.com', 'Bill', 'Sooth', 'abc123', FALSE, TRUE),
    ('joey@gmail.com', 'Joey', 'Mings', 'abc123', FALSE, TRUE),
    ('gilbert@gmail.com', 'Gilbert', 'Lee', 'abc123', FALSE, TRUE),
    ('pat@gmail.com', 'Patrick', 'Parker', 'abc123', FALSE, TRUE),
    ('samm@gmail.com', 'Sam', 'Smuth', 'abc123', FALSE, TRUE),
    ('johnnnn@gmail.com', 'John', 'Bunani', 'abc123', FALSE, TRUE),
    ('jesssmuth@gmail.com', 'Jess', 'Smuth', 'abc123', FALSE, TRUE),
    ('jamesfahez@gmail.com', 'James', 'Fahez', 'abc123', FALSE, TRUE),
    ('samhay@gmail.com', 'Samantha', 'Hay', 'abc123', FALSE, TRUE),
    ('foobar@gmail.com', 'Foo', 'Bar', 'abc123', FALSE, TRUE),
    ('alicehyde@gmail.com', 'Alice', 'Hyde', 'abc123', FALSE, TRUE),
    ('georgiamendy@gmail.com', 'Georgia', 'Mendy', 'abc123', FALSE, TRUE),
    ('elliotjohnston@gmail.com', 'Elliot', 'Johnston', 'abc123', FALSE, TRUE),
    ('philiplo@gmail.com', 'Philip', 'Lo', 'abc123', FALSE, FALSE),
    ('tramyphanny@gmail.com', 'Tra Ma', 'Phanny', 'abc123', FALSE, FALSE);

INSERT INTO access_logs(accessTimestamp, userId) VALUES 
    (TIMESTAMP '2021-01-16 10:23:54', 1),
    (TIMESTAMP '2021-01-29 10:23:54', 1),
    (TIMESTAMP '2021-02-01 10:23:54', 2),
    (TIMESTAMP '2021-02-05 10:56:54', 3),
    (TIMESTAMP '2021-03-02 10:23:54', 3),
    (TIMESTAMP '2021-03-12 10:23:54', 5),
    (TIMESTAMP '2021-03-22 10:23:54', 4),
    (TIMESTAMP '2021-03-22 13:01:59', 4),
    (TIMESTAMP '2021-04-24 10:23:54', 2),
    (TIMESTAMP '2021-04-27 10:23:54', 1),
    (TIMESTAMP '2021-04-27 12:23:54', 5),
    (TIMESTAMP '2021-04-28 10:23:54', 6),
    (TIMESTAMP '2021-04-29 10:23:54', 6),
    (TIMESTAMP '2021-04-30 10:23:54', 6),
    (TIMESTAMP '2021-05-01 10:23:54', 8),
    (TIMESTAMP '2021-05-02 10:23:54', 9),
    (TIMESTAMP '2021-05-03 10:23:54', 11),
    (TIMESTAMP '2021-05-04 10:23:54', 11),
    (TIMESTAMP '2021-05-06 10:23:54', 12),
    (TIMESTAMP '2021-05-06 10:23:54', 13);

INSERT INTO employees (employeeRole, userId) VALUES
    ('ADMIN', 1),
    ('STAFF', 2),
    ('STAFF', 3),
    ('STAFF', 19),
    ('STAFF', 20);

INSERT INTO addresses (address, city, postcode, region, country, userId, isPrimary) VALUES 
    ('123 Fake Street', 'Sydney', '2000', 'NSW', 'Australia',2, TRUE),
    ('32 Real Street', 'Brisbane', '4000', 'QLD', 'Australia',3, TRUE),
    ('22 Pacific Road', 'Chatswood', '2067', 'NSW', 'Australia',4, TRUE ),
    ('1 Albert Avenue', 'Hornsby', '2077', 'NSW', 'Australia',4, FALSE ),
    ('22 Anthony Road', 'Chatswood', '2067', 'NSW', 'Australia',5, TRUE),
    ('3 Riddles Street', 'Bankstown', '2200', 'NSW', 'Australia',5, FALSE ),
    ('262 Pacific Road', 'Blacktown', '2148', 'NSW', 'Australia',6, TRUE ),
    ('4 Albert Avenue', 'Hornsby', '2077', 'NSW', 'Australia',7, TRUE ),
    ('5 Riddles Street', 'Bankstown', '2200', 'NSW', 'Australia',8, FALSE),
    ('6 Anthony Road', 'Chatswood', '2067', 'NSW', 'Australia',8, FALSE),
    ('7 Pacific Highway', 'Sydney', '2000', 'NSW', 'Australia',8, TRUE),
    ('8 Albert Avenue', 'Hornsby', '2077', 'NSW', 'Australia',9, TRUE),
    ('9 Archer Street', 'North Bondi', '2026', 'NSW', 'Australia',10, TRUE),
    ('8 Riddles Road', 'Bankstown', '2200', 'NSW', 'Australia', 11, TRUE),
    ('77 Pacific Road', 'Blacktown', '2148', 'NSW', 'Australia',12, TRUE),
    ('66 Archer Street', 'North Bondi', '2026', 'NSW', 'Australia',13, TRUE);

INSERT INTO suppliers (supplierName, company, email) VALUES
    ('Tech Pty', 'Tech', 'suppliers@tech.com.au'),
    ('Cisco Importers Ltd', 'Cisco', 'importers@cisco.com'),
    ('Arduino Suppliers', 'Arduino','suppliers@arduino.com');


INSERT INTO items (itemName, quantity, price, imageUrl, category, supplierId) VALUES
    ('Arduino Nano IoT Interface Adapter', 10, 11.95, 'resources/images/1.png', 'Adapter', 1),
    ('CCS811 Air Quality Sensor', 10, 30.00, 'resources/images/2.png', 'Sensors', 1),
    ('ESP32 IoT WiFi BLE Module with Integrated USB', 10, 16.95, 'resources/images/3.png', '', 2),
    ('Industrial IoT RS485 To Wireless Converter', 5, 168.95, 'resources/images/4.png', 'Communications', 1),
    ('Industrial IoT Wireless Linear Displacement Sensor', 5, 196.95, 'resources/images/5.png', 'Sensors', 2),
    ('Industrial IoT Wireless Vibration & Temperature Sensor V2 MEMS', 3, 258.95, 'resources/images/6.png', 'Sensors', 1),
    ('Industrial IoT Wireless Temperature Humidity Sensor', 10, 198.95, 'resources/images/7.png', 'Controllers', 1),
    ('I2C Shield for Raspberry Pi with Inward Facing I2C Port', 30, 10.95, 'resources/images/8.png', 'Raspberry Pi', 2),
    ('I2C Shield for Raspberry Pi with Outward Facing I2C Port', 50, 10.95, 'resources/images/9.png', 'Raspberry Pi', 1),
    ('Dual I2C Shield for Arduino Due with Modular Communications Interface', 50, 12.95, '19/11/PR37-10_1-500x500.png', 'Adapters', 1),
    ('Arduino Nano', 10, 11.95, '19/09/207-2079543_arduino-nano-arduino-nano-board1_2_700x667-500x500.png', 'Adapters', 3),
    ('ADT75 Temperature Sensor ±1°C 12-Bit with 3 Address Lines I2C Mini Module', 21, 24.95, '19/09/ADT75_I2CS_A_1-600x393_1000x667-500x500.png', 'Sensors', 1),
    ('8-Channel DC Current Monitor with I2C Interface', 10, 84.95, '18/10/ADS7828_I2CCM8-500x500.png', 'Controllers', 3),
    ('IoT Training Controller Light Sound Sensor Action', 10, 63.95, '18/09/PR51-18-w-OLED_1-1-500x500.png', 'Convertors', 1),
    ('Long Range IoT Wireless RTD Temperature Sensor', 5, 188.95, '19/11/3-Wire-RTD-WIreless-Transmitter-500x500.jpg', 'Sensors', 1),
    ('MG-811 CO2 Gas Sensor with I2C Interface', 10, 68.95, '19/09/PR51-19_1-600x400_800x667-500x500.png', 'Sensors', 3),
    ('Particle Photon', 10, 11, '18/10/Photon2-autoxauto-800x800-500x500.jpg', '', 3),
    ('Raspberry Pi Model B RASP-PI-3', 10, 47.83, '18/10/INPI2_3-500x500.png', 'Raspberry Pi', 1),
    ('Raspberry Pi Model 3 B + I2C Adapter + I2C Cable + I2C Sensor', 5, 105.51, '18/10/44670760_2173331872880195_6023066916761894912N-500x500.png', 'Raspberry Pi', 1),
    ('SI1132 UV Index Ambient Light Sensor I2C Mini Module', 10, 26.95, '18/09/SI1132_I2CS_A_1-e1541141298185-500x500.png', 'Sensors', 1),
    ('Temperature Sensor Thermistor 10K OHM ±3% PROBE', 10, 15.95, '18/10/0_1-500x500.jpeg', 'Sensors', 3),
    ('TCS3472 Very High Sensitivity Color Light-to-Digital Converter with IR Filter I2C Mini Module', 15, 28.95, '18/09/TMP007_I2CS_A_1-e1541142323284-500x500.png', 'Sensors', 1),
    ('Water Detection Sensor with Buzzer', 10, 24.95, '18/09/PCA9536_WDBZ_I2CS_1-500x500.png', 'Sensors', 1),
    ('Water Level Sensor with Analog to Digital Converter ADC121C021', 10, 24.95, '18/09/ADC121C021-WL-I2CS_1-500x500.png', 'Converters', 1),
    ('Wireless 0-10V 4-Channel Input USB endNode', 3, 248.95, '19/11/endNode_ASM1-6_1-500x500.jpg', 'Converters', 1);

INSERT INTO carts (userId, totalPrice) VALUES 
    (2, 41.95), (4, 60.00), (4, 16.95), (5,348.85), 
    (6, 185.90), (6, 60.75), (7, 567.60), (7, 16.95), 
    (7, 348.85), (8, 24.95), (null, 196.95), (null, 68.75),
    (null, 196.95), (null, 74.85), (null, 418.85), (null, 24.95), 
    (null, 196.95), (null, 10.95), (null, 10.95), (null, 49.90);

INSERT INTO orders (orderDate, orderTime, orderStatus, isPaid, cartId, userId) VALUES
    ('2021-02-01', '09:55:02', 'Delivered', TRUE, 1, 2),
    ('2021-02-04', '13:05:07', 'Shipped', TRUE, 2, 4),
    ('2021-02-03', '06:48:53', 'Delivered', TRUE, 3, 4),
    ('2021-03-04', '21:31:26', 'Delivered', TRUE, 4, 5),
    ('2021-03-06', '21:31:26', 'Delivered', TRUE, 5, 6),
    ('2021-03-07', '21:31:26', 'Delivered', TRUE, 6, 6),
    ('2021-03-08', '21:31:26', 'Delivered', TRUE, 7, 7),
    ('2021-03-09', '21:31:26', 'Delivered', TRUE, 8, 7),
    ('2021-04-10', '21:31:26', 'Delivered', TRUE, 9, 7),
    ('2021-04-11', '21:31:26', 'Delivered', TRUE, 10, 8),
    ('2021-04-12', '21:31:26', 'Delivered', TRUE, 11, NULL),
    ('2021-04-13', '21:31:26', 'Delivered', TRUE, 12, NULL),
    ('2021-04-14', '22:31:26', 'Delivered', TRUE, 13, NULL),
    ('2021-04-15', '01:31:26', 'Delivered', TRUE, 14, NULL),
    ('2021-04-22', '01:31:26', 'Delivered', TRUE, 15, NULL),
    ('2021-04-23', '11:31:26', 'Delivered', TRUE, 16, NULL),
    ('2021-04-24', '23:31:26', 'Delivered', TRUE, 17, NULL),
    ('2021-04-25', '12:31:26', 'Shipped', TRUE, 18, NULL),
    ('2021-04-26', '21:31:26', 'Shipped', TRUE, 19, NULL),
    ('2021-04-27', '21:31:26', 'Submitted', TRUE, 20, NULL);

UPDATE orders 
SET totalPrice = carts.totalPrice 
FROM carts
WHERE cartid=carts.id;

INSERT INTO cart_items (itemId, quantity, itemPrice, cartId) VALUES
    (1, 1, 11.95, 1),
    (2, 1, 30.00, 1),
    (2, 2, 30.00, 2),
    (3, 1, 16.95, 3),
    (3, 1, 16.95, 5),
    (3, 1, 16.95, 6),
    (3, 1, 16.95, 7),
    (3, 1, 16.95, 8),
    (4, 2, 168.95, 4),
    (4, 1, 168.95, 5),
    (4, 3, 168.95, 7),
    (4, 2, 168.95, 9),
    (5, 1, 196.95, 11),
    (5, 1, 196.95, 13),
    (5, 2, 196.95, 15),
    (5, 1, 196.95, 17),
    (8, 2, 10.95, 6),
    (8, 4, 10.95, 7),
    (8, 1, 10.95, 18),
    (8, 1, 10.95, 19),
    (8, 2, 10.95, 12),
    (9, 2, 10.95, 6),
    (9, 1, 10.95, 9),
    (9, 2, 10.95, 12),
    (24, 1, 24.95, 15),
    (24, 1, 24.95, 10),
    (24, 1, 24.95, 12),
    (24, 3, 24.95, 14),
    (24, 1, 24.95, 16),
    (24, 2, 24.95, 20);

INSERT INTO credit_cards (cardNumber, expirationMonth, expirationYear, cardOwner, userId, isPrimary) VALUES
    ('1234-5678-1234-1234', '01', '23', 'Jane Smath',2, TRUE),
    ('1234-5678-1234-5678', '09', '22', 'Brad Smoth',4, FALSE),
    ('9234-5678-1234-5678', '09', '22', 'Brad Smoth',4, TRUE),
    ('8234-5673-1234-5678', '06', '25', 'Bill Smoth',6, TRUE),
    ('4234-5428-1234-5678', '07', '21', 'Joey Mings',7, TRUE),
    ('6234-5678-1234-5678', '08', '21', 'Joey Mings',7, FALSE),
    ('7234-5642-1234-5678', '09', '23', 'Gilbert Lee',8, TRUE),
    ('6666-1234-1234-5555', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-6666', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-7777', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-8888', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-8899', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-0000', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-9999', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-9876', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-6543', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-3245', '09', '23', 'Foo Bar',15, FALSE),
    ('6666-1234-1234-3466', '09', '23', 'Foo Bar',15, TRUE);

INSERT INTO credit_card_payments (cardNumber, orderId) VALUES
    ('1234-5678-1234-1234', 1),
    ('1234-5678-1234-1234', 2),
    ('6666-1234-1234-0000', 3),
    ('6666-1234-1234-0000', 5),
    ('6666-1234-1234-0000', 6),
    ('6666-1234-1234-0000', 7),
    ('6666-1234-1234-0000', 8),
    ('6666-1234-1234-0000', 9),
    ('6666-1234-1234-0000', 10),
    ('6666-1234-1234-0000', 11),
    ('6666-1234-1234-0000', 12),
    ('6666-1234-1234-0000', 13),
    ('6666-1234-1234-0000', 14),
    ('6666-1234-1234-0000', 15),
    ('6666-1234-1234-0000', 16),
    ('6666-1234-1234-0000', 17),
    ('6666-1234-1234-0000', 18),
    ('6666-1234-1234-0000', 19),
    ('6666-1234-1234-0000', 20);

INSERT INTO shipping (address, city, postcode, region, country, recipient, trackingNumber, orderId) VALUES
    ('32 Real Street', 'Brisbane', '4000', 'QLD', 'Australia', 'Jane Smath', 'S0230HGTY', 2),
    ('22 Pacific Road', 'Chatswood', '2067', 'NSW', 'Australia' , 'Brad Smoth', 'Y000GH1', 4),
    ('22 Pacific Road', 'Chatswood', '2067', 'NSW', 'Australia' , 'Brad Smoth', 'S00001', 4);
