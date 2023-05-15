package business;

import java.sql.Timestamp;

import data.common.Dificultad;



public abstract class ReservaDTO {
	

	protected String email;
	protected Timestamp fecha;
	protected int duracion;
	protected float precio;
	protected float descuento;
	protected String pista;
	protected Dificultad trackType;
	
	
	/**
   * Constructor without parameters
   */
	
	public ReservaDTO()
	{
	}
	
	
	/* Getters y Setters for all the variables */
	
	
	/**
   * @return the email of the user
   */
	
	public String getEmail()
	{
		return email;
	}
	
	/**
   * @return the date of Reserva
   */
	
	public Timestamp getFecha()
	{
		return fecha;
	}
	
	
	/**
   * @return the duration of Reserva
   */
	
	public int getDuracion()
	{
		return duracion;
	}

	
	public String getPista()
	{
		return pista;
	}
	
	/**
   * @return the price of Reserva
   */
	
	public float getPrecio()
	{
		return precio;
	}
	
	
	/**
   * @return the discount
   */
	
	public float getDescuento()
	{
		return descuento;
	}
	
	
	/**
   * @return the number of the bond
   */
	

	public Dificultad getType() {
		return trackType;
	}
	
	
	/**
   * set the email
   */
	
	public void setEmail(String newemail)
	{
		email = newemail;
	}
	
	
	/**
   * set the date 
   @param newfecha new date 
   */
	
	public void setFecha(Timestamp newfecha )
	{
		fecha = newfecha;
	}
	
	/**
   * set the duration
   @param newduracion new duration
   */
	
	public void setDuracio(int newduracion)
	{
		duracion = newduracion;
	}
	
	/**
   * set the price
   @param newprecio new price
   */
	
	public void setPrecio(float newprecio)
	{
		precio = newprecio;
	}
	
	/**
   * set the discount
   @param newdescuento new discount
   */
	
	public void setDescuento(float newdescuento)
	{
		descuento = newdescuento;
	}
	
	


	public String toString() 
	{
		return "Datos de la reserva:\n"+"ID usuario: "+email+" "+"Fecha de reserva: "+fecha+" "+"Duracion de la reserva: "+duracion+" "+
	"Pista: "+pista+" "+"Precio total de la reserva: "+precio+" "+"Descuento: "+descuento;
	}


	
	public void setPista(String pista2) {
		pista = pista2;
	}
}
