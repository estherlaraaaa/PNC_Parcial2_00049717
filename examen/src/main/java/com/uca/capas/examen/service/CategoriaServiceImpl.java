package com.uca.capas.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.examen.dao.CategoriaDAO;
import com.uca.capas.examen.domain.Categoria;
import com.uca.capas.examen.domain.Libro;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDAO categoriaDao;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	public Categoria findOne(Integer c_categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDao.save(categoria);
		
	}

}
