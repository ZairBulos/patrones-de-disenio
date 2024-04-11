# Template Method

Es un patrón de diseño de comportamiento que define el esqueleto de un algoritmo en la superclase pero permite que las subclases sobrescriban pasos del algoritmo sin cambiar su estructura.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/template-method/structure.png)

1. La **Clase Abstracta** declara métodos que actúan como pasos de un algoritmo, así como el propio método plantilla que invoca estos métodos en un orden específico. Los pasos pueden declararse `abstractos` o contar con una implementación por defecto.
2. Las **Clases Concretas** pueden sobrescribir todos los pasos, pero no el propio método plantilla.

## Aplicabilidad

- Cuando quieras permitir a tus clientes que extiendan únicamente pasos particulares de un algoritmo, pero no todo el algoritmo o su estructura.
- Cuando tengas muchas clases que contengan algoritmos casi idénticos, pero con algunas diferencias mínimas. Como resultado, puede que tengas que modificar todas las clases cuando el algoritmo cambie.

## ¿Cómo implementarlo?

1. Analiza el algoritmo objetivo para ver si puedes dividirlo en pasos. Considera qué pasos son comunes a todas las subclases y cuáles siempre serán únicos.
2. Crea la clase base abstracta y declara el método plantilla y un grupo de métodos abstractos que representen los pasos del algoritmo. Perfila la estructura del algoritmo en el método plantilla ejecutando los pasos correspondientes. Considera declarar el método plantilla como `final` para evitar que las subclases lo sobrescriban.
3. No hay problema en que todos los pasos acaben siendo abstractos. Sin embargo, a algunos pasos les vendría bien tener una implementación por defecto. Las subclases no tienen que implementar esos métodos.
4. Piensa en añadir ganchos entre los pasos cruciales del algoritmo.
5. Para cada variación del algoritmo, crea una nueva subclase concreta. Ésta debe implementar todos los pasos abstractos, pero también puede sobrescribir algunos de los opcionales.

## Pros y contras

### Pros

- Puedes permitir a los clientes que sobrescriban tan solo ciertas partes de un algoritmo grande, para que les afecten menos los cambios que tienen lugar en otras partes del algoritmo.
- Puedes colocar el código duplicado dentro de una superclase.

### Contras

- Algunos clientes pueden verse limitados por el esqueleto proporcionado de un algoritmo.
- Puede que violes el *principio de sustitución de Liskov* suprimiendo una implementación por defecto de un paso a través de una subclase.
- Los métodos plantilla tienden a ser más difíciles de mantener cuantos más pasos tengan.