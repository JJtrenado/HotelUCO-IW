package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.ReservaDAO;

/**
 * Servlet implementation class GetReservas
 */
@WebServlet("/GetReservas")
public class GetReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReservas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> reservas = ReservaDAO.ListarReservasFuturas();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Iterator<String> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            out.print(iterator.next() + " ----- " + iterator.next());
            if (iterator.hasNext()) {
                out.print(",");
                iterator.hasNext();
            }
        }

        // Cerrar el PrintWriter
        out.close();
	}
}
