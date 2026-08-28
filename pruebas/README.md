# Pruebas del ecosistema (evidencia)

Capturas de las 5 pruebas de la sección 7 del taller, ejecutadas con `curl -i` sobre ambos microservicios corriendo.

| # | Captura | Resultado |
|---|---|---|
| 1 | `01-crear-producto-1.png` | `200` crea producto id 1 |
| 2 | `02-listar-productos.png` | `200` lista los 2 productos de prueba |
| 3 | `03-crear-pedido.png` | `200` pedido con `total: 300000.00` (150000 x 2) |
| 4 | `04-error-producto-inexistente.png` | `404` `{"error":"Producto no encontrado: 99"}` |
| 5 | `05-error-servicio-caido.png` | `503` `{"error":"producto-service no disponible"}`, pedido-service sigue respondiendo |

Salidas crudas de `curl` en `raw/`.
