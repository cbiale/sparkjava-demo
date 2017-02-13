DROP TABLE PAGOS;
DROP TABLE COMERCIOS;
DROP TABLE CLIENTES;


CREATE TABLE COMERCIOS (
id int not null auto_increment,
     name VARCHAR (40),
     logo VARCHAR (100),
      PRIMARY KEY (id)
);

CREATE TABLE CLIENTES (
      id int not null auto_increment,
      name VARCHAR(40),
      ci VARCHAR(50) not null,
      PRIMARY KEY (id)
);


CREATE TABLE PAGOS (
  id int not null auto_increment,
  comercio_id int,
  cliente_id int ,
  monto decimal,
  operaction date,
  PRIMARY KEY (id),
  FOREIGN KEY (cliente_id) REFERENCES CLIENTES(id),
  FOREIGN KEY (comercio_id) REFERENCES COMERCIOS(id)
);


--
--SELECT i.TABLE_NAME, i.CONSTRAINT_TYPE, i.CONSTRAINT_NAME, k.REFERENCED_TABLE_NAME, k.REFERENCED_COLUMN_NAME 
--FROM information_schema.TABLE_CONSTRAINTS i 
--LEFT JOIN information_schema.KEY_COLUMN_USAGE k ON i.CONSTRAINT_NAME = k.CONSTRAINT_NAME 
--WHERE i.CONSTRAINT_TYPE = 'FOREIGN KEY' 
--AND i.TABLE_SCHEMA = DATABASE()
--AND i.TABLE_NAME = '<yourtable>';
--
