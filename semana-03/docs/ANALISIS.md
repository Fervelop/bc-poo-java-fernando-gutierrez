# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: Client
- Atributos encapsulados:
  - nameClient
  - lastNameClient
  - phoneNumber
  - email
  - plate
  - model
  - serviceHistory
- Validaciones agregadas: 
  - Para `setPhoneNumber`: El número de teléfono debe tener entre 7 y 15 dígitos
  - Para `setEmail`: El correo electrónico no puede estar vacío

### Clase: MaintenanceService
- Atributos encapsulados:
  - typeService 
  - mechanic
  - costBase
  - workingTime
  - serviceId
- Validaciones agregadas:
    - Para `setFinalized`: No permite finalizar el servicio si no hay mecánico asignado.
    - Para `setMechanic`: El mecánico no puede ser null.

### Clase: Mechanic
- Atributos encapsulados: 
  - nameMechanic
  - id
  - specialization
  - isAvailable
  - completedJobsCount 
- Validaciones agregadas:
    - Para `setName`:Valida que el nombre no sea nulo ni vacío.
    - Para `setId`: El ID debe ser un número positivo.
    - Para `setSpecialization`: La especialización no puede ser nula ni vacía.

## Constructores Sobrecargados

### Clase: Client
- Constructor 1: Recibe todos los datos del cliente (nombre, apellido, teléfono, email, placa, modelo y número de servicios).
  Es el constructor principal que garantiza la creación de un objeto totalmente definido.
- Constructor 2: Recibe únicamente el nombre del cliente y la placa.
  El resto de los atributos se inicializan con valores por defecto como:
  "Sin Apellido", 0L, "Sin email", "Sin marca de moto", 0.
  Se usa cuando solo se conoce la información mínima necesaria para identificar al cliente y su vehículo.
- Constructor 3: Recibe únicamente la placa del vehículo.
  Útil en situaciones donde solo se desea registrar un vehículo, sin datos aún del propietario.
  Establece valores predeterminados como "Sin nombre" y "Sin Apellido".

## Beneficios Logrados
- Mayor flexibilidad al crear objetos: Dependiendo de la información disponible, se puede crear un cliente de forma completa, parcial o mínima sin romper la lógica del programa.
- Evita código repetitivo: Los constructores básicos y mínimos reutilizan el constructor completo mediante this(...), centralizando la lógica de inicialización. 
- Mejor experiencia de desarrollo: Facilita pruebas, prototipos y registros rápidos en el flujo del taller sin necesidad de conocer toda la información del cliente desde el inicio.

### Clase: MaintenanceService
- Constructor 1: Recibe todos los datos necesarios para crear un servicio de mantenimiento:
  typeService, mechanic, costBase, workingTime y serviceId.
  Permite definir un servicio totalmente detallado, incluyendo su identificador único y dejando el campo finalized inicialmente en false.
- Constructor 2: Solicita todos los datos excepto el serviceId.
  Asigna un serviceId por defecto (valor: 1) y delega el resto al constructor completo mediante this(...).
  Este constructor es útil cuando aún no se gestiona un sistema de IDs automáticos, pero se conoce toda la información principal del servicio.
- Constructor 3: Requiere únicamente un mechanic, un costBase y las horas de trabajo (workingTime).
  El tipo de servicio se asigna como "Sin servicio especificado" y el serviceId se fija también en 1.
  Ideal para registrar servicios rápidos o preliminares, donde no se conoce aún su categoría específica.

## Beneficios Logrados
- Flexibilidad en la creación de servicios: Permite crear un servicio con información completa, parcial o mínima, adaptándose a diferentes escenarios del taller. 
- Reducción de código repetido: Los constructores básico y mínimo reutilizan la lógica del constructor completo mediante this(...), garantizando consistencia. 
- Mayor comodidad y velocidad: Facilita la creación de servicios preliminares cuando aún no se dispone del tipo o del ID final, mejorando el flujo de trabajo.

### Clase: Mechanic
- Constructor 1: Recibe el nombre, el ID y la especialización del mecánico.
  Además, inicializa automáticamente: `isAvailable = true` (mecánico disponible)
`completedJobsCount = 0` (sin trabajos completados)
Este constructor garantiza la creación de un mecánico totalmente definido.
- Constructor 2: Solicita únicamente el nombre y el ID del mecánico.
  Asigna por defecto la especialización "Sin especialización" y delega al constructor completo mediante this(...).
  Ideal para registrar mecánicos cuando aún no se conoce o no importa su especialidad.

## Beneficios Logrados
- Creación flexible de objetos: Se pueden registrar mecánicos con información completa o solo básica, según lo necesite el sistema. 
- Centralización de la lógica: El constructor básico reutiliza el constructor completo, evitando repetir código e inicializando siempre los estados (isAvailable, completedJobsCount) de manera consistente. 
- Mejor mantenibilidad: Si la lógica interna cambia (por ejemplo, un nuevo valor por defecto), solo se ajusta en el constructor base.