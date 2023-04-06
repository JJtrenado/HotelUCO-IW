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
	    <form method="post" action="/Práctica3/PostReserva">
	    	<h2>Reserva tu estancia</h2>
		    <div id="noHabitaciones" style="color:red;"></div>
			<div class="field">
				<label for="Date">Fecha Inicial: </label>
				<input type="date" id="fechaInicio" name="fechaInicio" oninput="calcularMultiplicacion()" value="" required>
			</div>
			<div class="field">
				<label for="Date">Fecha Final: </label>
				<input type="date" id="fechaFinal" name="fechaFinal" oninput="calcularMultiplicacion()" value="" required>
			</div>
			<div class="field">
				<label for="Date">Nº Personas: </label>
				<input type="number" id="numero" name="numeroPersonas" oninput="calcularMultiplicacion()" value="" required>
			</div>
			<p style="display:none;">
				<input type="text" readonly name="Email" value=<%= usuario.getUsuario() %>>
				<div id="precio" style="display:none;"></div>
			</p>
			<br />
			<p>El el precio para la estancia seleccionada es: <span id="resultado"></span></p>
			<button type="submit">Reservar</button>
			<br />
		</form>
	</div>


<script>
function calcularMultiplicacion() {
  var fecha1 = new Date(document.getElementById("fechaInicio").value);
  var fecha2 = new Date(document.getElementById("fechaFinal").value);
  var numero = document.getElementById("numero").value;

  var diferencia = fecha2.getTime() - fecha1.getTime();
  var dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));

  var resultado = dias * numero * 50;

  document.getElementById("precio").innerHTML = "<input type='number' readonly name='precio' value=" + resultado + ">"
  document.getElementById("resultado").innerHTML = resultado;
}
</script>

    
</body>
</html>