package programa4;

/**
 * Clase para crear una lista ligada
 * @author Yeifer Herrera, Viviana Londoño, Oscar Lopera
 *
 */
public class ListaLigada {

	 
	private Nodo[] Cabeza = new Nodo[2];
	private int cant_datos;
   
    public ListaLigada(){/*Constructor*/
        Cabeza[0] = null;
        Cabeza[1] = null;	
        cant_datos = 0;
    }

    public boolean vacia(){
        return (Cabeza[0] == null);/*Verifies that exists in the first*/
    }

    public Nodo getPrimerNodo(){
        return Cabeza[0];
    }

    public Nodo getUltimoNodo(){
        return Cabeza[1];
    }

    public Nodo Back(Nodo X){ /*Anterior*/

        Nodo Anterior = getPrimerNodo();/*initialized on First*/

        while (Anterior.getSiguiente() != X)
        {/*Choose the back of X*/
            Anterior = Anterior.getSiguiente();/*Compare Choose the back of X*/
        }
        return Anterior;/*Return the anter*/
    }/*Fin Anterior*/


    /**
     * Método para insertar nodo en la lista
     * @param dato
     */
    public void insertarNodo(double dato){

        Nodo Last = new Nodo(dato);

        if (vacia())
        {
        	Cabeza[0] = Cabeza[1] = Last;
        }
        else
        {
        	Cabeza[1].setSiguiente(Last);
        	Cabeza[1] = Last;
        }
        cant_datos++;
    }

    /**
     * Método para buscar un nodo en la lista
     * @param dato
     * @return Nodo, Retorna el nodo que se buscó
     */
    public Nodo buscarNodo(double dato){ /*Buscar*/

        Nodo X = getPrimerNodo();/*Llevamos a X el primer Nodo */
        while ((X != null) && (X.getDato() != dato)) { /*Hasta igualar datos*/
            X = X.getSiguiente();/*Avanzamos alsiguiente */
		 }
		if (X == null){
				System.out.println("El dato no fuï¿½ encontrado");
		   	 }
		return X; /*Retornamos resultado de la bï¿½squeda */
		    }/*Fin Buscar*/

    /**
     * Método para eliminar un nodo de la lista
     * @param dato
     */
	public void Delete(double dato){ /*Eliminar*/
		Nodo Anterior;
		Nodo X;
		
		if(vacia()){
		System.out.println("La lista estï¿½ vacia");
		return;
		}
		
		X= buscarNodo(dato);
		
		if(X==null){
		System.out.println("El dato no existe");
		}
		
		
		if (X == getPrimerNodo())
		    {/*Es el primero!*/
		
			Cabeza[0] = Cabeza[0].getSiguiente();/*El primero se remplaza por el siguiente*/
		        /*"Ha sido eliminado el primero"*/
		        if (Cabeza[0] == null)
		        {/*Si solo existe un dato*/
		        	Cabeza[1] = null;
		        }
		    }
		    else
		    {/*Si NO es el primero!*/
		        Anterior = Back(X);/*Llevamos el anterior de X*/
		        Anterior.setSiguiente(X.getSiguiente());/*Enlazamos con el siguiente de X */
		        /*El Nodo X se desconecta de la lista*/
		        if (X == Cabeza[1])
		        {
		        	Cabeza[1] = Anterior;/*Anterior tendrï¿½ como Siguiente NULL*/
		        }
		    }
		if (cant_datos>0) {
			cant_datos--;
		}

	
	}

	/**
	 * Método para obtener la cantidad de datos
	 * @return
	 */
	public int getCant_datos() {
		return cant_datos;
	}

}
