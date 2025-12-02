package com.tallermotos.implementaciones;
import com.tallermotos.abstractas.*;

public class OilChangeService extends Service {

    //Atributos
    private double oilPrice;

    //Constructor
    public OilChangeService (String serviceName, double baseCost, double oilPrice) {
        super(serviceName, baseCost);
        this.oilPrice = oilPrice;
    }

    // Metodo abstracto
    @Override
    public double calculateTotalCost() {
        return baseCost + oilPrice;
    }
}
 // end class
