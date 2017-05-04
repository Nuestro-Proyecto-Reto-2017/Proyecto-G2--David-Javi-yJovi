create or replace package gest_centro 
IS
  --declaraciones
  type tcursor is ref cursor;
  procedure visualizar_lista_centro (c_centros out tcursor);
  procedure visualizar_datos_centro_nombre (p_nombreEntrada in varchar2,c_centros out tcursor);
END;