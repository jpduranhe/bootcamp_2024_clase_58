<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<div class="col-md-12">
			<h1>Listado de Personas Registradas</h1>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Nombre</th>
			      <th scope="col">Apellido</th>
			      <th scope="col">Edad</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listadoPersonas}" var="persona">
				<tr>
			      <td>${persona.nombre}</td>
			      <td>${persona.apellidos}</td>
			      <td>${persona.edad}</td>
			    </tr>
				</c:forEach>
			    
			  </tbody>
			</table>
			<a href="/clase_58/persona-formulario" class="btn btn-success" > Volver al formulario</a>
		</div>
	</div>

</body>
</html>