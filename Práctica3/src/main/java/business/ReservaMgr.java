package business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import data.dao.ReservaDAO;
import data.common.reservationfactory.*;
import data.common.reservationtypes.*;
import data.common.DBConnection;
import data.common.Dificultad;
/***
 * A handler that helps to create reservations
 * @author Antonio Díaz Pérez
 *
 */
public class ReservaMgr {

	/***
	 * A function to add a child reservation
	 * @param mail the email of the adult that made the reservation
	 * @param date the date for the reservation
	 * @param lenght the length of the reservation
	 * @param track the track for the reservation
	 * @param type the type of reservation
	 * @param child the number of children in the reservation
	 * @param idbono the id of the reservation bono
	 * @return
	 */
	
	public static void addReservaChild(String mail, Timestamp date1, Timestamp date2, int NuPeople, int Precio) {
	    DBConnection dbConnection = new DBConnection();
	    Connection connection = null;
	    
	    try {
	        connection = dbConnection.getConnection();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    PreparedStatement ps = null;
	    
	    try {
	        ps = connection.prepareStatement("INSERT INTO Reservations (Email, StartDate, EndDate, NuPeople, Precio) values(?,?,?,?,?)");
	        ps.setString(1, mail);
	        ps.setTimestamp(2, date1);
	        ps.setTimestamp(3, date2);
	        ps.setInt(4, NuPeople);
	        ps.setInt(5, Precio);
	        
	        // Ejecutar la consulta SQL para insertar los datos en la tabla
	        ps.executeUpdate();
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    }
	    
	    dbConnection.closeConnection();
	}

}