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
    public void infoPerson () {
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + lastName);
        System.out.println("Telefono: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public String getRole() {
        return "Persona genérica";
    }



} // end class
