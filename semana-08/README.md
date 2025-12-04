# 🏍️ Sistema de Gestión - Taller de Motos "Velocidad Segura"

Este proyecto implementa un **sistema de gestión para un taller de motos**, para la gestion de motos, clientes, servicios, busquedas y filtros y algunas estadisticas relevantes teniendo el cuenta que se puede administrar desde las clases:

- **Motos**
- **Clientes**
- **Servicios del taller**

---

## Funcionalidades Principales

### 1. Gestión de Motos
- Registrar moto
- Buscar moto por placa
- Actualizar información
- Eliminar moto

### 2. Gestión de Clientes
- Registrar cliente
- Buscar cliente por ID
- Actualizar datos
- Eliminar cliente

### 3. Gestión de Servicios
- Crear servicio
- Validar tipo y existencia de la moto
- Cambiar estado
- Marcar como finalizado
- Agregar al historial

### 4. Búsquedas y Filtros
- Servicios por placa
- Servicios por tipo
- Servicios activos

### 5. Estadísticas
- Tipo de servicio más solicitado
- Cliente con más servicios
- Número de servicios por moto

---

## 🗂️ Estructuras de Datos Utilizadas

El sistema utiliza las siguientes colecciones:

| Tipo                      | Uso |
|---------------------------|-----|
| `Map<String, Motorcycle>` | Almacena motos por número de placa |
| `Map<String, Client>`     | Almacena clientes por su ID |
| `List<Service>`           | Historial completo de servicios |
| `Set<String>`             | Conjunto de tipos de servicio válidos |

Estas estructuras garantizan:
- Búsquedas rápidas
- Evitar duplicados
- Gestión ordenada del historial

---

## 🧩 Diagrama de Clases (Opcional)

```
+------------------+ +-------------------+
|    Motorcycle    | |      Client       |
+------------------+ +-------------------+
| - plate          | | - idClient        |
| - carBrand       | | - name            |
| - model          | | - phoneNumber     |
| - year           | +-------------------+
+------------------+

+----------------------------+
|         Service            |
+----------------------------+
| - idService                |
| - typeService              |
| - state                    |
| - motorcycle : Motorcycle  |
| - client : Client          |
+----------------------------+

+-----------------+
|    Gestor       |
+-----------------+
| Map motorcycle  |
| Map clients     |
| List services   |
| Set types       |
+-----------------+

```
---

## Ejecución del Menú (Consola)

#### MENU TALLER DE MOTOS

1. Registrar Moto 
   - Buscar Moto por placa 
   - Eliminar Moto
2. Registrar Cliente
   - Buscar Cliente por ID
   - Eliminar Cliente
3. Crear Servicio
4. Ver Servicios Activos
5. Actualizar Moto
6. Actualizar Cliente
7. Cambiar Estado de Servicio
8. Finalizar Servicio
9. Ver Todos los Servicios

0. Salir

---

### Requisitos Previos para el Uso del Sistema

Antes de crear un servicio, debes tener:

### Una Moto registrada
Cada moto debe contener:
- Placa (única)
- Marca
- Modelo
- Año

### Un Cliente registrado
Cada cliente debe contener:
- ID (único)
- Nombre
- Teléfono

###  Servicio
Para crear un servicio, el sistema valida:
- Que exista la moto asociada.
- Que exista el cliente.
- Que el tipo de servicio no esté vacío.
- Que el ID del servicio no esté repetido.

Si alguno de estos datos no existe, el servicio **no podrá crearse**.

### Pasos para Registrar Entidades

## Registrar una Moto

Opción: **1**

El sistema solicitará:
- Placa
- Marca
- Modelo
- Año

Si la placa no existe aún, la moto quedará registrada.

---

## Registrar un Cliente

Opción: **2**

El sistema solicitará:
- ID del cliente
- Nombre
- Teléfono

Si el ID no existe, se registrará correctamente.

---

# Crear un Servicio

Opción: **3**

El sistema pedirá:
- ID del Servicio
- Tipo del Servicio (ej: "Mantenimiento", "Frenos", "Aceite")
- Placa de la Moto asociada
- ID del Cliente que solicita el servicio

El sistema valida:
- Que la moto exista
- Que el cliente exista
- Que el ID del servicio no esté duplicado
- Que el tipo de servicio no esté vacío

Si todo es válido → El servicio se crea y queda en estado **"Pendiente"**.

---

# Ver Servicios Activos

Opción: **4**

Muestra los servicios cuyo estado NO es "Finalizado".  

### Actualización de Información

## Actualizar Moto
Opción: **5**

Debes ingresar:
- Placa → Identifica la moto
- Nueva marca
- Nuevo modelo
- Nuevo año

Si la moto existe, se actualiza.

---

## Actualizar Cliente
Opción: **6**

Debes ingresar:
- ID del cliente
- Nuevo nombre
- Nuevo teléfono

Si el cliente existe, se actualiza.

---

## Gestión de Servicios

### Cambiar Estado del Servicio
Opción: **7**

Estados permitidos:
- "Pendiente"
- "En Proceso"
- "Finalizado"

Solo debes ingresar:
- ID del servicio
- Nuevo estado

---

##  Finalizar Servicio
Opción: **8**

Ingresa:
- ID del servicio

El sistema:
- Cambia el estado a **Finalizado**
- Lo mueve al historial si corresponde

---

#  Ver Todos los Servicios

Opción: **9**

Se muestran en una tabla ordenada:

### Salir del Sistema

Opción: **0**

Finaliza la aplicación.

---

# Conclusión

Este sistema permite gestionar:
- Motos
- Clientes
- Servicios

A través de:
- CRUD completo
- Validaciones
- Múltiples consultas
- Estadísticas (en el gestor)
- Menú interactivo fácil de usar


## 📁 Estructura del Proyecto
```
src/com.tallermotos
├── modelo/
│ ├── Motorcycle.java
│ ├── Client.java
│ └── Service.java
├── servicio/
│ └── Gestor.java
├── util/
│ └── Validator.java
└── main/
```
---
