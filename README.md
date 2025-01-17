# Literatura Alura

Este es un proyecto de gestión de libros y autores, desarrollado como parte de un curso en Alura. La aplicación permite buscar libros, listar todos los libros y listar autores vivos.

## Tecnologías Utilizadas

- **Java**: Versión 17
- **Spring Boot**: Versión 3.4.1
- **Spring Data JPA**: Para la gestión de la base de datos
- **PostgreSQL**: Base de datos utilizada
- **HikariCP**: Conexión a la base de datos
- **Maven**: Gestión de dependencias

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalados los siguientes programas:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuración

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu_usuario/literatura.git
   cd literatura
   ```

2. **Configura las variables de entorno**:

   Asegúrate de configurar las siguientes variables de entorno en tu sistema:

   - `DB_URL`: `jdbc:postgresql://localhost:5432/liter_alura`
   - `DB_USERNAME`: `postgres`
   - `DB_PASSWORD`: `tu_contraseña`

3. **Crea la base de datos**:

   Crea una base de datos en PostgreSQL llamada `liter_alura`.

4. **Ejecuta la aplicación**:

   Puedes ejecutar la aplicación usando Maven:

   ```bash
   mvn spring-boot:run
   ```

## Uso

Una vez que la aplicación esté en ejecución, puedes acceder a ella en `http://localhost:8080`. El menú principal te permitirá:

1. Buscar libro por título
2. Listar todos los libros
3. Listar autores vivos
4. Salir

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Agregué una nueva característica'`).
4. Haz un push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme:

- **Tu Perfil de GitHub**:  https://github.com/HectorSotoDiaz
