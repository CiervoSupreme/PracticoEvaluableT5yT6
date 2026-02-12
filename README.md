# Reto 4 - API REST de Gestión de Hoteles y Reservas

Este proyecto es una API REST desarrollada con Spring Boot y MongoDB para gestionar hoteles y reservas. Incluye autenticación básica y autorización basada en roles.

## Tecnologías Utilizadas

*   **Java 17** (o superior)
*   **Spring Boot 3.x**
    *   Spring Web
    *   Spring Data MongoDB
    *   Spring Security
    *   Spring Validation
*   **MongoDB** (Base de datos)
*   **Maven** (Gestor de dependencias)

## Configuración

### Base de Datos

Asegúrate de tener una instancia de MongoDB en ejecución. La aplicación se conectará por defecto a `mongodb://localhost:27017/reto4` (o la configuración que tengas en `application.properties`).

### Seguridad

La aplicación utiliza **Basic Auth**.
Se ha configurado un usuario en memoria para pruebas:

*   **Usuario:** `admin`
*   **Contraseña:** `admin`
*   **Rol:** `ADMIN`

## Recursos y Endpoints

### Hoteles (`/hoteles`)

Gestiona la información de los hoteles.

| Método | Endpoint | Descripción | Auth Requerida | Rol |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/hoteles` | Listar todos los hoteles | No | - |
| `GET` | `/hoteles/{id}` | Obtener detalle de un hotel | No | - |
| `POST` | `/hoteles` | Crear un nuevo hotel | Sí | ADMIN |
| `PUT` | `/hoteles/{id}` | Actualizar un hotel existente | Sí | ADMIN |

#### Ejemplos de Respuestas (Hoteles)

**1. Listar Hoteles (`GET /hoteles`)**

```json
[
    {
        "id": "65df...",
        "nombre": "Hotel Plaza",
        "ciudad": "Madrid",
        "estrellas": 4,
        "precioNoche": 120.50
    },
    {
        "id": "65df...",
        "nombre": "Grand Hotel",
        "ciudad": "Barcelona",
        "estrellas": 5,
        "precioNoche": 250.00
    }
]
```

**2. Crear Hotel (`POST /hoteles`)**

*Body:*
```json
{
    "nombre": "Hotel Sol",
    "ciudad": "Sevilla",
    "estrellas": 3,
    "precioNoche": 85.00
}
```

*Respuesta (200 OK):*
```json
{
    "id": "65df...",
    "nombre": "Hotel Sol",
    "ciudad": "Sevilla",
    "estrellas": 3,
    "precioNoche": 85.00
}
```

### Reservas (`/reservas`)

Gestiona las reservas de los clientes en los hoteles.

| Método | Endpoint | Descripción | Auth Requerida | Rol |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/reservas` | Listar todas las reservas | No | - |
| `POST` | `/reservas?hotelId={id}` | Crear una nueva reserva asociada a un hotel | Sí | ADMIN |

> **Nota:** Para crear una reserva, es obligatorio pasar el parámetro `hotelId` en la query string. El hotel debe existir.

#### Ejemplos de Respuestas (Reservas)

**1. Listar Reservas (`GET /reservas`)**

```json
[
    {
        "id": "65df...",
        "cliente": "Juan Pérez",
        "fechaEntrada": "2023-12-01",
        "fechaSalida": "2023-12-10",
        "hotelId": "65df..."
    }
]
```

**2. Crear Reserva (`POST /reservas?hotelId=65df...`)**

*Body:*
```json
{
    "cliente": "Maria Garcia",
    "fechaEntrada": "2024-01-15",
    "fechaSalida": "2024-01-20"
}
```

*Respuesta (200 OK):*
```json
{
    "id": "65df...",
    "cliente": "Maria Garcia",
    "fechaEntrada": "2024-01-15",
    "fechaSalida": "2024-01-20",
    "hotelId": "65df..."
}
```

## Ejecución

Para ejecutar la aplicación, utiliza el comando de Maven:

```bash
./mvnw spring-boot:run
```
