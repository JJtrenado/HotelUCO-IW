<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<jsp:useBean id="usuario" class="display.javabean.CustomerBean" scope="session"/>
<%@ page import="data.dao.UsuarioDAO" %>
<%@ page import="business.UsuarioDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HotelUCO</title>
<link href="/Práctica3/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

    <section id="hero">
        <h1>HotelUCO</h1>
        <h2>Tu Hotel Universitario. Reserva tu habitación</h2>
    </section>
	
	<% 
	String nextPage="";
	if(usuario.getUsuario() == null){ 
	%>
	
	<header>
        <nav>
            <a href="#hero">HotelUCO</a>
            <a href="#reservar">Reservar</a>
            <a href="#descripcion">Descripción</a>
            <a href="#ubicacion">Ubicación</a>
        </nav>
    </header>

   	<section id="reservar">
   	
   	<%
		if(request.getParameter("error") != null) {
	%>
	<div class="animation">
	<div class="error"><%= request.getParameter("error") %></div>
	</div>
	<%
		}
	%>
        <h2>Reserva tu habitación</h2>
   	 
    	<button id="mostrar-login">Acceder</button>
   	 <button id="mostrar-registro">Registrarse</button>
   	 
   	 <div class="note-form" id="login" style="display: none;">
   		 <form method="post" action="/Práctica3/mvc/controllers/loginController.jsp">
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
   	 
   	 <div class="note-form" id="registro" style="display: none;">
   		 <form method="post" action="/Práctica3/mvc/controllers/registerController.jsp">
   			 <div class="field">
   			 <label for="name">Nombre y apellidos: </label>
   			 <input type="text" name="name" value="" required>    
   			 </div>
   			 <br/>
   			 <div class="field">
   			 <label for="date">fecha de nacimiento: </label>
   			 <input type="date" name="date" value="" required>
   			 </div>
   			 <div class="field">
   			 <label for="email">Email: </label>
   			 <input type="text" name="email" value="" required>    
   			 </div>
   			 <br/>
   			 <div class="field">
   			 <label for="password">Contraseña: </label>
   			 <input type="password" name="password" value="" required>    
   			 </div>
   			 <br/>
   			 <div class="field">
   			 <label for="rol">Rol: </label>
   			 <input type="text" readonly name="rol" value="Cliente" required>
   			 </div>
   			 <br />
   			 <input type="submit" value="Acceder">
   		 </form>
   	 </div>
		
		
		<script>
			// Seleccionar el botón y el formulario
			const btnMostrarlogin  = document.querySelector('#mostrar-login');
			const login  = document.querySelector('#login');
	
			// Agregar evento de click al botón
			btnMostrarlogin .addEventListener('click', () => {
			  // Mostrar el formulario cambiando su estilo display a "block"
			  login.style.display = 'block';
			  registro.style.display = 'none';
			});
			
			const btnMostrarRegistro = document.querySelector('#mostrar-registro');
	   		 const registro = document.querySelector('#registro');
	   		 // Agregar evento de click al botón
	   		 btnMostrarRegistro.addEventListener('click', () => {
	   		   // Mostrar el formulario cambiando su estilo display a "block"
	   		  	registro.style.display = 'block';
				login.style.display = 'none';
	   		 });

    	</script>
    </section>

    <section id="descripcion">
        <h2>Conoce HotelUCO</h2>
        <div>
        	<p>HotelUCO es un hotel de lujo ubicado en el corazón de la ciudad. Contamos con habitaciones cómodas y modernas, además de una gran cantidad de servicios para que disfrutes de una estancia inolvidable.</p>
        	<img class="cover" src="/Práctica3/mvc/public/hotel.jpg" alt="Imagen del interior del HotelUCO">
        </div>
    </section>

    <section id="ubicacion">
        <h2>Ubicación</h2>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d0!2d0!3d0!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDjCsDAwJzAwLjAiTiAxwqA1MCcwMC4wIlc!5e0!3m2!1ses!2ses!4v1634317083800!5m2!1ses!2ses" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
    </section>

    <footer>
        <p>HotelUCO &copy; 2023. Todos los derechos reservados.</p>
    </footer>
	
	<% }
	else if(usuario.getRol().equals("Administrador")) { 
	%>
		<div class="container">
			<div class="info">
				<h2>Bienvenido <%out.println(usuario.getUsuario());%></h2>
			</div>
			<section id="reservar">
				<button><a href="/Práctica3/mvc/controllers/disconnectController.jsp">Desconectar</a></button>
				<button><a href="/Práctica3/mvc/views/ModifyAdminView.jsp">Modificar Datos</a></button>
				<button><a href="/Práctica3/crearhabitacion?rol=Administrador">Crear habitación</a></button>
				<button><a href="/Práctica3/ManejadorModifyHabitacion?rol=Administrador">Modificar habitación</a></button>
				<button><a href="/Práctica3/ManejadorDeleteReservation?rol=Administrador">Eliminar Reserva</a></button>
			</section>
		</div>
	<% }
	else if(usuario.getRol().equals("Cliente")){
	%>
		<% Timestamp res = UsuarioDAO.getProximaReserva(usuario.getUsuario()); %>
		<div class="container">
			<div class="info">
				<h2>Bienvenido <%out.println(usuario.getUsuario()); %>!</h2>
			</div>
			<% if(res == null) { %>
				<p>Su próxima reserva es el: No tiene reservas.</p>
			<% }else { %>
				<p>Su próxima reserva es el: <%out.println(UsuarioDAO.getProximaReserva(usuario.getUsuario())); %></p>
			<% } %>
			<section id="reservar">
				<button><a href="/Práctica3/mvc/controllers/disconnectController.jsp">Desconectar</a></button>
				<button><a href="/Práctica3/mvc/views/ModifyClientView.jsp">Modificar mis datos</a></button>
				<button><a href="/Práctica3/mvc/views/ClientViews/MakeIndividualReservation.jsp">Reserva</a></button>
				<button><a href="/Práctica3/mvc/views/ClientViews/DeleteClientReservationView.jsp">Eliminar Reserva</a></button>
			</section>
		</div>
	
	<%
	}
	else{
		%>
		<div class="botones">
			<a href="/Práctica3/mvc/controller/disconnectController.jsp">Desconectar</a>
			<a href="/Práctica3/mvc/views/ModifyClientView.jsp">Modificar Datos</a>
		</div>
	<%
	}
	%>
	
</body>
</html>