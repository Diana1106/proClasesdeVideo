<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String idBus = request.getParameter("idBus");
String nombrePr = request.getParameter("Npr");
String cantidadpr = request.getParameter("Cantidadpr");
String preciopr = request.getParameter("Preciopr");
String totalpr = request.getParameter("Totalpr");

if(idBus==null){
	idBus = "";
	nombrePr = "";
	cantidadpr = "";
	preciopr = "";
	totalpr = "";
	
}

%>

<body>

<h2>AGREGAR DATOS</h2>

<form action="ServletControler">
<TABLE align= "center">
	<thead>
		
	</thead>
	<tbody>
		<tr>
			<td>
				
	<p>id_productos</p><input type="text" name="Id_pro" id="idcarga" value="<%=idBus%>">
	<p>nombre_producto</p><input type="text" name="Nproductos" id="Npro" value="<%=nombrePr%>">
	<p>precio_producto</p><input type="text" name="Pproductos" id="PPro" value="<%=preciopr%>">
	<p>cantidad_producto</p><input type="text" name="Cproductos" id="Cpro" value="<%=cantidadpr%>">
	<p>total_producto</p><input type="text" name="Tproductos" id="Tpro" value="<%=totalpr%>">
	<br>
	<br>
			</td>
		</tr>
	</tbody>
	
</TABLE>

<input type="submit" class="btn btn-info" value="GUARDAR" name="btn">
<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
</form>
</body>
</html>