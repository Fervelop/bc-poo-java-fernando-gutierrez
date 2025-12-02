package com.tallermotos.interfaces;

public interface Repairable {

    boolean requireParts(); // Indica si se requieren piezas para la reparacion
    double calculateCostParts(); // Calcula el costo de las piezas necesarias
    String diagnosticateFault (); // Diagnostica la falla del vehiculo

}
