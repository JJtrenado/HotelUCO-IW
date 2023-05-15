package business;

import data.dao.PistaDAO;
import data.common.Dificultad;

public class PistaMgr {


	public static boolean addRoom(int IdRoom, boolean state, int NuBed) {
		PistaDTO track = new PistaDTO(IdRoom, state, NuBed);
		PistaDAO.crearPista(track);
		return true;
	}
	
}
