package programa4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import programa4.ListaLigada;
import programa4.Nodo;

/**
 * Clase principal donde se realiza el cálculo del tamaño del rango relativo
 * @author Yeifer Herrera, Viviana Londoño, Oscar Lopera
 *
 */
public class ProgramaPS4 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ListaLigada datos_lista_1 = new ListaLigada();
		ListaLigada datos_lista_2 = new ListaLigada();
		
		int option = 0;
		String entradaTeclado = "";
	    Scanner entradaEscaner = new Scanner (System.in); //Creacion de un objeto Scanner
		while (option==0) {
			System.out.println ("Empezamos el programa de pruebas de software");
	        System.out.println ("Menu:"); 
	        System.out.println ("1. Ingresar las lista a promediar");
	        System.out.println ("2. Ingresar lista unica promedio");
	        System.out.println ("3. Salir");
	        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner

	       
	        
	        switch (entradaTeclado) {
				case "1":{
					System.out.println ("Por favor introduzca la ruta donde esta ubicado el archivo con el primer conjunto de datos:");
			        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
			        datos_lista_1 = LeerArchivo(entradaTeclado);
			        
			        System.out.println ("Por favor introduzca la ruta donde esta ubicado el archivo con el segundo conjunto de datos:");
			        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
			        datos_lista_2 = LeerArchivo(entradaTeclado);
			        option=1;
					break;
				}
					
					
				case "2":{
					System.out.println ("Por favor introduzca la ruta donde esta ubicado el archivo con el conjunto de datos:");
			        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
			        datos_lista_1 = LeerArchivo(entradaTeclado);
					option=2;
					break;
				}
				
				case "3":{
					System.out.println ("Bye");
					System.exit(0);
					break;
				}
					
		
				default:{
					option=0;
					break;
					}
			}
	    	
			
		}
		ListaLigada data = new ListaLigada();
		if (option==1) {
			data = promediar_Listas(datos_lista_1, datos_lista_2);
		}else {
			data = datos_lista_1;
		}
		
		data = calcular_ln_cada_dato(data);
		double avg = Media(data);
		
		double desviacionestandar = desviacionEstandar(data);
		
		double lnVS = avg - (2*desviacionestandar);
		double lnS = avg - desviacionestandar;
		double lnM = avg;
		double lnL = avg + desviacionestandar;
		double lnVL = avg + (2*desviacionestandar);
		
		double VS = Math.pow(Math.E, lnVS);
		double S = Math.pow(Math.E, lnS);
		double M = Math.pow(Math.E, lnM);
		double L = Math.pow(Math.E, lnL);
		double VL = Math.pow(Math.E, lnVL);
		
		mostrar_datos(VS, S, M, L, VL);
		
	}


	/**
	 * Método que lee el archivo y almacena sus datos en la lista ligada
	 * @param archivo
	 * @return ListaLigada, retorna una lista ligada con los datos leidos desde el archivo
	 * @throws IOException
	 */
	public static ListaLigada LeerArchivo (String archivo) throws IOException {
	    String cadena = "";
	    double dato = 0;
	    ListaLigada lista = new ListaLigada();
	    if (archivo.length()>4) {
	    	if (verificarExtension(archivo)) {
	  	      
	  	      try {
	  	    	  FileReader f = new FileReader(archivo);
	  		      BufferedReader b = new BufferedReader(f);
	  		      while((cadena = b.readLine())!=null) {
	  		    	  try {
	  		    		  dato = Double.parseDouble(cadena);
	  				 } catch (NumberFormatException nfe){
	  					lista = new ListaLigada();
	  					System.out.println("Dato no numerico encontrado");
	  					System.exit(0);
	  					//break;
	  				 }  
	  		          lista.insertarNodo(dato);    
	  		      }
	  		      b.close();
	  		} catch (FileNotFoundException e) {
	  			// TODO: handle exception
	  			System.out.println("404..ERROR FATAL!!!!! El archivo no existe");
	  		}
	  	    }else{
	  	    	System.out.println("No se leyo el archivo");
	  	    	
	  	    }
		} else {
			System.out.println("Direccion de archivo muy corta o invalida");
		}
	    
	    System.out.println("Se han guardado los datos en una lista enlazada");
	    	    return lista;  
	}
	
	
	
	/**
	 * Funcion para verificar la extesión del archivo
	 * @param ruta
	 * @return
	 */
	public static boolean verificarExtension(String ruta){
		String extension = ruta.substring((ruta.length()-4),ruta.length());
		//Verificar extension del archivo
		if (!extension.equals(".txt")) {
			System.out.println("La extension del archivo no es correcta");
			return false;
		}
		System.out.println("La extension es correcta. ");
		return true;
		
		
		
	}
	
	
	/**
	 * Funcion para encontrar el promedio de cada uno de los datos de una lista ligada
	 * @param lista
	 * @return listaresultante
	 */
	public static ListaLigada promediar_Listas(ListaLigada x,ListaLigada y) {
		ListaLigada resultante = new ListaLigada();
		
		if (x.getCant_datos() == y.getCant_datos()) {
			Nodo nodo_lista_x = x.getPrimerNodo();
			Nodo nodo_lista_y = y.getPrimerNodo();
			
			while (nodo_lista_y != null) { 
				resultante.insertarNodo(nodo_lista_x.getDato()/nodo_lista_y.getDato());
				nodo_lista_x = nodo_lista_x.getSiguiente();
				nodo_lista_y = nodo_lista_y.getSiguiente();
	  		} 
	  	     
		}else {
		System.out.println("ERROR - los tamaños de las listas no son iguales");	
		}
		
		System.out.println("Se ha generado la lista enlazada con los promedios correctamente");
		return resultante;
	}
	
	/**
	 * Función para calcular e locaritmo natural de cada uno de los valores contenidos en la lista
	 * @param lista
	 * @return resultante, retorna una lista ligada con el resultado
	 */
	public static ListaLigada calcular_ln_cada_dato(ListaLigada lista) {
		ListaLigada resultante = new ListaLigada();
		
		
			Nodo nodo_lista = lista.getPrimerNodo();
			
			while (nodo_lista != null) { 
				resultante.insertarNodo(Math.log(nodo_lista.getDato()));
				nodo_lista = nodo_lista.getSiguiente();
				
	  		} 
	  	     

		System.out.println("Se ha generado la lista enlazada con el logaritmo natural de cada valor");
		return resultante;
	}
	
	
	/**
	 * Función para sumar datos de una lista ligada
	 * @param lista
	 * @return suma
	 */
	public static double suma(ListaLigada lista) {
		double suma = 0;
		Nodo nodo = lista.getPrimerNodo();/*initialized on First*/
		 while (nodo != null){ 
  	    		suma=suma+nodo.getDato();
  	    		nodo = nodo.getSiguiente();/*Compare Choose the back of X*/	
  	    		

  		}
  	    return suma;
	}
	
	/**
	 * Funcion para calcular la media de los datos de una lista ligada
	 * @param lista
	 * @return Media
	 */
	public static double Media(ListaLigada lista) {
		
		return suma(lista)/lista.getCant_datos();
		
	}
	
	/**
	 * Funcion para calcular la desviacion estandar de los datos de una lista ligada
	 * @param lista
	 * @return desviacionEstandar
	 */
	public static double desviacionEstandar(ListaLigada lista) {
		double media = Media(lista);
		double suma = 0;
		Nodo nodo = lista.getPrimerNodo();/*initialized on First*/
		while (nodo != null){    	
  	    		suma=suma+(Math.pow((nodo.getDato()-media), 2));
  	
  	    		nodo = nodo.getSiguiente();/*Compare Choose the back of X*/	

  		}
  	    suma = suma/(lista.getCant_datos()-1);
  	    suma = Math.sqrt(suma);
  	    System.out.println("La desviación estandar es: "+suma);
		return suma;
		
	}
	
	/**
	 * Funcion para mostrar los datos del modelo de regresion
	 * @param double b0 ,double b1, double r_xy ,double r2, double yk
	 * @return void
	 */
	public static void mostrar_datos(double VS ,double S, double M ,double L, double VL) {
		System.out.println("El valor de VS es : "+VS);
		System.out.println("El valor de S es "+S);
		System.out.println("El valor de M es : "+M);
		System.out.println("El valor de L es "+L);
		System.out.println("El valor de VL es : "+VL);

		
	}
}
