<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
	     <html>
	      	<body>
	      		<table>
	      			<tr>
	      				<th>kmInicio</th>
	      				<th>kmFinal</th>
	      				<th>tipoParte</th>
	      				<th>DNI</th>
	      				<th>matricula</th>
	      				<th>albaran-salida</th>
	      			</tr>
	      			<xsl:for-each select="listaPartes/Parte">
	      			<tr>
	      				<th>
	      					<xsl:value-of select="kmInicio" />
	      				</th>
	      				<th>
	      					<xsl:value-of select="kmFinal" />
	      				</th>
	      				<th>
	      					<xsl:value-of select="tipoParte" />
	      				</th>
	      				<th>
	      					<xsl:value-of select="dni" />
	      				</th>
	      				<th>
	      					<xsl:value-of select="matricula" />
	      				</th>
	      				<th>
	      					<xsl:value-of select="albaran" />
	      				</th>>
	      			</tr>
	      			</xsl:for-each>
	        	</table>
	      	</body>
  		</html>
   	</xsl:template>
</xsl:stylesheet>
