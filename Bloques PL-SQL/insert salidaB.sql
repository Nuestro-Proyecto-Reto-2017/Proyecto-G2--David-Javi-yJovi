create or replace procedure insertar_salidasb(horaSalida in date,horaLlegada in date, albaran in varchar2,v_idparte in number)
is 
begin 
  insert into  salidaBasura (horasalida,horallegada,albaran,parteBasura_idparte)values(horaSalida,horaLlegada, albaran, v_idparte);
  if sql%notfound then
      RAISE_APPLICATION_ERROR(-20011, 'Error al insertar');
  end if;
exception
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;