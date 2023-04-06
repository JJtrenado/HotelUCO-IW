<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceder</title>
<link href="/Práctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

    <section id="hero">
        <h1>HotelUCO</h1>
        <h2>Tu Hotel Universitario. Reserva tu habitación</h2>
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
	<form method="post" action="../controllers/loginController.jsp">
		<div class="field">
		<label for="email">Email: </label>
		<input type="text" name="email" value="" required>
		</div>	
		<br />
		<div class="field">
		<label for="password">Contraseña: </label>
		<input type="password" name="password" value="" required>
		</div>	
		<br />
		<input type="submit" value="Acceder">
	</form>
	</div>
</body>
</html>