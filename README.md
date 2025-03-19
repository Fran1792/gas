<<<<<<< HEAD
# gasolinera1_FJM
=======
# Sistema de Gestión de Gasolinera

## Descripción

Este proyecto implementa una API REST para la gestión de una gasolinera, desarrollado para la empresa CONTOSO S.L. El sistema permite gestionar surtidores, productos (combustibles), precios, tanques y registrar operaciones de suministro de combustible.

Se recomiendo ver el archivo: enunciado_ejercicio.pdf para entender lo que se pretende implementar y también el modelo entidad relación albergado en la raíz de este proyecto.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Lombok
- MySQL/H2 Database
- Maven

## Características Principales

- Gestión de surtidores (alta, baja, modificación)
- Control de productos de combustible (gasolina 95, gasolina 98, diésel normal y diésel premium)
- Registro histórico de precios mensuales
- Monitoreo de niveles de combustible en tanques
- Registro de operaciones de suministro

## Estructura del Proyecto

3. **Precio**: Historial de precios por producto
   - idPrecio (PK)
   - idProducto (FK)
   - fechaInicio
   - fechaFin
   - precioPorLitro

4. **Tanque**: Almacenamiento de combustible
   - idTanque (PK)
   - codigo
   - capacidadMaxima
   - nivelActual
   - idProducto (FK)

5. **Suministro**: Registro de operaciones
   - idSuministro (PK)
   - idSurtidor (FK)
   - idProducto (FK)
   - fechaHora
   - volumenLitros
   - importeEuros

6. **SurtidorProducto**: Relación entre surtidores y productos
   - idSurtidorProducto (PK)
   - idSurtidor (FK)
   - idProducto (FK)

## Diagrama Entidad-Relación


Surtidor 1---* SurtidorProducto *---1 Producto
Producto 1---* Precio
Producto 1---* Tanque
Surtidor 1---* Suministro *---1 Producto

## Configuración e Instalación

### Requisitos Previos

- Java JDK 17 o superior
- Maven 3.6 o superior
- MySQL (opcional, puede usar H2 en memoria para desarrollo)

### Pasos para Ejecutar

1. Clonar el repositorio:
   
   git clone https://github.com/tu-usuario/gasolinera.git
   cd gasolinera

2. Configurar la base de datos en `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/gasolinera
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update


3. Compilar y ejecutar:

mvn clean install
mvn spring-boot:run


4. La API estará disponible en: `http://localhost:8080/api/`

## API Endpoints

### Productos

- `GET /api/productos/traer` - Obtener todos los productos
- `GET /api/productos/traer/{id}` - Obtener un producto por ID
- `POST /api/productos/crear` - Crear un nuevo producto
- `PUT /api/productos/editar/{id}` - Actualizar un producto existente
- `DELETE /api/productos/borrar/{id}` - Eliminar un producto


### Surtidores

- `GET /api/surtidores/traer` - Obtener todos los surtidores
- `GET /api/surtidores/traer/{id}` - Obtener un surtidor por ID
- `POST /api/surtidores/crear` - Crear un nuevo surtidor
- `PUT /api/surtidores/editar/{id}` - Actualizar un surtidor existente
- `DELETE /api/surtidores/borrar/{id}` - Eliminar un surtidor


### Precios

- `GET /api/precios/traer` - Obtener todos los precios
- `GET /api/precios/traer/{id}` - Obtener un precio por ID
- `POST /api/precios/crear` - Crear un nuevo precio
- `PUT /api/precios/editar/{id}` - Actualizar un precio existente
- `DELETE /api/precios/borrar/{id}` - Eliminar un precio


### Tanques

- `GET /api/tanques/traer` - Obtener todos los tanques
- `GET /api/tanques/traer/{id}` - Obtener un tanque por ID
- `POST /api/tanques/crear` - Crear un nuevo tanque
- `PUT /api/tanques/editar/{id}` - Actualizar un tanque existente
- `DELETE /api/tanques/borrar/{id}` - Eliminar un tanque


### Suministros

- `GET /api/suministros/traer` - Obtener todos los suministros
- `GET /api/suministros/traer/{id}` - Obtener un suministro por ID
- `POST /api/suministros/crear` - Crear un nuevo suministro
- `PUT /api/suministros/editar/{id}` - Actualizar un suministro existente
- `DELETE /api/suministros/borrar/{id}` - Eliminar un suministro


### Relación Surtidor-Producto

- `GET /api/surtidor-productos/traer` - Obtener todas las relaciones
- `GET /api/surtidor-productos/traer/{id}` - Obtener una relación por ID
- `POST /api/surtidor-productos/crear` - Crear una nueva relación
- `PUT /api/surtidor-productos/editar/{id}` - Actualizar una relación existente
- `DELETE /api/surtidor-productos/borrar/{id}` - Eliminar una relación


## Ejemplos de Uso con Postman

### Crear un Producto

**Método**: POST**URL**: `http://localhost:8080/api/productos/crear`**Headers**: Content-Type: application/json**Body**:

```json
{
    "nombre": "Gasolina 95",
    "descripcion": "Gasolina sin plomo de 95 octanos",
    "tipo": "Gasolina"
}
```

### Registrar un Suministro

**Método**: POST**URL**: `http://localhost:8080/api/suministros/crear`**Headers**: Content-Type: application/json**Body**:

{
    "surtidor": {
        "idSurtidor": 1
    },
    "producto": {
        "idProducto": 1
    },
    "fechaHora": "2023-03-15T10:30:00",
    "volumenLitros": 45.5,
    "importeEuros": 65.98
}


## Contribuir

1. Haz un Fork del proyecto
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request


## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

## Contacto

[Carlos Roncero Parra] - [[ccrp06@educastillalamancha.es]
>>>>>>> a7eeb2c (Primer commit)
"# gas" 
