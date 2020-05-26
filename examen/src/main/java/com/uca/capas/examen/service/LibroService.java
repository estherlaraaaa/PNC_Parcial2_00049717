package com.uca.capas.examen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.examen.domain.Libro;

public interface LibroService {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void save(Libro libro) throws DataAccessException;
	
	public void delete(Integer codigo) throws DataAccessException;

}
