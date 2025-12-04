package com.tallermotos.modelo;

public class Service {

    //Atributos
    private String idService;
    private String typeService;
    private Motorcycle motorcycle;
    private Client client;
    private String state;

    //Constructor


    public Service(String idService, String typeService, Motorcycle motorcycle, Client client, String state) {
        this.idService = idService;
        this.typeService = typeService;
        this.motorcycle = motorcycle;
        this.client = client;
        this.state = "Pendiente";
    }


    //Getters y Setters

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService='" + idService + '\'' +
                ", typeService='" + typeService + '\'' +
                ", motorcycle=" + motorcycle +
                ", client=" + client +
                ", state='" + state + '\'' +
                '}';
    }
}
