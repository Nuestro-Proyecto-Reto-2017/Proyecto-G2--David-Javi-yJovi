create or replace PROCEDURE select_trabajadores_dni (v_dni    IN  trabajador.dni%TYPE, c_cursor OUT SYS_REFCURSOR) AS 
BEGIN 
  OPEN c_cursor FOR
    SELECT *
    FROM   trabajador
    WHERE  dni = v_dni;
    
END ;