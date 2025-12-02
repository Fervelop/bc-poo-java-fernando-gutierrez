# Jerarquía de Clases - Semana 04

## Diagrama
```
             com.tallermotos.modelo.com.tallermotos.modelo.Person
                |
           +----+----+
           |         |
        com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client    com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic
```
## Justificación
Se eligió esta jerarquía porque tanto com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client como com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic representan tipos de personas dentro del dominio del taller, y comparten atributos comunes como:
- Nombre
- Apellido
- Teléfono
- Email

Al crear la clase padre com.tallermotos.modelo.com.tallermotos.modelo.Person, se logra:

1. Evitar duplicación de código.
2. Mantener una estructura limpia y escalable.
3. Facilitar la extensión futura (otros roles también podrían heredar de com.tallermotos.modelo.com.tallermotos.modelo.Person).
4. Permitir polimorfismo entre diferentes tipos de personas.

Esta jerarquía se ajusta perfectamente al contexto del taller, donde múltiples roles comparten características esenciales.

## Atributos Heredados
Las clases com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client y com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic heredan los siguientes atributos desde com.tallermotos.modelo.com.tallermotos.modelo.Person:
- name (String)
- lastName (String)
- phoneNumber (long)
- email (String)

Estos atributos están declarados como protected, lo que permite que las subclases los utilicen directamente sin necesidad de getters.

## Métodos Sobrescritos
- ```infoPerson()``` : Este método se encuentra en com.tallermotos.modelo.com.tallermotos.modelo.Person, pero cada subclase lo implementa según su necesidad:

com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client:
Muestra datos del cliente y además la información de la moto y su historial de servicios.

com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic:
Muestra los datos del mecánico, su especialización, estado de disponibilidad y trabajos realizados.

- ```getRole()``` : Este método demuestra polimorfismo, ya que el comportamiento cambia según el tipo real del objeto, incluso si es accedido desde una referencia del tipo com.tallermotos.modelo.com.tallermotos.modelo.Person.

com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Client: retorna "Cliente del taller".

com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.com.tallermotos.modelo.Mechanic: retorna "Mecánico especializado en <especialización>".

