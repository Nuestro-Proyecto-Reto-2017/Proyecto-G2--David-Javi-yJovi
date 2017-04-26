create or replace procedure buscar_nombreCursor (pnombre in trabajador.dni%type,c_trab out Sys_refcursor)
is
begin
  open c_trab for 
    select nombre
    from trabajador
    where upper(nombre)=upper(pnombre);
  if c_trab%notfound then
    DBMS_OUTPUT.PUT_LINE('true');
  else  
    DBMS_OUTPUT.PUT_LINE('false');
  end if;
end;

