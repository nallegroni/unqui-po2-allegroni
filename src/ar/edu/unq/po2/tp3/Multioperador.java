package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Multioperador {
	
	
	public int sumar(ArrayList<Integer> numeros) {
		int suma = 0;
		for (int numero : numeros) {
			suma += numero;
		}
		return suma;
	}
	
	public int restar(ArrayList<Integer> numeros) {
		if (numeros.isEmpty()) return 0;
		int resta = numeros.getFirst();
		for (int i = 1; i < numeros.size(); i++) {
			resta -= numeros.get(i);
		}
		return resta;
		/*
		[34,5,78,91]  size = 4
		 
		resta = 34		index 0
		empieza el for
		resta -= 5		index 1 
		resta -= 78		index 2
		resta -= 91		index 3
		*/
	}
	
	public int multiplicar(ArrayList<Integer> numeros) {
		if (numeros.isEmpty()) return 0;
		int multiplicacion = 1;
		for (int n : numeros) {
			multiplicacion *= n;
		}
		return multiplicacion;
	}

}
