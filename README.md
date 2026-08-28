# ecosistema-ecommerce

Taller básico Electiva I — dos microservicios Spring Boot con comunicación síncrona HTTP.

| Microservicio | Puerto | Responsabilidad |
|---|---|---|
| producto-service | 8081 | Catálogo de productos (crear, listar, consultar) |
| pedido-service | 8082 | Pedidos; al crear un pedido consulta a producto-service para validar el producto y obtener su precio |

## Requisitos

- JDK 21
- Maven 3.9+

## Ejecutar

En dos terminales distintas:

```bash
cd producto-service && mvn spring-boot:run
```

```bash
cd pedido-service && mvn spring-boot:run
```

## Pruebas (Postman o curl)

```bash
curl -X POST http://localhost:8081/api/productos -H 'Content-Type: application/json' -d '{"nombre":"Teclado mecanico","precio":150000,"stock":10}'
curl http://localhost:8081/api/productos
curl -X POST "http://localhost:8082/api/pedidos?productoId=1&cantidad=2"
curl -X POST "http://localhost:8082/api/pedidos?productoId=99&cantidad=1"
```

- El pedido devuelve `total = precio * cantidad`.
- Producto inexistente: `404` con `{"error":"Producto no encontrado: 99"}`.
- producto-service caído: `503` con `{"error":"producto-service no disponible"}`; pedido-service sigue en pie.

## Endpoints

**producto-service**

- `GET /api/productos`
- `GET /api/productos/{id}`
- `POST /api/productos`
- Consola H2: `http://localhost:8081/h2-console` (JDBC URL `jdbc:h2:mem:productodb`)

**pedido-service**

- `POST /api/pedidos?productoId={id}&cantidad={n}`
