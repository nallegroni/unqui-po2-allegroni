package ar.edu.unq.po2.tp2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
        Empresa empresa = new Empresa("TechCorp", "30-12345678-9");

        Empleado e1 = new EmpleadoPermanente("Juan Perez", "Calle 123", "Casado", LocalDate.of(1980, 5, 20), 2000, 2, 10, true);
        Empleado e2 = new EmpleadoTemporal("Ana Gomez", "Av. Siempreviva 742", "Soltera", LocalDate.of(1975, 3, 10), 1800, LocalDate.of(2025, 12, 31), 10);
        Empleado e3 = new EmpleadoContratado("Luis Lopez", "San Martín 500", "Soltero", LocalDate.of(1990, 7, 15), 1500, "C-123", "Transferencia");

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);

        System.out.println("Total Sueldos Netos: " + empresa.calcularTotalSueldosNetos());
        System.out.println("Total Sueldos Brutos: " + empresa.calcularTotalSueldosBrutos());
        System.out.println("Total Retenciones: " + empresa.calcularTotalRetenciones());

        System.out.println("\nLiquidación de Sueldos:");
        empresa.liquidarSueldos();
    }
}
