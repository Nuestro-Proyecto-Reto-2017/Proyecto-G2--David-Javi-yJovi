create or replace procedure insertar_parteb (kmi in float ,kmf in float,tipoparte in varchar2,logistica in varchar2,matricula in varchar2,incidencias in varchar2,aviso in varchar2,gastoG in float, gastoP in float , gastoD in float, ogastos in float,fecha in date, v_idparte out number)
is 
begin 

insert into  parteBasura(INCIDENCIAS,AVISO_IDAVISO,KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,gastoG,gastoP,gastoD,gastoO,FECHAPARTE) 
values(incidencias,aviso,kmi,kmf,tipoparte,logistica, matricula,gastoG,gastoP,gastoD,ogastos,fecha);
select max(idpartebasura)into v_idparte from parteBasura ;  

end;