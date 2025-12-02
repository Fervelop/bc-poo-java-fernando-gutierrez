import com.tallermotos.modelo.*;
import com.tallermotos.servicio.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE TALLER DE MOTOS   ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        // 1. CREAR EL GESTOR DEL SISTEMA
        GestorTallerMotos gestor = new GestorTallerMotos();
        System.out.println("--- 1. INICIALIZACIÓN ---");
        System.out.println("Sistema gestor inicializado.");

        // =========================================================
        // 2. CREAR Y AGREGAR OBJETOS DE TIPO 1: MECHANIC (MÍNIMO 3)
        // =========================================================
        System.out.println("\n--- 2. REGISTRANDO MECÁNICOS ---");
        Mechanic mec1 = new Mechanic("Maria", "Rojas", 3115698745L, "maria@gmail.com", 1, "Frenos");
        Mechanic mec2 = new Mechanic("Jose",  "Martinez", 3214569874L, "jose@gmail.com", 2, "Cambio de Llantas");
        Mechanic mec3 = new Mechanic("Duvan", "Olarte", 3125469874L, "duvan@gmail.com", 3, "Sistemas Electricos");

        gestor.addMechanic(mec1);
        gestor.addMechanic(mec2);
        gestor.addMechanic(mec3);

        // =========================================================
        // 3. CREAR OBJETOS DE TIPO 3: CLIENT (MÍNIMO 2)
        // (El gestor no gestiona Clientes, solo se usan para contexto)
        // =========================================================
        System.out.println("\n--- 3. CREANDO CLIENTES ---");
        Client cli1 = new Client("Fernando", "Gutierrez", 1234567890, "fernando@mail.com", "AAA-123", "YAHAMA", 3);
        Client cli2 = new Client("Angelo", "Tovar", 123456789, "angelo@mail.com", "ABC-123", "TVS", 0);
        Client cli3 = new Client("Diana", "Mendez", 987654321, "diana@mail.com", "XYZ-789", "Bajaj", 5);

        cli1.showData();
        System.out.println("\n--------------------------------------");

        // =========================================================
        // 4. CREAR OBJETOS DE TIPO 2: MAINTENANCE SERVICE (MÍNIMO 3)
        // (Se crea sin asignar mecánico inicialmente)
        // =========================================================
        System.out.println("\n--- 4. CREANDO ÓRDENES DE MANTENIMIENTO ---");
        // Nota: Asumo que el constructor de MS fue corregido para incluir el serviceId
        MaintenanceService serv1 = new MaintenanceService("Cambio de Aceite", mec1 , 35000,1, 101);
        MaintenanceService serv2 = new MaintenanceService("Cambio de llantas", mec2 , 150000,2, 102);
        MaintenanceService serv3 = new MaintenanceService("Revisión Eléctrica", mec3 , 50000, 3, 103);

        System.out.println("Servicios creados (ID: 101, 102, 103).");

        // =========================================================
        // 5. DEMOSTRACIÓN DE FUNCIONALIDADES DEL GESTOR
        // =========================================================

        // DEMO: Interacción (Asignar y Agregar)
        System.out.println("\n--- 5. INTERACCIÓN Y ASIGNACIÓN DE ÓRDENES ---");
        // Asignar al servicio 1 (ID 101) al mecánico 1 (Tatiana)
        gestor.addService(serv1, 1);
        // Asignar al servicio 2 (ID 102) al mecánico 2 (Jose)
        gestor.addService(serv2, 2);
        // Asignar al servicio 3 (ID 103) al mecánico 3 (Duvan)
        gestor.addService(serv3, 3);

        // DEMO: Listar objetos
        gestor.listMechanics();

        // DEMO: Contar objetos
        System.out.println("\n--- 6. ESTADÍSTICAS DEL SISTEMA ---");
        System.out.println("Total de Órdenes en el Sistema: " + gestor.getTotalServices());
        int enProceso = gestor.countServiceInProcess();
        System.out.println("Órdenes actualmente en proceso: " + enProceso);

        // DEMO: Buscar objetos
        System.out.println("\n--- 7. BÚSQUEDA DE ÓRDENES ---");
        int idBuscado = 101;
        MaintenanceService servicioBuscado = gestor.searchServiceId(idBuscado);

        if (servicioBuscado != null) {
            System.out.println("✓ Servicio con ID " + idBuscado + " encontrado:");
            // DEMO: Interacción (Mostrar información)
            servicioBuscado.showInformation();
            System.out.println("Costo Total Estimado: $" + servicioBuscado.calculateTotalCost());
        } else {
            System.out.println("✗ Servicio con ID " + idBuscado + " no encontrado.");
        }

        // DEMO: Interacción Avanzada (Finalizar servicio y liberar mecánico)
        System.out.println("\n--- 8. FINALIZANDO SERVICIOS ---");

        // Finalizar servicio 1 (ID 101)
        if (serv1.getMechanic() != null) {
            serv1.setFinalized(true);
            serv1.getMechanic().completeJob(); // Llama al metodo del mecánico para liberarlo y contar
            System.out.println("Servicio 101 FINALIZADO.");
        }

        // DEMO: Contar objetos después de la interacción
        System.out.println("\nÓrdenes EN PROCESO (después de finalizar): " + gestor.countServiceInProcess()); // Debería ser 2
        gestor.listMechanics(); // Tatiana (ID 1) debe aparecer como "SÍ" Disponible.

        System.out.println("\n✓ Programa integrado finalizado exitosamente.");

        // Demostracion semana 4 Poliformismo
        Person[] person = new Person[3];
        person[0] = new Client("Carlos", "Gómez", 3219876543L, "carlos@mail.com",
                "ABC123", "Yamaha FZ", 4);
        person[1] = new Mechanic("Laura", "Pérez", 3001112233L, "laura@taller.com", 0, "Frenos");
        person[2] = new Client("Andrés", "Rojas", 3224445566L, "andres@mail.com",
                "XYZ890", "Honda CB", 1
        );

        // Polimorfismo en acción
        for (Person per : person) {
            System.out.println("------------------------");
            per.infoPerson();
            System.out.println("Rol: " + per.getRole());
            System.out.println("------------------------");
        }

    } // end args
} // end class
