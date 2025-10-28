public class Main {
    public static void main(String[] args) {
        // Crear 5 órdenes de reparación
        OrdenDeReparacion orden1 = new OrdenDeReparacion("MOT-001", "ABC123", "Cambio de Aceite", 50000);
        OrdenDeReparacion orden2 = new OrdenDeReparacion("MOT-002", "DEF456", "Reparación de Frenos", 80000);
        OrdenDeReparacion orden3 = new OrdenDeReparacion("MOT-003", "GHI789", "Cambio de Llantas", 120000);
        OrdenDeReparacion orden4 = new OrdenDeReparacion("MOT-004", "JKL012", "Revisión General", 70000);
        OrdenDeReparacion orden5 = new OrdenDeReparacion("MOT-005", "MNO345", "Cambio de Cadena", 60000);

        // Mostrar información de cada orden
        orden1.mostrarInformacion();
        System.out.println("Costo con descuento 10%: $" + orden1.aplicarDescuento(10));
        System.out.println();

        orden2.mostrarInformacion();
        System.out.println("Costo con descuento 5%: $" + orden2.aplicarDescuento(5));
        System.out.println();

        orden3.mostrarInformacion();
        System.out.println("Costo con descuento 15%: $" + orden3.aplicarDescuento(15));
        System.out.println();

        orden4.mostrarInformacion();
        System.out.println("Costo con descuento 0%: $" + orden4.aplicarDescuento(0));
        System.out.println();

        orden5.mostrarInformacion();
        System.out.println("Costo con descuento 20%: $" + orden5.aplicarDescuento(20));
        System.out.println();

        // Marcar algunas órdenes como completadas
        orden1.setCompletada(true);
        orden3.setCompletada(true);

        System.out.println("=== ESTADO FINAL DE ÓRDENES ===");
        orden1.mostrarInformacion();
        orden2.mostrarInformacion();
        orden3.mostrarInformacion();
        orden4.mostrarInformacion();
        orden5.mostrarInformacion();
    }
}
