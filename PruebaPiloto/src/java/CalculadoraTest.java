package java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	//Variables de instancia
	static Calculadora calc;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass()");
		calc = new Calculadora();
		
	}
	//Before: inicializar
	@Before
	public void before(){
		System.out.println("before");
		
	}
	

	@Test
	public void testSumar() {
		System.out.println("sumar");
		int res=calc.sumar(2, 3);
		int esperado=5;
		assertEquals("Suma no coincide",esperado, res);
		
	}
	
	@Test
	public void testRestar() {	
		System.out.println("restar");
		int res=calc.restar(3, 2);
		int esperado=1;
		assertEquals(esperado, res);
	}
	
	@Test
	public void testDividir() {	
		System.out.println("dividir");
		int res=calc.dividir(3, 2);
		int esperado=1;
		assertEquals(esperado, res);
	}
	
	//test puede recibir el par�metro expected que busca clases dentro de java
	@Test(expected=ArithmeticException.class)
	public void testDividirCero() {	
		System.out.println("dividir cero");
		calc.dividir(3, 0);
		//int esperado=1;
		//assertEquals(esperado, res);
	}
	
	@Test(timeout=1000)
	public void testMetodoOptimo(){
		calc.metodoOptimo();
	}
	
	//After: reinicio, eliminar o incluir algo
	@After
	public void after(){
		System.out.println("after");
		calc.clear();
		
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass()");
		
	}

}
