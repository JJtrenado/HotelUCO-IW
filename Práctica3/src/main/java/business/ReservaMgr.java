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

public class ReservaMgr {


	
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