package business;

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

  public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean Estado) {
		this.Estado = Estado;
	}

  public int getNuBed() {
		return NuBed;
	}

	public void setNuBed(int NuBed) {
		this.NuBed = NuBed;
	}


	@Override
	public String toString() {
		return "Estado: " + Estado + "\tNumero de camas: " + NuBed;
	}

}
