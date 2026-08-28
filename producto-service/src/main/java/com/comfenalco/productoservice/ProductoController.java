package com.comfenalco.productoservice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository repository;

    @GetMapping
    public List<Producto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return repository.save(producto);
    }
}
