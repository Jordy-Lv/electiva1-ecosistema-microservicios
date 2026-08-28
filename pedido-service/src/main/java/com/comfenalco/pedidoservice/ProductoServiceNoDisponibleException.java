package com.comfenalco.pedidoservice;

public class ProductoServiceNoDisponibleException extends RuntimeException {

    public ProductoServiceNoDisponibleException() {
        super("producto-service no disponible");
    }
}
