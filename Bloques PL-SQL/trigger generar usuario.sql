create or replace trigger generar_user
after insert on trabajador for each row
declare 
  begin   
  insert into usuario(usuario,contraseña,Trabajador_dni) values( :new.dni, :new.nombre, :new.dni); 
  if sql%notfound then
      RAISE_APPLICATION_ERROR(-20011, 'Error al insertar');
  end if;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;

  