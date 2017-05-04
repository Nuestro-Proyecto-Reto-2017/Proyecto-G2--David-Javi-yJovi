-- Generado por Oracle SQL Developer Data Modeler 4.2.0.921
--   en:        2017-04-01 09:57:58 CEST
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c

drop table salida cascade constraints;
drop table parte cascade constraints;
drop table gasto cascade constraints;
drop table aviso cascade constraints;
drop table usuario cascade constraints;
drop table trabajador cascade constraints;
drop table centro cascade constraints;
drop table vehiculo cascade constraints;
drop table parteBasura cascade constraints;
drop table salidaBasura cascade constraints;

CREATE TABLE aviso (
    idaviso       NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE 
    Constraint aviso_pk PRIMARY KEY,
    descripcion   VARCHAR2(100) NOT NULL
);


CREATE TABLE centro (
    idcentro        NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
      CONSTRAINT centros_pk PRIMARY KEY ,
    nombre         VARCHAR2(15) NOT NULL,
    calle          VARCHAR2(50) NOT NULL,
    numero         VARCHAR2(3) NOT NULL,
    codigopostal   VARCHAR2(5) NOT NULL,
    ciudad         VARCHAR2(15) NOT NULL,
    provincia      VARCHAR2(15) NOT NULL,
    telefono       VARCHAR2(9) NOT NULL
);


CREATE TABLE gasto (
    idgasto      NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE  
     CONSTRAINT gasto_pk PRIMARY KEY,
    gastogasoil   float,
    gastopeajes   float,
    gastodietas   float,
    otrosgastos   float
);


CREATE TABLE parte (
    idparte               NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
      CONSTRAINT parte_pk PRIMARY KEY,
    kminicio             float NOT NULL,
    kmfinal              float NOT NULL,
    tipoparte            VARCHAR2(15) NOT NULL,
    incidencias          VARCHAR2(100) ,
    fechaParte           DATE NOT NULL,
    creado               VARCHAR2(9) NOT NULL,
    vehiculo_matricula   VARCHAR2(12) NOT NULL,
    aviso_idaviso        NUMBER(5),
    gasto_idgasto        NUMBER(5),
    CONSTRAINT tp_part_ck CHECK (tipoparte IN ('SC','C','R'))
);


CREATE TABLE salida (
    idsalida         NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
     CONSTRAINT salida_pk PRIMARY KEY,
    horasalida      DATE NOT NULL,
    horallegada     DATE NOT NULL,
    albaran         VARCHAR2(15) NOT NULL,
    parte_idparte   NUMBER(5) NOT NULL
);


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
    centro_idcentro     number(5) NOT NULL,
    CONSTRAINT tt_trab_ck CHECK (tipotrabajador IN ('LOGISTICA','ADMINISTRACION'))
);



ALTER TABLE trabajador ADD CONSTRAINT trabajador_pk PRIMARY KEY ( dni );

CREATE TABLE usuario (
    usuario          VARCHAR2(21) CONSTRAINT usuario_pk PRIMARY KEY,
    contraseña       VARCHAR2(15) NOT NULL,
    trabajador_dni   VARCHAR2(9) NOT NULL
);


CREATE TABLE vehiculo (
    matricula       VARCHAR2(12) NOT NULL,
    marca           VARCHAR2(15) NOT NULL,
    modelo          VARCHAR2(15) NOT NULL
);

CREATE TABLE parteBasura (
    idpartebasura               NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
      CONSTRAINT parteBasura_pk PRIMARY KEY,
    kminicio             float ,
    kmfinal              float ,
    tipoparte            VARCHAR2(15) ,
    incidencias          VARCHAR2(100) ,
    fechaParte           DATE,
    creado               VARCHAR2(9) ,
    vehiculo_matricula   VARCHAR2(12) ,
    aviso_idaviso        varchar2(100),
    gastoG_idgasto        NUMBER(5),
    gastoP_idgasto        NUMBER(5),
    gastoD_idgasto        NUMBER(5),
    gastoO_idgasto        NUMBER(5)
);

CREATE TABLE salidaBasura (
    idsalida         NUMBER (5)
      GENERATED ALWAYS AS IDENTITY 
                        MINVALUE 1 
                        MAXVALUE 99999
                        INCREMENT BY 1 
                        START WITH 1  
                        NOORDER  
                        NOCYCLE  NOT NULL ENABLE
     CONSTRAINT salidaBasura_pk PRIMARY KEY,
    horasalida      DATE,
    horallegada     DATE,
    albaran         VARCHAR2(15),
    parteBasura_idparte   NUMBER(5) not null
);

ALTER TABLE salidaBasura ADD CONSTRAINT parteBasura_salida_fk FOREIGN KEY ( parteBasura_idparte )
    REFERENCES parteBasura (idpartebasura);

ALTER TABLE vehiculo ADD CONSTRAINT vehiculo_pk PRIMARY KEY ( matricula );

ALTER TABLE parte ADD CONSTRAINT parte_aviso_fk FOREIGN KEY ( aviso_idaviso )
    REFERENCES aviso ( idaviso );

ALTER TABLE parte ADD CONSTRAINT parte_gasto_fk FOREIGN KEY ( gasto_idgasto )
    REFERENCES gasto ( idgasto );

ALTER TABLE parte ADD CONSTRAINT parte_trabajador_fkv2 FOREIGN KEY ( creado )
    REFERENCES trabajador ( dni );

ALTER TABLE parte ADD CONSTRAINT parte_vehiculo_fk FOREIGN KEY ( vehiculo_matricula )
    REFERENCES vehiculo ( matricula );

ALTER TABLE salida ADD CONSTRAINT salida_parte_fk FOREIGN KEY ( parte_idparte )
    REFERENCES parte ( idparte );

ALTER TABLE trabajador ADD CONSTRAINT trabajador_centro_fk FOREIGN KEY ( centro_idcentro )
    REFERENCES centro ( idcentro );

ALTER TABLE usuario ADD CONSTRAINT usuario_trabajador_fk FOREIGN KEY ( trabajador_dni )
    REFERENCES trabajador ( dni );



