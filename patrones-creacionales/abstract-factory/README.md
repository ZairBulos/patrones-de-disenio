# Abstract Factory

Es un patrón de diseño creacional que nos permite producir familias de objetos relacionados sin especificar sus clases concretas.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/abstract-factory/structure.png)

1. Los **Productos Abstractos** declaran interfaces para un grupo de productos diferentes pero relacionados que forman una familia de productos.
2. Los **Productos Concretos** son implementaciones distintas de productos abstractos agrupados por variantes. Cada producto abstracto debe implementarse en todas las variantes dadas.
3. La interfaz **Fábrica Abstracta** declara un grupo de métodos para crear cada uno de los productos abstractos.
4. Las **Fábricas Concretas** implementan métodos de creación de la fábrica abstracta. Cada fábrica concreta se corresponde con una variante específica de los productos y crea tan solo dichas variantes de los productos.
5. Aunque las fábricas concretas instancian productos concretos, las firmas de sus métodos de creación deben devolver los productos *abstractos* correspondientes. De este modo, el código cliente que utiliza una fábrica no se acopla a la variante específica del producto que obtiene de una fábrica. El **Cliente** puede funcionar con cualquier variante fábrica/producto concreta, siempre y cuando se comunique con sus objetos a través de interfaces abstractas.

## Aplicabilidad

- Cuando tu código deba funcionar con varias familias de productos relacionados, pero no desees que dependa de las clases concretas de esos productos, ya que puede ser que no los conozcas de antemano o sencillamente quieras permitir una futura extensibilidad.
- Cuando tengas una clase con un grupo de métodos de fábrica que nublen su responsabilidad principal.

## ¿Cómo implementarlo?

1. Mapea una matriz de distintos tipos de productos frente a variantes de dichos productos. 
2. Declara interfaces abstractas de producto para todos los tipos de productos. Después haz que todas las clases concretas de productos implementen esas interfaces. 
3. Declara la interfaz de la fábrica abstracta con un grupo de métodos de creación para todos los productos abstractos. 
4. Implementa un grupo de clases concretas de fábrica, una por cada variante de producto. 
5. Crea un código de inicialización de la fábrica en algún punto de la aplicación. Deberá instanciar una de las clases concretas de la fábrica, dependiendo de la configuración de la aplicación o del entorno actual. Pasa este objeto de fábrica a todas las clases que construyen productos. 
6. Explora el código y encuentra todas las llamadas directas a constructores de producto. Sustitúyelas por llamadas al método de creación adecuado dentro del objeto de fábrica.

## Pros y contras

### Pros

- Puedes tener la certeza de que los productos que obtienes de una fábrica son compatibles entre sí.
- Evitas un acoplamiento fuerte entre productos concretos y el código cliente.
- *Principio de responsabilidad única*. Puedes mover el código de creación de productos a un solo lugar, haciendo que el código sea más fácil de mantener.
- *Principio de abierto/cerrado*. Puedes introducir nuevas variantes de productos sin descomponer el código cliente existente.

### Contras

- Puede ser que el código se complique más de lo que debería, ya que se introducen muchas nuevas interfaces y clases junto al patrón.

## Relaciones con otros patrones

- Muchos diseños empiezan utilizando el Factory Method (menos complicado y más personalizable mediante las subclases) y evolucionan hacia Abstract Factory, Prototype, o Builder (más flexibles, pero más complicados). 
- Builder se enfoca en construir objetos complejos, paso a paso. Abstract Factory se especializa en crear familias de objetos relacionados. Abstract Factory devuelve el producto inmediatamente, mientras que Builder te permite ejecutar algunos pasos adicionales de construcción antes de extraer el producto. 
- Las clases del Abstract Factory a menudo se basan en un grupo de métodos de fábrica, pero también puedes utilizar Prototype para escribir los métodos de estas clases. 
- Abstract Factory puede servir como alternativa a Facade cuando tan solo deseas esconder la forma en que se crean los objetos del subsistema a partir del código cliente. 
- Puedes utilizar Abstract Factory junto a Bridge. Este emparejamiento resulta útil cuando algunas abstracciones definidas por Bridge sólo pueden funcionar con implementaciones específicas. En este caso, Abstract Factory puede encapsular estas relaciones y esconder la complejidad al código cliente. 
- Los patrones Abstract Factory, Builder y Prototype pueden todos ellos implementarse como Singletons.