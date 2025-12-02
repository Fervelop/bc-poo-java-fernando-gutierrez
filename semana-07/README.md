# Semana 07: Paquetes y Excepciones - Taller De Motos "Velocidad Segura"

## 👤 Información del Estudiante
- **Nombre**: Fernando Gutierrez Rojas
- **Ficha**: 3228970A
- **Dominio**: Taller De Motos "Velocidad Segura"
- **Fecha**: 30/11/2025

## 📝 Descripción del Proyecto

[Breve descripción de tu dominio y qué hace tu sistema]

**Ejemplo**: Sistema de gestión para un taller de reparación y mantenimiento de motocicletas. El sistema permite registrar mecánicos y órdenes de servicio, además de gestionar la asignación de trabajos, asegurando que solo se asignen tareas a mecánicos disponibles. Implementa validaciones robustas y manejo de excepciones personalizadas para errores de asignación.
## 📦 Estructura de Paquetes
Se asume la estructura de paquetes `com.taller`.

| Paquete | Contenido / Descripción |
| :--- | :--- |
| `com.taller/` | **Raíz** del proyecto. |
| `├── modelo/` | Clases de datos (entidades): `com.tallermotos.modelo.com.tallermotos.modelo.Person`, `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client`, `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic`, `com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.MaintenanceService`. |
| `├── servicio/` | Clases de lógica de negocio: `com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.com.tallermotos.servicio.GestorTallerMotos`. |
| `├── excepciones/` | Clases de excepciones personalizadas. |
| `└── Main.java` | Clase principal para la ejecución y demostración. |

## ⚠️ Excepciones Personalizadas

### 1. MechanicNotFoundException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Se lanza cuando el sistema intenta buscar o asignar un servicio a un mecánico utilizando un ID que no está registrado en la lista de personal.
- **Ejemplo**: Un usuario intenta asignar la Orden 1002 al Mecánico con ID 99, pero solo existen mecánicos con IDs 10 y 20.

### 2. MechanicNotAvailableException
- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: Se lanza cuando el mecánico solicitado existe, pero su estado (isAvailable) es false, indicando que ya tiene un trabajo asignado y no puede recibir uno nuevo.
- **Ejemplo**: Un usuario intenta asignar la Orden 1003 al Mecánico Luis Gómez (ID 20), pero Luis ya está trabajando en la Orden 1001.

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
cd semana-07
javac -d bin src/com/tallermotos/*/*.java src/com/tallermotos/*.java
java -cp bin com.tallermotos.Main