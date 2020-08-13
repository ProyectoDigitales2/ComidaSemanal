use comida;

insert into categoria (categoria) VALUES ('SOPA'), 
										('CALDO'),
										('ARROZ'),
										('FIDEO'),
										('CEVICHES'),
										('DIETA'),
										('VEGETARIANO'),
										('GOURMET'),
										('RÁPIDA');
                                        
insert into ingrediente (nombre) VALUES ('ACHIOTE'),
										('AJO'),
										('ALIÑO'),
										('ARROZ'),
										('ARVEJA'),
										('ATÚN'),
										('CALAMAR'),
										('CAMARÓN'),
										('CANELA'),
										('CANGREJO'),
										('CARNE'), 
										('CEBOLLA BLANCA'),
										('CEBOLLA'),
										('CHOCLO'),
										('CHORIZO'),
										('CHULETA'),
										('CHUZO CERVECERO'),
										('CHUZO COLOMBIANO'),
										('CHUZO CUENCANO'),
										('COL'),
										('COSTILLA'),
										('ESPINACA'),
										('FREJÓL'),
										('FIDEO'),
										('HABA'),
										('HARINA'),
										('HUEVO'),
										('JUGO DE NARANJA'),
										('LAUREL'),
										('LECHE'),
										('LECHUGA'),
										('LENTEJA'),
										('LIMÓN'),
										('MANÍ'),
										('MANTEQUILLA'),
										('MAYONESA'),
										('MONDONGO'),
										('MORTADELA'),
										('MOSTAZA'),
										('MOZARELLA'),
										('PAPA'),
										('PASAS'),
										('PASTA DE TOMATE'),
										('PEPINO'),
										('PEREJIL'),
										('PESCADO'),
										('PIMIENTA'),
										('PIMIENTO'),
										('POLLO'),
										('PULPO'),
										('QUESO'),
										('QUESILLO'),
										('RÁBANO'),
										('RECORTE'),
										('REFRITO'),
										('SALAMI'),
										('SALSA DE TOMATE'),
										('SALSA BBQ'),
										('TOMATE'),
										('VERDE'),
										('VERDURA'),
										('VETERABA'),
										('YERBITA'),
										('YUCA'),
										('ZANAHORIA'),
										('MOTE'),
										('GARBANZO');
insert into ingrediente (nombre) VALUES ('ALBAHACA');   
insert into ingrediente (nombre) VALUES ('PATITA DE CHANCHO'); 
insert into ingrediente (nombre) VALUES ('HIERBABUENA');  
insert into ingrediente (nombre) VALUES ('ACEITE');
insert into ingrediente (nombre) VALUES ('CEBOLLIN');
insert into ingrediente (nombre) VALUES ('ORÉGANO');
                                    
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES
('CALDO DE BOLAS','CALIENTE',2),
('CALDO DE LEGUMBRES','CALIENTE',2),
('ARROZ CON HUEVO','CALIENTE',3),
('SOPA DE LENTEJA','CALIENTE',1),
('BISTEC DE CARNE','CALIENTE',3),
('ENSALADA DE ATÚN','FRIO',3),
('GUATITA','CALIENTE',3),
('YAPINGACHO','CALIENTE',3);
insert into comida (nombre, temperatura, id_categoria) VALUES ('', 'CALIENTE',1);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('PURÉ DE PAPA Y CARNE','CALIENTE',3);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('PURÉ DE PAPA Y CHULETA','CALIENTE',3);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('PURÉ DE PAPA Y CHORIZO','CALIENTE',3);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('PURÉ DE PAPA Y POLLO','CALIENTE',3);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('CEVICHE DE CAMARÓN','FRIO',5);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('CEVICHE DE PULPO','FRIO',5);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('CEVICHE DE CALAMAR','FRIO',5);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('MENESTRÓN DE CARNE','CALIENTE',2);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('MENESTRÓN DE PATITA DE CHANCHO','CALIENTE',2);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('MENESTRÓN DE QUESO','CALIENTE',2);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('SOPA DE POLLO','CALIENTE',1);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('SOPA DE CARNE','CALIENTE',1);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('SOPA DE CAMARÓN','CALIENTE',1);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('SOPA DE PESCADO','CALIENTE',1);
INSERT INTO comida (nombre, temperatura, id_categoria) VALUES('SOPA DE QUESO','CALIENTE',1);

#CALDO DE BOLAS
INSERT INTO plato (id_ingrediente,id_comida) values
(11,1),
(21,1),
(14,1),
(61,1),
(64,1),
(60,1),
(42,1),
(65,1),
(27,1),
(34,1),
(5,1),
(1,1);

#CALDO DE LEGUMBRES
INSERT INTO plato (id_ingrediente,id_comida) values
(41,2),
(14,2),
(25,2),
(65,2),
(52,2),
(30,2),
(22,2),
(12,2);

#ARROZ CON HUEVO
INSERT INTO plato (id_ingrediente,id_comida) values
(4,3),
(27,3);

#SOPA DE LENTEJA
INSERT INTO plato (id_ingrediente,id_comida) values
(32,4),
(11,4),
(41,4),
(65,4),
(20,4),
(24,4),
(1,4),
(3,4),
(55,4);

#BISTEC DE CARNE
INSERT INTO plato (id_ingrediente,id_comida) values
(11,5),
(48,5),
(59,5),
(13,5);

#ENSALADA DE ATÚN
INSERT INTO plato (id_ingrediente,id_comida) values
(6,6),
(13,6),
(41,6),
(33,6);

#GUATITA
INSERT INTO plato (id_ingrediente,id_comida) values
(37,7),
(41,7),
(34,7),
(55,7),
(63,7),
(2,7);

#YAPINGACHO
INSERT INTO plato (id_ingrediente,id_comida) values
(27,8),
(15,8),
(41,8),
(34,8),
(31,8),
(13,8);

#PURÉ DE PAPA Y CARNE
INSERT INTO plato (id_ingrediente,id_comida) values
(41,9),
(30,9),
(35,9),
(45,9),
(11,9);

#PURÉ DE PAPA Y CHULETA
INSERT INTO plato (id_ingrediente,id_comida) values
(41,10),
(30,10),
(35,10),
(45,10),
(16,10);

#PURÉ DE PAPA Y CHORIZO
INSERT INTO plato (id_ingrediente,id_comida) values
(41,11),
(30,11),
(35,11),
(45,11),
(15,11);

#PURÉ DE PAPA Y POLLO
INSERT INTO plato (id_ingrediente,id_comida) values
(41,12),
(30,12),
(35,12),
(45,12),
(49,12);

#CEVICHE DE CAMARÓN
INSERT INTO plato (id_ingrediente,id_comida) values
(13,13),
(48,13),
(28,13),
(39,13),
(57,13),
(33,13),
(59,13),
(71,13),
(8,13);

#CEVICHE DE PULPO
INSERT INTO plato (id_ingrediente,id_comida) values
(13,14),
(48,14),
(28,14),
(39,14),
(57,14),
(33,14),
(59,14),
(71,14),
(50,14);

#CEVICHE DE CALAMAR
INSERT INTO plato (id_ingrediente,id_comida) values
(13,15),
(48,15),
(28,15),
(39,15),
(57,15),
(33,15),
(59,15),
(71,15),
(7,15);

#MENESTRÓN DE CARNE
INSERT INTO plato (id_ingrediente,id_comida) values
(23,16),
(55,16),
(41,16),
(52,16),
(68,16),
(65,16),
(24,16),
(11,16);

#MENESTRÓN DE PATITA DE CHANCHO
INSERT INTO plato (id_ingrediente,id_comida) values
(23,17),
(55,17),
(41,17),
(52,17),
(68,17),
(65,17),
(24,17),
(69,17);

#MENESTRÓN DE QUESO
INSERT INTO plato (id_ingrediente,id_comida) values
(23,18),
(55,18),
(41,18),
(52,18),
(68,18),
(65,18),
(24,18),
(51,18);

#SOPA DE POLLO
INSERT INTO plato (id_ingrediente,id_comida) values
(24,19),
(49,19),
(41,19),
(12,19),
(72,19),
(2,19);

#SOPA DE CARNE
INSERT INTO plato (id_ingrediente,id_comida) values
(48,20),
(13,20),
(11,20),
(41,20),
(24,20),
(70,20),
(1,20);

#SOPA DE CAMARÓN
INSERT INTO plato (id_ingrediente,id_comida) values
(8,21),
(41,21),
(24,21),
(51,21),
(14,21),
(12,21),
(30,21),
(73,21),
(63,21),
(1,21);

#SOPA DE PESCADO
INSERT INTO plato (id_ingrediente,id_comida) values
(46,22),
(64,22),
(60,22),
(34,22),
(55,22),
(63,22),
(1,22);

#SOPA DE QUESO
INSERT INTO plato (id_ingrediente,id_comida) values
(51,23),
(30,23),
(73,23),
(41,23),
(24,23),
(12,23),
(1,23);