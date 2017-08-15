package pruebas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que contiene los métodos y el main del programa
 * @author Viviana Londoño, Oscar Lopera, Yeifer Herrera
 *
 */
public class ProgramaPS1 {


	/**
	 * Main del programa
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
	// TODO Auto-generated method stub
		ListaLigada datos = new ListaLigada(); 
		System.out.println ("Empezamos el programa de pruebas de software");
        System.out.println ("Por favor introduzca la ruta donde estÃ¡ ubicado el archivo con los numero:");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //CreaciÃ³n de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un mÃ©todo sobre un objeto Scanner
        datos = LeerArchivo(entradaTeclado);
        if (datos.vacia() ) {
			System.out.println("El archivo estÃ¡ vacÃ­o.");
		}else{
			System.out.println("la media es "+Media(datos));
			System.out.println("la desviacion estandar es "+ desviacionEstandar(datos));
		}
       
	}
	
	/**
	 * Método para leer el archivo a ejecutar, y guardar los datos en una lista enlazada
	 * @param archivo
	 * @return ListaLigada, retorna una lista ligada con los datos leidos del archivo
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
	  			System.out.println("404..No se ha encontrado el archivo");
	  		}
	  	    }else{
	  	    	System.out.println("No se leyo el archivo");
	  	    	
	  	    }
		} else {
			System.out.println("Direccion de archivo muy corta o invalida");
			System.exit(0);
		}
	    	    return lista;  
	}
	
	/**
	 * Método para verificar que el archivo a procesar contenga la extensión correcta
	 * @param ruta
	 * @return boolean true o false, retorna true si la extensión es correcta, o false en caso contrario
	 */
	public static boolean verificarExtension(String ruta){
		
		if (ruta.length()<4) {
			System.out.println("Error con la ruta o nombre del archivo");
			System.exit(0);
		}
			String extension = ruta.substring((ruta.length()-4),ruta.length());
			//Verificar extension del archivo
			if (!extension.equals(".txt")) {
				System.out.println("La extensión del archivo no es correcta");
				return false;
			}
			System.out.println("La extension es correcta. ");
			return true;
			
		
	}
	
	/**
	 * Método para encontrar la media de los valores
	 * @param lista
	 * @return media, retorna un double con el valor de la media
	 */
	public static double Media(ListaLigada lista) {
		double suma = 0;
		int contador = 0;
		double media = 0;
  	    Nodo nodo = lista.getPrimerNodo();/*initialized on First*/
  	    
  	    do {    	
  	    	suma=suma+nodo.getDato();
  	    		contador++;
  	    		nodo = nodo.getSiguiente();/*Compare Choose the back of X*/	

  		} while (nodo != null);
  	    media = suma/contador;
		return media;
		
	}
	
	/**
	 * Método para encontrar la desviación estandar de los valores
	 * @param lista
	 * @return suma, retorna el resultado de la desviación estandar
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
	

	
}
