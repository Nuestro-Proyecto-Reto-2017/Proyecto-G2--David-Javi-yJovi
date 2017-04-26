create or replace procedure buscar_nombre (pnombre in trabajador.dni%type,pcadena out varchar2)
is
cursor c_trab is
    select *
    from trabajador
    where upper(nombre)=upper(pnombre);
  pruebaCaja c_trab%ROWTYPE;
begin
  open c_trab;
  fetch c_trab into pruebaCaja;
  if c_trab%notfound then
    pcadena:='No se ha encontrado el siguiente DNI: '||pnombre;
  else  
    while c_trab%found loop
      pcadena:=pruebaCaja.dni||' '||pruebaCaja.nombre||' '||pruebaCaja.apellidouno||' '||pruebaCaja.apellidodos||' calle: '||pruebaCaja.calle||' portal: '||pruebaCaja.portal||' piso: '||pruebaCaja.piso||' mano: '||pruebaCaja.mano||' Telefono empresa: '||pruebaCaja.telefonoempresa||' Tipo trabajador: '||pruebaCaja.tipotrabajador||' Centro: '||pruebaCaja.centro_idcentro||'\n';
      fetch c_trab into pruebaCaja;
    end loop;
    close c_trab;
  end if;
end;