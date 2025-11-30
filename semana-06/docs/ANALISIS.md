# Análisis de Diseño - Semana 06: Taller de Motos

## 1. Identificación de Abstracciones

### Clase Abstracta
**Nombre:** Service

**¿Por qué es abstracta?**
- Representa el concepto general de un servicio dentro del taller (aceite, frenos, llantas, etc.).
- Tiene atributos comunes que todos los servicios comparten:
    - nombre del servicio
    - costo base
- Tiene métodos comunes como calculateTotalCost(), basicInfo().
- NO puede ser instanciada porque no existe un “servicio genérico” real en el taller.
- Cada subclase implementa comportamiento específico:
    - **OilChangeService** → cambia aceite.
    - **BrakeService** → reemplaza pastillas.
    - **TireChangeService** → cambia llantas.

**Jerarquía:**
Service  
├── OilChangeService  
├── BrakeService  
└── TireChangeService

---

## 2. Interfaces Implementadas

### Interface 1: Repairable
**Capacidad que define:**  
Define si un servicio requiere reparación con piezas adicionales. Sus métodos son:
- requireParts()
- calculateCostParts()
- diagnosticateFault()

**Clases que la implementan:**
- **OilChangeService:** puede requerir filtro, aceite, tapón, etc.
- **BrakeService:** requiere pastillas, líquido de frenos, discos opcionales.
- **TireChangeService:** requiere llantas, válvulas, balanceo.

**Por qué tiene sentido:**  
Todos estos servicios afectan componentes físicos de la moto que requieren piezas, fallas específicas y diagnósticos.

---

### Interface 2: TimeTrackable
**Capacidad que define:**  
Permite realizar un seguimiento del tiempo invertido en un servicio, controlando:
- **startJob:** Inicia el conteo de tiempo.
- **finishJob:** Finaliza el conteo de tiempo.
- **durationJob:** Calcula la duración total del trabajo.

**Por qué tiene sentido:**  
El tiempo es un factor clave en talleres mecánicos porque:
- Afecta el costo de mano de obra.
- Permite medir eficiencia del mecánico.
- Facilita cotizaciones más precisas.
- Algunos servicios requieren tiempos mínimos de seguridad (como purga de frenos).

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para `Service` porque:**
- Hay una relación clara **“es un”** (OilChangeService *es un* Service).
- Todas las subclases comparten estado (atributos).
- Parte de la lógica puede ser implementada en la clase padre.
- Se requiere herencia para reutilizar código común.

**Elegí interfaces para Repairable y TimeTrackable porque:**
- Representan capacidades o comportamientos extra, no una jerarquía.
- Permiten múltiples implementaciones sin forzar herencia múltiple.
- Son contratos claros y obligatorios para quien los implemente.
- No contienen código, solo definen lo que una clase debe poder hacer.

---

## 4. Principios SOLID Aplicados

### **Single Responsibility Principle (SRP)**
- Cada clase tiene una responsabilidad única:
    - *Service:* lógica base del servicio.
    - *OilChangeService:* operaciones específicas del cambio de aceite.
    - *BrakeService:* comportamiento específico del servicio de frenos.
    - *TireChangeService:* lógica del cambio de llantas.
    - *Interfaces:* definen capacidades, no lógica.

---

### **Open/Closed Principle (OCP)**
- Puedes agregar nuevos servicios (ej. ElectricalService) sin modificar los existentes.
- El sistema está abierto a extensión, cerrado a modificación.

---

### **Liskov Substitution Principle (LSP)**
- Cualquier subclase puede sustituir a la clase abstracta Service sin romper el sistema.
- Un método que reciba `Service` puede usar:
    - OilChangeService
    - BrakeService
    - TireChangeService

---

### **Interface Segregation Principle (ISP)**
- Las interfaces están bien separadas:
    - Repairable solo para servicios que usan piezas.
    - TimeTrackable solo para servicios que requieren seguimiento de tiempo.
- Ninguna clase implementa métodos innecesarios.

---

### **Dependency Inversion Principle (DIP)**
- Las dependencias están basadas en abstracciones (Service, Repairable, TimeTrackable) y no en implementaciones concretas.
- Esto permite intercambiar servicios sin afectar el código.

---
## 5. Mejoras Logradas

### **Antes (Semana 05):**
- Todas las clases podían tener comportamiento repetido.
- Los servicios no seguían una estructura común.
- No existía una separación clara de responsabilidades.
- No había contratos (interfaces) para servicios con piezas o diagnósticos.

### **Después (Semana 06):**
- Estructura más ordenada y escalable.
- Comportamientos comunes en `Service`.
- Interfaces claras para capacidades específicas.
- Subclases limpias y especializadas.
- Código más profesional y mantenible.

---

## 6. Diagrama de Clases
```
                           <<abstract>>
                             Service
            |+------------------+------------------+
            |                   |                  |
        OilChange          BrakeService    TireChangeService
            |                   |                  |
        implements          implements         implements
        Repairable          Repairable         Repairable
      TimeTrackable        TimeTrackable      TimeTrackable
```
---
## 7. Desafíos y Soluciones

### **Desafío 1:**
Diferenciar qué va en la clase abstracta y qué pertenece a una subclase.

**Solución:**  
Identificar atributos y comportamientos compartidos, moverlos a `Service` y dejar variaciones en las subclases.

---

### **Desafío 2:**
Evitar que las clases tuvieran métodos que no usaban.

**Solución:**  
Separar interfaces en capacidades específicas (ISP): Repairable y TimeTrackable.

---

## 8. Próximos Pasos

- Implementar un gestor de servicios (ServiceManager).
- Agregar un sistema de asignación de mecánicos.
- Integrar un módulo para facturación.
- Conectar con un sistema de clientes y motos del dueño.