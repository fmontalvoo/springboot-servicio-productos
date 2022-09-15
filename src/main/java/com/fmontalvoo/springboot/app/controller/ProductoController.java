package com.fmontalvoo.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmontalvoo.springboot.app.models.Producto;
import com.fmontalvoo.springboot.app.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;

	@PostMapping
	public Producto save(@RequestBody Producto producto) {
		return service.save(producto);
	}

	@GetMapping("/{id}")
	public Producto findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
		return service.findById(id).map(p -> {
			p.setNombre(producto.getNombre());
			p.setPrecio(producto.getPrecio());
			p.setCreatedAt(p.getCreatedAt());
			return service.save(p);
		}).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping
	public List<Producto> findAll() {
		return service.findAll();
	}
}
