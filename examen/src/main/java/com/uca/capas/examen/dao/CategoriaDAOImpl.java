package com.uca.capas.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.examen.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	
	@PersistenceContext(unitName="examen")
	private EntityManager entityManager;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb =  new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query  query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria>resultset=query.getResultList();
		return resultset;
	}

	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		Categoria categoria = entityManager.find(Categoria.class,code);
		return categoria;
	}

	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		if(categoria.getC_categoria() == null) { 
			entityManager.persist(categoria);
		}
		else { 
			entityManager.merge(categoria); 
		}
		
	}

}
