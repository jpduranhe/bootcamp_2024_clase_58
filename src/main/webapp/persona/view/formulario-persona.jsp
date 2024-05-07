<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formulario Persona</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
	
		<div class="row">
			<div class="cold-md-12">
				<form action="#" method="post">
				  <div class="mb-3">
				    <label for="nombre" class="form-label">Nombre</label>
				    <input type=text class="form-control" name="nombre" id="nombre" aria-describedby="nombreHelp">
				    <div id="nombreHelp" class="form-text">Escriba sus 2 nombres.</div>
				  </div>
				  <div class="mb-3">
				    <label for="apellidos" class="form-label">Apellidos</label>
				    <input type="text" class="form-control" name="apellidos" id="apellidos" aria-describedby="apellidosHelp">
				    <div id="apellidosHelp" class="form-text">Escriba sus 2 apellidos.</div>
				  </div>
				  <div class="mb-3">
				    <label for="edad" class="form-label">Edad</label>
				    <input type="number" class="form-control" name="edad" id="edad" aria-describedby="edadHelp">
				    <div id="edadHelp" class="form-text">Escriba sus edad.</div>
				  </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>