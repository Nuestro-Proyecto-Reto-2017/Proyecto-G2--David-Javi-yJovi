create or replace procedure buscar_partesMensualesJoin (c_part out Sys_refcursor)
is
begin
  open c_part for 
    select *
    from parte p,vehiculo v,gasto g,aviso a,trabajador t
    where t.dni=p.creado
    and v.matricula=p.vehiculo_matricula
    and a.idaviso=p.aviso_idaviso(+)
    and g.idgasto=p.gasto_idgasto(+)
    and MONTHS_BETWEEN(fechaparte,sysdate)<=1
    order by fechaParte, creado;
  exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err partes no encontrados');
end;