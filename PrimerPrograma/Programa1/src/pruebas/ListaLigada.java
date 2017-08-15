package pruebas;

public class ListaLigada {

	 
	private Nodo[] Cabeza = new Nodo[2];
   
    public ListaLigada(){/*Constructor*/
        Cabeza[0] = null;
        Cabeza[1] = null;	
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


    public void insertarNodo(double dato){ /*Insertar al Final*/

        Nodo Last = new Nodo(dato);

        if (vacia())
        {
        	Cabeza[0] = Cabeza[1] = Last;/*The new Nodo is the last and first*/
        }
        else
        {
        	Cabeza[1].setSiguiente(Last);
        	Cabeza[1] = Last;
        }
    }/*Fin Insertar al Final*/

    
    public Nodo buscarNodo(double dato){ /*Buscar*/

        Nodo X = getPrimerNodo();/*Llevamos a X el primer Nodo */
        while ((X != null) && (X.getDato() != dato)) { /*Hasta igualar datos*/
            X = X.getSiguiente();/*Avanzamos alsiguiente */
		 }
		if (X == null){
				System.out.println("El dato no fué encontrado");
		   	 }
		return X; /*Retornamos resultado de la búsqueda */
		    }/*Fin Buscar*/

	public void Delete(double dato){ /*Eliminar*/
		Nodo Anterior;
		Nodo X;
		
		if(vacia()){
		System.out.println("La lista está vacia");
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
		        	Cabeza[1] = Anterior;/*Anterior tendrá como Siguiente NULL*/
		        }
		    }


	
}
}
