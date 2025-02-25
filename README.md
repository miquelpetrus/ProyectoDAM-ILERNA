# MolíGest

## Descripción del Proyecto
MolíGest es un software de gestión integral diseñado específicamente para asociaciones de vecinos. Su objetivo es optimizar la administración de recursos, la gestión de eventos, la comunicación interna y la transparencia financiera dentro de una AAVV (Asociación de Vecinos).

El sistema ha sido desarrollado utilizando el patrón de diseño **MVC** y tecnologías como **Java, Hibernate, Swing, MySQL y Maven**, garantizando una arquitectura modular y escalable.

## Tecnologías Utilizadas
- **Lenguaje**: Java
- **Base de datos**: MySQL
- **Framework ORM**: Hibernate
- **Gestión de dependencias**: Maven
- **Interfaz gráfica**: Swing
- **Control de versiones**: GitHub
- **Entorno de desarrollo**: Eclipse y NetBeans
- **Herramientas adicionales**: MySQL Workbench, PHPMyAdmin, Canva, Photoshop

## Instalación y Configuración
### Requisitos Previos
Antes de instalar MolíGest, asegúrate de tener instalado:
- Java JDK 17 o superior
- MySQL Server 8.0 o superior
- Maven
- Hibernate
- Eclipse o NetBeans (opcional para desarrollo)

### Pasos de Instalación
1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/MoliGest.git
   ```
2. **Configura la base de datos:**
   - Crea una base de datos en MySQL llamada `molisgest_db`.
   - Importa el esquema desde `molisgest_schema.sql` ubicado en `/db/`.
3. **Compila el proyecto:**
   ```bash
   mvn clean install
   ```
4. **Ejecuta la aplicación:**
   ```bash
   java -jar target/molisgest.jar
   ```
5. **Primer inicio:**
   - Usuario: `admin`
   - Contraseña: `admin123` (Se recomienda cambiarla tras el primer inicio)

## Uso del Sistema
MolíGest permite realizar las siguientes acciones:
- **Gestión de socios**: Altas, bajas, modificación y cuotas.
- **Gestión de facturas**: Creación, edición y pago de facturas.
- **Gestión de eventos**: Registro, edición y control de participación.
- **Administración de productos y proveedores**.
- **Seguimiento financiero**: Control de bancos, ingresos y gastos.
- **Seguridad y privacidad**: Acceso con credenciales y encriptación de contraseñas.

## Capturas de Pantalla
*(Se pueden añadir capturas de pantalla de la interfaz si se desea)*

## Vías Futuras
Las próximas mejoras del sistema incluyen:
- **Interfaz gráfica mejorada** con un diseño más intuitivo.
- **Integración con página web** para facilitar el acceso remoto.
- **Servicio de mailing** para comunicación con los socios.
- **Módulo de encuestas** para obtener feedback de la comunidad.

## Contacto
Para más información o colaboración en el proyecto:
📧 **Email:** contacto@moligest.com
🌐 **Repositorio en GitHub:** [https://github.com/tu-usuario/MoliGest](https://github.com/tu-usuario/MoliGest)

---
¡Gracias por contribuir a la mejora de MolíGest! 🚀
