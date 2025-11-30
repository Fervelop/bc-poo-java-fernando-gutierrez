package com.tallermotos;
import com.tallermotos.excepciones.MechanicNotAvailable;
import com.tallermotos.excepciones.MechanicNotFound;
import com.tallermotos.modelo.*;
import com.tallermotos.servicio.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        System.out.println("=== Sistema de Gestión Taller de Motos - Demostración Excepciones ===\n");

        GestorTallerMotos gestor = new GestorTallerMotos();

        // 1. Preparar datos de prueba
        Mechanic m1 = new Mechanic("Juan Pérez", 10);
        Mechanic m2 = new Mechanic("Luis Gómez", 20);

        // El mecánico M2 se agrega y se pone como 'ocupado' para forzar una excepción
        m2.assignJob();

        gestor.addMechanic(m1);
        gestor.addMechanic(m2);

        // Órdenes de prueba // String typeService,Mechanic mechanic, double costBase, int workingTime, int serviceId
        MaintenanceService ordenExitosa = new MaintenanceService("Revision", m1, 10000,2, 1001);
        MaintenanceService ordenErrorID = new MaintenanceService("Cambio de aceite", m2, 8000,1, 1002);
        MaintenanceService ordenErrorDisponible = new MaintenanceService("Frenos", m2, 12000,3, 1003);

        // --- CASOS DE PRUEBA ---

        // Caso 1: Operación exitosa ✅
        System.out.println("--- Caso 1: Asignación Exitosa ---");
        try {
            // Asigna al mecánico disponible (ID 10)
            gestor.addService(ordenExitosa, 10);
        } catch (MechanicNotFound | MechanicNotAvailable e) {
            System.err.println("❌ ERROR INESPERADO: " + e.getMessage());
        }

        // Caso 2: Excepción por validación (IllegalArgumentException) ❌
        System.out.println("\n--- Caso 2: Búsqueda con ID Inválido (IllegalArgumentException) ---");
        try {
            // Se llama al método searchServiceId, que implementa try-catch para validar IDs > 0
            gestor.searchServiceId(-5);
        } catch (Exception e) { // Capturamos la excepción lanzada internamente (si aplica)
            System.err.println("❌ Error de Validación: " + e.getMessage());
        }

        // Caso 3: Excepción personalizada 1 (`MechanicNotFound`) ❌
        System.out.println("\n--- Caso 3: Mecánico No Encontrado ---");
        try {
            // Intentar asignar a un ID que no existe (ej: 99)
            gestor.addService(ordenErrorID, 99);
        } catch (MechanicNotFound e) {
            System.err.println("❌ EXCEPCIÓN PERSONALIZADA 1: " + e.getMessage());
        } catch (MechanicNotAvailable e) {
            System.err.println("❌ ERROR INESPERADO: " + e.getMessage());
        }

        // Caso 4: Excepción personalizada 2 (`MechanicNotAvailable`) ❌
        System.out.println("\n--- Caso 4: Mecánico Ocupado (No Disponible) ---");
        try {
            // Intentar asignar al mecánico M2 (ID 20), que está ocupado
            gestor.addService(ordenErrorDisponible, 20);
        } catch (MechanicNotFound e) {
            System.err.println("❌ ERROR INESPERADO: " + e.getMessage());
        } catch (MechanicNotAvailable e) {
            System.err.println("❌ EXCEPCIÓN PERSONALIZADA 2: " + e.getMessage());
        }

        // Caso 5: Recuperación después de error ✅
        System.out.println("\n--- Caso 5: Recuperación y Reintento Exitoso ---");
        // Intentamos asignar la orden que falló en el Caso 4, pero a un mecánico disponible.

        // Primero, liberamos un mecánico (simulación de finalización de trabajo)
        m1.completeJob();

        // Reintentar la asignación al mecánico M1 (ID 10), ahora disponible de nuevo
        try {
            gestor.addService(ordenErrorDisponible, 10);
            System.out.println("✅ Recuperación exitosa: El servicio fue asignado tras reintento.");
        } catch (MechanicNotFound | MechanicNotAvailable e) {
            System.err.println("❌ Recuperación fallida: " + e.getMessage());
        }

        // --- FINALLY para limpieza ---

        System.out.println("\n--- Uso del bloque Finally para Limpieza ---");
        ejemploFinally();

        System.out.println("\n=== Demostración de Excepciones completada ===");
    }

    /**
     * 4.3 Ejemplo de Finally para limpieza (Simulación de recurso externo)
     */
    public static void ejemploFinally() {
        // En un taller, esto podría simular cerrar una conexión a DB,
        // o asegurar que un archivo de registro (log) se cierre.

        // Usamos String como recurso simulado para evitar complejidades de IO reales.
        String reporteAbierto = "Reporte de Diagnóstico.txt";

        try {
            System.out.println("1. Abriendo recurso: " + reporteAbierto);

            // Simulación de un error durante el procesamiento
            if (Math.random() > 0.5) {
                throw new RuntimeException("Error en la conexión con el sensor de diagnóstico.");
            }

            System.out.println("2. Procesamiento de datos exitoso.");

        } catch (RuntimeException e) {
            System.err.println("❌ ERROR detectado: " + e.getMessage());

        } finally {
            // El bloque finally siempre se ejecuta, haya habido una excepción o no.
            System.out.println("3. Ejecutando FINALLY: Asegurando que el recurso '" + reporteAbierto + "' sea cerrado.");
        }

    } // end args
} // end class
