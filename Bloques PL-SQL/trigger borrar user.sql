create or replace trigger borrar_user
after delete on trabajador for each row
declare 
begin 
  delete from usuario where trabajador_dni =:old.dni; 
  if sql%notfound then
      RAISE_APPLICATION_ERROR(-20011, 'Error al eliminar');
  end if;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;