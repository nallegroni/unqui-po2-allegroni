package ar.edu.unq.po2.tpComposite;

import java.util.ArrayList;

public class Ejercito implements Personaje {
    
    private ArrayList<Personaje> personajes;
    private Mapa mapa;
    private Punto ubicacionActual;

    public Ejercito(Punto ubicacionActual, Mapa mapa) {
        this.personajes = new ArrayList<Personaje>();
        this.mapa = mapa;
        this.ubicacionActual = ubicacionActual;
    }

    @Override
    public Punto getUbicacionActual() {
        return this.ubicacionActual;
    }

    public void agregarMiembro(Personaje miembro) {
        this.personajes.add(miembro);
    }

    public void removerMiembro(Personaje miembro) {
        this.personajes.remove(miembro);
    }

    @Override
    public void caminar(Punto destino) {
        for (Personaje personaje : this.personajes) {
            personaje.caminar(destino);
        }
    }

}
