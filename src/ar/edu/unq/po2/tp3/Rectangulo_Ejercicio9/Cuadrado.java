package ar.edu.unq.po2.tp3.Rectangulo_Ejercicio9;

import ar.edu.unq.po2.tp3.Point;

public class Cuadrado extends Rectangulo {

	public Cuadrado(Point primerEsquina, int lado) {
		super(primerEsquina, new Point(primerEsquina.getX() + lado, primerEsquina.getY() + lado));
	}

}
