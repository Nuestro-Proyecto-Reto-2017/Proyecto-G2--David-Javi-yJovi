create or replace package gest_centro 
IS
  --declaraciones
  type tcursor is ref cursor;
  procedure visualizar_lista_centro (c_centros out tcursor);
  /* FALTA MODIFICARLOS
  procedure visualizar_datos_centro_id (p_id in number, c_centros out tcursor,pnum_trabajadores out number);
  procedure visualizar_datos_centro_nombre (p_nombre in varchar2, c_centros out tcursor,pnum_trabajadores out number);*/
END;