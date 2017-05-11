create or replace procedure buscar_salidasParte (pIdParte in number,c_salid out Sys_refcursor)
is
begin
  open c_salid for 
    select *
    from salida
    where parte_idparte = pIdParte;
  exception
    when others then
      RAISE_APPLICATION_ERROR(-20011, 'Error en el procedimiento');
end;