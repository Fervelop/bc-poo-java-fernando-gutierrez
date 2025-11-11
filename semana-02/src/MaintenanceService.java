public class MaintenanceService {

    //Atributos
    private final String typeService; // Ej: "Cambio de aceite", "Frenos", "Llantas"
    private Mechanic mechanic;  // Nombre del mecanico que hace el servicio (clase secundaria de mecanico)
    private double costBase;    // Precio inicial del servicio
    private int workingTime;    // Cantidad de horas de mano de obra
    private boolean finalized;      // Estado del servicio
    private int serviceId;          // Id de los servicios

    //Constructor
    public MaintenanceService(String typeService,Mechanic mechanic, double costBase, int workingTime, int serviceId) {
        this.typeService = typeService;
        this.mechanic = mechanic;
        this.costBase = costBase;
        this.workingTime = workingTime;
        this.finalized = false;
        this.serviceId = serviceId;
    }

    // Metodo: Mostrar informacion del servicio
    public void showInformation () {
        System.out.println("=== SERVICIO DE MANTENIMIENTO ===");
        System.out.println("Tipo de servicio: " + typeService);
        System.out.println("Mecanico: " + mechanic.getNameMechanic() + "(Especialidad: " + mechanic.getSpecialization() + ")");
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
    public int getServiceId() {
        return serviceId;
    }
    public boolean getIsFinalized() {
        return finalized;
    }
    public Mechanic getMechanic() {
        return mechanic;
    }

    // Setter
    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }



} // end class
