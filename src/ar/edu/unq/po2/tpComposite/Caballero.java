package ar.edu.unq.po2.tpComposite;

public class Caballero implements Personaje {

    private Punto ubicacionActual;
    private Mapa mapa;
    private boolean avanzandoLateralmente = false;

    public Caballero(Punto ubicacionInicial, Mapa mapa) {
        this.ubicacionActual = ubicacionInicial;
        this.mapa = mapa;
    }

    @Override
    public Punto getUbicacionActual() {
        return this.ubicacionActual;
    }

    @Override
    public void caminar(Punto destino) {
        System.out.println("El caballero cabalga hacia el punto " + destino);
        
        while (!this.ubicacionActual.equals(destino)) {
            Punto siguientePaso = calcularSiguientePaso(this.ubicacionActual, destino);

            this.ubicacionActual = siguientePaso;
        }
    }

    public Punto calcularSiguientePaso(Punto ubicacionActual, Punto destino) {
        
        
        int nuevaX = ubicacionActual.x;
        int nuevaY = ubicacionActual.y;

        if (this.avanzandoLateralmente) {
            if (nuevaX < destino.x) {
                nuevaX++;
            } else if (nuevaX > destino.x) {
                nuevaX--;
            }
        } else {
            if (nuevaY < destino.y) {
                nuevaY++;
            } else if (nuevaY > destino.y) {
                nuevaY--;
            }
        }

        this.avanzandoLateralmente = !this.avanzandoLateralmente;
        return new Punto(nuevaX, nuevaY);
    }

}
