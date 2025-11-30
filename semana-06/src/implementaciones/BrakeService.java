package implementaciones;

public class BrakeService extends Service {

    //Atributos
    private double costBrakePads; // Costo pastillas de freno
    private double costLabour; // Costo mano de obra

    //Constructor
    public BrakeService (String serviceName, double baseCost, double costBrakePads, double costLabour) {
        super(serviceName, baseCost);
        this.costBrakePads = costBrakePads;
        this.costLabour = costLabour;
    }

    //Metodo abstracto
    @Override
    public double calculateTotalCost () {
        return baseCost + costLabour + costBrakePads;
    }

} // end class
