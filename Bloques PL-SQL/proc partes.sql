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
      if v_idaviso is not null then
        insert into  parte(KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,AVISO_IDAVISO,FECHAPARTE,INCIDENCIAS) values(kmi,kmf,tipoparte,logistica, matricula,v_idaviso,v_fecha,observaciones);
        if sql%found then
          select max(idparte)into v_idparte 
          from parte ;  
          if v_idparte is null then
            RAISE_APPLICATION_ERROR(-20011, 'Error no se encuentran partes');
          end if;
        else
          RAISE_APPLICATION_ERROR(-20011, 'Error al insertar parte con avisos');
        end if;
      end if;
    end if;
    if gastoG is not null or gastoP is not null or gastoD is not null or ogastos is not null then  
      insert into gasto(GastoGasoil, GastoPeajes,GastoDietas,Otrosgastos) values (gastoG,gastoP,gastoD,ogastos);
      if sql%found  then 
        select max(idgasto)into v_idgasto
        from gasto;
        if v_idgasto is not null then
          update parte set gasto_idgasto =v_idgasto where idparte=v_idparte;
          if sql%notfound then
            RAISE_APPLICATION_ERROR(-20011, 'Error al actualizar los gastos');
          end if;
        end if;
      end if;
    end if;
  end if;
  if (gastoG is not null or gastoP is not null or gastoD is not null or ogastos is not null) and avis_descripcion is null then  
    insert into gasto (GastoGasoil, GastoPeajes,GastoDietas,Otrosgastos) values (gastoG,gastoP,gastoD,ogastos);
    if sql%found then 
      select max(idgasto)into v_idgasto
      from gasto;
      if v_idgasto is not null then
        insert into parte (KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA ,gasto_idgasto,FECHAPARTE,INCIDENCIAS) values(kmi,kmf,tipoparte,logistica, matricula,v_idgasto,v_fecha,observaciones);
        if sql%notfound then
          RAISE_APPLICATION_ERROR(-20011, 'Error al insertar los gastos');
        end if;
      end if;
    end if;
  end if;
  if (gastoG is null and gastoP is null and gastoD is null and ogastos is null) and avis_descripcion is null then
    insert into parte  (KMINICIO ,KMFINAL,TIPOPARTE,CREADO ,VEHICULO_MATRICULA,FECHAPARTE,INCIDENCIAS ) values(kmi,kmf,tipoparte,logistica, matricula,v_fecha,observaciones);
    if sql%notfound then
      RAISE_APPLICATION_ERROR(-20011, 'Error al insertar los partes');
    end if;  
  end if;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;