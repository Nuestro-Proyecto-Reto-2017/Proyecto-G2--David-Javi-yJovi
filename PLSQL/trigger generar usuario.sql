create or replace trigger generar_user
after insert on trabajador for each row
declare 
  begin   
  insert into usuario(usuario,contrase�a,Trabajador_dni) values( :new.dni, :new.nombre, :new.dni); 
end;

  