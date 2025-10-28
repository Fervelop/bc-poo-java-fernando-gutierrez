public class OrdenDeReparacion {

    // Atributos

    private String numeroOrden;
    private String placa;
    private String tipoServicio;
    private double costo;
    private boolean completada;

    // Constructor

    public OrdenDeReparacion(String numeroOrden, String placaMoto, String tipoServicio, double costo) {
        this.numeroOrden = numeroOrden;
        this.placa = placa;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.completada = false; // por defecto la orden inicia sin completar
    }

    // Método void (imprime información de la orden)

    public void mostrarInformacion() {
        System.out.println("=== ORDEN DE REPARACIÓN ===");
        System.out.println("Número de Orden: " + numeroOrden);
        System.out.println("Placa de Moto: " + placa);
        System.out.println("Tipo de Servicio: " + tipoServicio);
        System.out.println("Costo: $" + costo);
        System.out.println("Estado: " + (completada ? "COMPLETADA" : "PENDIENTE"));
    }

    // Método que retorna un valor calculado
    public double aplicarDescuento(double porcentaje) {
        return costo - (costo * porcentaje / 100);
    }

    // Getter

    public String getNumeroOrden() {
        return numeroOrden;
    }

    // Setter

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}

