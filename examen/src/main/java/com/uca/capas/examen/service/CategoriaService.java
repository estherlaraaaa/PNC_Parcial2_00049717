package com.uca.capas.examen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen.domain.Categoria;
import com.uca.capas.examen.domain.Libro;

public interface CategoriaService {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;
	
	public Categoria findOne(Integer c_categoria) throws DataAccessException;

}
