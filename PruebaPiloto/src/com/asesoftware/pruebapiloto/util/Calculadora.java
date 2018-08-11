package com.asesoftware.pruebapiloto.util;

public class Calculadora {
	//Variables de instancia
	private int memoria;
	// Constructor
	public Calculadora(){
		memoria=0;
	}
	//Metodo sumar
	public int sumar(int a, int b){
		memoria= a+b;
		return memoria;
	}
	//Metodo restar
	public int restar(int a, int b){
		memoria= a-b;
		return memoria;
	}
	//Metodo add
	public int add(int vlr){
		memoria+=vlr;
		return memoria;
	}
	//Metodo sub
	public int sub(int vlr){
		memoria-=vlr;
		return memoria;
	}
	//Getter
	public int getMemoria(){
		return memoria;
	}
	//Metodo clear
	public void clear(){
		memoria=0;
	}
	//Metodo multiplicar
	public int multiplicar(int a, int b){
		memoria= a*b;
		return memoria;
	}
	//Metodo divididr
	public int dividir(int a, int b){
		if(b==0){
			throw new ArithmeticException("No es posible dividir entre cero");
		}
		memoria= a/b;
		return memoria;
	}
	
	public void metodoOptimo() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
