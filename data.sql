INSERT INTO USUARIOS VALUES ('CC', '1035420439', 'Ramón', '1988-08-30');
INSERT INTO USUARIOS VALUES ('CC', '1000000000', 'Paco', '2000-01-05');
INSERT INTO USUARIOS VALUES ('CC', '1036500000', 'María', '1995-09-22');

INSERT INTO MEDIDAS 
(id_medida, tipo_id, id_usuario, fecha_toma, peso, talla) 
VALUES (DEFAULT, 'CC', '1035420439', cast(now() as date), 62.5, 176);

INSERT INTO MEDIDAS
(id_medida, tipo_id, id_usuario, fecha_toma, peso, talla) 
VALUES (DEFAULT, 'CC', '1000000000', cast(now() as date), 50.0, 160);

INSERT INTO MEDIDAS
(id_medida, tipo_id, id_usuario, fecha_toma, peso, talla) 
VALUES (DEFAULT, 'CC', '1036500000', cast(now() as date), 57.3, 173);

SELECT * FROM USUARIOS;
SELECT * FROM MEDIDAS;
