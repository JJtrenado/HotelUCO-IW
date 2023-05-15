<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
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
	
	<% String persona = "-- Seleccione --"; %>
	<% if(request.getParameter("persona") != null){ persona = request.getParameter("persona"); } %>
	
	<% if(usuario != null && usuario.getRol().equals("Cliente")) { %>
			<div class="note-form">
			<form method="post" action="../controllers/ModifyUserController.jsp">
				<div class="field">
					<p style="display:none;">
					<input type="text" readonly name="email" value=<%= usuario.getUsuario() %>>
					</p>
					
					<label for="email">Parámetro a modificar:</label>
					<select name="menu" required id="opcion" onchange="cambiarCampo()">
		  				<option>Nombre</option>
		  				<option>Password</option>
		  				<option>Fecha de nacimiento</option>
					</select>
					
					<label for="nuevo">Nuevo parámetro: </label>
    				<input type="text" id="nuevo" name="nuevo" value="" required>
				</div>
				
				<br /><input type="submit" value="Modificar">
			</form>
			</div>
	<% } %>
		
</body>

	<script>
	function cambiarCampo() {
		  var opcion = document.getElementById("opcion").value;
		  var campo = document.getElementById("nuevo");
		  
		  if (opcion === "Fecha de nacimiento") {
		    campo.type = "date";
		  } else {
		    campo.type = "text";
		  }
		}
	</script>

</html>
