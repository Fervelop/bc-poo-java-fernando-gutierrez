package abstractas;

public abstract class Service {

    // Atributos
    protected String serviceName;
    protected double baseCost;

    // Constructor
    public Service (String serviceName, double baseCost) {
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    // Metodo abstracto: Cada servicio calcula su costo independiente
    public abstract double calculateTotalCost ();

    // Metodo concreto: Mostrar informacion basica
    public void basicInfo () {
        System.out.println("Nombre del servicio: " + serviceName);
        System.out.println("Costo base: $" + baseCost);
    }

    public String getServiceName() {
        return serviceName;
    }

} // end class
