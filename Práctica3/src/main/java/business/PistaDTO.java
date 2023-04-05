package business;

import data.common.Dificultad;


/**
* A class to represent a pista
* @author Juan José Trenado zafra
* @version 06/10/2022
*/

public class PistaDTO {
	
	/**
   * Attributes
   */
	private int IdRoom;
	private boolean Estado;
	private int NuBed;
	
	/**
   * Constructor without parameters
   */
	public PistaDTO() {

  }
	

	public PistaDTO(int IdRoom, boolean estado, int NuBed) {
		this.IdRoom = IdRoom;
		this.Estado = estado;
		this.NuBed = NuBed;
	}
	
	
	/* Getters and setters */

	  public int getId() {
			return IdRoom;
		}
	/**
   * @return the state of the pista
   */
  public Boolean getEstado() {
		return Estado;
	}
	/**
   * set the name of the pista
   */
	public void setEstado(Boolean Estado) {
		this.Estado = Estado;
	}
	/**
   * @return maximun karts that can play on the pista
   */
  public int getNuBed() {
		return NuBed;
	}
	/**
   * set maximun karts that can play on the pista
   */
	public void setNuBed(int NuBed) {
		this.NuBed = NuBed;
	}

	/* Other methods */
	/**
   * @return all information of the pista by string
   */
	@Override
	public String toString() {
		return "Estado: " + Estado + "\tNumero de camas: " + NuBed;
	}

}
