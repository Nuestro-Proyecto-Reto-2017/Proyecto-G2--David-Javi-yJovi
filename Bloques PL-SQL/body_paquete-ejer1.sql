create or replace package body gest_centro 
IS

  procedure visualizar_lista_centro(c_centros out tcursor)
  is
  begin
    open c_centros for
      select * 
      from centro;
  end;

  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  /*MAL necesita modificacion*/
  procedure visualizar_datos_centro_nombre (p_nombreEntrada in varchar2,c_centros out tcursor)
  is
  begin
    open c_centros for
      select *
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

