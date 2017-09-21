package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import pruebas.ListaLigada;
import pruebas.ProgramaPS3;

public class prueba1 {
	
	
	ProgramaPS3 prog = new ProgramaPS3();
	ListaLigada list = new ListaLigada();
	
	
	//@Test
	public void testLeerArchivoP1() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/1.txt";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP2() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/letra.txt";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP3() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/EspacioBlanco.txt";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP4() throws IOException  {
		String ruta = ".txt";
		prog.LeerArchivo(ruta);
	}
	//@Test
	public void testLeerArchivoP5() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/nombre";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP6() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/noExiste.txt";
		prog.LeerArchivo(ruta);
	}
	//@Test
	public void testLeerArchivoP7() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/1.pdf";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP8() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/OrdenMal.txt";
		prog.LeerArchivo(ruta);
	}
	//@Test
	public void testLeerArchivoP9() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testLeerArchivoP10() throws IOException  {
		String ruta = "";
		prog.LeerArchivo(ruta);
	}
	//@Test
	public void testLeerArchivoP11() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/1.txt";
		prog.LeerArchivo(ruta);
	}
	
	//@Test
	public void testVerificarExtensionP12() {
		String ruta = "";
		prog.verificarExtension(ruta);
	}
	//@Test
	public void testVerificarExtensionP13() {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/rutaDiferente.csv";
		prog.verificarExtension(ruta);
	}
	//@Test
	public void testVerificarExtensionP14() {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/sinExtension";
		prog.verificarExtension(ruta);
	}
	
	//@Test
	public void testLeerArchivoP15() throws IOException  {
		String ruta = "C:/Users/yeiferh/workspace/Programa1/src/vacia.txt";
		prog.LeerArchivo(ruta);
	}
	
	@Test
	public void testMediaP16() {
		list = new ListaLigada();
		list.insertarNodo(1.2);
		list.insertarNodo(2);
		list.insertarNodo(3);
		list.insertarNodo(4);
		
		System.out.println(prog.Media(list));
	}
	
	//@Test
	public void testMediaP17() {
		list = new ListaLigada();
		System.out.println(prog.Media(list));
	}

	//@Test
	public void testDesviacionEstandarP18() {
		list = new ListaLigada();
		list.insertarNodo(1);
		list.insertarNodo(2);
		list.insertarNodo(3);
		list.insertarNodo(4);

		System.out.println(prog.desviacionEstandar(list));
	}
	
	//@Test
	public void testDesviacionEstandarP19() {
		list = new ListaLigada();
		System.out.println(prog.desviacionEstandar(list));
	}

}
