package com.asesoftware.pruebapiloto.util;

public class Calculadora {

private int memoria;
	
	public Calculadora() {
		memoria = 0;
	}
	
	public int sumar(int a, int b) {
		memoria =  a+b;
		return memoria;
	} 
	
	public int restar(int a, int b) {
		memoria = a - b;
		return memoria;
	}
	
	public int dividir(int a, int b) {
		if (b==0) {
			throw new ArithmeticException("No es posible dividir entre cero");
		}
		memoria = a/b;
		return memoria;
	}
	
	public int add(int valor) {
		memoria += valor;
		return memoria;
	}
	
	public int sub(int valor) {
		memoria -= valor;
		return memoria;
	}
	
	public int memoria() {
		return memoria;
	}
	
	public void clear() {
		memoria = 0;
	}
	
	public void metodoOptimo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
