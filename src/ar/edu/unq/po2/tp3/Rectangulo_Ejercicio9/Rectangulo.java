package ar.edu.unq.po2.tp3.Rectangulo_Ejercicio9;

import ar.edu.unq.po2.tp3.Point;

public class Rectangulo{
	
	private Point primerEsquina;
    private Point segundaEsquina;    
    
	public Rectangulo(Point primerEsquina, Point segundaEsquina) {      
		int base = Math.abs(primerEsquina.getX() - segundaEsquina.getX());
	    int altura = Math.abs(primerEsquina.getY() - segundaEsquina.getY());
	    
        // Se evita la creacion de un rectangulo invalido
        if (base == 0 || altura == 0) {
            throw new IllegalArgumentException("Los puntos no definen un Rectangulo valido");
        }
        
		this.primerEsquina = primerEsquina;
		this.segundaEsquina = segundaEsquina;
	}

	public int getBase() {
        return Math.abs(primerEsquina.getX() - segundaEsquina.getX());
    }

    public int getAltura() {
        return Math.abs(primerEsquina.getY() - segundaEsquina.getY());
    }
	
	public int getArea() {
		return getBase() * getAltura();
	}
	
	public int getPerimetro() {
		return 2 * (getBase() + getAltura());
	}
	
	public boolean esHorizontal() {
		return getBase() > getAltura();
	}
	
	public boolean esVertical() {
		return getBase() < getAltura();
	}
}
