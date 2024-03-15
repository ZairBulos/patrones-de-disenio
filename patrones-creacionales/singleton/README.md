# Singleton

es un patrón de diseño creacional que nos permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/singleton/structure-es.png)

1. La clase **Singleton** declara el método estático `obtenerInstancia` que devuelve la misma instancia de su propia clase.

    El constructor del Singleton debe ocultarse del código cliente. La llamada al método `obtenerInstancia` debe ser la única manera de obtener el objeto de Singleton.

## Aplicabilidad

- Cuando una clase de tu programa tan solo deba tener una instancia disponible para todos los clientes.
- Cuando necesites un control más estricto de las variables globales.

## ¿Cómo implementarlo?

1. Añade un campo estático privado a la clase para almacenar la instancia Singleton. 
2. Declara un método de creación estático público para obtener la instancia Singleton. 
3. Implementa una inicialización diferida dentro del método estático. Debe crear un nuevo objeto en su primera llamada y colocarlo dentro del campo estático. El método deberá devolver siempre esa instancia en todas las llamadas siguientes. 
4. Declara el constructor de clase como privado. El método estático de la clase seguirá siendo capaz de invocar al constructor, pero no a los otros objetos. 
5. Repasa el código cliente y sustituye todas las llamadas directas al constructor de la instancia Singleton por llamadas a su método de creación estático.

## Pros y contras

### Pros

- Puedes tener la certeza de que una clase tiene una única instancia. 
- Obtienes un punto de acceso global a dicha instancia. 
- El objeto Singleton solo se inicializa cuando se requiere por primera vez.

### Contras

- Vulnera el *Principio de responsabilidad única*. El patrón resuelve dos problemas al mismo tiempo.
- El patrón Singleton puede enmascarar un mal diseño, por ejemplo, cuando los componentes del programa saben demasiado los unos sobre los otros. 
- El patrón requiere de un tratamiento especial en un entorno con múltiples hilos de ejecución, para que varios hilos no creen un objeto Singleton varias veces. 
- Puede resultar complicado realizar la prueba unitaria del código cliente del Singleton porque muchos *frameworks* de prueba dependen de la herencia a la hora de crear objetos simulados (mock objects). Debido a que la clase Singleton es privada y en la mayoría de los lenguajes resulta imposible sobrescribir métodos estáticos, tendrás que pensar en una manera original de simular el Singleton. O, simplemente, no escribas las pruebas. O no utilices el patrón Singleton.

## Relaciones con otros patrones

- Una clase fachada a menudo puede transformarse en una Singleton, ya que un único objeto fachada es suficiente en la mayoría de los casos. 
- Flyweight podría asemejarse a Singleton si de algún modo pudieras reducir todos los estados compartidos de los objetos a un único objeto flyweight. Pero existen dos diferencias fundamentales entre estos patrones:
  1. Solo debe haber una instancia Singleton, mientras que una clase Flyweight puede tener varias instancias con distintos estados intrínsecos. 
  2. El objeto Singleton puede ser mutable. Los objetos flyweight son inmutables.
- Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.