select * from centro;
select * from usuario;
select * from trabajador;


insert into centro (nombre,calle,numero,codigopostal,ciudad,provincia,telefono)values ('PRUEBA','callefalsa','1','12345','Vitoria','Alava','123456789'); 

insert into trabajador (dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,tipotrabajador,fechanac,centro_idcentro) 
values('12345678D','admin','ape1','ape2','callefalsa','1','2','3','123456789','987654321',1200,'ADMINISTRACION',to_date('12/05/2017','dd/mm/yy'),(select idcentro from centro where upper(nombre) ='PRUEBA'));

