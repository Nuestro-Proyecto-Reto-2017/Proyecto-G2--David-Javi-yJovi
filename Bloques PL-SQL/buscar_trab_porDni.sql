create or replace procedure buscar_dni_boolean (pdni in trabajador.dni%type,c_trab out sys_refcursor)
is
begin
  open c_trab for
    select * 
    from trabajador
    where upper(dni)=upper(pdni);
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;