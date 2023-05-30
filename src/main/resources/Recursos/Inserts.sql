-- Insert statements for table amolaberinto.lugar
INSERT INTO amolaberinto.lugar ( clase_asignada, alineacion_asignada, tipo) VALUES ( 'Mago', 'Neutral', 'Bosque');
INSERT INTO amolaberinto.lugar ( clase_asignada, alineacion_asignada, tipo) VALUES ( 'Guerrero', 'Legal Bueno', 'Pueblo');
-- Insert statements for table amolaberinto.personaje
INSERT INTO amolaberinto.personaje (nombre, clase, alineamiento,imagen, nivel,clase_armadura,vida, experiencia,lugar_id) VALUES ('Gandalf', 'Mago', 'Neutral','http://localhost:8083/media/Gandalf.png', 10,5,10, 15000,1);
INSERT INTO amolaberinto.personaje (nombre, clase, alineamiento,imagen, nivel,clase_armadura,vida, experiencia,lugar_id) VALUES ('Aragorn', 'Guerrero', 'Legal Bueno','http://localhost:8083/media/Aragorn4.png', 8,5,10, 10000,1);
INSERT INTO amolaberinto.personaje (nombre, clase, alineamiento,imagen, nivel,clase_armadura,vida, experiencia,lugar_id) VALUES ('Legolas', 'Arquero', 'Legal Bueno','http://localhost:8083/media/Legolas.png', 7,5,10, 8000,2);

-- Insert statements for table amolaberinto.habilidad
INSERT INTO amolaberinto.habilidad (id, nombre, interpretativas, personaje_id) VALUES (1, 'Magia', 1, 1);
INSERT INTO amolaberinto.habilidad (id, nombre, interpretativas, personaje_id) VALUES (2, 'Espada', 0, 2);
INSERT INTO amolaberinto.habilidad (id, nombre, interpretativas, personaje_id) VALUES (3, 'Arco', 0, 3);
INSERT INTO amolaberinto.habilidad (id, nombre, interpretativas, personaje_id) VALUES (4, 'Curación', 1, 1);

-- Insert statements for table amolaberinto.inventario
INSERT INTO amolaberinto.objetos (id,nombre, valor, peso, consumible, personaje_id) VALUES (1, 'Varita Mágica',3, 1.2, 0, 1);
INSERT INTO amolaberinto.objetos (id,nombre, valor, peso, consumible, personaje_id) VALUES (2, 'Espada Larga',4, 2.5, 0, 2);
INSERT INTO amolaberinto.objetos (id,nombre, valor, peso, consumible, personaje_id) VALUES (3, 'Arco Élfico',15, 1.8, 0, 3);
INSERT INTO amolaberinto.objetos (id,nombre, valor, peso, consumible, personaje_id) VALUES (4, 'Poción de Curación',142, 0.2, 1, 1);

-- Insert statements for table amolaberinto.lugar
INSERT INTO amolaberinto.lugar ( clase_asignada, alineacion_asignada, tipo) VALUES ( 'Mago', 'Neutral', 'Bosque');
INSERT INTO amolaberinto.lugar ( clase_asignada, alineacion_asignada, tipo) VALUES ( 'Guerrero', 'Legal Bueno', 'Pueblo');

-- Insert statements for table amolaberinto.mision
INSERT INTO amolaberinto.mision (id, recompensa, objetivos,estado,tiempo_restante,lugar_id) VALUES 
(3, '1000 monedas de oro', 'Buscar el tesoro perdido en el valle de los reyes.','EN_CURSO',10,1),
(4, '2000 monedas de oro', 'Capturar al fugitivo más buscado del reino.','EN_CURSO',10,1),
(5, '500 monedas de oro', 'Recoger y entregar un paquete importante a su destino.','FALLADO',0,1),
(6, '800 monedas de oro', 'Proteger a un grupo de mercaderes de los bandidos del camino.','PENDIENTE',0,2),
(7, '1500 monedas de oro', 'Desentrañar el misterio de la desaparición de un importante noble del reino.','COMPLETADO',10,2);

-- Insert statements for table amolaberinto.moneda
INSERT INTO amolaberinto.moneda (bronce, plata, oro, platino, personaje_id) 
VALUES (50, 25, 10, 2, 2);