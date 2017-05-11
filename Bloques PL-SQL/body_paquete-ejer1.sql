create or replace package body gest_centro 
IS

  procedure visualizar_lista_centro(c_centros out tcursor)
  is
  begin
    open c_centros for
      select * 
      from centro;
  exception
    when others then
      RAISE_APPLICATION_ERROR(-20012,'Error en el procedimiento');
  end;
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
  procedure visualizar_datos_centro_nombre (p_nombreEntrada in varchar2,c_centros out tcursor)
  is
  begin
    open c_centros for
      select *
      from centro
      where upper(nombre) = upper(p_nombreEntrada);
  exception
    when others then
      RAISE_APPLICATION_ERROR(-20012,'Error en el procedimiento');
  end;
  --=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
END;

