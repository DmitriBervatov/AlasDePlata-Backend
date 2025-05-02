-- PERMISSIONS
INSERT INTO permissions (id, name) VALUES (1, 'CREATE');
INSERT INTO permissions (id, name) VALUES (2, 'READ');
INSERT INTO permissions (id, name) VALUES (3, 'UPDATE');
INSERT INTO permissions (id, name) VALUES (4, 'DELETE');
INSERT INTO permissions (id, name) VALUES (5, 'REFACTOR');

-- ROLES
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');
INSERT INTO roles (id, name) VALUES (3, 'INVITED');
INSERT INTO roles (id, name) VALUES (4, 'DEVELOPER');

-- ROLE_PERMISSIONS
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4); -- ADMIN
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 1), (2, 2); -- USER
INSERT INTO role_permissions (role_id, permission_id) VALUES (3, 2); -- INVITED
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 1), (4, 2), (4, 3), (4, 4), (4, 5); -- DEVELOPER

-- USERS
INSERT INTO users (id, username, password, is_enabled, account_No_Expired, account_No_Locked, credential_No_Expired)
VALUES (1, 'santiago', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', true, true, true, true),
       (2, 'daniel', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', true, true, true, true),
       (3, 'andrea', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', true, true, true, true),
       (4, 'anyi', '$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6', true, true, true, true);

-- USER_ROLES
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4);

-- Destinations
INSERT INTO destinations (id, city, country, airport_code) VALUES (1, 'Bogotá', 'Colombia', 'BOG');
INSERT INTO destinations (id, city, country, airport_code) VALUES (2, 'Medellín', 'Colombia', 'MDE');
INSERT INTO destinations (id, city, country, airport_code) VALUES (3, 'Cartagena', 'Colombia', 'CTG');

-- Airplanes
INSERT INTO airplanes (id, model, capacity, registration_number) VALUES (1, 'Boeing 737', 180, 'ABC123');
INSERT INTO airplanes (id, model, capacity, registration_number) VALUES (2, 'Airbus A320', 150, 'XYZ789');

-- Flights
INSERT INTO flights (id, flight_number, origin_id, destination_id, departure_time, arrival_time, airplane_id, status) VALUES
(1, 'AV101', 1, 2, '2025-05-02T08:00:00', '2025-05-02T09:00:00', 1, 'PROGRAMMED'),
(2, 'AV202', 2, 3, '2025-05-03T10:00:00', '2025-05-03T11:30:00', 2, 'PROGRAMMED');

-- Passengers
INSERT INTO passengers (id, user_id, passport_number, nationality, birth_date) VALUES (1, 1, 'P1234567', 'Colombian', '1990-01-01');
INSERT INTO passengers (id, user_id, passport_number, nationality, birth_date) VALUES (2, 2, 'P7654321', 'Colombian', '1985-06-15');

-- Reservations
INSERT INTO reservations (id, user_id, flight_id, reservation_date, status) VALUES (1, 1, 1, '2025-05-01T12:00:00', 'CONFIRMED');
INSERT INTO reservations (id, user_id, flight_id, reservation_date, status) VALUES (2, 2, 2, '2025-05-01T13:00:00', 'CONFIRMED');

-- Seats
INSERT INTO seats (id, flight_id, seat_number, class, is_available) VALUES (1, 1, '12A', 'ECONOMY', true);
INSERT INTO seats (id, flight_id, seat_number, class, is_available) VALUES (2, 2, '14B', 'ECONOMY', true);

-- ReservationPassengers
INSERT INTO reservation_passengers (id, reservation_id, passenger_id, seat_id) VALUES (1, 1, 1, 1);
INSERT INTO reservation_passengers (id, reservation_id, passenger_id, seat_id) VALUES (2, 2, 2, 2);



-- Payments
INSERT INTO payments (id, reservation_id, amount, payment_date, payment_method) VALUES (1, 1, 350000, '2025-05-01T14:00:00', 'CREDIT_CARD');
INSERT INTO payments (id, reservation_id, amount, payment_date, payment_method) VALUES (2, 2, 420000, '2025-05-01T15:00:00', 'PAYPAL');

-- Flight Prices
INSERT INTO flight_prices (id, flight_id, class, price) VALUES (1, 1, 'ECONOMY', 350000);
INSERT INTO flight_prices (id, flight_id, class, price) VALUES (2, 2, 'ECONOMY', 420000);

-- AiInteractions
INSERT INTO ai_interactions (id, user_id, interaction_type, message, response, created_at) VALUES
(1, 1, 'INQUIRY', '¿Cuál es mi vuelo?', 'Tu vuelo es AV101', '2025-05-01T16:00:00');

-- Ajustar secuencias para evitar conflictos de clave primaria en inserts automáticos
SELECT setval('permissions_id_seq', (SELECT MAX(id) FROM permissions));
SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('destinations_id_seq', (SELECT MAX(id) FROM destinations));
SELECT setval('airplanes_id_seq', (SELECT MAX(id) FROM airplanes));
SELECT setval('flights_id_seq', (SELECT MAX(id) FROM flights));
SELECT setval('passengers_id_seq', (SELECT MAX(id) FROM passengers));
SELECT setval('reservations_id_seq', (SELECT MAX(id) FROM reservations));
SELECT setval('seats_id_seq', (SELECT MAX(id) FROM seats));
SELECT setval('reservation_passengers_id_seq', (SELECT MAX(id) FROM reservation_passengers));
SELECT setval('payments_id_seq', (SELECT MAX(id) FROM payments));
SELECT setval('flight_prices_id_seq', (SELECT MAX(id) FROM flight_prices));
SELECT setval('ai_interactions_id_seq', (SELECT MAX(id) FROM ai_interactions));