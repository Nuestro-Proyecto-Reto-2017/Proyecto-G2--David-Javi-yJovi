create or replace procedure buscar_dni_boolean (pdni in trabajador.dni%type,c_trab out sys_refcursor)
is
begin
  open c_trab for
    select * 
    from trabajador
    where upper(dni)=upper(pdni);
exception
  when no_data_found then
    RAISE_APPLICATION_ERROR(-20011, 'Err DNI trabajador no encontrado');
  when too_many_rows then
    RAISE_APPLICATION_ERROR(-20012,'Hay mas de un trabajador con ese dni');
end;