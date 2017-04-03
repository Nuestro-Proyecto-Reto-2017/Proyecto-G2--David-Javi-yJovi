-- Generado por Oracle SQL Developer Data Modeler 4.2.0.921
--   en:        2017-04-01 09:57:58 CEST
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



CREATE TABLE aviso (
    idaviso       VARCHAR2(5) NOT NULL,
    descripcion   VARCHAR2(100) NOT NULL
);

ALTER TABLE aviso ADD CONSTRAINT aviso_pk PRIMARY KEY ( idaviso );

CREATE TABLE centro (
    idcentro       VARCHAR2(5) NOT NULL,
    nombre         VARCHAR2(15) NOT NULL,
    calle          VARCHAR2(50) NOT NULL,
    numero         VARCHAR2(3) NOT NULL,
    codigopostal   VARCHAR2(5) NOT NULL,
    ciudad         VARCHAR2(15) NOT NULL,
    provincia      VARCHAR2(15) NOT NULL,
    telefono       VARCHAR2(9) NOT NULL
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( idcentro );

CREATE TABLE gasto (
    idgasto       VARCHAR2(5) NOT NULL,
    gastogasoil   float,
    gastopeajes   float,
    gastodietas   float,
    otrosgastos   float
);

ALTER TABLE gasto ADD CONSTRAINT gasto_pk PRIMARY KEY ( idgasto );

CREATE TABLE parte (
    idparte              VARCHAR2(5) NOT NULL,
    kminicio             float NOT NULL,
    kmfinal              float NOT NULL,
    tipoparte            VARCHAR2(15) NOT NULL,
    trabajador_dni1      VARCHAR2(9) NOT NULL,
    trabajador_dni       VARCHAR2(9) NOT NULL,
    vehiculo_matricula   VARCHAR2(12) NOT NULL,
    aviso_idaviso        VARCHAR2(5) NOT NULL,
    gasto_idgasto        VARCHAR2(5) NOT NULL
);

CREATE UNIQUE INDEX parte__idx ON
    parte ( aviso_idaviso ASC );

CREATE UNIQUE INDEX parte__idxv1 ON
    parte ( gasto_idgasto ASC );

CREATE UNIQUE INDEX parte__idxv2 ON
    parte ( vehiculo_matricula ASC );

ALTER TABLE parte ADD CONSTRAINT parte_pk PRIMARY KEY ( idparte );

CREATE TABLE salida (
    idsalida        VARCHAR2(5) NOT NULL,
    horasalida      DATE NOT NULL,
    horallegada     DATE NOT NULL,
    albaran         VARCHAR2(15) NOT NULL,
    parte_idparte   VARCHAR2(5) NOT NULL
);

ALTER TABLE salida ADD CONSTRAINT salida_pk PRIMARY KEY ( idsalida );

CREATE TABLE trabajador (
    dni                 VARCHAR2(9) NOT NULL,
    nombre              VARCHAR2(15) NOT NULL,
    apellidouno         VARCHAR2(20) NOT NULL,
    apellidodos         VARCHAR2(20) NOT NULL,
    calle               VARCHAR2(50) NOT NULL,
    portal              VARCHAR2(3) NOT NULL,
    piso                VARCHAR2(2) NOT NULL,
    mano                VARCHAR2(1) NOT NULL,
    telefonopersonal    VARCHAR2(9),
    telefonoempresa     VARCHAR2(9) NOT NULL,
    salario             float,
    fechanac            DATE,
    tipotrabajador      VARCHAR2(15) NOT NULL,
    centro_idcentro     VARCHAR2(5) NOT NULL,
    usuario_idusuario   VARCHAR2(5) NOT NULL
);

CREATE UNIQUE INDEX trabajador__idx ON
    trabajador ( usuario_idusuario ASC );

ALTER TABLE trabajador ADD CONSTRAINT trabajador_pk PRIMARY KEY ( dni );

CREATE TABLE usuario (
    idusuario        VARCHAR2(5) NOT NULL,
    usuario          VARCHAR2(21) NOT NULL,
    contraseña       VARCHAR2(15) NOT NULL,
    trabajador_dni   VARCHAR2(9) NOT NULL
);

CREATE UNIQUE INDEX usuario__idx ON
    usuario ( trabajador_dni ASC );

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

CREATE TABLE vehiculo (
    matricula       VARCHAR2(12) NOT NULL,
    marca           VARCHAR2(15) NOT NULL,
    modelo          VARCHAR2(15) NOT NULL,
    parte_idparte   VARCHAR2(5) NOT NULL
);

CREATE UNIQUE INDEX vehiculo__idx ON
    vehiculo ( parte_idparte ASC );

ALTER TABLE vehiculo ADD CONSTRAINT vehiculo_pk PRIMARY KEY ( matricula );

ALTER TABLE parte ADD CONSTRAINT parte_aviso_fk FOREIGN KEY ( aviso_idaviso )
    REFERENCES aviso ( idaviso );

ALTER TABLE parte ADD CONSTRAINT parte_gasto_fk FOREIGN KEY ( gasto_idgasto )
    REFERENCES gasto ( idgasto );

ALTER TABLE parte ADD CONSTRAINT parte_trabajador_fk FOREIGN KEY ( trabajador_dni )
    REFERENCES trabajador ( dni );

ALTER TABLE parte ADD CONSTRAINT parte_trabajador_fkv2 FOREIGN KEY ( trabajador_dni1 )
    REFERENCES trabajador ( dni );

ALTER TABLE parte ADD CONSTRAINT parte_vehiculo_fk FOREIGN KEY ( vehiculo_matricula )
    REFERENCES vehiculo ( matricula );

ALTER TABLE salida ADD CONSTRAINT salida_parte_fk FOREIGN KEY ( parte_idparte )
    REFERENCES parte ( idparte );

ALTER TABLE trabajador ADD CONSTRAINT trabajador_centro_fk FOREIGN KEY ( centro_idcentro )
    REFERENCES centro ( idcentro );

ALTER TABLE trabajador ADD CONSTRAINT trabajador_usuario_fk FOREIGN KEY ( usuario_idusuario )
    REFERENCES usuario ( idusuario );

ALTER TABLE usuario ADD CONSTRAINT usuario_trabajador_fk FOREIGN KEY ( trabajador_dni )
    REFERENCES trabajador ( dni );

ALTER TABLE vehiculo ADD CONSTRAINT vehiculo_parte_fk FOREIGN KEY ( parte_idparte )
    REFERENCES parte ( idparte );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             6
-- ALTER TABLE                             18
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
