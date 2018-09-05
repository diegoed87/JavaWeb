package com.asesoftware.pruebapiloto.pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	
	static Calculadora calc;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass()");
		calc = new Calculadora();
	}

	@Before
	public void before(){
		System.out.println("before()");
		calc.clear();
	}
	
	@After
	public void after(){
		System.out.println("After");
		calc.clear();
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass()");
	}
	
	@Test
	public void testSumar(){
		System.out.println("sumar()");
		int resultado = calc.sumar(2, 3);
		int esperado = 5;
		assertEquals("Suma no coincide", esperado, resultado);
	
	}
	
	@Test
	public void testRestar(){
		System.out.println("restar()");
		int resultado = calc.restar(3, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDividir(){
		System.out.println("dividir()");
		int resultado = calc.dividir(3, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDividirCero(){
		System.out.println("dividirCero()");
		int resultado = calc.dividir(3, 0);
		int esperado = 1;
		assertEquals(esperado, resultado);
		}
	
	@Test(timeout=3000)
	public void testMetodoOptimo(){
		calc.metodoOptimo();
	}
}
