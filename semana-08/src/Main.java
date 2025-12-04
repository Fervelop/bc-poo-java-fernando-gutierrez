import com.tallermotos.modelo.Client;
import com.tallermotos.modelo.Motorcycle;
import com.tallermotos.modelo.Service;
import com.tallermotos.servicio.Gestor;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== MENU TALLER DE MOTOS =====");
            System.out.println("1. Registrar Moto");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Crear Servicio");
            System.out.println("4. Ver servicios activos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String plate = sc.nextLine();
                    System.out.print("Marca: ");
                    String carBrand = sc.nextLine();
                    System.out.print("Modelo: ");
                    String model = sc.nextLine();
                    System.out.print("Año: ");
                    int year = sc.nextInt(); sc.nextLine();

                    boolean ok = gestor.registerMotorcycle(new Motorcycle(plate, carBrand, model, year));
                    System.out.println(ok ? "Moto registrada" : "Error al registrar moto");
                }

                case 2 -> {
                    System.out.print("ID Cliente: ");
                    String idClient = sc.nextLine();
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String phoneNumber = sc.nextLine();

                    boolean ok = gestor.registerClient(new Client(idClient, name, phoneNumber));
                    System.out.println(ok ? "Cliente registrado" : "Error al registrar cliente");
                }

                case 3 -> {
                    System.out.print("ID Servicio: ");
                    String idService = sc.nextLine();
                    System.out.print("Tipo Servicio: ");
                    String type = sc.nextLine();
                    System.out.print("Placa Moto: ");
                    String plate = sc.nextLine();
                    System.out.print("ID Cliente: ");
                    String idClient = sc.nextLine();
                    System.out.print("Estado: ");
                    String state = sc.nextLine();

                    boolean ok = gestor.createService(idService, type, plate, idClient, state);
                    System.out.println(ok ? "Servicio creado" : "Error al crear servicio");
                }

                case 4 -> {
                    List<Service> actives = gestor.serviceActivate();
                    System.out.println("Servicios activos:");
                    actives.forEach(System.out::println);
                }
            }
        }

        System.out.println("Saliendo del sistema...");

*/


        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n===== MENU TALLER DE MOTOS =====");
            System.out.println("1. Registrar Moto");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Crear Servicio");
            System.out.println("4. Ver Servicios Activos");
            System.out.println("5. Actualizar Moto");
            System.out.println("6. Actualizar Cliente");
            System.out.println("7. Cambiar Estado de Servicio");
            System.out.println("8. Finalizar Servicio");
            System.out.println("9. Ver Todos los Servicios");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ===================== REGISTRAR MOTO ======================
                case 1 -> {
                    System.out.print("Placa: ");
                    String plate = sc.nextLine();
                    System.out.print("Marca: ");
                    String carBrand = sc.nextLine();
                    System.out.print("Modelo: ");
                    String model = sc.nextLine();
                    System.out.print("Año: ");
                    int year = sc.nextInt(); sc.nextLine();

                    boolean ok = gestor.registerMotorcycle(new Motorcycle(plate, carBrand, model, year));
                    System.out.println(ok ? "Moto registrada" : "Error al registrar moto");
                }

                // ===================== REGISTRAR CLIENTE ======================
                case 2 -> {
                    System.out.print("ID Cliente: ");
                    String idClient = sc.nextLine();
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String phoneNumber = sc.nextLine();

                    boolean ok = gestor.registerClient(new Client(idClient, name, phoneNumber));
                    System.out.println(ok ? "Cliente registrado" : "Error al registrar cliente");
                }

                // ===================== CREAR SERVICIO ======================
                case 3 -> {
                    System.out.print("ID Servicio: ");
                    String idService = sc.nextLine();
                    System.out.print("Tipo Servicio: ");
                    String typeService = sc.nextLine();
                    System.out.print("Placa Moto: ");
                    String plate = sc.nextLine();
                    System.out.print("ID Cliente: ");
                    String idClient = sc.nextLine();
                    System.out.print("Estado: ");
                    String state = sc.nextLine();

                    boolean ok = gestor.createService(idService, typeService, plate, idClient, state);
                    System.out.println(ok ? "Servicio creado" : "Error al crear servicio");
                }

                // ===================== VER SERVICIOS ACTIVOS ======================
                case 4 -> {
                    List<Service> actives = gestor.serviceActivate();
                    showServices(actives, "SERVICIOS ACTIVOS");
                }

                // ===================== ACTUALIZAR MOTO ======================
                case 5 -> {
                    System.out.print("Placa de la moto a actualizar: ");
                    String plate = sc.nextLine();

                    Motorcycle motorcycle = gestor.searchMotorcycle(plate);
                    if (motorcycle == null) {
                        System.out.println("Moto no encontrada.");
                        break;
                    }

                    System.out.print("Nueva marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Nuevo modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Nuevo año: ");
                    int anio = sc.nextInt(); sc.nextLine();

                    boolean ok = gestor.setMotorcycle(plate, motorcycle.getCarBrand(), motorcycle.getModel(), motorcycle.getYear());
                    System.out.println(ok ? "Moto actualizada" : "Error al actualizar moto");
                }

                // ===================== ACTUALIZAR CLIENTE ======================
                case 6 -> {
                    System.out.print("ID del cliente a actualizar: ");
                    String idClient = sc.nextLine();

                    Client client = gestor.searchClient(idClient);
                    if (client == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    System.out.print("Nuevo nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String phoneNumber = sc.nextLine();

                    boolean ok = gestor.setClient(idClient, name, phoneNumber);
                    System.out.println(ok ? "Cliente actualizado" : "Error al actualizar cliente");
                }

                // ===================== CAMBIAR ESTADO DE SERVICIO ======================
                case 7 -> {
                    System.out.print("ID del servicio: ");
                    String idService = sc.nextLine();
                    System.out.print("Nuevo estado (Pendiente / En Proceso / Finalizado): ");
                    String state = sc.nextLine();

                    boolean ok = gestor.setStateService(idService, state);
                    System.out.println(ok ? "Estado actualizado" : "Error al actualizar estado");
                }

                // ===================== FINALIZAR SERVICIO ======================
                case 8 -> {
                    System.out.print("ID del servicio: ");
                    String idService = sc.nextLine();

                    boolean ok = gestor.endService(idService);
                    System.out.println(ok ? "Servicio finalizado" : "Error al finalizar servicio");
                }

                // ===================== VER TODOS LOS SERVICIOS ======================
                case 9 -> {
                    showServices(gestor.serviceForType(""), "TODOS LOS SERVICIOS");
                }
            }
        }

        System.out.println("Saliendo del sistema...");
    }


    // ======================================================
    // ====== METODO AUXILIAR PARA MOSTRAR SERVICIOS ========
    // ======================================================

    private static void showServices(List<Service> list, String title) {
        System.out.println("\n===== " + title + " =====");
        System.out.printf("%-10s %-15s %-10s %-15s %-15s%n",
                "ID", "TIPO", "PLACA", "CLIENTE", "ESTADO");
        System.out.println("------------------------------------------------------------------");

        for (Service service : list) {
            System.out.printf("%-10s %-15s %-10s %-15s %-15s%n",
                    service.getIdService(),
                    service.getTypeService(),
                    service.getMotorcycle().getPlate(),
                    service.getClient().getName(),
                    service.getState());
        }

    }
}