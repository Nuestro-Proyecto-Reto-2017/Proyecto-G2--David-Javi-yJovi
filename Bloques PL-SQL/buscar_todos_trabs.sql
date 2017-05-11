create or replace procedure buscar_todos (c_trab out Sys_refcursor)
is
begin
  open c_trab for 
    select *
    from trabajador;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;