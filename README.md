# Proyecto Spring Boot / Spring Data (Java 17)

Este proyecto utiliza Spring Boot y Spring Data con Java 17.
Se conecta a una base de datos MySQL.

------------------------------------------------------------
REQUISITOS
------------------------------------------------------------
Antes de ejecutar la aplicación, crear la base de datos:

Nombre de la base de datos: jpa_audit_db

Ejemplo en MySQL:
CREATE DATABASE jpa_audit_db;

------------------------------------------------------------
AUTENTICACIÓN
------------------------------------------------------------
Para consumir los endpoints se requiere autenticación con Basic Auth.

ROL USER
- Username: norio
- Password: 123

ROL ADMIN
- Username: admin
- Password: 123

------------------------------------------------------------
ENDPOINTS DISPONIBLES
------------------------------------------------------------

1. CREAR PRODUCTO
------------------------------------------------------------
Método: POST  
URL: http://localhost:8080/create  
Permiso: USER (norio)

Body (JSON):
{
    "name": "pera",
    "description": "descripcion del producto",
    "price": 10000
}

2. ACTUALIZAR PRODUCTO
------------------------------------------------------------
Método: PUT  
URL: http://localhost:8080/update/1  
Permiso: ADMIN (admin)

Body (JSON):
{
    "name": "pera modificado",
    "description": "descripcion del producto",
    "price": 10000
}

3. ELIMINAR PRODUCTO
------------------------------------------------------------
Método: DELETE  
URL: http://localhost:8080/delete/1  
Permiso: ADMIN (admin)
