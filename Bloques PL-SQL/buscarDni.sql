create or replace procedure buscar_dni (pdni in trabajador.dni%type,ptipotrabajador out varchar2,pdniout out varchar2,pnombre out varchar2,papellidouno out varchar2,papellidodos out varchar2,pcalle out varchar2,pportal out varchar2,ppiso out varchar2,pmano out varchar2,ptelefonopersonal out varchar2,ptelefonoempresa out varchar2,psalario out float,pfechanac out date)
is
begin
    select dni,nombre,apellidouno,apellidodos,calle,portal,piso,mano,telefonopersonal,telefonoempresa,salario,fechanac,tipotrabajador 
    into pdniout,pnombre,papellidouno,papellidodos,pcalle,pportal,ppiso,pmano,ptelefonopersonal,ptelefonoempresa,psalario,pfechanac,ptipotrabajador
    from trabajador
    where upper(DNI)=upper(pdni);
exception
  when no_data_found then
    RAISE_APPLICATION_ERROR(-20011, 'Err nombre trabajador no encontrado');
  when too_many_rows then
    RAISE_APPLICATION_ERROR(-20011, 'Err nombre trabajador no encontrado');
  when others then
    RAISE_APPLICATION_ERROR(-20012, 'Error en el procedimiento');
end;
