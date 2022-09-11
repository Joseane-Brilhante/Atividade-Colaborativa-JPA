package br.edu.ifpb.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifpb.model.entities.Categoria;

public class CategoriaDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public CategoriaDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void addCategoria(Categoria categoria) {
		manager.persist(categoria);
	}
	
	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}
	
	public List<Categoria> todas() {
		TypedQuery<Categoria> query = manager.createQuery("FROM Categoria", Categoria.class);
		return query.getResultList();
	}
}
