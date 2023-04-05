package servlets.clientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ReservaMgr;
import data.common.Dificultad;
import data.common.SystemManager;
import data.dao.ReservaDAO;

/**
 * Servlet implementation class PostReservaIndividual
 */
@WebServlet("/PostReserva")
public class PostReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("Email");
		Timestamp date1 = SystemManager.StringToDateSQL2(request.getParameter("fechaInicio") + " " + "00:00:00");
		Timestamp date2 = SystemManager.StringToDateSQL2(request.getParameter("fechaFinal") + " " + "00:00:00");
		int NuPeople = Integer.parseInt(request.getParameter("numeroPersonas"));
		int Precio = Integer.parseInt(request.getParameter("precio"));
		
		response.setContentType("text/html");	
		
		ReservaMgr.addReservaChild(email, date1, date2, NuPeople, Precio);
			
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
