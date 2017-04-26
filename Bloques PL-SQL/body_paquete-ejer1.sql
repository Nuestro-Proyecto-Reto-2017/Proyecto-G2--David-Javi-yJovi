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
  procedure visualizar_datos_centro_nombre (p_nombreEntrada in varchar2, p_nombre out varchar2,p_calle out varchar2,p_numero out varchar2,p_codigopostal out varchar2,p_ciudad out varchar2,p_provincia out varchar2,p_telefono out varchar2)
  is
  begin
      select nombre,calle, numero,codigopostal, ciudad, provincia, telefono into p_nombre,p_calle,p_numero,p_codigopostal, p_ciudad, p_provincia, p_telefono 
      from centro
      where upper(nombre) = upper(p_nombreEntrada);
  exception
    when no_data_found then
      RAISE_APPLICATION_ERROR(-20011, 'Err nombre centro no encontrado');
    when too_many_rows then
      RAISE_APPLICATION_ERROR(-20012,'Hay mas de un centro con ese nombre');
  end;
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
END;

