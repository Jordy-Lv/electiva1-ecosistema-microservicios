package com.comfenalco.pedidoservice;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorErrores {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> productoNoEncontrado(ProductoNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }

    @ExceptionHandler(ProductoServiceNoDisponibleException.class)
    public ResponseEntity<Map<String, String>> productoServiceCaido(ProductoServiceNoDisponibleException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Map.of("error", e.getMessage()));
    }
}
