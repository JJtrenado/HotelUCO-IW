package business;


import java.sql.Timestamp;

import data.common.SystemManager;

public class UsuarioDTO {

   private String NameS;
   private String Password;
   private Timestamp BirthD;
   private Timestamp InscriptionD;
   private String Email;
   private String rol;

   /**
    * Constructor without parameters
      */

   public UsuarioDTO(){

   }

   public UsuarioDTO(String nombrea, String passwd, Timestamp birth, String email, String rol_){
      NameS=nombrea;
      Password = passwd;
      BirthD=birth;
      InscriptionD= SystemManager.DateToDateSQL(new java.util.Date());
      Email=email;
      rol = rol_;
   }
   
   public UsuarioDTO(String nombrea, Timestamp birth, String email, String rol_){
	      NameS=nombrea;
	      BirthD=birth;
	      InscriptionD= SystemManager.DateToDateSQL(new java.util.Date());
	      Email=email;
	      rol = rol_;
	   }
   
   public UsuarioDTO(String nombrea, String passwd, Timestamp birth, Timestamp inscr, String email, String rol_){
	      NameS=nombrea;
	      Password = passwd;
	      BirthD=birth;
	      InscriptionD= inscr;
	      Email=email;
	      rol = rol_;
	   }

   /**
   * @return the name of the user
   */

   public String getNameSurname() {
      return NameS;
   }


   public void setNameSurname(String NameSNew) {
      NameS=NameSNew;
   }

   public String getPassword() {
	   return Password;
   }
   
   public void setPassword(String passwd) {
	   Password = passwd;
   }
   /**
   * 
   * @return the birth date of the user
   */
   public Timestamp getBirthDate() {
      return BirthD;
   }

   /**
   * Changue the birth date of the user
   * @param NewBirth the new birth date
   */
   public void setBirthDate(Timestamp NewBirth) {
      BirthD=NewBirth;
   }

   /**
   * 
   * @return the inscription date of the user
   */
   public Timestamp getInscriptionDate() {
      return InscriptionD;
   }


   /**
   * 
   * @return the email of the user
   */
   public String getEmail() {
      return Email;
   }

   /**
   * Changue the user's email
   * @param newEmail the new email for the user
   */
   public void setEmail(String newEmail) {
      Email=newEmail;
   }

   /**
   * Function to refine the class
   * @return an string with all the variables of an instance
   */

   public String toString() {
      return "El nombre del usuario es "+NameS+" su fecha de nacimiento es "+BirthD+" se inscribió en el sistema el "+InscriptionD+", su email es " + Email
    		  + " y su rol es " + rol;
   }

   public void setInscription(Timestamp date) {
      InscriptionD = date;
   }
   
   public String getRol() {
	   return rol;
   }
   
   public void setRol(String rol_) {
	   rol = rol_;
   }


}
