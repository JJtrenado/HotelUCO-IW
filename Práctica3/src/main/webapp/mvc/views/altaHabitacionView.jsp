<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Habitación</title>
<link href="/Práctica3/mvc/views/formStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		if(request.getParameter("error") != null) {
	%>
	<div class="animation">
	<div class="error"><%= request.getParameter("error") %></div>
	</div>
	<%
		}
	%>
	<div class="note-form">
	<form method="post" action="/Práctica3/postCrearHabitacion ">
	<div class="field">
			<label for="numeroCamas">Nº de habitación: </label>
			<input name="IdRoom" type="number">
		</div>
		<div class="field">
			<label for="numeroCamas">Nº camas de la habitación: </label>
			<input name="NuBed" type="number">
		</div>
		<br/>
		<div class="field">
			<label for="estado">Estado de la habitación: </label>
			<select name="State" required>
				<option>Disponible</option>
				<option>Reservada</option>
			</select>
		</div>
		<br/>
		<input type="submit" value="Crear Habitación">
	</form>
	</div>
</body>
</html>