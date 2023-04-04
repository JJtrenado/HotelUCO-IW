<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean  id="usuario" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Pistas</title>
<link href="../formStyles.css" rel="stylesheet" type="text/css">
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
	    <form id="miFormulario" action="#" onsubmit="return peticion()">
	    	<h2>Reserva tu estancia</h2>
		    <div id="noHabitaciones" style="color:red;"></div>
			<div class="field">
				<label for="Date">Fecha Inicial: </label>
				<input type="date" name="fechaInicio" value="" required>
			</div>
			<div class="field">
				<label for="Date">Fecha Final: </label>
				<input type="date" name="fechaFinal" value="" required>
			</div>
			<div class="field">
				<label for="Date">Nº Personas: </label>
				<input type="number" name="numeroPersonas" value="" required>
			</div>
			<p style="display:none;">
			<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
			</p>
			<br />
			<button type="submit">Pedir Precio</button>
			<br />
		</form>
	</div>
	
	<div class="note-form" id="precio">
	 
	</div>
	
	<script>
	  function peticion() {
		const formulario = document.getElementById('miFormulario');
	   	
	   	const searchParams = new URLSearchParams();
	   	searchParams.set('fechaInicio', formulario.elements.fechaInicio.value);
	   	searchParams.set('fechaFinal', formulario.elements.fechaFinal.value);
	   	searchParams.set('numeroPersonas', formulario.elements.numeroPersonas.value);
	   	searchParams.set('Email', formulario.elements.Email.value);

	   	const url = "/Práctica3/getPrecio?" + searchParams.toString();
		//console.log(url);
	   	fetch(url)
	      .then(response => response.text())
	      .then(data => {
	    	  if(data == ''){
		        	document.getElementById("noHabitaciones").innerHTML = "No hay habitaciones disponibles"
		        }
	    	// Procesar la respuesta del servlet
              var substrings = data.split(",");
	                
				// Obtener una referencia al select del formulario con un ID de "miSelect"
				var precio = document.getElementById("precio");
			
				// Guardo en una string todo el html que quiero insertar
				var htmlParaInsertar = "";
				for (var i = 0; i < substrings.length; i++) {
					 htmlParaInsertar = htmlParaInsertar + "<option>" + substrings[i] + "</option>";
				}
				
				// inserto el Html
				precio.innerHTML= htmlParaInsertar;
	  	});
	    return false;
	  }
	</script>
    
</body>
</html>