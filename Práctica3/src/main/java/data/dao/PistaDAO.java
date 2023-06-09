package data.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.ResultSet;

import business.PistaDTO;
import data.common.*;

public class PistaDAO {

  public PistaDAO(){
  }

  public static void crearPista(PistaDTO track){
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	  
	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement("INSERT INTO Room (IdRoom, State, NuBed) values(?,?,?)");
		  ps.setInt(1, track.getId());
		  ps.setBoolean(2, track.getEstado());
		  ps.setInt(3, track.getNuBed());
		  ps.executeUpdate();
	  } catch (SQLException e1) { e1.printStackTrace(); }

	  dbConnection.closeConnection();
  }

  public static boolean comprobarExistenciaPista(String name){
	  boolean ret = false;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	  

	  
	  Statement stmt = null;
	  
	  try {
		  stmt = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) stmt.executeQuery("SELECT Name FROM Tracks WHERE Name = " + "'" + name + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  try {
		  if(rs.next() == true) {
			  	ret = true;
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  if(stmt != null) { 
		  try {
			  stmt.close();
		  } catch (SQLException e) { e.printStackTrace(); } 
	  }
			
	  dbConnection.closeConnection();
		
	  return ret;
}

  public static int asociarKartAPistaDisponible(int kart, String track){
	  int ret = 2;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
	    
	  
		  
	  if(comprobarExistenciaPista(track) == true && comprobarSitiosLibrePista(track) == true) {
		  PreparedStatement ps;
		  
		  try {
			  ps = connection.prepareStatement("UPDATE Karts set TrackName = ? WHERE Id = ?");
			  ps.setString(1, track);
			  ps.setInt(2, kart);
			  
			  ps.executeUpdate();
			  ret = 1;
		  } catch (SQLException e) { e.printStackTrace(); }
		  
	  }
	  dbConnection.closeConnection();
	  return ret;
  }

  private static boolean comprobarSitiosLibrePista(String track){
	  
	  boolean bool = false;
	  
	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  try {
		  connection = dbConnection.getConnection();
	  } catch (IOException e) { e.printStackTrace(); }
	    
	  
	  Statement stmt_track = null;
	  
	  try {
		  stmt_track = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs_track = null;
	  
	  try {
		  rs_track = (ResultSet) stmt_track.executeQuery("SELECT * FROM Tracks WHERE Name = " + "'" + track + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  Statement stmt_kart = null;
	  
	  try {
		  stmt_kart = connection.createStatement();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  ResultSet rs_kart = null;
	  
	  try {
		  rs_kart = (ResultSet) stmt_kart.executeQuery("SELECT COUNT(Id) FROM Karts WHERE (State = 'Disponible' OR State = 'Reservado') AND TrackName = " + "'" + track + "'");
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  
	  try {
		  if(rs_track.next() && rs_kart.next()) {
			  	try {
			  		if(rs_track.getInt("MaxKarts") > rs_kart.getInt(1)) { bool = true; }
			  	} catch (SQLException e) { e.printStackTrace(); }
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  	  
	  dbConnection.closeConnection();
	  return bool;
  }


  public static void pistasLibresConXKarts(int nKarts, Dificultad dificultad){


	  DBConnection dbConnection = new DBConnection();
	  Connection connection = null;
	  
	  try {
		  connection = dbConnection.getConnection();
	  } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }

	  
	  PreparedStatement ps = null;
	  
	  try {
		  ps = connection.prepareStatement("SELECT * FROM Tracks WHERE State = ? AND Difficulty = ?");
		  ps.setInt(1, 1);
		  ps.setString(2, dificultad.toString());
	  } catch (SQLException e2) { e2.printStackTrace(); }


	  ResultSet rs = null;
	  
	  try {
		  rs = (ResultSet) ps.executeQuery();
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  try {
		while(rs.next()) {
			  Statement stmt_kart = null;
			  
			  try {
				  stmt_kart = connection.createStatement();
			  } catch (SQLException e) { e.printStackTrace(); }
			  
			  ResultSet rs_kart = null;
			
			  try {
				  rs_kart = (ResultSet) stmt_kart.executeQuery("SELECT COUNT(Id) FROM Karts WHERE (State = 'Disponible' OR State = 'Reservado') AND TrackName = " + "'" + rs.getString("Name") + "'");
				  rs_kart.next();
				  
				  if(rs_kart.getInt(1) >= nKarts) {
					  System.out.println("Track -> " + rs.getString("Name"));
				  }
			  } catch (SQLException e1) { e1.printStackTrace(); }
		  }
	  } catch (SQLException e) { e.printStackTrace(); }
	  
	  dbConnection.closeConnection();

		
	}

  public static ArrayList<String> trackList(int child){
	  	ArrayList<String> tracks = new ArrayList<String>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }

		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Tracks WHERE State = 1 AND (Difficulty = ? OR Difficulty = ?) ORDER BY Name ");
			ps.setString(1, Dificultad.familiar.toString());
			if(child == 1) { ps.setString(2, Dificultad.infantil.toString()); }
			else { ps.setString(2, Dificultad.adultos.toString()); }
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				if(comprobarSitiosLibrePista(rs.getString("Name")) == true) {
					tracks.add(rs.getString("Name"));
				}
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return tracks;
  }

  public static ArrayList<String> listAllRooms(){
	  ArrayList<String> track = new ArrayList<String>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
		  
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Room ORDER BY IdRoom ");
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				track.add(rs.getString("IdRoom"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return track;
  }

  public static ArrayList<String> listTrackDisponible(String type, int min){
	  ArrayList<String> track = new ArrayList<String>();
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }

		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM Tracks WHERE Difficulty = ? AND MaxKarts > ?");
			ps.setString(1, type);
			ps.setInt(2, min);
		} catch (SQLException e1) { e1.printStackTrace(); }
		
		ResultSet rs = null;
		
		try {
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()) {
				track.add(rs.getString("Name"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		    
		dbConnection.closeConnection();
		
		return track;
  }
  
  public static void ModifyStateTrack(int id, String state) {
		DBConnection dbConnection = new DBConnection();
		Connection connection = null;
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e2) { e2.printStackTrace(); }
		
		try {
			connection = dbConnection.getConnection();
		} catch (IOException e) { e.printStackTrace(); }
		  
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement("UPDATE Room set State = ? WHERE IdRoom = ?");
			ps.setInt(2, id);
			if(state.equals("Disponible")) { ps.setInt(1, 1); }
			else { ps.setInt(1, 0); }
			ps.executeUpdate();
		} catch (SQLException e1) { e1.printStackTrace(); }
		    
		dbConnection.closeConnection();
	}
}




