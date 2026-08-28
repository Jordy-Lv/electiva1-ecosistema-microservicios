package com.comfenalco.pedidoservice;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Long productoId) {
        super("Producto no encontrado: " + productoId);
    }
}
