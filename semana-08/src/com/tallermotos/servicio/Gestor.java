package com.tallermotos.servicio;

import com.tallermotos.modelo.Client;
import com.tallermotos.modelo.Motorcycle;
import com.tallermotos.modelo.Service;
import com.tallermotos.util.Validator;

import java.util.*;

public class Gestor {

    // Estructuras de datos por entidad
    private Map<String, Motorcycle> motorcycles = new HashMap<>();
    private Map<String, Client> clients = new HashMap<>();
    private List<Service> historialServices = new ArrayList<>();
    private Set<String> typesServices = new HashSet<>();

    //Añadir servicios al gestor
    public Gestor() {
        typesServices.add("Mantenimiento");
        typesServices.add("Frenos");
        typesServices.add("Cambio de aceite");
        typesServices.add("Motor");
    }

    // Registrar motos con validacion
    public boolean registerMotorcycle(Motorcycle motorcycle) {
        if (!Validator.validatePlate(motorcycle.getPlate())) return false;
        if (motorcycles.containsKey(motorcycle.getPlate())) return false;

        motorcycles.put(motorcycle.getPlate(), motorcycle);
        return true;
    }

    //Buscar moto por placa
    public Motorcycle searchMotorcycle(String plate) {
        return motorcycles.get(plate);
    }

    //Eliminar moto por placa
    public boolean deleteMotorcycle(String plate) {
        return motorcycles.remove(plate) != null;
    }

    //Actualizar moto con placa, marca, modelo y año
    public boolean setMotorcycle(String plate, String carBrand, String model, int year) {
        Motorcycle motorcycle1 = motorcycles.get(plate);
        if (motorcycle1 == null) return false;

        motorcycle1.setCarBrand(carBrand);
        motorcycle1.setModel(model);
        motorcycle1.setYear(year);
        return true;
    }

    //Registrar clientes
    public boolean registerClient(Client client) {
        if (!Validator.validateId(client.getIdClient())) return false;
        if (clients.containsKey(client.getIdClient())) return false;

        clients.put(client.getIdClient(), client);
        return true;
    }

    //Buscar cliente por id
    public Client searchClient(String idClient) {
        return clients.get(idClient);
    }

    //Actualizar cliente
    public boolean setClient(String idClient, String name, String phoneNumber) {
        Client client = clients.get(idClient);
        if (client == null) return false;

        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        return true;
    }

    //Eliminar cliente
    public boolean deleteClient(String idClient) {
        return clients.remove(idClient) != null;
    }

    //Crear servicio
    public boolean createService(String idService, String typeService, String plate, String idClient, String state) {
        if (!Validator.validateTypeService(typesServices, typeService)) return false;

        Motorcycle motorcycle = motorcycles.get(plate);
        Client client = clients.get(idClient);

        if (motorcycle == null || client == null) return false;

        Service service = new Service(idService, typeService, motorcycle, client, state);
        historialServices.add(service);
        return true;
    }


    //Cambiar estado del servicio
    public boolean setStateService(String idService, String stateNew) {
        for (Service service : historialServices) {
            if (service.getIdService().equals(idService)) {
                service.setState(stateNew);
                return true;
            }
        }
        return false;
    }

    //Finalizar servicio
    public boolean endService(String idService) {
        return setStateService(idService, "Finalizado");
    }


    //Filtros

    //Servicio por placa

    public List<Service> serviceForPlate(String plate) {
        List<Service> list = new ArrayList<>();
        for (Service service : historialServices) {
            if (service.getMotorcycle().getPlate().equals(plate)) list.add(service);
        }
        return list;
    }
    //Servicio por tipo
    public List<Service> serviceForType(String typeService) {
        List<Service> list = new ArrayList<>();
        for (Service service : historialServices) {
            if (service.getTypeService().equalsIgnoreCase(typeService)) list.add(service);
        }
        return list;
    }

    //Servicio por estado activo
    public List<Service> serviceActivate() {
        List<Service> list = new ArrayList<>();
        for (Service service : historialServices) {
            if (!service.getState().equalsIgnoreCase("Finalizado")) list.add(service);
        }
        return list;
    }

    //Estadisticas

    //Tipo de servicio mas solicitado
    public String typeMoreSolicited() {
        Map<String, Integer> counter = new HashMap<>();

        for (Service s : historialServices) {
            counter.put(s.getTypeService(), counter.getOrDefault(s.getTypeService(), 0) + 1);
        }

        return counter.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Sin servicios");
    }


    //Cliente con mas servicios
    public String clientMoreServices() {
        Map<String, Integer> counter = new HashMap<>();

        for (Service service : historialServices) {
            String idService = service.getClient().getIdClient();
            counter.put(idService, counter.getOrDefault(idService, 0) + 1);
        }

        return counter.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> clients.get(e.getKey()).getName())
                .orElse("Sin servicios");
    }

    //Numero de servicios por moto
    public int servicesForMoto(String plate) {
        return serviceForPlate(plate).size();
    }


} // end class
