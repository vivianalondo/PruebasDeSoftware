package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import pruebas.ListaLigada;
import pruebas.ProgramaPS1;

/**
 * Clase para realizar los test a los métodos de la clase principal
 * @author Viviana Londoño, Oscar Lopera, Yeifer Herrera
 *
 */
public class prueba1 {
	
	
	ProgramaPS1 prog = new ProgramaPS1();
	ListaLigada list = new ListaLigada();
	
	/**
	 * Test de  verificación de ingreso de la ruta de archivo correcta.
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP1() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/1.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con una letra en sus datos
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP2() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/letra.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un espacio en blanco en sus datos
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP3() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/EspacioBlanco.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un error en el nombre ingresado.
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP4() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un error en el nombre ingresado(Nombre de archivo sin extensión)
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP5() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/nombre";
		prog.LeerArchivo(ruta);
	}
	
	
	/**
	 * Test de verificacion de archivo no existente
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP6() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/noExiste.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un error en el nombre ingresado(Archivo con una extensión diferente).
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP7() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/1.pdf";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un orden errado de sus datos
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP8() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/OrdenMal.txt";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificación de ruta de archivo incompleta.
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP9() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificación de ruta de archivo vacía.
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP10() throws IOException  {
		String ruta = "";
		prog.LeerArchivo(ruta);
	}
	
	/**
	 * Test de verificación de la extensión del archivo a procesar.
	 * @throws IOException
	 */
	//@Test
	public void verificarExtensionP11() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/1.txt";
		prog.verificarExtension(ruta);
	}
	
	/**
	 * Test de verificación de ruta de archivo vacía.
	 */
	//@Test
	public void testVerificarExtensionP12() {
		String ruta = "";
		prog.verificarExtension(ruta);
	}
	
	/**
	 * Test de verificacion de archivo existente con un error en el nombre ingresado(Archivo con una extensión diferente)
	 */
	//@Test
	public void testVerificarExtensionP13() {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/extensionDiferente.csv";
		prog.verificarExtension(ruta);
	}
	
	/**
	 * test de verificacion de archivo existente con un error en el nombre ingresado(Nombre de archivo sin extensión).
	 */
	//@Test
	public void testVerificarExtensionP14() {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/sinExtension";
		prog.verificarExtension(ruta);
	}
	
	/**
	 * Test de verificación de archivo correctamente construido pero sin información.
	 * @throws IOException
	 */
	//@Test
	public void testLeerArchivoP15() throws IOException  {
		String ruta = "C:/Users/Viviana/Desktop/Programa1v4/Programa1/src/vacia.txt";
		list = prog.LeerArchivo(ruta);
		if (list.vacia()) {
			System.out.println("El archivo se encuentra vacio");
		}
		
	}
	
	/**
	 * Test de verificación del del método para obtener la media de los datos ingresados.
	 */
	//@Test
	public void testMediaP16() {
		list = new ListaLigada();
		list.insertarNodo(1.2);
		list.insertarNodo(2);
		list.insertarNodo(3);
		list.insertarNodo(4);
		
		System.out.println(prog.Media(list));
	}
	
	/**
	 * Test de verificación del del método para obtener la media con la lista ligada vacía.
	 */
	//@Test
	public void testMediaP17() {
		list = new ListaLigada();
		System.out.println(prog.Media(list));
	}

	/**
	 * Test de verificación del del método para obtener la desviación estandar de los datos ingresados.
	 */
	//@Test
	public void testDesviacionEstandarP18() {
		list = new ListaLigada();
		list.insertarNodo(1);
		list.insertarNodo(2);
		list.insertarNodo(3);
		list.insertarNodo(4);

		System.out.println(prog.desviacionEstandar(list));
	}
	
	/**
	 * Test de verificación del del método para obtener la desviación estandar con la lista ligada vacía.
	 */
	@Test
	public void testDesviacionEstandarP19() {
		list = new ListaLigada();
		System.out.println(prog.desviacionEstandar(list));
	}

}
