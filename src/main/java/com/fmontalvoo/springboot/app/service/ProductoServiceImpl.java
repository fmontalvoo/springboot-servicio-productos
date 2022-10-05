package com.fmontalvoo.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmontalvoo.springboot.app.repository.ProductoRepository;
import com.fmontalvoo.springboot.commons.models.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return repository.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto update(Long id, Producto producto) {
		return repository.findById(id).map(p -> {
			p.setNombre(producto.getNombre());
			p.setPrecio(producto.getPrecio());
			p.setCreatedAt(p.getCreatedAt());
			return repository.save(p);
		}).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) repository.findAll();
	}

}
