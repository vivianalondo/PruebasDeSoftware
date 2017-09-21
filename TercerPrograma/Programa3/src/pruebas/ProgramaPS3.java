package pruebas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProgramaPS3 {



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
	    	    return lista;  
	}


	public static void main(String[] args) throws FileNotFoundException, IOException {
	// TODO Auto-generated method stub
		ListaLigada datosX = new ListaLigada();
		ListaLigada datosY = new ListaLigada();
		double estimador = 0;
		System.out.println ("Empezamos el programa de pruebas de software");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creacion de un objeto Scanner
        
        System.out.println ("Por favor introduzca la ruta donde esta ubicado el archivo con el conjunto X de datos:"); 
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
        datosX = LeerArchivo(entradaTeclado);
        
        System.out.println ("Por favor introduzca la ruta donde esta ubicado el archivo con el conjunto Y de datos:");
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
        datosY = LeerArchivo(entradaTeclado);
        
        System.out.println ("Por favor introduzca el valor estimador");
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un metodo sobre un objeto Scanner
       
        	try {
        		estimador = Double.parseDouble(entradaTeclado);
			 } catch (NumberFormatException nfe){
				System.out.println("estimador es no numerico");
				System.exit(0);
				//break;
			 }  
		
        
        
        
        if (datosX.vacia()|| datosY.vacia()) {
			System.out.println("El archivo esta vacio.");
		}else{
			int cant_datos = 0;
			if (datosX.getCant_datos()==datosY.getCant_datos()) {
				cant_datos = datosX.getCant_datos();
			}else {
				
				System.out.println("las listas de datos no poseen el mismo tamaño");
				System.exit(0);
			}
			double mediaX = Media(datosX);
			double mediaY = Media(datosY);
			
			ListaLigada XY = multiplicar_Listas(datosX, datosY);
			ListaLigada XX = multiplicar_Listas(datosX, datosX);
			ListaLigada YY = multiplicar_Listas(datosY, datosY);
			
			double sumXY = suma(XY);
			double sumXX = suma(XX);
			double sumYY = suma(YY);
			
			double sumX = suma(datosX);
			double sumY = suma(datosY);
			
			double B1 = obtener_B1(sumXY, mediaX, mediaY, sumXX, cant_datos);

			double B0 = obtener_B0(mediaX, mediaY, B1);

			double R_xy = obtener_r_xy(cant_datos, sumXY, sumX, sumY, sumXX, sumYY);

			double R2 = R_xy * R_xy;
			
			double Y_estimado = B0 + (B1*estimador);
			
			mostrar_datos(B0, B1, R_xy, R2, Y_estimado);


		}
       
	}
	
	/**
	 * FunciÃ³n para verificar el archivo
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
		int contador = 0;
		double suma = 0;
		Nodo nodo = lista.getPrimerNodo();/*initialized on First*/
  	    do {    	
  	    		suma=suma+(Math.pow((nodo.getDato()-media), 2));
  	
  	    		contador++;
  	    		nodo = nodo.getSiguiente();/*Compare Choose the back of X*/	

  		} while (nodo != null);
  	    suma = suma/(contador-1);
  	    suma = Math.sqrt(suma);
		return suma;
		
	}
	
//////////////////////metodo para el programa 3 ////////////////////////////
	/**
	 * Funcion para sumar datos de una lista ligada
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
	 * Funcion para multiplicar cada uno de los datos de una lista ligada
	 * @param lista
	 * @return listaresultante
	 */
	public static ListaLigada multiplicar_Listas(ListaLigada x,ListaLigada y) {
		ListaLigada resultante = new ListaLigada();
		
		if (x.getCant_datos() == y.getCant_datos()) {
			Nodo nodo_lista_x = x.getPrimerNodo();
			Nodo nodo_lista_y = y.getPrimerNodo();
			
	  	    do { 
				resultante.insertarNodo(nodo_lista_x.getDato()*nodo_lista_y.getDato());
				nodo_lista_x = nodo_lista_x.getSiguiente();
				nodo_lista_y = nodo_lista_y.getSiguiente();
	  		} while (nodo_lista_y != null);
	  	     
		}else {
		System.out.println("ERROR - los tamaños de las listas no son iguales");	
		}
		
		return resultante;
	}
	
	/**
	 * Funcion para calcular el estimador B1 de la regresion
	 * @param double xy,double media_x, double media_y, double xx, int cant_datos
	 * @return resultado_b1
	 */
	public static double obtener_B1(double xy,double media_x, double media_y, double xx, int cant_datos) {
		double resultado_b1 = 0;
		resultado_b1 = xy-(cant_datos*media_x*media_y);
		resultado_b1 = resultado_b1/(xx-(cant_datos*media_x*media_x));
		return resultado_b1;
	}
	
	/**
	 * Funcion para calcular el estimador B0 de la regresion
	 * @param double media_x, double media_y, double b1
	 * @return resultado_b0
	 */
	public static double obtener_B0(double media_x, double media_y, double b1) {
		double resultado_b0 = 0;
		resultado_b0 = media_y -(b1*media_x);
		return resultado_b0;
	}
	
	/**
	 * Funcion para calcular el estimador coeficiente de correlacion r
	 * @param int cant_datos, double xy ,double x, double y,double xx, double yy
	 * @return resultado_r_xy
	 */
	public static double obtener_r_xy(int cant_datos, double xy ,double x, double y,double xx, double yy) {
		double resultado_r_xy = 0;
		
		resultado_r_xy = (cant_datos*xy)-(x*y);
		resultado_r_xy = resultado_r_xy/Math.sqrt((((cant_datos*xx)-(x*x))*((cant_datos*yy)-(y*y))));

		return resultado_r_xy;
	}
	
	/**
	 * Funcion para mostrar los datos del modelo de regresion
	 * @param double b0 ,double b1, double r_xy ,double r2, double yk
	 * @return void
	 */
	public static void mostrar_datos(double b0 ,double b1, double r_xy ,double r2, double yk) {
		System.out.println("El valor de B0 es : "+b0);
		System.out.println("El valor de B1 es "+b1);
		System.out.println("El valor del coeficiente de relacion Rxy es "+r_xy);
		System.out.println("El valor del coeficiente de relacion R cuadrado es "+r2);
		System.out.println("El valor del estimador "+yk);
	}
	
}
