package pruebas;

public class Nodo {

    private double Dato;
    private Nodo Siguiente;


 Nodo(){/*Contructor 1*/
    Dato = 0;
    Siguiente = null;
 }
 Nodo(double dato){/*Constructor 2*/
     Dato = dato;
     Siguiente = null;
 }
 public void setSiguiente(Nodo X){
    Siguiente =X;
 }
 public void SetDato(double dato){
     Dato = dato;
 }
 public double getDato(){
     return Dato;
 }
 public Nodo getSiguiente(){
     return Siguiente;
 }

}
