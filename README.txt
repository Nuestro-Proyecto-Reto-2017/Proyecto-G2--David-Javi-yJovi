G2
Pasos para ejecutar el programa:
	1.- Abriremos con Sqldeveloper nuestro modelo fisico situado en: "Modelo Fisico-> G2_BD_ModeloFisico.ddl", despues lo ejecutaremos.
	2.- Compilar todos los Procedimientos PL/SQL menos "PrimerInsert" que podemos encontrar en la carpeta "Bloques PL-SQL"
	3.- Para poder loguearte en el programa y crear el primer usuario podemos hacerlo de 2 maneras:
		-En el main del proyecto Java comentar abrirVentanaLogin(); y descomentar abrirVentanaAdministración(); y dentro de 
		abrirVentanaAdministración(); tendremos que comentar la linea vlogin.dispose();. 
		Entonces podremos ejecutar el programa directamente en la ventana de administración para crear el primer centro y el 
		primer trabajador. Al crearse el trabajador se creara directamente el usuario (mediante el "trigger generar usuario.sql")
		- La otra manera es abrir con Sqldeveloper el archivo llamado "PrimerInsert" y ejecutar primero la linea de insertar el centro
		y despues insertar la del trabajador. Al crearse el trabajador se creara directamente el usuario (mediante el "trigger generar 
		usuario.sql").
	4.-Despues de tener nuestro primer usuario podremos ejecutar nuestro programa Java, 
		NOTA: Si ya habiamos ejecutado el programa Java para crear el primer centro y trabajador, entonces tendremos que dejar como 
		estaba el main: descomentar abrirVentanaLogin();  comentar : abrirVentanaAdministración(); y descomentar vlogin.dispose(); 
		que se encuentra dentro de abrirVentanaAdministración();
	5.- Una vez llegados a este punto podemos probar el programa a nuestro gusto.

Cosas a tener en cuenta: 
	-Modificar partes contiene errores por lo que hemos puesto los botones de modificar el parte disabled.
	-Al insertar las salidas se nos insertan con una fecha en vez de con una hora, por lo cual el trigger de calcular horas no funciona,
	esto hace que el al validar un parte no se nos updatee porque el trigger no le deja. Si se quiere probar el update se podria borrar 
	el trigger.

IMPORTANTE: por falta de tiempo no hemos podido hacer validaciones en la introduccion de datos, por lo que si los introducimos de una manera 
	incorrecta saldra una exception. 
	Se requiere meter los datos de manera correcta.
	