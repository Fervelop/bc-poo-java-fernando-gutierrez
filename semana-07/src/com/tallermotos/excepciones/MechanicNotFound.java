package com.tallermotos.excepciones;

/**
 * Excepción lanzada cuando se intenta asignar un servicio
 * a un mecánico cuyo ID no se encuentra registrado en el sistema.
 */
public class MechanicNotFound extends Exception {

    /**
     * Constructor con mensaje de error.
     * @param message El mensaje que describe la causa del error.
     */
    public MechanicNotFound(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa original.
     * @param message El mensaje que describe la causa del error.
     * @param cause La causa subyacente de la excepción.
     */
    public MechanicNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}