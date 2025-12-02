package com.tallermotos.servicio;
import com.tallermotos.modelo.*;
import java.util.ArrayList;

public class GestorTallerMotos {

    // ArrayLists para almacenar objetos
    private ArrayList<Mechanic> mechanics;
    private ArrayList<MaintenanceService> services;

    // Constructor
    public GestorTallerMotos() {
        this.mechanics = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    // METODO 1: Agrega un nuevo mecánico al sistema.
    public boolean addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
        System.out.println("Mecánico " + mechanic.getNameMechanic() + " agregado exitosamente.");
        return true;
    }

    // METODO 2: Busca una orden de mantenimiento por su ID.
    public MaintenanceService searchServiceId(int idService) {
        for (MaintenanceService service : services) {
            if (service.getServiceId() == idService) {
                return service;
            }
        }
        return null; // No encontrado
    }

    // METODO 3: Lista todos los mecánicos registrados y su estado actual.
    public void listMechanics() {
        System.out.println("\n=== LISTA DE PERSONAL (Mecánicos) ===");
        if (mechanics.isEmpty()) {
            System.out.println("No hay mecánicos registrados.");
            return;
        }

        for (int i = 0; i < mechanics.size(); i++) {
            Mechanic mech = mechanics.get(i);
            System.out.println((i + 1) + ". " + mech.getNameMechanic() +
                    " [" + mech.getSpecialization() +
                    "] - Disponible: " + (mech.isAvailable() ? "SÍ" : "NO"));
        }
    }

    // METODO 4: Cuenta cuántas órdenes de trabajo están actualmente 'En Proceso'.
    public int countServiceInProcess() {
        int inProcess = 0;
        for (MaintenanceService service : services) {
            if (!service.getIsFinalized()) {
                inProcess++;
            }
        }
        return inProcess;
    }

    // METODO 5: Asigna una orden de mantenimiento a un mecánico disponible y actualiza sus estados.
    public boolean addService(MaintenanceService orden, int mechanicId) {
        // 1. Agregar la orden al sistema
        services.add(orden);

        // 2. Buscar y verificar la disponibilidad del mecánico
        Mechanic mechanicAsigned = null;
        for (Mechanic mech : mechanics) {
            if (mech.getId() == mechanicId) {
                mechanicAsigned = mech;
                break;
            }
        }

        if (mechanicAsigned == null) {
            System.out.println("✗ ERROR: Mecánico con ID " + mechanicId + " no encontrado.");
            return false;
        }

        if (!mechanicAsigned.isAvailable()) {
            System.out.println("✗ ERROR: El mecánico " + mechanicAsigned.getNameMechanic() + " está ocupado.");
            return false;
        }

        // 3. Realizar la asignación y actualizar estados
        mechanicAsigned.assignJob(); // Pone al mecánico como NO disponible
        orden.setMechanic(mechanicAsigned); // Asigna el objeto com.tallermotos.modelo.Mechanic a la Orden
        orden.setFinalized(false); // Actualiza el estado de la orden

        System.out.println("\n✓ ORDEN " + orden.getServiceId() + " ASIGNADA a " + mechanicAsigned.getNameMechanic());
        return true;
    }

    // Getters para el total de objetos
    public int getTotalMechanics() {
        return mechanics.size();
    }

    public int getTotalServices() {
        return services.size();
    }
}