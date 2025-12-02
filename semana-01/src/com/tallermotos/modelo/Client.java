package com.tallermotos.modelo;

public class Client {

    //Atributos
    private String nameClient;        // nombre
    private String lastNameClient;    // apellido
    private long phoneNumber;    // celular
    private String email;       // email
    private String plate;       // placa
    private String model;          // marca de la moto
    private int serviceHistory; // Cantidad de servicios

    //Constructor
    public Client (String name, String lastName, long phoneNumber, String email, String plate, String model, int serviceHistory) {
        this.nameClient = name;
        this.lastNameClient = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.plate = plate;
        this.model = model;
        this.serviceHistory = serviceHistory;
    }

    //Metodos

    //1. Metodo:  Mostrar datos cliente
    public void showData (){
        System.out.println("=== DATOS DEL CLIENTE ===");
        System.out.println("Nombre: " + nameClient + " " + lastNameClient);
        System.out.println("Celular: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Marca: " + model);
        System.out.println("Placa de moto: " + plate);
        System.out.println("Numero de servicios: " + serviceHistory);
    }

    //2. Metodo: Incrementa el numero de servicios
    public void increaseHistory () {
        serviceHistory++;
    }

    //3. Metodo: Saber si es cliente frecuente
    public boolean isFrequentClient() {
        return serviceHistory >= 3;
    }

    //Getter
    public String getNameClient() {
        return this.nameClient;
    }
    public String getPlate() {
        return this.plate;
    }
    public int getServiceHistory() {
        return this.serviceHistory;
    }

    //Setter
    public void setPhoneNumber (long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail (String email) {
        this.email = email;
    }
}
