package ar.edu.unq.po2.tpSOLID.sistema_informatico;

public class Propiedad {
    private String descripcion;
    private String direccion;
    private float valorFiscal;

    public Propiedad(String descripcion, String direccion, float valorFiscal) {
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.valorFiscal = valorFiscal;
    }

    public float getValorFiscal() {
        return valorFiscal;
    }
}
