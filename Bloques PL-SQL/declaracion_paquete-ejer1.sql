create or replace package gest_centro 
IS
  --declaraciones
  type tcursor is ref cursor;
  procedure visualizar_lista_centro (c_centros out tcursor);
  procedure visualizar_datos_centro_nombre (p_nombreEntrada in varchar2, p_nombre out varchar2,p_calle out varchar2,p_numero out varchar2,p_codigopostal out varchar2,p_ciudad out varchar2,p_provincia out varchar2,p_telefono out varchar2);
END;