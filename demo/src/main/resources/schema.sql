DROP TABLE IF EXISTS VISITAS;
  
CREATE TABLE VISITAS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  VISITADO VARCHAR(100) NOT NULL,
  CONTEO INT NOT NULL,
  TIPO_VISITADO VARCHAR(250) NOT NULL
);