package com.fmontalvoo.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.fmontalvoo.springboot.app.models.Producto;

public interface ProductoService {

	public Producto save(Producto producto);

	public Optional<Producto> findById(Long id);

	public void delete(Long id);

	public List<Producto> findAll();
}
