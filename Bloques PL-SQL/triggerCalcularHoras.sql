create or replace trigger calcularHorasExtra
after update of tipoparte on parte for each row when (new.tipoparte = 'R')
declare 
  cursor cursorPrueba is
    select horaSalida, horaLlegada
    from salida
    where parte_idparte = :new.idparte; 
  pruebaCaja cursorPrueba%ROWTYPE;
  vHoraS SALIDA.HORASALIDA%type;
  vHoraL SALIDA.HORALLEGADA%type;
  vHorasExtra  trabajador.horasExtra%type :=0;
  vTrabHoras trabajador.horasExtra%type ;
begin 
  open cursorPrueba;
    loop
        fetch cursorPrueba into pruebaCaja;
        vHoraS:=pruebaCaja.horaSalida;
        vHoraL:=pruebaCaja.horaLlegada;
        vHorasExtra:=(vHoraL-vHoraS)+vHorasExtra;
    end loop;
  close cursorPrueba;
      update trabajador set horasExtra=vHorasExtra where dni = :new.creado;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;