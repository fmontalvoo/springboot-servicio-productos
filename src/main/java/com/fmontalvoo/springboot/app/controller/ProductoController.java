package com.fmontalvoo.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fmontalvoo.springboot.app.models.Producto;
import com.fmontalvoo.springboot.app.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody Producto producto) {
		return service.save(producto);
	}

	@GetMapping("/{id}")
	public Producto findById(@PathVariable Long id) throws InterruptedException {
//		if (id.equals(5L))
//			throw new IllegalStateException("Registro contiene errores.");
//
//		if (id.equals(6L))
//			TimeUnit.SECONDS.sleep(5L);

		return service.findById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
		return service.update(id, producto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping
	public List<Producto> findAll() {
		return service.findAll();
	}
}
