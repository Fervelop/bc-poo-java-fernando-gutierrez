package com.tallermotos.modelo;

public class Client extends Person{

    //Atributos
    private String plate;       // placa
    private String model;          // marca de la moto
    private int serviceHistory; // Cantidad de servicios

    //Constructor
    public Client (String name, String lastName, long phoneNumber, String email, String plate, String model, int serviceHistory) {
        super(name, lastName, phoneNumber, email);
        this.plate = plate;
        this.model = model;
        this.serviceHistory = serviceHistory;
    }
    // Constructor básico (llama al completo)
    public Client (String name, String plate) {
        this(name, "Sin Apellido", 0L, "Sin email", plate, "Sin marca de moto", 0);
    }

    // Constructor mínimo
    public Client(String plate) {
        this("Sin nombre", "Sin Apellido", 0L, "Sin email", plate, "Sin marca de moto", 0);
    }

    //Metodos

    //1. Metodo:  Mostrar datos cliente
    public void showData (){
        System.out.println("=== DATOS DEL CLIENTE ===");
        System.out.println("Nombre: " + name + " " + lastName);
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
    public String getName() {
        return this.name;
    }
    public String getPlate() {
        return this.plate;
    }
    public int getServiceHistory() {
        return this.serviceHistory;
    }
    public String getLastName() { return this.lastName; }
    public long getPhoneNumber() { return this.phoneNumber; }
    public String getEmail() { return this.email; }
    public String getModel() {return this.model; }

    //Setter
    public void setPhoneNumber (long phoneNumber) {
        if (phoneNumber < 1_000_000L || phoneNumber > 999_999_999_999_999L) {
            throw new IllegalArgumentException("El número de teléfono debe tener entre 7 y 15 dígitos.");
        }
        this.phoneNumber = phoneNumber;
    }
    public void setEmail (String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío.");
        }
        this.email = email;
    }

    //Metodo auxiliar privado

    private boolean validarPhoneNumber(long phoneNumber) {
        return phoneNumber >= 1_000_000L && phoneNumber <= 999_999_999_999_999L;
    }

    // Metodos heredables

    @Override
    public String infoPerson() {
        return "=== DETALLES DEL CLIENTE ===\n" +
                "  Nombre: " + name + " " + lastName + "\n" +
                "  Contacto: " + email + "\n" +
                "  Teléfono: " + phoneNumber + "\n" +
                "----------------------------\n" +
                "  Moto (Modelo): " + model + "\n" +
                "  Moto (Placa): " + plate;
    }

    @Override
    public String getRole() {
        return "Cliente del taller";
    }





}
