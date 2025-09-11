package ar.edu.unq.po2.tp3;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0, 0);
	}
	
	// Mueve el punto hacia las nuevas coordenadas
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Suma el punto con otro punto, sumando sus coordenadas.
	public Point add(Point point) {
		return new Point(this.x + point.x, this.y + point.y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
