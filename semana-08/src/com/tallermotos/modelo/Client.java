package com.tallermotos.modelo;

public class Client {

    //Atributos
    private String idClient;
    private String name;
    private String phoneNumber;

    //Constructor
    public Client(String id, String name, String phoneNumber) {
        this.idClient = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters y Setters

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + idClient + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
