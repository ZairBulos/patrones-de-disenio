# Flyweight

Es un patrón de diseño estructural que te permite mantener más objetos dentro de la cantidad disponible de RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/flyweight/structure.png)

1. La clase **Flyweight** contiene la parte del estado del objeto original que pueden compartir varios objetos. El mismo objeto flyweight puede utilizarse en muchos contextos diferentes. El estado almacenado dentro de un objeto flyweight se denomina *intrínseco*, mientras que al que se pasa a sus métodos se le llama *extrínseco*.
2. La clase **Contexto** contiene el estado extrínseco, único en todos los objetos originales. Cuando un contexto se empareja con uno de los objetos flyweight, representa el estado completo del objeto original.
3. Normalmente, el comportamiento del objeto original permanece en la clase flyweight. En este caso, quien invoque un método del objeto flyweight debe también pasar las partes adecuadas del estado extrínseco dentro de los parámetros del método. Por otra parte, el comportamiento se puede mover a la clase de contexto, que utilizará el objeto flyweight vinculado como mero objeto de datos.
4. El **Cliente** calcula o almacena el estado extrínseco de los objetos flyweight. Desde la perspectiva del cliente, un flyweight es un objeto plantilla que puede configurarse durante el tiempo de ejecución pasando información contextual dentro de los parámetros de sus métodos.
5. La **Fábrica flyweight** gestiona un grupo de objetos flyweight existentes. Con la fábrica, los clientes no crean objetos flyweight directamente. En lugar de eso, invocan a la fábrica, pasándole partes del estado intrínseco del objeto flyweight deseado. La fábrica revisa objetos flyweight creados previamente y devuelve uno existente que coincida con los criterios de búsqueda, o bien crea uno nuevo si no encuentra nada.

## Aplicabilidad

- Cuando tu programa deba soportar una enorme cantidad de objetos que apenas quepan en la RAM disponible.
  - la aplicación necesita generar una cantidad enorme de objetos similares
  - esto consume toda la RAM disponible de un dispositivo objetivo
  - los objetos contienen estados duplicados que se pueden extraer y compartir entre varios objetos

## ¿Cómo implementarlo?

1. Divide los campos de una clase que se convertirá en flyweight en dos partes:
   - el estado intrínseco: los campos que contienen información invariable duplicada a través de varios objetos
   - el estado extrínseco: los campos que contienen información contextual única de cada objeto
2. Deja los campos que representan el estado intrínseco en la clase, pero asegúrate de que sean inmutables. Deben llevar sus valores iniciales únicamente dentro del constructor.
3. Repasa los métodos que utilizan campos del estado extrínseco. Para cada campo utilizado en el método, introduce un nuevo parámetro y utilízalo en lugar del campo. 
4. Opcionalmente, crea una clase fábrica para gestionar el grupo de objetos flyweight, buscando uno existente antes de crear uno nuevo. Una vez que la fábrica esté en su sitio, los clientes sólo deberán solicitar objetos flyweight a través de ella. Deberán describir el flyweight deseado pasando su estado intrínseco a la fábrica. 
5. El cliente deberá almacenar o calcular valores del estado extrínseco (contexto) para poder invocar métodos de objetos flyweight. Por comodidad, el estado extrínseco puede moverse a una clase contexto separada junto con el campo referenciador del flyweight.

## Pros y contras

### Pros

- Puedes ahorrar mucha RAM, siempre que tu programa tenga toneladas de objetos similares.

### Contras

- Puede que estés cambiando RAM por ciclos CPU cuando deba calcularse de nuevo parte de la información de contexto cada vez que alguien invoque un método flyweight.
- El código se complica mucho. Los nuevos miembros del equipo siempre estarán preguntándose por qué el estado de una entidad se separó de tal manera.