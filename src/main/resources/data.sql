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
VALUES (1, 'santiago', '$2a$10$alDHPqptkxJ2/XffiFPDEOUzl/zR.a0yN2a7jbReHLMecbHGUi5nu', true, true, true, true),
       (2, 'daniel', '$2a$10$alDHPqptkxJ2/XffiFPDEOUzl/zR.a0yN2a7jbReHLMecbHGUi5nu', true, true, true, true),
       (3, 'andrea', '$2a$10$alDHPqptkxJ2/XffiFPDEOUzl/zR.a0yN2a7jbReHLMecbHGUi5nu', true, true, true, true),
       (4, 'anyi', '$2a$10$alDHPqptkxJ2/XffiFPDEOUzl/zR.a0yN2a7jbReHLMecbHGUi5nu', true, true, true, true);

-- USER_ROLES
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4);

-- Destinations
INSERT INTO destinations (id, city, country, image_url, airport_code, continent) VALUES
(1, 'Bogotá', 'Colombia', 'https://images.unsplash.com/photo-1506744038136-46273834b3fb', 'BOG', 'SOUTH_AMERICA'),
(2, 'Medellín', 'Colombia', 'https://images.unsplash.com/photo-1464983953574-0892a716854b', 'MDE', 'SOUTH_AMERICA'),
(3, 'Cartagena', 'Colombia', 'https://images.unsplash.com/photo-1502086223501-7ea6ecd79368', 'CTG', 'SOUTH_AMERICA'),
(4, 'Lima', 'Peru', 'https://images.unsplash.com/photo-1509228468518-180dd4864904', 'LIM', 'SOUTH_AMERICA'),
(5, 'Quito', 'Ecuador', 'https://images.unsplash.com/photo-1464983953574-0892a716854b', 'UIO', 'SOUTH_AMERICA'),
(6, 'Buenos Aires', 'Argentina', 'https://images.unsplash.com/photo-1519681393784-d120267933ba', 'EZE', 'SOUTH_AMERICA'),
(7, 'Madrid', 'España', 'https://images.unsplash.com/photo-1464983953574-0892a716854b', 'MAD', 'EUROPE');

-- Airlines
INSERT INTO airlines (id, name, country) VALUES 
(1, 'Avianca', 'Colombia'),
(2, 'LATAM', 'Chile'),
(3, 'American Airlines', 'USA'),
(4, 'Air France', 'France');


-- Airplanes
INSERT INTO airplanes (id, model, capacity, registration_number, airline_id) VALUES 
(1, 'Boeing 737', 180, 'ABC123', 1),
(2, 'Airbus A320', 150, 'XYZ789', 2),
(3, 'Boeing 787', 240, 'DEF456', 2),
(4, 'Airbus A330', 260, 'GHI012', 3),
(5, 'Boeing 777', 300, 'JKL345', 4),
(6, 'Airbus A350', 280, 'MNO678', 1);


-- Flights
INSERT INTO flights (id, flight_number, origin_id, destination_id, departure_time, arrival_time, airplane_id, status) VALUES
(1, 'AV101', 1, 2, '2025-05-07T08:00:00', '2025-05-08T09:00:00', 1, 'PROGRAMMED'),
(2, 'AV202', 2, 3, '2025-05-08T10:00:00', '2025-05-08T11:30:00', 2, 'PROGRAMMED'),
(3, 'LA303', 3, 4, '2025-05-10T12:00:00', '2025-05-10T14:00:00', 3, 'PROGRAMMED'),
(4, 'AA404', 4, 1, '2025-05-12T15:00:00', '2025-05-12T17:00:00', 4, 'PROGRAMMED'),
(5, 'AF505', 1, 5, '2025-05-15T09:30:00', '2025-05-15T13:00:00', 5, 'PROGRAMMED'),
(6, 'LA606', 2, 6, '2025-05-18T14:00:00', '2025-05-18T18:00:00', 6, 'PROGRAMMED'),
(7, 'AV707', 3, 7, '2025-05-21T07:00:00', '2025-05-21T15:00:00', 1, 'PROGRAMMED'),
(8, 'AA808', 4, 2, '2025-05-25T16:00:00', '2025-05-25T18:30:00', 2, 'PROGRAMMED');

-- Passengers
INSERT INTO passengers (id, user_id, passport_number, nationality, birth_date) VALUES 
(1, 1, 'P1234567', 'Colombian', '1990-01-01'),
(2, 2, 'P7654321', 'Colombian', '1985-06-15'),
(3, 3, 'P1111111', 'Colombian', '1992-07-21'),
(4, 4, 'P2222222', 'Peruvian', '1995-12-10');



-- Reservations
INSERT INTO reservations (id, user_id, flight_id, reservation_date, status) VALUES 
(1, 1, 1, '2025-05-01T12:00:00', 'CONFIRMED'),
(2, 2, 2, '2025-05-01T13:00:00', 'CONFIRMED'),
(3, 3, 1, '2025-05-01T16:00:00', 'CONFIRMED'),
(4, 4, 2, '2025-05-01T17:00:00', 'CONFIRMED');


-- Seats
INSERT INTO seats (id, flight_id, seat_number, class, is_available) VALUES 
(1, 1, '12A', 'ECONOMY', true),
(2, 1, '12B', 'ECONOMY', true),
(3, 1, '12C', 'ECONOMY', true),
(4, 1, '12D', 'ECONOMY', true),
(5, 1, '12E', 'ECONOMY', true),
(6, 1, '12F', 'ECONOMY', true),
(7, 1, '12G', 'ECONOMY', true),
(8, 1, '12H', 'ECONOMY', true),
(9, 2, '14A', 'ECONOMY', true);


-- ReservationPassengers
INSERT INTO reservation_passengers (id, reservation_id, passenger_id, seat_id) VALUES 
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 2, 1, 1),
(4, 2, 2, 2);



-- Payments
INSERT INTO payments (id, reservation_id, amount, payment_date, payment_method) VALUES 
(1, 1, 350, '2025-05-01T14:00:00', 'CREDIT_CARD'),
(2, 2, 420, '2025-05-01T15:00:00', 'PAYPAL'),
(3, 3, 370, '2025-05-01T18:00:00', 'CREDIT_CARD'),
(4, 4, 410, '2025-05-01T19:00:00', 'PAYPAL');

-- Flight Prices
INSERT INTO flight_prices (id, flight_id, class, price) VALUES 
(1, 1, 'ECONOMY', 350),
(2, 2, 'ECONOMY', 420),
(3, 1, 'BUSINESS', 700),
(4, 2, 'BUSINESS', 800),
(5, 1, 'FIRST_CLASS', 1200),
(6, 2, 'FIRST_CLASS', 1500);

-- Benefits
INSERT INTO benefits (id, code, name, description) VALUES
(1, 'EQUIPAJE_MANO', 'Equipaje de mano', 'Hasta 10kg, 1 pieza'),
(2, 'EQUIPAJE_BODEGA', 'Equipaje en bodega', 'Hasta 23kg, 1 pieza'),
(3, 'ASIENTO_PREFERENTE', 'Asiento preferente', 'Selección de asiento preferente'),
(4, 'WIFI', 'WiFi a bordo', 'Acceso a internet durante el vuelo');

-- Flight Price Benefits
INSERT INTO flight_price_benefits (id, flight_price_id, benefit_id, value, extra_info) VALUES
(1, 1, 1, 'Incluido', null),
(2, 1, 2, 'No incluido', null),
(3, 1, 3, 'No incluido', null),
(4, 1, 4, 'No incluido', null),
(5, 3, 1, 'Incluido', null),
(6, 3, 2, 'Incluido', null),
(7, 3, 3, 'Incluido', null),
(8, 3, 4, 'Incluido', null),
(9, 2, 1, 'Incluido', null),
(10, 2, 2, 'No incluido', null),
(11, 2, 3, 'No incluido', null),
(12, 2, 4, 'No incluido', null),
(13, 4, 1, 'Incluido', null),
(14, 4, 2, 'Incluido', null),
(15, 4, 3, 'Incluido', null),
(16, 4, 4, 'Incluido', null);


-- AiInteractions
INSERT INTO ai_interactions (id, user_id, interaction_type, message, response, created_at) VALUES
(1, 1, 'INQUIRY', '¿Cuál es mi vuelo?', 'Tu vuelo es AV101', '2025-05-01T16:00:00'),
(2, 2, 'CHECK_IN', '¿Puedo hacer check-in?', 'El check-in está disponible 24h antes del vuelo.', '2025-05-01T17:00:00'),
(3, 3, 'INQUIRY', '¿Hay wifi en el avión?', 'Sí, hay wifi disponible.', '2025-05-01T18:00:00'),
(4, 4, 'INQUIRY', '¿Puedo llevar equipaje extra?', 'Sí, pero tiene un costo adicional.', '2025-05-01T19:00:00');

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
-- ...existing code...
SELECT setval('benefits_id_seq', (SELECT MAX(id) FROM benefits));
SELECT setval('flight_price_benefits_id_seq', (SELECT MAX(id) FROM flight_price_benefits));
-- ...existing code...