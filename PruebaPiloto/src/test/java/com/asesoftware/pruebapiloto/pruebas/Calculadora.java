package com.asesoftware.pruebapiloto.pruebas;
public class Calculadora {
    
	private int memoria;
	
	public Calculadora(){
		memoria=0;
	}
       
	public int sumar(int a, int b){
              memoria = a+b;
              return memoria;
       }
       
       public int restar(int a, int b){
           memoria = a-b;
           return memoria;
       }
       
       public int dividir(int a, int b){
    	   if (b == 0){
    		   throw new ArithmeticException("No es posible divir entre cero");
    	   }
    	   memoria = a / b;
    	   return memoria;
    	   
       }
       
       public int add(int vlr){
    	   memoria += vlr;
    	   return memoria;
       }
       
       public int sub(int vlr){
    	   memoria -= vlr;
    	   return memoria;
       }
       
       public int memoria(){
    	   return memoria;
       }
       
       public void clear(){
    	   memoria = 0;
       }
       
       public void metodoOptimo(){
    	  try {Thread.sleep(2000);
    	  }catch (InterruptedException e){
    		  e.printStackTrace();
    	  }
       }
}
