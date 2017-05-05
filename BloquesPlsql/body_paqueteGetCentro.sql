create or replace package body GetCentro
is
procedure obtenerDatosCentro (nombreC in varchar,datos out tcursor)
is
begin
open datos for
  select * 
  from centro
  where upper(nombre)=upper(nombreC);
end obtenerDatosCentro;
procedure obtenerDatosCentroXid (idC in number,datos out tcursor)
is
begin
open datos for
  select * 
  from centro
  where idcentro=idC;
end obtenerDatosCentroXid;
procedure obtenerTodosLosCentros (datos out tcursor)
is
begin
open datos for 
  select * 
  from centro;
end obtenerTodosLosCentros;
end;