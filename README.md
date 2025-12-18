# Sistema de Gestión de Alumnos (Java Desktop)

Aplicación de escritorio desarrollada en Java para la administración eficiente de información académica. El sistema permite gestionar datos de alumnos mediante operaciones CRUD, persistencia de datos relacional y manipulación de archivos externos.

## 🚀 Características Principales
* **Gestión de Datos (CRUD):** Registro, lectura, actualización y eliminación de alumnos.
* **Sistema de Login:** Control de acceso mediante autenticación de usuarios administradores.
* **Patrón de Diseño DAO:** Arquitectura en capas para separar la lógica de negocio del acceso a datos.
* **Importación Masiva:** Funcionalidad para cargar datos desde archivos **Excel (.xlsx)** utilizando Apache POI.
* **Búsqueda Avanzada:** Filtros dinámicos mediante consultas SQL optimizadas.
* **Interfaz Gráfica:** Desarrollada con Java Swing.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java SE (JDK 17+)
* **Base de Datos:** PostgreSQL
* **Librerías:**
    * `postgresql-42.x.jar` (Conector JDBC)
    * `apache-poi` (Manipulación de Excel)
* **IDE Recomendado:** NetBeans / Eclipse / IntelliJ IDEA

## 🗄️ Base de Datos (PostgreSQL)
El proyecto incluye un script `db/database.sql` con la estructura completa.

### Estructura
* **Tablas:** `usuarios` (Admin), `alumnos` (Datos académicos) y `sedes` (Catálogo de campus).
* **Procedimientos Almacenados:** Se implementaron funciones PL/pgSQL (`pa_mostrarAlumnos`, `pa_buscaralumnosApellidos`) para optimizar las consultas desde Java.

### ⚠️ Reinicio de Datos (Importante para Pruebas)
Si deseas realizar una nueva importación masiva desde un archivo Excel diferente y necesitas limpiar la base de datos, utiliza el siguiente comando SQL incluido en el script. Esto eliminará todos los registros de alumnos y reiniciará los contadores de ID a 1:

```sql```
TRUNCATE TABLE alumnos RESTART IDENTITY CASCADE;

## ⚙️ Instrucciones de Instalación
1. Clonar el repositorio o descargar el código fuente.
2. Ejecutar el script SQL ubicado en la carpeta `db/database.sql` para crear la base de datos y tablas necesarias en PostgreSQL.
3. Abrir el proyecto en tu IDE de preferencia.
4. Asegurarse de agregar los `.jar` de la carpeta `lib` al *Class Path* del proyecto.
5. Configurar las credenciales de conexión en el archivo `Conexion.java` (dentro de `src`).
6. Ejecutar la clase principal: **Login.java**
7. **Crear Usuario / Login:** Al iniciar la app, utiliza la opción "Registrar" para crear un nuevo usuario administrador, luego inicia sesión con esas credenciales para acceder al panel de gestión de información.

---
**Autor:** Adriano Alonso Zulaoga Aybar - *Proyecto Académico / Portafolio*
