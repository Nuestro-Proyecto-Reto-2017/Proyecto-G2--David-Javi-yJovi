create or replace procedure buscar_salidasParte (pIdParte in number,c_salid out Sys_refcursor)
is
begin
  open c_salid for 
    select *
    from salida
    where parte_idparte = pIdParte;
  exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err partes no encontrados');
end;