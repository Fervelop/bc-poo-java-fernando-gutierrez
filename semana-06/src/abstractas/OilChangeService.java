package abstractas;

public class OilChangeService extends Service {

    //Atributos
    private double oilPrice;

    //Costructor
    public OilChangeService (String serviceName, double costBase, double oilPrice) {
        super(serviceName, costBase);
        this.oilPrice = oilPrice;
    }

    // Metodo abstracto
    @Override
    public double calculateTotalCost() {
        return baseCost + oilPrice;
    }
}
 // end class
