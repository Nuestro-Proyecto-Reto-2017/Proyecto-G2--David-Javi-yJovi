create or replace procedure buscar_dni (pdni in trabajador.dni%type,pcadena out varchar2)
is
  cursor cursorPrueba is
    select *
    from trabajador
    where upper(DNI)=upper(pdni);
  pruebaCaja cursorPrueba%ROWTYPE;
begin

  open cursorPrueba;
  fetch cursorPrueba into pruebaCaja;
  if cursorPrueba%notfound then
    pcadena:='No se ha encontrado el siguiente DNI: '||pdni;
  else  
    while cursorPrueba%found loop
      pcadena:=pruebaCaja.dni||' '||pruebaCaja.nombre||' '||pruebaCaja.apellidouno||' '||pruebaCaja.apellidodos||' calle: '||pruebaCaja.calle||' portal: '||pruebaCaja.portal||' piso: '||pruebaCaja.piso||' mano: '||pruebaCaja.mano||' Telefono empresa: '||pruebaCaja.telefonoempresa||' Tipo trabajador: '||pruebaCaja.tipotrabajador||' Centro: '||pruebaCaja.centro_idcentro;
      fetch cursorPrueba into pruebaCaja;
    end loop;
    close cursorPrueba;
  end if;
end;
