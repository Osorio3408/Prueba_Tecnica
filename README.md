Preguntas teóricas (Conceptuales, cortas)

1. Explica qué diferencia hay entre:
   * HashMap y ConcurrentHashMap.
     * *HashMap*: Es una colección no sincronizada, que permite almacenar pares clave/valor (similar a un diccionario), permite valores null tanto en claves como en valores y no es segura en entornos concurrentes.
     * *ConcurrentHashMap*: Tiene la misma estructura de pares clave/valor, pero no permite null, está diseñada para entornos multihilo y permite lecturas concurrentes sin bloquear toda la estructura.

   * List, Set y Map en Java Collections.
     * *List*: Es una colección ordenada que permite elementos duplicados. Cada elemento tiene una posición (índice) y puede accederse por su número de índice. 
     * *Set*: Es una colección que no permite elementos duplicados. El orden depende de la implementación. Se usa cuando se requiere unicidad.
     * *Map*: No forma parte directa de Collection, pero pertenece al mismo framework. Almacena pares clave/valor, donde las claves son únicas y los valores pueden repetirse.


2. ¿Qué es un Optional en Java y para qué sirve?  
    * Es una clase contenedora que representa un valor que puede o no estar presente, evitando el uso directo de null y permite manejar la ausencia de datos de forma segura y declarativa.
 
  
3. ¿Cómo manejarías excepciones en un servicio que accede a base de
   datos? 
   * Utilizaría un manejo centralizado de errores mediante try-catch y excepciones personalizadas. En la capa de acceso a datos (como DAO o Repository) capturaría errores específicos y los traduciría a excepciones de negocio.   
     Además, aseguraría el uso de transacciones con @Transactional para garantizar la integridad de los datos en caso de fallos.


4. ¿Qué diferencia hay entre @Component, @Service y @Repository en
   Spring?  
   * @Component: Es una anotación genérica que marca una clase como un bean gestionado por el contenedor de Spring.  
        Se utiliza cuando la clase no encaja en un rol específico 
   * @Service: Es una especialización de @Component usada en la lógica de la aplicación. Indica que la clase contiene la lógica principal del sistema y mejora la legibilidad semántica del código.
   * @Repository: También hereda de @Component, pero se usa en la capa de acceso a datos. Permite manejar excepciones específicas de la base de datos.


5. En Fineract, el backend expone una API REST: ¿cómo mapeamos un
endpoint?
    * Ejemplo:
      ```java
      @RestController
      @RequestMapping("/api/v1/clients")
      public class ClientController {
        @GetMapping("/{id}")
        public ClientDto getById(@PathVariable Long id) {  }
        
        @PostMapping
        public ClientDto create(@RequestBody ClientDto payload) { }
      }
      ```