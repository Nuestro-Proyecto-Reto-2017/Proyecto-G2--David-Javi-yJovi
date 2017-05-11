create or replace procedure registrar_parte (kmi in float ,kmf in float,tipoparte in varchar2,logistica in varchar2,matricula in varchar2,observaciones in varchar2,avis_descripcion in varchar2, gastoG in float, gastoP in float , gastoD in float, ogastos in float,v_fecha in date)
is 
v_idaviso aviso.idaviso%type;
v_idgasto gasto.idgasto%type;
v_idparte parte.idparte%type;
/*kmi parte.kmInicio%type;
kmf parte.kmFinal%type;
tipoparte parte.tipoparte%type;
logistica parte.creado%type;
matricula vehiculo.matricula%type;
--observaciones parte.incidencias%type;
avis_descr*/
begin 
  if avis_descripcion is not null then  
      insert into aviso(descripcion) values (avis_descripcion);
    if sql%found then 
      select max(idAviso)into v_idaviso
      from aviso;
          insert into  parte(KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,AVISO_IDAVISO,FECHAPARTE,INCIDENCIAS) values(kmi,kmf,tipoparte,logistica, matricula,v_idaviso,v_fecha,observaciones);
          select max(idparte)into v_idparte from parte ;  
    end if;
    if gastoG is not null or gastoP is not null or gastoD is not null or ogastos is not null
      then  
      insert into gasto(GastoGasoil, GastoPeajes,GastoDietas,Otrosgastos) values (gastoG,gastoP,gastoD,ogastos);
        select max(idgasto)into v_idgasto
        from gasto;
      if sql%found  then 
        update parte set gasto_idgasto =v_idgasto where idparte=v_idparte;
      end if;
    end if;
  end if;
  if gastoG is not null or gastoP is not null or gastoD is not null or ogastos is not null and avis_descripcion is null then  
    insert into gasto (GastoGasoil, GastoPeajes,GastoDietas,Otrosgastos) values (gastoG,gastoP,gastoD,ogastos);
    if sql%found then 
      insert into parte (KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,gasto_idgasto,FECHAPARTE,INCIDENCIAS) values(kmi,kmf,tipoparte,logistica, matricula,v_idgasto,v_fecha,observaciones);
    end if;
  else insert into parte  (KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA,FECHAPARTE,INCIDENCIAS ) values(kmi,kmf,tipoparte,logistica, matricula,v_fecha,observaciones);
  end if;
end;