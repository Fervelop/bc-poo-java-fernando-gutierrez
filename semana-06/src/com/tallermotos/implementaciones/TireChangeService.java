package com.tallermotos.implementaciones;
import com.tallermotos.abstractas.*;
import com.tallermotos.interfaces.*;

public class TireChangeService extends Service implements TimeTrackable, Repairable { // Clase cambio de llantas

    private double costPerTire; // Costo por llanta
    private int numberOfTires; // Numero de llantas
    private String startTime; // Hora de inicio
    private String endTime; // Hora de fin
    private int hoursWorked; // Horas trabajadas
    private double costLabour; // Costo de mano de obra

    // Constructor
    public TireChangeService(String serviceName, double baseCost, double costPerTire, int numberOfTires, double costLabour) {
        super(serviceName, baseCost);
        this.costPerTire = costPerTire;
        this.numberOfTires = numberOfTires;
        this.costLabour = costLabour;
    }
    // TimeTrackable methods
    @Override
    public void startJob() {
        startTime = "10:00 AM";
        System.out.println("Trabajo iniciado a las " + startTime);
    }

    @Override
    public void finishJob() {
        endTime = "12:00 PM";
        hoursWorked = 2; // Suponiendo que el trabajo tomo 2 horas
        System.out.println("Trabajo finalizado a las " + endTime);
    }

    @Override
    public int durationJob() {
        return this.hoursWorked; // Devuelve las horas trabajadas
    }
    // Repairable methods
    @Override
    public boolean requireParts() {
        return true; // Siempre requiere llanta
    }

    @Override
    public double calculateCostParts() {
        return (numberOfTires * costPerTire);
    }

    @Override
    public String diagnosticateFault() {
        return "El vehiculo no presenta fallas, solo se realiza el cambio de llantas.";
    }

    @Override
    public double calculateTotalCost() {
        return (costPerTire * numberOfTires) + costLabour + baseCost;
    }
}
