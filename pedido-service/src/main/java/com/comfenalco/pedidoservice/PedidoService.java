package com.comfenalco.pedidoservice;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final RestTemplate restTemplate;
    private final PedidoRepository repository;

    @Value("${producto-service.url}")
    private String productoServiceUrl;

    public Pedido crearPedido(Long productoId, Integer cantidad) {
        Producto producto = obtenerProducto(productoId);
        if (producto == null) {
            throw new ProductoNoEncontradoException(productoId);
        }
        BigDecimal total = producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
        return repository.save(new Pedido(null, productoId, cantidad, total, "CREADO"));
    }

    private Producto obtenerProducto(Long productoId) {
        try {
            return restTemplate.getForObject(
                    productoServiceUrl + "/api/productos/" + productoId, Producto.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ProductoNoEncontradoException(productoId);
        } catch (ResourceAccessException e) {
            throw new ProductoServiceNoDisponibleException();
        }
    }
}
