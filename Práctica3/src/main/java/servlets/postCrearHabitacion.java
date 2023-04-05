package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.PistaMgr;

@WebServlet(name="postCrearHabitacion", urlPatterns="/postCrearHabitacion")
public class postCrearHabitacion extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	RequestDispatcher disp;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String rol = (String) request.getParameter("rol");
		
		if(rol==null) {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
		else if(rol.equals("Administrador")) {
			disp = request.getRequestDispatcher("/mvc/views/altaHabitacionView.jsp");
			disp.forward(request, response);
		}
		else {
			disp = request.getRequestDispatcher("/mvc/views/Error/ErrorView.jsp");
			disp.forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String estado = (String) request.getParameter("State");
		int NuBed= Integer.parseInt(request.getParameter("NuBed"));
		int IdRoom= Integer.parseInt(request.getParameter("IdRoom"));
		Boolean state=false;
		if(estado.equals("Disponible")) {
			state=true;
		}
		else if(estado.equals("Mantenimiento")) {
			state=false;
		}		
		
		if(PistaMgr.addRoom(IdRoom, state, NuBed)==true) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<br><h2>Habitación creada correctamente</h2>");
			disp = request.getRequestDispatcher("/index.jsp");
			disp.include(request, response);
		}
		else {
			disp = request.getRequestDispatcher("error");
			disp.forward(request, response);
		}
	}

}