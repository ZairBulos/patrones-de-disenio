# Bridge

Es un patrón de diseño estructural que te permite dividir una clase grande, o un grupo de clases estrechamente relacionadas, en dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/bridge/structure-es.png)

1. La **Abstracción** ofrece lógica de control de alto nivel. Depende de que el objeto de la implementación haga el trabajo de bajo nivel.
2. La **Implementación** declara la interfaz común a todas las implementaciones concretas. Una abstracción sólo se puede comunicar con un objeto de implementación a través de los métodos que se declaren aquí. 

   La abstracción puede enumerar los mismos métodos que la implementación, pero normalmente la abstracción declara funcionalidades complejas que dependen de una amplia variedad de operaciones primitivas declaradas por la implementación.

3. Las **Implementaciones Concretas** contienen código específico de plataforma.
4. Las **Abstracciones Refinadas** proporcionan variantes de lógica de control. Como sus padres, trabajan con distintas implementaciones a través de la interfaz general de implementación.
5. Normalmente, el **Cliente** sólo está interesado en trabajar con la abstracción. No obstante, el cliente tiene que vincular el objeto de la abstracción con uno de los objetos de la implementación.

## Aplicabilidad

- Cuando quieras dividir y organizar una clase monolítica que tenga muchas variantes de una sola funcionalidad (por ejemplo, si la clase puede trabajar con diversos servidores de bases de datos).
- Cuando necesites extender una clase en varias dimensiones ortogonales (independientes).
- Cuando necesites poder cambiar implementaciones durante el tiempo de ejecución.

## ¿Cómo implementarlo?

1. Identifica las dimensiones ortogonales de tus clases. Estos conceptos independientes pueden ser: *abstracción/plataforma*, *dominio/infraestructura*, *front end/back end*, o *interfaz/implementación*.
2. Comprueba qué operaciones necesita el cliente y defínelas en la clase base de abstracción. 
3. Determina las operaciones disponibles en todas las plataformas. Declara aquellas que necesite la abstracción en la interfaz general de implementación. 
4. Crea clases concretas de implementación para todas las plataformas de tu dominio, pero asegúrate de que todas sigan la interfaz de implementación. 
5. Dentro de la clase de abstracción añade un campo de referencia para el tipo de implementación. La abstracción delega la mayor parte del trabajo al objeto de la implementación referenciado en ese campo. 
6. Si tienes muchas variantes de lógica de alto nivel, crea abstracciones refinadas para cada variante extendiendo la clase base de abstracción. 
7. El código cliente debe pasar un objeto de implementación al constructor de la abstracción para asociar el uno con el otro. Después, el cliente puede ignorar la implementación y trabajar solo con el objeto de la abstracción.

## Pros y contras

### Pros

- Puedes crear clases y aplicaciones independientes de plataforma.
- El código cliente funciona con abstracciones de alto nivel. No está expuesto a los detalles de la plataforma.
- *Principio de abierto/cerrado*. Puedes introducir nuevas abstracciones e implementaciones independientes entre sí.
- *Principio de responsabilidad única*. Puedes centrarte en la lógica de alto nivel en la abstracción y en detalles de la plataforma en la implementación.

### Contras

- Puede ser que el código se complique si aplicas el patrón a una clase muy cohesionada.