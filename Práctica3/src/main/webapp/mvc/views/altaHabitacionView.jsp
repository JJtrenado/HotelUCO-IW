<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Habitaci�n</title>
<link href="/Pr�ctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

    <section id="hero">
        <h1>HotelUCO</h1>
        <h2>Tu Hotel Universitario. Reserva tu habitaci�n</h2>
    </section>
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
	<form method="post" action="/Pr�ctica3/postCrearHabitacion ">
	<div class="field">
			<label for="numeroCamas">N� de habitaci�n: </label>
			<input name="IdRoom" type="number">
		</div>
		<div class="field">
			<label for="numeroCamas">N� camas de la habitaci�n: </label>
			<input name="NuBed" type="number">
		</div>
		<br/>
		<div class="field">
			<label for="estado">Estado de la habitaci�n: </label>
			<select name="State" required>
				<option>Disponible</option>
				<option>Reservada</option>
			</select>
		</div>
		<br/>
		<input type="submit" value="Crear Habitaci�n">
	</form>
	</div>
</body>
</html>