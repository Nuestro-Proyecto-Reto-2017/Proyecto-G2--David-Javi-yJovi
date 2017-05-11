select * from centro;
select * from usuario;
select * from trabajador;
select * from parte;
select * from vehiculo;
select * from salida;
select * from aviso;
select * from gasto;

insert into centro (nombre,calle,numero,codigopostal,ciudad,provincia,telefono)values ('PRUEBA','callefalsa','1','12345','Vitoria','Alava','123456789'); 
insert into trabajador (dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,tipotrabajador,fechanac,centro_idcentro) 
values('12345678D','PEPE','ape1','ape2','callefalsa','1','2','3','123456789','987654321',1200,'ADMINISTRACION',to_date('12/05/2017','dd/mm/yy'),(select idcentro from centro where upper(nombre) ='PRUEBA'));
delete trabajador where DNI= '12345678D';
delete centro where idcentro = 2;

insert into aviso (descripcion) values ('Tiene horas extras');

insert into vehiculo (matricula,marca,modelo) values ('1234ba','Opel','Corsa');

insert into gasto (GASTOGASOIL,GASTODIETAS,GASTOPEAJES,OTROSGASTOS) values (null,null,null,null);

update parte set tipoparte ='R' where idparte=21;
insert into parte (KMINICIO,KMFINAL,TIPOPARTE,FECHAPARTE,CREADO,VEHICULO_MATRICULA,AVISO_IDAVISO,GASTO_IDGASTO) values (25,32,'C',SYSDATE,'12345678b','1234ba',1,1);

insert into salida (horasalida,horallegada,albaran,parte_idparte) values (to_date('14:00','hh24:mi'),to_date('18:00','hh24:mi'),'4321alb',21);

select TO_TIMESTAMP(horaSalida,'dd/mm/yy HH24:MI:SS'),TO_TIMESTAMP(horaLlegada,'dd/mm/yy  HH24:MI:SS')
from salida
where parte_idparte=1;