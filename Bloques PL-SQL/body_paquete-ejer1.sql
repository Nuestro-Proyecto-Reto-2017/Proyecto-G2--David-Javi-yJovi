create or replace package body gest_centro 
IS

  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  /*
  function buscar_centro_por_nombre (p_nom varchar2)return number;
  
  function buscar_centro_por_nombre (p_nom varchar2)
  return number
  is v_idNum centros.id%type;
  begin
    select id into v_idNum
      from centros
      where upper(nombre)=upper(p_nom);
      return v_idNum;
  exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err nombre centro no encontrado');
    when too_many_rows then
      RAISE_APPLICATION_ERROR(-20012,'Hay mas de un centro con ese nombre');
  end;*/
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  procedure visualizar_lista_centro(c_centros out tcursor)
  is
  begin
    open c_centros for
      select * 
      from centro;
  end;
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
    /*MAL necesita modificacion*/
 /* procedure visualizar_datos_centro_id (p_id in number, c_centros out tcursor,pnum_trabajadores out number)
  is
  begin
    open c_centros for
      select *
      from centro 
      where idCentro = p_id;
    select count(dni) as "Trabajadores del centro" into pnum_trabajadores
    from trabajador 
    where idCentro=p_id;
    if pnum_trabajadores is null then
      RAISE_APPLICATION_ERROR(-20100, 'Tabla de trabajadores vacia');
    end if;
  end;
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  /*MAL necesita modificacion*/
 /* procedure visualizar_datos_centro_nombre (p_nombre in varchar2, c_centros out tcursor,pnum_trabajadores out number)
  is
  begin
    open c_centros for
      select *
      from centro
      where upper(nombre) = upper(p_nombre);
    select count(dni) as "Trabajadores del centro" into pnum_trabajadores
    from trabajador
    where upper(nombre) = upper(p_nombre);
    if pnum_trabajadores is null then
      RAISE_APPLICATION_ERROR(-20100, 'Tabla de trabajadores vacia');
    end if;
  end;*/
 
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  
END;