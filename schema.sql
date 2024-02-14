/*CREATE DATABASE healthcheckBASIC;*/
--USE healthcheck;


/*Table "USUARIOS"*/

CREATE TABLE USUARIOS (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  tipo_id VARCHAR(255),
  nombre VARCHAR(255),
  fecha_nacimiento DATE,
  peso FLOAT,
  talla INT);


/*  CONSTRAINT [constraint_name]   
  PRIMARY KEY (column_name(s))  
);*/
