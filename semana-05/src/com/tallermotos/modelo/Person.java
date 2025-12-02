package com.tallermotos.modelo;

public class Person { // Clase padre

    protected String name;
    protected String lastName;
    protected long phoneNumber;
    protected String email;

    // Constructor

    public Person (String name, String lastName, long phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Metodos heredables
    public String infoPerson () {
        return "Nombre: " + name + " | " + "Apellido: " + lastName + " | " + "Telefono: " + phoneNumber + " | " + "Email: " + email;
    }

    public String getRole() {
        return "Persona genérica";
    }



} // end class
