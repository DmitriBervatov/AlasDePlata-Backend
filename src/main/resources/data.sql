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
(3, 'LA303', 3, 4, '2025-05-09T12:00:00', '2025-05-10T14:00:00', 3, 'PROGRAMMED'),
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
-- Seats
INSERT INTO seats (id, flight_id, seat_number, class, seat_type, seat_status) VALUES 

-- Fila 1 (Premium)
(1, 1, '1A', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(2, 1, '1B', 'ECONOMY', 'PREMIUM', 'OCCUPIED'),
(3, 1, '1C', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(4, 1, '1D', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(5, 1, '1E', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(6, 1, '1F', 'ECONOMY', 'PREMIUM', 'SELECTED'),
(7, 1, '1G', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(8, 1, '1H', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),

-- Fila 2 (Premium)
(9, 1, '2A', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(10, 1, '2B', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(11, 1, '2C', 'ECONOMY', 'PREMIUM', 'OCCUPIED'),
(12, 1, '2D', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(13, 1, '2E', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(14, 1, '2F', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(15, 1, '2G', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(16, 1, '2H', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),

-- Fila 3 (Emergency Exit)
(17, 1, '3A', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(18, 1, '3B', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(19, 1, '3C', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(20, 1, '3D', 'ECONOMY', 'EMERGENCY_EXIT', 'OCCUPIED'),
(21, 1, '3E', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(22, 1, '3F', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(23, 1, '3G', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(24, 1, '3H', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),

-- Fila 4 (Emergency Exit)
(25, 1, '4A', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(26, 1, '4B', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(27, 1, '4C', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(28, 1, '4D', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(29, 1, '4E', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(30, 1, '4F', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(31, 1, '4G', 'ECONOMY', 'EMERGENCY_EXIT', 'OCCUPIED'),
(32, 1, '4H', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),

-- Filas 5-8 (Normal, algunos ocupados y seleccionados)
(33, 1, '5A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(34, 1, '5B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(35, 1, '5C', 'ECONOMY', 'NORMAL', 'OCCUPIED'),
(36, 1, '5D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(37, 1, '5E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(38, 1, '5F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(39, 1, '5G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(40, 1, '5H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

(41, 1, '6A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(42, 1, '6B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(43, 1, '6C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(44, 1, '6D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(45, 1, '6E', 'ECONOMY', 'NORMAL', 'SELECTED'),
(46, 1, '6F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(47, 1, '6G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(48, 1, '6H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

(49, 1, '7A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(50, 1, '7B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(51, 1, '7C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(52, 1, '7D', 'ECONOMY', 'NORMAL', 'OCCUPIED'),
(53, 1, '7E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(54, 1, '7F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(55, 1, '7G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(56, 1, '7H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

(57, 1, '8A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(58, 1, '8B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(59, 1, '8C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(60, 1, '8D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(61, 1, '8E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(62, 1, '8F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(63, 1, '8G', 'ECONOMY', 'NORMAL', 'OCCUPIED'),
(64, 1, '8H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

-- Filas 9-12 (Normal, algunos seleccionados y ocupados)
(65, 1, '9A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(66, 1, '9B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(67, 1, '9C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(68, 1, '9D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(69, 1, '9E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(70, 1, '9F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(71, 1, '9G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(72, 1, '9H', 'ECONOMY', 'NORMAL', 'OCCUPIED'),

(73, 1, '10A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(74, 1, '10B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(75, 1, '10C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(76, 1, '10D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(77, 1, '10E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(78, 1, '10F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(79, 1, '10G', 'ECONOMY', 'NORMAL', 'SELECTED'),
(80, 1, '10H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

(81, 1, '11A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(82, 1, '11B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(83, 1, '11C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(84, 1, '11D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(85, 1, '11E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(86, 1, '11F', 'ECONOMY', 'NORMAL', 'OCCUPIED'),
(87, 1, '11G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(88, 1, '11H', 'ECONOMY', 'NORMAL', 'AVAILABLE'),

(89, 1, '12A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(90, 1, '12B', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(91, 1, '12C', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(92, 1, '12D', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(93, 1, '12E', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(94, 1, '12F', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(95, 1, '12G', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(96, 1, '12H', 'ECONOMY', 'NORMAL', 'SELECTED'),
(97, 2, '14A', 'ECONOMY', 'NORMAL', 'AVAILABLE'),
(98, 2, '14B', 'ECONOMY', 'PREMIUM', 'AVAILABLE'),
(99, 2, '14C', 'ECONOMY', 'EMERGENCY_EXIT', 'AVAILABLE'),
(100, 2, '14D', 'BUSINESS', 'NORMAL', 'OCCUPIED'),
(101, 2, '14E', 'BUSINESS', 'PREMIUM', 'AVAILABLE'),
(102, 2, '14F', 'FIRST_CLASS', 'NORMAL', 'AVAILABLE'),
(103, 2, '14G', 'FIRST_CLASS', 'PREMIUM', 'OCCUPIED'),
(104, 2, '14H', 'ECONOMY', 'NORMAL', 'SELECTED');


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

-- Servicios adicionales
INSERT INTO additional_services (id, name, description, price, icon) VALUES
(1, 'WiFi a bordo', 'Acceso a internet durante el vuelo', 12.50, 'wifi'),
(2, 'Sala VIP', 'Acceso a la sala VIP del aeropuerto', 30.00, 'briefcase'),
(3, 'Comida especial', 'Menú especial a bordo', 18.00, 'meal'),
(4, 'Embarque prioritario', 'Prioridad al abordar el avión', 8.00, 'arrow-up-circle'),
(5, 'Seguro de viaje', 'Cobertura de seguro durante el viaje', 20.00, 'shield');

-- Relacionar reservas con servicios adicionales
INSERT INTO reservation_additional_services (id, reservation_id, additional_service_id) VALUES
(1, 1, 1), -- Reserva 1 adquirió WiFi a bordo
(2, 1, 2), -- Reserva 1 adquirió Sala VIP
(3, 2, 3), -- Reserva 2 adquirió Comida especial
(4, 3, 4), -- Reserva 3 adquirió Embarque prioritario
(5, 4, 5); -- Reserva 4 adquirió Seguro de viaje

-- Relacionar vuelos con servicios adicionales
INSERT INTO flight_additional_services (id, flight_id, additional_service_id) VALUES
(1, 1, 1), -- Vuelo 1 tiene WiFi a bordo
(2, 1, 2), -- Vuelo 1 tiene Sala VIP
(3, 2, 3), -- Vuelo 2 tiene Comida especial
(4, 2, 4), -- Vuelo 2 tiene Embarque prioritario
(5, 3, 1), -- Vuelo 3 tiene WiFi a bordo
(6, 3, 5), -- Vuelo 3 tiene Seguro de viaje
(7, 4, 2), -- Vuelo 4 tiene Sala VIP
(8, 5, 3), -- Vuelo 5 tiene Comida especial
(9, 6, 4), -- Vuelo 6 tiene Embarque prioritario
(10, 7, 5); -- Vuelo 7 tiene Seguro de viaje


-- AiInteractions
-- INSERT INTO ai_interactions (id, user_id, interaction_type, message, response, created_at) VALUES
-- (1, 1, 'INQUIRY', '¿Cuál es mi vuelo?', 'Tu vuelo es AV101', '2025-05-01T16:00:00'),
-- (2, 2, 'CHECK_IN', '¿Puedo hacer check-in?', 'El check-in está disponible 24h antes del vuelo.', '2025-05-01T17:00:00'),
-- (3, 3, 'INQUIRY', '¿Hay wifi en el avión?', 'Sí, hay wifi disponible.', '2025-05-01T18:00:00'),
-- (4, 4, 'INQUIRY', '¿Puedo llevar equipaje extra?', 'Sí, pero tiene un costo adicional.', '2025-05-01T19:00:00');

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
-- SELECT setval('ai_interactions_id_seq', (SELECT MAX(id) FROM ai_interactions));
SELECT setval('benefits_id_seq', (SELECT MAX(id) FROM benefits));
SELECT setval('additional_services_id_seq', (SELECT MAX(id) FROM additional_services));
SELECT setval('reservation_additional_services_id_seq', (SELECT MAX(id) FROM reservation_additional_services));
SELECT setval('flight_additional_services_id_seq', (SELECT MAX(id) FROM flight_additional_services));
SELECT setval('flight_price_benefits_id_seq', (SELECT MAX(id) FROM flight_price_benefits));
