package ar.edu.unq.po2.tpTemplateMethod.Sueldos_recargado;

public class EmpleadoPasante extends Empleado{

    private final double pagoPorHora = 40;

    public EmpleadoPasante(int horasTrabajadas, boolean esCasado, int cantidadHijos) {
        super(horasTrabajadas, false, 0);
    }

    @Override
    public double calcularSueldoBruto() {
        double sueldoPorHoras = this.getHorasTrabajadas() * this.pagoPorHora;

        return sueldoPorHoras;
    }
}
