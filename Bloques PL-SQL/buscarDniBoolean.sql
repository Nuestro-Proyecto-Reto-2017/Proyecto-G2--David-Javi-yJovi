create or replace procedure buscar_nombrec_boolean (pnombrec in centro.nombre%type,c_centr out Sys_refcursor)
is
begin
  open c_centr for 
    select *
    from centro
    where upper(nombre)=upper(pnombrec);
end;

