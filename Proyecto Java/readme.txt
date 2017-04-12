Cosas a tener en cuenta:
	Driver utilizado:"oracle.jdbc.driver.OracleDriver"
	Conexion: "jdbc:oracle:thin:@10.10.10.9:1521:db12102"
	Usuario: "system"
	contraseña: "oracle"
	La biblioteca(library) que contiene el driver se llama : BDOracle

Cosas que no he podido terminar a tiempo y dejarlo como me gustaria:
	Solo tengo 1 busqueda, mi idea era hacer busquedas con distintos parametros para que el "where" sea diferente y me saque distintos Trabajadores/centros
	PARA BUSCAR EN TRABAJADOR HAY QUE BUSCAR POR NOMBRE
	ejemplo si buscas por nombre "pepe" te pueden salir varios "pepe" pero si buscas por DNI solo te saldra uno.
	Al agregar y modificar un trabajador no se le puede asignar el centro(obligatorio, se agregan todos los trabajadores al centro con ID 1, si no hay ningun centro con ese ID dara problemas), ni la fecha (opcional).
	Lo del centro es porque lo quiero hacer con un combobox donde se guarden todos los centros de la base de datos necesitaria hacer una consulta primero,
	Lo de la fecha es porque tengo que hacerle la conversion.
	Tengo que organizarlo TODO, 
	ejemplo Funciones/procedimientos que deberian ir en la clase administracion/logistica estan en el main. (No sigue el diagrama de clases).

	La salida de datos despues de una consulta me gustaria guardarla de manera mas vistosa/ en una tabla o algo así.

	NO he conseguido hacer una consulta mediate un paquete. Sin paquete no he tenido problemas.