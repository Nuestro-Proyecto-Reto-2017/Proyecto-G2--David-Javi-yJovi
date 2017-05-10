create or replace procedure buscar_todos (c_trab out Sys_refcursor)
is
begin
  open c_trab for 
    select *
    from trabajador;
  exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err trabajadores no encontrados');
end;