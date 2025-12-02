# POLIMORFISMO EN EL SISTEMA DE TALLER DE MOTOS

## 1. Sobrecarga (Overloading)

La **sobrecarga** ocurre cuando varios métodos tienen **el mismo nombre**, pero **diferentes parámetros**.

En nuestro sistema del Taller de Motos, la sobrecarga se aplica principalmente en el **com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.GestorTallerMotos**, permitiendo buscar servicios según diferentes criterios.

### Métodos Sobrecargados en com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.GestorTallerMotos

```java
public ArrayList<com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.MaintenanceService> buscarServicio(String typeService);
public ArrayList<com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.MaintenanceService> buscarServicio(com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client client);
public ArrayList<com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.MaintenanceService> buscarServicio(boolean finalized);
```

### Justificación en el Dominio

En un taller de motos, se deben realizar consultas de servicios por distintos motivos:

| Necesidad del negocio                | Método sobrecargado     | Descripción                                   |
| ------------------------------------ | ----------------------- | --------------------------------------------- |
| Buscar servicios por tipo            | buscarServicio(String)  | "llantas", "frenos", etc.                     |
| Buscar servicios hechos a un cliente | buscarServicio(com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client)  | Encuentra servicios según el dueño de la moto |
| Buscar servicios finalizados o no    | buscarServicio(boolean) | Útil para reportes y control interno          |


---

## 2. Sobrescritura (Overriding)

La sobrescritura ocurre cuando una **subclase redefine un método** que ya existe en la **clase padre**, utilizando `@Override`.

En nuestro sistema, la clase padre es **com.tallermotos.modelo.com.tallermotos.modelo.Person**, con dos subclases:

- **com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client**
- **com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic**

Ambas sobrescriben el método heredado.

### Métodos Sobrescritos

```java
@Override
public String getRole();
```

### Tabla Comparativa de Sobrescritura

| Método           | Clase Padre (com.tallermotos.modelo.com.tallermotos.modelo.Person) | com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client                      | com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic                         |
| ---------------- | -------------------- | --------------------------- | -------------------------------- |
| getDescription() | "Persona genérica"   | "Cliente: nombre, teléfono" | "Mecánico: nombre, especialidad" |

Esto permite que al llamar el mismo método, cada tipo de persona muestre información relevante.

---

## 3. Polimorfismo Dinámico (Dynamic Binding)

El polimorfismo dinámico ocurre cuando una referencia del **tipo padre** ejecuta un método definido en una **subclase**.

Se ve claramente cuando usamos un **ArrayList<com.tallermotos.modelo.com.tallermotos.modelo.Person>** y dentro colocamos `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client` y `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic`.

### Ejemplo Real del Proyecto

```java
ArrayList<com.tallermotos.modelo.com.tallermotos.modelo.Person> persons = new ArrayList<>();
persons.add(c1); // com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client
persons.add(m1); // com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic

for (com.tallermotos.modelo.com.tallermotos.modelo.Person p : persons) {
    System.out.println(p.getRole()); // Dynamic Binding
}
```

### Explicación

Aunque el array es de tipo **com.tallermotos.modelo.com.tallermotos.modelo.Person**, cuando se ejecuta:

```java
p.getRole)
```

Java decide **en tiempo de ejecución** cuál versión llamar:

- Si p es un `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client` → llama la versión de com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client.
- Si p es un `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic` → llama la versión de com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic.

Esto ocurre sin necesidad de hacer if/else o conversiones.

---

## 4. Beneficios del Polimorfismo

### 1. Código más limpio y reutilizable

Podemos tratar objetos diferentes (com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client y com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic) bajo el mismo tipo: com.tallermotos.modelo.com.tallermotos.modelo.Person.

### 2. Facilidad para extender el sistema

Si mañana agregamos:

- `Admin`
- `Proveedor`
- `Recepcionista`

Mientras extiendan com.tallermotos.modelo.com.tallermotos.modelo.Person y sobrescriban métodos, el sistema seguirá funcionando.

### 3. Mantiene el principio OCP (Open/Closed Principle)

Puedo agregar nuevas subclases **sin modificar** el código existente.

### 4. Búsquedas flexibles con sobrecarga

Permite tener un solo método `buscarServicio()` que funciona según el parámetro.

### 5. Permite implementar Dynamic Binding

Haciendo que el programa se comporte de manera diferente según el tipo real del objeto.

---

## ¿Qué sería difícil sin polimorfismo?

- Tendríamos que hacer **muchos if/else** para saber si un objeto es Cliente o Mecánico.
- Tendríamos métodos con nombres largos: `buscarServicioPorCliente`, `buscarServicioPorTipo`…
- Sería difícil agregar nuevos tipos de personas sin reescribir medio sistema.
- El código sería más rígido y menos profesional.

