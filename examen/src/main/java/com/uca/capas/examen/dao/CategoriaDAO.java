package com.uca.capas.examen.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen.domain.Categoria;
import com.uca.capas.examen.domain.Libro;

public interface CategoriaDAO {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;

	public Categoria findOne(Integer code) throws DataAccessException;

}
