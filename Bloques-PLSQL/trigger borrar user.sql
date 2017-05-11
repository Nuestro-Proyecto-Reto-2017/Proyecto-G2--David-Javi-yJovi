create or replace trigger borrar_user
after delete on trabajador for each row
declare 
begin 

  delete from usuario where trabajador_dni =:old.dni; 

end;