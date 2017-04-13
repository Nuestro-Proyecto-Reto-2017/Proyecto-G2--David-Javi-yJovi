create or replace procedure obtenerDatosTrabajador(dniTrab in number,datos out Sys_Refcursor)
as
begin 
open datos for
 select * 
  from trabajador
  where upper(dni)=upper(dniTrab);
end;