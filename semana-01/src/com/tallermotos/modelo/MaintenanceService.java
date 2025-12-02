package com.tallermotos.modelo;

public class MaintenanceService {

    //Atributos
    private String typeService; // Ej: "Cambio de aceite", "Frenos", "Llantas"
    private String mechanicName;  // Nombre del mecanico que hace el servicio
    private double costBase;    // Precio inicial del servicio
    private int workingTime;    // Cantidad de horas de mano de obra
    private boolean finalized;      // Estado del servicio

    //Constructor
    public MaintenanceService(String typeService,String mechanicName, double costBase, int workingTime) {
        this.typeService = typeService;
        this.mechanicName = mechanicName;
        this.costBase = costBase;
        this.workingTime = workingTime;
        this.finalized = finalized;
    }

    // Metodo: Mostrar informacion del servicio
    public void showInformation () {
        System.out.println("=== SERVICIO DE MANTENIMIENTO ===");
        System.out.println("Tipo de servicio: " + typeService);
        System.out.println("Mecanico: " + mechanicName);
        System.out.println("Costo base: $" + costBase);
        System.out.println("Horas de trabajo: " + workingTime);
        System.out.println("Estado: " + (finalized ? "FINALIZADO" : "EN PROCESO"));
    }

    // Metodo que retorna un valor calculado
    // Calcula el costo total incluyendo mano de obra ($20,000 por hora)
    public double calculateTotalCost() {
        double laborCost = workingTime * 20000; // costo mano de obra
        return costBase + laborCost;
    }

    //Getter
    public String getTypeService() {
        return typeService;
    }

    // Setter
    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }



} // end class
