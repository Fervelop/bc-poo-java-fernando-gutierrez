public class MaintenanceService {

    //Atributos
    private final String typeService; // Ej: "Cambio de aceite", "Frenos", "Llantas"
    private Mechanic mechanic;  // Nombre del mecanico que hace el servicio (clase secundaria de mecanico)
    private double costBase;    // Precio inicial del servicio
    private int workingTime;    // Cantidad de horas de mano de obra
    private boolean finalized;      // Estado del servicio
    private int serviceId;          // Id de los servicios
    private Client client;


    //Constructor
    public MaintenanceService(String typeService,Mechanic mechanic, double costBase, int workingTime, int serviceId) {
        this.typeService = typeService;
        this.mechanic = mechanic;
        this.costBase = costBase;
        this.workingTime = workingTime;
        this.finalized = false;
        this.serviceId = serviceId;
    }
    // Constructor básico (llama al completo)
    public MaintenanceService(String typeService, Mechanic mechanic, double costBase, int workingTime) {
        this(typeService, mechanic, costBase, workingTime, 1);
    }

    // Constructor minimo
    public MaintenanceService(Mechanic mechanic, double costBase, int workingTime) {
        this("Sin servicio especificado", mechanic, costBase, workingTime, 1);
    }


    // Metodo: Mostrar informacion del servicio
    public void showInformation () {
        System.out.println("=== SERVICIO DE MANTENIMIENTO ===");
        System.out.println("Tipo de servicio: " + typeService);
        System.out.println("Mecanico: " + mechanic.getName() + "(Especialidad: " + mechanic.getSpecialization() + ")");
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
    public double getCostBase() {return this.costBase;}
    private int getWorkingTime (){return this.workingTime;}
    public Client getClient() {return client;}


    // Setter
    public void setFinalized(boolean finalized) {
        if (finalized && this.mechanic == null) {
            throw new IllegalStateException(
                    "No se puede finalizar el servicio porque no hay un mecánico asignado."
            );
        }
        this.finalized = finalized;
    }
    public void setMechanic(Mechanic mechanic) {
        if (mechanic == null) {
            throw new IllegalArgumentException("El mecánico no puede ser null.");
        }
        this.mechanic = mechanic;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    // Metodo auxiliar privado

    private boolean validarMechanic(Mechanic mechanic) {
        return mechanic != null;
    }


} // end class
