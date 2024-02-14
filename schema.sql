/*CREATE DATABASE healthcheck;*/

/*Table "USUARIOS"*/

CREATE TABLE USUARIOS (
  tipo_id VARCHAR(10),
  id_usuario VARCHAR(50),
  nombre VARCHAR(255),
  fecha_nacimiento DATE,
  PRIMARY KEY (tipo_id, id_usuario)  
  UNIQUE(tipo_id, id_usuario),
  );



/*Table "MEDIDAS"*/

CREATE TABLE MEDIDAS (
  id_medida SERIAL,
  tipo_id VARCHAR(10),
  id_usuario VARCHAR(50),
  fecha_toma DATE,
  peso FLOAT,
  talla INT,
  FOREIGN KEY (tipo_id, id_usuario)  REFERENCES USUARIOS (tipo_id, id_usuario) ON DELETE CASCADE,
  PRIMARY KEY (id_medida, fecha_toma)
  );
--ON DELETE CASCADE: AT delete usuario, THEN medida(s) ASSOCIATED WILL BE DELETED TOO
