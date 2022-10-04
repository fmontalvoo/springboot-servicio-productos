package com.fmontalvoo.springboot.app.service;

import java.util.List;
import java.util.Optional;

import com.fmontalvoo.springboot.app.models.Producto;

public interface ProductoService {

	public Producto save(Producto producto);

	public Producto findById(Long id);

	public Producto update(Long id, Producto producto);

	public void delete(Long id);

	public List<Producto> findAll();
}
