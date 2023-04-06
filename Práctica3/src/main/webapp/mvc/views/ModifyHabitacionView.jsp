<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Habitación</title>
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
		<form method="post" action="/Práctica3/PostModifyHabitacion">
		    <h2 id="respuesta">Espere mientras carga</h2>
		    <div id="noHabitaciones" style="color:red;"></div>
			<div class="field">
				<label for="ID">ID de habitación: </label>
				<select id="miSelect1" name="ID">
				</select>
			</div>
			<br/>
			<div class="field">
				<label for="ID">Estado de la habitación: </label>
				<select name="estado" required>
				<option>Disponible</option>
				<option>Reservada</option>
			</select>
			</div>
			<br />
			<input type="submit" value="Modificar Habitación">
		</form>
	</div>
	
    <script>
    window.onload = function realizarSolicitud1() {
        // Realizar una solicitud GET al servlet
        fetch("/Práctica3/getHabitaciones")
            .then(response => response.text()) // Obtener la respuesta como texto plano
            .then(data => {
            	if(data == ''){
		        	document.getElementById("noHabitaciones").innerHTML = "No hay Habitaciones"
		        }
                // Procesar la respuesta del servlet
                var substrings = data.split(",");
	                
				// Obtener una referencia al select del formulario con un ID de "miSelect"
				var miSelect1 = document.getElementById("miSelect1");
			
				// Guardo en una string todo el html que quiero insertar
				var htmlParaInsertar = "";
				for (var i = 0; i < substrings.length; i++) {
					 htmlParaInsertar = htmlParaInsertar + "<option>" + substrings[i] + "</option>";
				}
				
				// inserto el Html
				miSelect1.innerHTML= htmlParaInsertar;
				
				const texto = "Seleccione la Habitación y su Estado";
	                document.getElementById("respuesta").innerHTML = texto;
	    	});
    } 
    </script>
</body>
</html>