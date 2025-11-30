package com.tallermotos.servicio;

import com.tallermotos.excepciones.MechanicNotAvailable;
import com.tallermotos.excepciones.MechanicNotFound;
import com.tallermotos.modelo.Client;
import com.tallermotos.modelo.MaintenanceService;
import com.tallermotos.modelo.Mechanic;
import com.tallermotos.modelo.Person;

import java.util.ArrayList;

public class GestorTallerMotos {

    // ArrayLists para almacenar objetos
    private ArrayList<Mechanic> mechanics;
    private ArrayList<MaintenanceService> services;
    private ArrayList<Person> persons;

    // Constructor
    public GestorTallerMotos() {
        this.mechanics = new ArrayList<>();
        this.services = new ArrayList<>();
        this.persons = new ArrayList<>();
    }

    // METODO 1: Agrega un nuevo mecánico al sistema.
    public boolean addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
        System.out.println("Mecánico " + mechanic.getName() + " agregado exitosamente.");
        return true;
    }

    // METODO 2: Busca una orden de mantenimiento por su ID.
    public MaintenanceService searchServiceId(int idService) {
        try {
            if (idService <= 0) {
                // Simulamos un error de dato de entrada no válido antes de la búsqueda
                throw new IllegalArgumentException("El ID del servicio debe ser positivo.");
            }

            for (MaintenanceService service : services) {
                if (service.getServiceId() == idService) {
                    return service;
                }
            }

            // Si el bucle termina sin encontrar nada
            System.out.println("⚠ Advertencia: Servicio con ID " + idService + " no encontrado.");
            return null; // No encontrado

        } catch (IllegalArgumentException e) {
            System.err.println("❌ ERROR de Búsqueda: " + e.getMessage());
            return null;
        }
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
            System.out.println((i + 1) + ". " + mech.getName() +
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

    /**
     * METODO 5: Asigna una orden de mantenimiento a un mecánico disponible y actualiza sus estados.
     * * Este metodo busca al mecánico por ID, verifica su disponibilidad y, si todo es correcto,
     * asigna la orden y actualiza el estado del mecánico y del servicio.
     * * @param orden La orden de mantenimiento a asignar.
     * @param mechanicId El ID del mecánico al que se intentará asignar.
     * @return true si la asignación fue exitosa.
     * @throws com.tallermotos.excepciones.MechanicNotFound Si el ID del mecánico no existe en el sistema.
     * @throws com.tallermotos.excepciones.MechanicNotAvailable Si el mecánico existe pero no está disponible.
     */
    public boolean addService(MaintenanceService orden, int mechanicId)
            throws MechanicNotFound, MechanicNotAvailable {

        // Agregamos la orden primero. Si falla, se debe remover para mantener la integridad.
        services.add(orden);

        // 1. Buscar el mecánico
        Mechanic mechanicAsigned = null;
        for (Mechanic mech : mechanics) {
            if (mech.getId() == mechanicId) {
                mechanicAsigned = mech;
                break;
            }
        }

        // 2. Verificar existencia y lanzar la excepción personalizada
        if (mechanicAsigned == null) {
            services.remove(orden); // Limpieza: Si falla, la orden no debe permanecer
            throw new MechanicNotFound("Mecánico con ID " + mechanicId + " no encontrado. Imposible asignar la orden.");
        }

        // 3. Verificar disponibilidad y lanzar la excepción personalizada
        if (!mechanicAsigned.isAvailable()) {
            services.remove(orden); // Limpieza: Si falla, la orden no debe permanecer
            throw new MechanicNotAvailable("El mecánico " + mechanicAsigned.getName() + " está actualmente ocupado. Intente más tarde.");
        }

        // 4. Realizar la asignación y actualizar estados
        mechanicAsigned.assignJob();        // Pone al mecánico como NO disponible
        orden.setMechanic(mechanicAsigned); // Asigna el objeto Mechanic a la Orden
        orden.setFinalized(false);          // Actualiza el estado de la orden

        System.out.println("\n✓ ORDEN " + orden.getServiceId() + " ASIGNADA a " + mechanicAsigned.getName());
        return true;
    }

    // Getters para el total de objetos
    public int getTotalMechanics() {
        return mechanics.size();
    }

    public int getTotalServices() {
        return services.size();
    }

    // SOBRECARGA 1: Buscar servicio por tipo (String)
    public ArrayList<MaintenanceService> buscarServicio (String typeService) {
        ArrayList<MaintenanceService> resultado = new ArrayList<>();

        for (MaintenanceService s : services) {
            if (s.getTypeService().equalsIgnoreCase(typeService)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // SOBRECARGA 2: Buscar servicio por estado (boolean)
    public ArrayList<MaintenanceService> buscarServicio (Client client) {
        ArrayList<MaintenanceService> resultado = new ArrayList<>();

        for (MaintenanceService s : services) {
            if (s.getClient() != null && s.getClient().equals(client)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public ArrayList<MaintenanceService> buscarServicio(boolean finalizado) {
        ArrayList<MaintenanceService> resultados = new ArrayList<>();

        for (MaintenanceService s : services) {
            if (s.getIsFinalized() == false) {
                resultados.add(s);
            }
        }

        return resultados;
    }
    // METODO POLIMÓRFICO 1: Aceptar cualquier persona (com.tallermotos.modelo.Client o com.tallermotos.modelo.Mechanic)

    public void registrarPersona(Person p) {
        persons.add(p);
        System.out.println("Registrado: " + p.getRole());
    }


    // METODO POLIMÓRFICO 2: Mostrar info sin saber si es com.tallermotos.modelo.Client o com.tallermotos.modelo.Mechanic

    public void mostrarInformacion(Person p) {
        System.out.println("\n--- Información ---");
        System.out.println(p.infoPerson());            // Polimórfico
        System.out.println(p.getRole());     // Polimórfico
    }

    // METODO POLIMÓRFICO 3: Procesar todos los objetos com.tallermotos.modelo.Person
    public void procesarListado() {
        System.out.println("\n=== LISTADO GENERAL ===");

        for (Person p : persons) {
            System.out.println(p.infoPerson());        // Cada subclase ejecuta su versión
            System.out.println(p.getRole()); // com.tallermotos.modelo.Client o com.tallermotos.modelo.Mechanic
            System.out.println("-----------------------");
        }
    }

} // end class