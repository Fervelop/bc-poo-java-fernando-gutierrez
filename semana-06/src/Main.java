import abstractas.*;
import implementaciones.BrakeService;
import implementaciones.OilChangeService;
import implementaciones.TireChangeService;
import interfaces.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DEL TALLER DE MOTOS ===\n");

        // --------------------------------------------------------------
        // 1. Polimorfismo con clase abstracta
        // --------------------------------------------------------------
        System.out.println("--- POLIMORFISMO: SERVICIOS ---");

        Service[] services = new Service[3];

        services[0] = new OilChangeService("Cambio de Aceite", 30000, 15000);
        services[1] = new BrakeService("Servicio de Frenos", 50000, 20000, 15000);
        services[2] = new TireChangeService(25000, 2, 80000);

        // Llamada polimórfica
        for (Service s : services) {
//            System.out.println(s.basicInfo());
            System.out.println("Costo Total: $" + s.calculateTotalCost());
        }

        // --------------------------------------------------------------
        // 2. Demostración de interfaces
        // --------------------------------------------------------------
        System.out.println("\n--- INTERFACES: Repairable ---");

        Repairable rep = new TireChangeService(25000, 1, 80000);

        System.out.println("¿Requiere piezas?: " + rep.requireParts());
        System.out.println("Costo de las piezas: $" + rep.calculateCostParts());
        System.out.println("Diagnóstico: " + rep.diagnosticateFault());

        // --------------------------------------------------------------
        // 3. Múltiple implementación
        // --------------------------------------------------------------
        System.out.println("\n--- INTERFACES: TimeTrackable ---");

        TimeTrackable track = new TireChangeService(25000, 2, 80000);

        track.startJob();
        track.finishJob();

        System.out.println("Duración del trabajo: " + track.durationJob() + " minutos");

        System.out.println("\n=== FIN DEL SISTEMA ===");


    }
}