package ar.edu.unq.po2.tpComposite;

public class Ingeniero implements Personaje {

    private Punto ubicacionActual;
    private Mapa mapa;
    private int lajas;

    public Ingeniero(Punto ubicacionInicial, Mapa mapa, int lajas) {
        this.ubicacionActual = ubicacionInicial;
        this.mapa = mapa;
        this.lajas = lajas;
    }

    @Override
    public Punto getUbicacionActual() {
        return this.ubicacionActual;
    }

    @Override
    public void caminar(Punto destino) {
        System.out.println("El ingeniero camina hacia el punto " + destino);

        while (!this.ubicacionActual.equals(destino)) {
            Punto siguientePaso = calcularSiguientePaso(this.ubicacionActual, destino);
            
            if (!this.mapa.hayLajaEn(siguientePaso) && this.lajas > 0) {
                this.mapa.colocarLajaEn(siguientePaso);
                this.lajas--;
                System.out.println("El ingeniero coloca una laja en " + siguientePaso + ". Lajas restantes: " + this.lajas);
            }

            this.ubicacionActual = siguientePaso;
        }
    }

    public Punto calcularSiguientePaso(Punto ubicacionActual, Punto destino) {
        int nuevaX = ubicacionActual.x;
        int nuevaY = ubicacionActual.y;

        if (nuevaX < destino.x) {
            nuevaX++;
        } else if (nuevaX > destino.x) {
            nuevaX--;
        }

        if (nuevaY < destino.y) {
            nuevaY++;
        } else if (nuevaY > destino.y) {
            nuevaY--;
        }

        return new Punto(nuevaX, nuevaY);
    }

    public int getLajasRestantes() {
        return this.lajas;
    }

}
