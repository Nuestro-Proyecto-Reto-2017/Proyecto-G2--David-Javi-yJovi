create or replace package body gest_centro 
is
procedure  visualizar_lista_centro ( c_centros OUT c_cursor )
is 

begin 
 open c_centros  for
    select idcentro
    from centro; 
   end visualizar_lista_centro;
procedure visualizar_datos_centro_id (p_id in varchar2, c_centros out c_cursor)
is

  begin 
    open c_centros  for
    select *
    from centro 
    where idcentro =p_id;
end visualizar_datos_centro_id;
end gest_centro;
