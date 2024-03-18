# Prototype

Es un patrón de diseño creacional que nos permite copiar objetos existentes sin que el código dependa de sus clases.

## Estructura

### Implementación básica

![](https://refactoring.guru/images/patterns/diagrams/prototype/structure.png)

1. La interfaz **Prototipo** declara los métodos de clonación. En la mayoría de los casos, se trata de un único método `clonar`.
2. La clase **Prototipo Concreto** implementa el método de clonación. Además de copiar la información del objeto original al clon, este método también puede gestionar algunos casos extremos del proceso de clonación, como, por ejemplo, clonar objetos vinculados, deshacer dependencias recursivas, etc.
3. El **Cliente** puede producir una copia de cualquier objeto que siga la interfaz del prototipo.

### Implementación del registro de prototipos

![](https://refactoring.guru/images/patterns/diagrams/prototype/structure-prototype-cache.png)

1. El **Registro de Prototipos** ofrece una forma sencilla de acceder a prototipos de uso frecuente. Almacena un grupo de objetos prefabricados listos para ser copiados. El registro de prototipos más sencillo es una tabla *hash* con los pares `name → prototype`. No obstante, si necesitas un criterio de búsqueda más preciso que un simple nombre, puedes crear una versión mucho más robusta del registro.

## Aplicabilidad

- Cuando tu código no deba depender de las clases concretas de objetos que necesites copiar.
- Cuando quieras reducir la cantidad de subclases que solo se diferencian en la forma en que inicializan sus respectivos objetos. Puede ser que alguien haya creado estas subclases para poder crear objetos con una configuración específica.

## ¿Cómo implementarlo?

1. Crea la interfaz del prototipo y declara el método `clonar` en ella, o, simplemente, añade el método a todas las clases de una jerarquía de clase existente, si la tienes. 
2. Una clase de prototipo debe definir el constructor alternativo que acepta un objeto de dicha clase como argumento. El constructor debe copiar los valores de todos los campos definidos en la clase del objeto que se le pasa a la instancia recién creada. Si deseas cambiar una subclase, debes invocar al constructor padre para permitir que la superclase gestione la clonación de sus campos privados.

    Si el lenguaje de programación que utilizas no soporta la sobrecarga de métodos, puedes definir un método especial para copiar la información del objeto. El constructor es el lugar más adecuado para hacerlo, porque entrega el objeto resultante justo después de invocar el operador `new`.
    
3. Normalmente, el método de clonación consiste en una sola línea que ejecuta un operador `new` con la versión prototípica del constructor. Observa que todas las clases deben sobreescribir explícitamente el método de clonación y utilizar su propio nombre de clase junto al operador new. De lo contrario, el método de clonación puede producir un objeto a partir de una clase madre. 
4. Opcionalmente, puedes crear un registro de prototipos centralizado para almacenar un catálogo de prototipos de uso frecuente. 

   Puedes implementar el registro como una nueva clase de fábrica o colocarlo en la clase base de prototipo con un método estático para buscar el prototipo. Este método debe buscar un prototipo con base en el criterio de búsqueda que el código cliente pase al método. El criterio puede ser una etiqueta tipo string o un grupo complejo de parámetros de búsqueda. Una vez encontrado el prototipo adecuado, el registro deberá clonarlo y devolver la copia al cliente.
   
   Por último, sustituye las llamadas directas a los constructores de las subclases por llamadas al método de fábrica del registro de prototipos.

## Pros y contras

### Pros

- Puedes clonar objetos sin acoplarlos a sus clases concretas. 
- Puedes evitar un código de inicialización repetido clonando prototipos prefabricados. 
- Puedes crear objetos complejos con más facilidad. 
- Obtienes una alternativa a la herencia al tratar con preajustes de configuración para objetos complejos.

### Contras

- Clonar objetos complejos con referencias circulares puede resultar complicado.