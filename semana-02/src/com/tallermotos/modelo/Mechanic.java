package com.tallermotos.modelo;

public class Mechanic {

    //Atributos
    private String nameMechanic;        // Nombre del mecanico
    private int id;                     // Unico id para cada mecanico
    private String specialization;      // Ej: Frenos, Aceite, Llantas
    private boolean isAvailable;        // Indica si está disponible para una nueva tarea
    private int completedJobsCount;     // Contador de trabajos finalizados

    //Constructor
    public Mechanic(String nameMechanic, int id, String specialization) {
        this.nameMechanic = nameMechanic;
        this.id = id;
        this.specialization = specialization;
        this.isAvailable = true;       // Inicialmente, está disponible
        this.completedJobsCount = 0;   // Inicia sin trabajos completados
    }

    // Metodo 1: Asignar Tarea (Relación con Mantenimiento)
    // Cambia el estado del mecánico a no disponible cuando se le asigna una orden de mantenimiento.

    public void assignJob() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println(this.nameMechanic + " ha sido asignado a un nuevo trabajo.");
        } else {
            System.out.println(this.nameMechanic + " ya está ocupado. Busque otro mecánico.");
        }
    }

    // Metodo 2: Finalizar Tarea (Relación con Mantenimiento)
    // Incrementa su contador de trabajos y lo vuelve disponible.

    public void completeJob() {
        this.isAvailable = true;
        this.completedJobsCount++;
        System.out.println(this.nameMechanic + " ha finalizado su trabajo. Trabajos completados: " + this.completedJobsCount);
    }

    // Metodo 3: Verificar Disponibilidad (Relación con Mantenimiento)
    // Metodo útil para el sistema de mantenimiento para saber a quién asignar la orden.

    public boolean checkAvailability() {
        return this.isAvailable;
    }

    // Getters y Setters
    public String getNameMechanic() {
        return nameMechanic; }
    public void setName(String nameMechanic) {
        this.nameMechanic = nameMechanic; }

    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }

    public String getSpecialization() {
        return specialization; }
    public void setSpecialization(String specialization) {
        this.specialization = specialization; }

    public boolean isAvailable() {
        return isAvailable; }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCompletedJobsCount() {
        return completedJobsCount; }
} // end class

