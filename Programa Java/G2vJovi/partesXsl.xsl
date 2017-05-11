<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
	     <html>
			<head>
			<title>
				Himevico SL
			</title>
			</head>
	      	<body>
	      		<table border="1" width="90%">
	      			<tr>
	      				<th colspan="4">Datos parte</th>
	      				<th colspan="3">Datos trabajador</th>
	      				<th colspan="3">Datos vehiculo</th>
	      				<th>Datos salida</th>
	      				<th>Aviso</th>
	      				<th colspan="4">Datos gastos</th>
	      			</tr>
	      			<tr>
	      				<th>kmInicio</th>
	      				<th>kmFinal</th>
	      				<th>tipoParte</th>
	      				<th>incidencias</th>
	      				<th>DNI</th>
	      				<th>Nombre</th>
	      				<th>Apellido</th>
	      				<th>matricula</th>
	      				<th>marca</th>
	      				<th>modelo</th>
	      				<th>salidas</th>
	      				<th>descripcion</th>
	      				<th>G.gasoil</th>
	      				<th>G.dietas</th>
	      				<th>G.peajes</th>
	      				<th>otros.G</th>
	      			</tr>
	      			<xsl:for-each select="listaPartes/Parte">
	      			<tr>
	      				<td>
	      					<xsl:value-of select="kmInicio" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="kmFinal" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="tipoParte" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="incidencias" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Trabajador/dni" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Trabajador/nombre" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Trabajador/apellido" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Vehiculo/matricula" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Vehiculo/marca" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Vehiculo/modelo" />
	      				</td>
	      				<td>
		      				<xsl:for-each select="Salida">
		      					Albaran: <xsl:value-of select="albaran" /><br></br>
		      					Hora Salida:<xsl:value-of select="horaSalida" /><br></br>
		      					Hora Llegada:<xsl:value-of select="horaLlegada" /><br></br>
		      					<hr/>
		      				</xsl:for-each>
	      				</td>
	      				<td>
	      					<xsl:value-of select="Aviso/descripcion" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Gasto/gastoGasoil" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Gasto/gastoDietas" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Gasto/gastoPeaje" />
	      				</td>
	      				<td>
	      					<xsl:value-of select="Gasto/otrosGastos" />
	      				</td>
	      			</tr>
	      			</xsl:for-each>
	        	</table>
	      	</body>
  		</html>
   	</xsl:template>
</xsl:stylesheet>
