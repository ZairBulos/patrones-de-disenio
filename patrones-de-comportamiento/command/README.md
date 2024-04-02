# Command

Es un patrón de diseño de comportamiento que convierte una solicitud en un objeto independiente que contiene toda la información sobre la solicitud. Esta transformación permite parametrizar los métodos con diferentes solicitudes, retrasar o poner en cola la ejecución de una solicitud y soportar operaciones que no se pueden realizar.

## Estructura

![](https://refactoring.guru/images/patterns/diagrams/command/structure.png?id=1cd7833638f4c43630f4a84017d31195)

1. La clase **Emisora** (o *invocadora*) es responsable de inicializar las solicitudes. Esta clase debe tener un campo para almacenar una referencia a un objeto de comando. El emisor activa este comando en lugar de enviar la solicitud directamente al receptor. Ten en cuenta que el emisor no es responsable de crear el objeto de comando. Normalmente, obtiene un comando precreado de parte del cliente a través del constructor.
2. La interfaz **Comando** normalmente declara un único método para ejecutar el comando.
3. Los **Comandos Concretos** implementan varios tipos de solicitudes. Un comando concreto no se supone que tenga que realizar el trabajo por su cuenta, sino pasar la llamada a uno de los objetos de la lógica de negocio. Sin embargo, para lograr simplificar el código, estas clases se pueden fusionar.

   Los parámetros necesarios para ejecutar un método en un objeto receptor pueden declararse como campos en el comando concreto. Puedes hacer inmutables los objetos de comando permitiendo la inicialización de estos campos únicamente a través del constructor.
4. La clase **Receptora** contiene cierta lógica de negocio. Casi cualquier objeto puede actuar como receptor. La mayoría de los comandos solo gestiona los detalles sobre cómo se pasa una solicitud al receptor, mientras que el propio receptor hace el trabajo real.
5. El **Cliente** crea y configura los objetos de comando concretos. El cliente debe pasar todos los parámetros de la solicitud, incluyendo una instancia del receptor, dentro del constructor del comando. Después de eso, el comando resultante puede asociarse con uno o varios emisores.

## Aplicabilidad

- Cuando quieras parametrizar objetos con operaciones.
- Cuando quieras poner operaciones en cola, programar su ejecución, o ejecutarlas de forma remota.
- Cuando quieras implementar operaciones reversibles.

## ¿Cómo implementarlo?

1. Declara la interfaz de comando con un único método de ejecución.
2. Empieza extrayendo solicitudes y poniéndolas dentro de clases concretas de comando que implementen la interfaz de comando. Cada clase debe contar con un grupo de campos para almacenar los argumentos de las solicitudes junto con referencias al objeto receptor. Todos estos valores deben inicializarse a través del constructor del comando.
3. Identifica clases que actúen como *emisoras*. Añade los campos para almacenar comandos dentro de estas clases. Las emisoras deberán comunicarse con sus comandos tan solo a través de la interfaz de comando. Normalmente las emisoras no crean objetos de comando por su cuenta, sino que los obtienen del código cliente.
4. Cambia las emisoras de forma que ejecuten el comando en lugar de enviar directamente una solicitud al receptor.
5. El cliente debe inicializar objetos en el siguiente orden:

   - Crear receptores. 
   - Crear comandos y asociarlos con receptores si es necesario. 
   - Crear emisores y asociarlos con comandos específicos.

## Pros y contras

### Pros

- *Principio de responsabilidad única*. Puedes desacoplar las clases que invocan operaciones de las que realizan esas operaciones.
- *Principio de abierto/cerrado*. Puedes introducir nuevos comandos en la aplicación sin descomponer el código cliente existente.
- Puedes implementar deshacer/rehacer.
- Puedes implementar la ejecución diferida de operaciones.
- Puedes ensamblar un grupo de comandos simples para crear uno complejo.

### Contra

- El código puede complicarse, ya que estás introduciendo una nueva capa entre emisores y receptores.