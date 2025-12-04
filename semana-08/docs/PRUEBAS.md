# PRUEBAS DEL SISTEMA — Taller de Motos

Este documento contiene una serie de **casos de prueba manuales** diseñados para validar
el correcto funcionamiento del sistema de Gestión del Taller de Motos.

Cada prueba incluye:

- Objetivo
- Datos de entrada
- Pasos a ejecutar
- Resultado esperado
- Estado

---

##  1. Agregar entidad válida (Registrar Moto)

### **Objetivo:**
Verificar que el sistema permite registrar correctamente una moto válida.

### **Datos de entrada:**
- Placa: `ABC123`
- Marca: `Yamaha`
- Modelo: `FZ`
- Año: `2018`

### **Pasos:**
1. Abrir el menú del sistema.
2. Seleccionar la opción **1. Registrar Moto**.
3. Ingresar los datos indicados.

### **Resultado esperado:**
Se muestra el mensaje **"Moto registrada"**  
y la moto queda almacenada en `Map<String, Moto>`.

### **Estado:**
Aprobado

---

## 2. Búsqueda exitosa (Buscar Cliente por ID)

### **Objetivo:**
Confirmar que el sistema encuentra un cliente previamente registrado.

### **Datos de entrada:**
- Cliente existente con ID: `1010`

### **Pasos:**
1. Registrar un cliente con ID `1010`.
2. Llamar al método `gestor.buscarCliente("1010")`.

### **Resultado esperado:**
Retorna un objeto `Cliente` con ID `1010`.

### **Estado:**
 Aprobado

---

## 3. Actualización de datos (Actualizar Moto)

### **Objetivo:**
Validar que el sistema permita modificar la información de una moto existente.

### **Datos de entrada:**
Moto original:
- Placa: `XYZ45A`
- Marca: `Honda`
- Modelo: `CB`
- Año: `2015`

Actualización:
- Marca: `Honda`
- Modelo: `CBR`
- Año: `2019`

### **Pasos:**
1. Registrar la moto original.
2. Invocar `gestor.actualizarMoto("XYZ45A", "Honda", "CBR", 2019)`.

### **Resultado esperado:**
El método retorna **true**  
y la moto queda actualizada con los nuevos valores.

### **Estado:**
 Aprobado

---

## 4. Validación de error (Registro duplicado)

### **Objetivo:**
Verificar que el sistema **no permite agregar entidades duplicadas**.

### **Datos de entrada:**
Moto con placa: `AAA111`

### **Pasos:**
1. Registrar la moto por primera vez.
2. Intentar registrarla nuevamente.

### **Resultado esperado:**
El segundo registro debe fallar.  
El sistema debe mostrar: **"Error al registrar moto"**  
y el método `registrarMoto()` debe retornar `false`.

### **Estado:**
 Aprobado

---

## 5. Operación compleja (Filtrar servicios activos)

### **Objetivo:**
Validar que el sistema filtre correctamente todos los servicios cuyo estado ≠ "Finalizado".

### **Datos de entrada:**
Registrar tres servicios:
- S1: Pendiente
- S2: En Proceso
- S3: Finalizado

### **Pasos:**
1. Crear las 3 motos y 3 clientes necesarios.
2. Registrar servicios S1, S2, S3.
3. Cambiar estado de S3 a "Finalizado".
4. Ejecutar:  

gestor.serviciosActivos();

### **Resultado esperado:**
La lista devuelta contiene **solo S1 y S2**.  
No incluye S3.

### **Estado:**
️ Aprobado

---

# ️ Conclusión

Estos casos de prueba cubren:

- CRUD básico
- Validaciones
- Búsqueda
- Actualización
- Manejo de errores
- Operaciones más complejas (filtrado y estados)

Se recomienda complementar con pruebas automáticas en JUnit para mayor robustez.
