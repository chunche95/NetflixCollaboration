package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.Exceptions;

public class Principal {
	
			public static String nombreFichero = "Contenido.csv";
			public static void main(String[] args) throws IOException {
				menu();
				Scanner leer = new Scanner(System.in);
				int opcion = leer.nextInt();
	            //métodos.         
	            switch (opcion) {
	                case 1 -> leerFichero2("Contenido.csv");
	                case 2 -> Numeros();
	                case 3 -> CosteMas50K();
	                case 4 -> ComprobacionSolicitud();
	                  
	                //Aqui comprobamos la expcion de escoger una opcion equivocada
	                default -> Exceptions.OpcionErronea();
	            }
				
				
			}//end main
			
			
			//----------------------------------------------------------------------------
			//------------------Comprobacion Excepcion Fichero----------------------------
			//----------------------------------------------------------------------------
			
			private static void leerFichero2(String fichero) throws IOException {
				String titulo, descripcion, tipoContenido, productora, pais;
				int año, duracion, nTemporadas, nCapitulos;
				boolean tendencia;
				String line;
				try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
					while ((line = br.readLine()) != null) {
						String[] split = line.split(";");
						tipoContenido = split[0];
						titulo = split[1];
						año = Integer.valueOf(split[2]);
						duracion = Integer.valueOf(split[3]);
						descripcion = split[4];
						tendencia = Boolean.valueOf(split[5]);

						// Informacion de una Pelicula
						if (tipoContenido.charAt(0)== 's') { 
							nTemporadas = Integer.valueOf(split[6]);
							nCapitulos = Integer.valueOf(split[7]);
						} 
						// Informacion de una Pelicula
						else { 
							productora = split[6];
							pais = split[7];
						}
					}
					
				} catch (IOException e) {
					System.out.println("........................................................");
		        	System.out.println("...... No se ha encontrado el fichero solicitado........");
					System.out.println("........................................................");

		        	e.printStackTrace();
		        	Exceptions.FileNotFoundExceptionList(nombreFichero);
		        	System.out.println("........................................................"); 
				}// end catch
		   
		    System.out.println("Siguiente Comprobacion");
		    
		    
			}//end metodo
			
			//----------------------------------------------------------------------------------------------------
			// ------------------Comprobacion de excepcion de dato numerico solicitado----------------------------
			//----------------------------------------------------------------------------------------------------	
			
			public static void Numeros () throws IOException {
				try {
				// numeros en lugar de letras
				 Scanner leer = new Scanner(System.in);
			     System.out.println("Introduce un numero");
			     int num1 =leer.nextInt();
			     System.out.println("Muchas gracias");
			     
			     } catch ( InputMismatchException ex1) {
			    	 Exceptions.failOption();
			     }//end catch
				
				System.out.println("Siguiente Comprobacion");
			}//fin metodo
			
			//----------------------------------------------------------------------------------------------------
			// ------------------Comprobacion de excepcion pasarse del limite-------------------------------------
			//----------------------------------------------------------------------------------------------------
			
			public static void CosteMas50K() throws IOException {
	
				 Scanner leer = new Scanner(System.in);
			     System.out.println("Introduce un precio");
			     int precio =leer.nextInt();
			     if (precio >50000) {
			    	 Exceptions.PromoSeries50();
			    }
			     else {
			    	 System.out.println("Muchas gracias");
			     }
			     System.out.println("Siguiente Comprobacion");
			    }//end metodo
			
			
			//----------------------------------------------------------------------------------------------------
			// ------------------Comprobacion de excepcion de contenido-------------------------------------
			//----------------------------------------------------------------------------------------------------
			
			public static void ComprobacionSolicitud () throws IOException {
				String Solicitud;
				try {
				System.out.println("Introduce tu solicitud");
				Scanner leer = new Scanner(System.in);
				Solicitud=leer.nextLine();
				leerFichero2("Contenido.csv");
				}catch (IOException e) {
					Exceptions.ComprobacionNContenido();
				}
				
			    System.out.println("Introduce tu solicitud");
			    
			}
			
			
			//----------------------------------------------------------------------------------------------------
			// ----------------------------------------Menu-------------------------------------------------------
			//----------------------------------------------------------------------------------------------------
			
			
			private static void menu(){    	    
				System.out.println("");
				System.out.println("\t |-------------------------------------|");
		        System.out.println("\t\t\t Menu principal");
		        System.out.println("\t |-------------------------------------|");
		        System.out.println("");
		        System.out.println("\t 1. Comprobar fichero.");
		        System.out.println("\t 2. Comprobar si no se introduce un numero.");
		        System.out.println("\t 3. Comprobar si el precio es mayor al limite.");
		        System.out.println("\t 4. Comprobar que le contenido agregado no estaba anteriormente.");	
		    }       
	}//fin clase
