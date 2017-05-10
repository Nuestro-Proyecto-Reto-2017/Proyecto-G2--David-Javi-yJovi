create or replace procedure buscar_nombreCursor (pnombre in trabajador.nombre%type,c_trab out Sys_refcursor)
is
begin
  open c_trab for 
    select *
    from trabajador
    where upper(nombre)=upper(pnombre);
exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err nombre trabajador no encontrado');
end;