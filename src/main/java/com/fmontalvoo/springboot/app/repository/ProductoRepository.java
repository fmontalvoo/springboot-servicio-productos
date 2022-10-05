package com.fmontalvoo.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.fmontalvoo.springboot.commons.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
