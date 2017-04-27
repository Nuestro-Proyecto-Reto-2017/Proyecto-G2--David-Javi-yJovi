create or replace package gest_centro 
is 
--declaraciones
type c_cursor is ref cursor ;
--declaraciones procedimientos
procedure  visualizar_lista_centro (c_centros out c_cursor );
procedure visualizar_datos_centro_id (p_id in varchar2, c_centros out c_cursor);
end;