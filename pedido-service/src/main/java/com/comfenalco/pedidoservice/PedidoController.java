package com.comfenalco.pedidoservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public Pedido crear(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        return service.crearPedido(productoId, cantidad);
    }
}
