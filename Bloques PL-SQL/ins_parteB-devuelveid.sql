create or replace procedure insertar_parteb (kmi in float ,kmf in float,tipoparte in varchar2,logistica in varchar2,matricula in varchar2,incidencias in varchar2,aviso in varchar2,gastoG in float, gastoP in float , gastoD in float, ogastos in float,fecha in date, v_idparte out number)
is 
begin 

insert into  parteBasura(INCIDENCIAS,AVISO,KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,gastoG,gastoP,gastoD,gastoO,FECHAPARTE) 
values(incidencias,aviso,kmi,kmf,tipoparte,logistica, matricula,gastoG,gastoP,gastoD,ogastos,fecha);
if sql%found then
  select max(idpartebasura)into v_idparte from parteBasura ;  
else
  RAISE_APPLICATION_ERROR(-20011, 'Error al insertar el parte temporal');
end if;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;