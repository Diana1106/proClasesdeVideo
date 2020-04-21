<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		//$('#carga').click( function(event){
			//alert('OK');
			var btn = $('#carga').val();
			$.post('ServletControler',{

			}, function(respose){

			let DATOS = JSON.parse(respose);
			//console.log(DATOS);

			var tablaDatos = document.getElementById('tablaDatos');
			for(let item of DATOS){

				tablaDatos.innerHTML += `
				<tr>
				
				<td>${item.idProductos}</td>
				<td>${item.nombreProducto}</td>
				<td>${item.precioProducto}</td>
				<td>${item.cantidadProducto}</td>
				<td>${item.totalProducto}</td>
				<td> 
				<a href="ServletControler?btn=ELIMINAR&Id_pro=${item.idProductos}" class="btn btn-warning"> ELIMINAR</a> 
				<a href="funciones.jsp?idBus=${item.idProductos}&Npr={item.nombreProducto}&Preciopr=${item.precioProducto}&Cantidadpr=${item.cantidadProducto}&Totalpr=${item.totalProducto}" class="btn btn-danger"> ACTUALIZAR</a> 
				</td>
				
				
				
	            </tr>
				`
			}

			//});
		});
	});

</script>

<body>

			<a href="funciones.jsp" class="btn btn-info">AGREGAR</a> 
			
					

					<table class="table table-dark" id="tablaDatos">

						<thead>
							<th>ID</th>
							<th>NOMBRE</th>
							<th>PRECIO</th>
							<th>CANTIDAD</th>
							<th>TOTAL</th>
							<th>OPCIONES</th>
						</thead>

						<tbody>
							
						</tbody>
						
					</table>


</body> 
</html>
