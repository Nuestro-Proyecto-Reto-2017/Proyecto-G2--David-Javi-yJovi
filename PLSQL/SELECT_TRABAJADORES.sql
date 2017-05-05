create or replace procedure select_trabajadores(x out trabajador%rowtype)
is

begin
select * into x
from trabajador;
end;