package Excepciones;
import java.io.File;
import java.io.IOException;

import main.Principal;

public class Exceptions {

	//----------------------------------------------------------------------------------
	//------------------------excepcion de fichero no enocntrado------------------------
	//----------------------------------------------------------------------------------
	
	public static void FileNotFoundExceptionList(String f) throws IOException {
	 	String sCarpAct = System.getProperty("user.dir");
		File carpeta = new File(sCarpAct);
	 	String[] listado = carpeta.list();
	 	System.out.println("");
	 	System.out.println("-----------------------------------------------------------------");
	 	System.out.println("El programa necesita el fichero llamado: " + f);
	 	System.out.println("-----------------------------------------------------------------");
	 	System.out.println("");
	 	if (listado == null || listado.length == 0) {
	 	    System.out.println("No hay elementos dentro de la carpeta actual");
	 	    return;
	 	} else {
	 	    for (int i=0; i< listado.length; i++) {
	 	        System.out.println(listado[i]);
	 	    }//fin for
	 	}//fin else 
	 	Principal.main(null);
 	} //fin Excepecion
	
	//------------------------------------------------------------------------------------------------------------------
	//------------------------Excepcion de dato introducido no es correcto, se esperaba un numero----------------------
	//------------------------------------------------------------------------------------------------------------------
	
	public static void failOption() throws IOException {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(" El dato introducido no es válido, se esperaba un dato tipo numerico.");
	    System.out.println(" Por favor, Vuelve a intentarlo de nuevo ;D ");
	    System.out.println("----------------------------------------------------------------------------");
	    Principal.main(null);
	 }// fin de metodo failOption
	
	//----------------------------------------------------------------------------------------------------
	// -------------------------Opcion no Valida, ya que dicha opcion no existe---------------------------
	//----------------------------------------------------------------------------------------------------
	
	public static void OpcionErronea() throws IOException {		
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("has introducido una opción que no existe, por favor, vuelve a intentarlo de nuevo.");
		System.out.println("-------------------------------------------------------------------------------------");
		Principal.main(null);
	}//Fin de metodo OpcioErronea
	
	//-----------------------------------------------------------------------------------------------
	//-------------------------------No puede tener una promocion mas de 50k-------------------------
	//-----------------------------------------------------------------------------------------------
	
	public static void PromoSeries50() throws IOException {
		System.out.println("-------------------------------------------------------------");
		System.out.println("El coste maximo de una promoción para una serie es 50K");
		System.out.println("Por favor, realice una nueva promocion menor a 50K");
		System.out.println("Perdone las molestias");
		System.out.println("--------------------------------------------------------------");
		Principal.main(null);
		
	}//Fin Metodo PromoSeries50
	
	//-------------------------------------------------------------------------------------------------------
	//--------------------Comprobar que la nueva solicitud no esta en el fichero Contenidos------------------
	//-------------------------------------------------------------------------------------------------------
	
	public static void ComprobacionNContenido() throws IOException {
		System.out.println("-------------------------------------------------------------");
		System.out.println("El nuevo contenido solicitado no se encuntra en cartelera");
		System.out.println("--------------------------------------------------------------");
		Principal.main(null);
		
	}//Fin Metodo PromoSeries50
	
}//fin clase 

