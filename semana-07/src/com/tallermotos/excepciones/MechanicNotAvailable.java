package com.tallermotos.excepciones;

/**
 * Excepción lanzada cuando el mecánico existe, pero su estado
 * actual es 'No Disponible' para un nuevo trabajo (está ocupado).
 */
public class MechanicNotAvailable extends Exception {

    /**
     * Constructor con mensaje de error.
     * @param message El mensaje que describe la causa del error.
     */
    public MechanicNotAvailable(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa original.
     * @param message El mensaje que describe la causa del error.
     * @param cause La causa subyacente de la excepción.
     */
    public MechanicNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }
}