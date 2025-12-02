import com.tallermotos.modelo.*;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase com.tallermotos.modelo.MaintenanceService
        MaintenanceService service1 = new MaintenanceService("Cambio de Aceite","Tatiana Torres",
                35000,1);
        MaintenanceService service2 = new MaintenanceService("Cambio de llantas","Jose Martinez", 150000, 2);

        // Llamar al metodo que imprime informacion + costo total con mano de obra
        service1.showInformation();
        System.out.println("Costo Total del Servicio: $" + service1.calculateTotalCost());
        System.out.println("--------------------------------------");

        service2.showInformation();
        System.out.println("Costo Total del Servicio: $" + service2.calculateTotalCost());
        System.out.println("--------------------------------------");

        // Cambiar estado con el setter para un estado finalizado del servicio
        service1.setFinalized(true);
        service2.setFinalized(true);

        // --------------------------- CLASE SECUNDARIA --------------------------------------
        Client client1 = new Client("Fernando", "Gutierrez", 1234567890, "fernando@gmail.com",
                "AAA-123", "YAHAMA", 3);
        Client client2 = new Client("Angelo", "Tovar", 123456789, "angelo@gmail.com", "ABC-123",
                "TVS", 0);


        //Llamar metodo 1
        System.out.println("--------------------------------------");
        client1.showData();
        System.out.println("--------------------------------------");
        client2.showData();

        //Metodo 2: Mostrar antes de llamar para verificar si se modifico
        //Cliente 1
        System.out.println("--------------------------------------");
        System.out.println("Cantidad de servicios de " + client1.getNameClient() + ":" + client1.getServiceHistory());
        client1.increaseHistory();
        System.out.println("Cantidad de servicios de " + client1.getNameClient() + ":" + client1.getServiceHistory());

        //Cliente 2
        System.out.println("--------------------------------------");
        System.out.println("Cantidad de servicios de " + client2.getNameClient() + ":" + client2.getServiceHistory());
        client2.increaseHistory();
        System.out.println("Cantidad de servicios de " + client2.getNameClient() + ":" + client2.getServiceHistory());

        //Metodo 3
        System.out.println("--------------------------------------");
        System.out.println("¿El cliente de nombre " + client1.getNameClient() + "es frecuente?: " + client1.isFrequentClient());
        System.out.println("¿El cliente de nombre " + client2.getNameClient() + "es frecuente?: " + client2.isFrequentClient());






    }
}