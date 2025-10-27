package ar.edu.unq.po2.tpComposite;

public class Mapa {
    
    private boolean[][] lajasColocadas;

    public Mapa(int ancho, int alto) {
        this.lajasColocadas = new boolean[ancho][alto];
    }

    // El Ingeniero usará esto para "leer" el mapa
    public boolean hayLajaEn(Punto p) {
        return this.lajasColocadas[p.x][p.y];
    }

    // El Ingeniero usará esto para "escribir" en el mapa
    public void colocarLajaEn(Punto p) {
        this.lajasColocadas[p.x][p.y] = true;
    }
}
