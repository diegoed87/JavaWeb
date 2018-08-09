package com.asesoftware.pruebapiloto.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.asesoftware.pruebapiloto.util.Calculadora;


public class PruebaCalculadora {


	static Calculadora calc;
	
	/*
	 * Inicializar
	 */
	@Before
	public void before() {
		System.out.println("Before()");
		calc.clear();
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass()");
		calc = new Calculadora();
	}
	
	/*
	 * Reinicio, limpiar, eliminar
	 */
	@After
	public void after() {
		System.out.println("After()");
		calc.clear();
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass()");
	}
	

	@Test
	public void testSumar() {
		System.out.println("Sumar()");
		int res = calc.sumar(2, 3);
		int esperado = 5;
		assertEquals("Suma no coincide",esperado, res);
	}
	
	@Test
	public void testResar() {
		System.out.println("Restar()");
		int res = calc.restar(3, 2);
		int esperado = 1;
		assertEquals(esperado, res);
	}
	
	@Test
	public void testDividir() {
		System.out.println("Dividir()");
		int res = calc.dividir(3, 2);
		int esperado = 1;
		assertEquals(esperado, res);
	}
	/*
	 * Test puede recibir un parametro expected que busca la clase de la Excepcion
	 */
	@Test(expected=ArithmeticException.class)
	public void testDividirCero() {
		System.out.println("Dividir()");
		int res = calc.dividir(3, 0);
		int esperado = 1;
		assertEquals(esperado, res);
	}
	
	@Test(timeout=2000)
	public void testMetodoOptimo() {
		calc.metodoOptimo();
	}

}
