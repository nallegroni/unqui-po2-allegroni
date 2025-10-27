package ar.edu.unq.po2.tpComposite;

import java.util.Objects;

public class Punto {
    protected int x;
    protected int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // 1. ¿Somos el mismo objeto en memoria?
        if (this == obj) {
            return true;
        }
        
        // 2. ¿Es nulo o de una clase diferente?
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // 3. Convertimos (cast) el objeto y comparamos los campos
        Punto punto = (Punto) obj;
        return this.x == punto.x && this.y == punto.y;
    }

    @Override
    public int hashCode() {
        // Usa la utilidad de Java para generar un hash basado en los campos.
        return Objects.hash(x, y);
    }
    
}
