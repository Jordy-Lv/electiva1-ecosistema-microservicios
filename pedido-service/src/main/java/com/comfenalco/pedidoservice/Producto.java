package com.comfenalco.pedidoservice;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Producto {

    private Long id;

    private String nombre;

    private BigDecimal precio;

    private Integer stock;
}
