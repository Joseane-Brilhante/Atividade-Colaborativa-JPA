package br.edu.ifpb.model.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ifpb.model.entities.Categoria;
import br.edu.ifpb.model.entities.Produto;

public class ProdutoDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public ProdutoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void addProduto(Produto produto) {
		manager.persist(produto);
	}
	
	public List<Produto> todos() {
		TypedQuery<Produto> query = manager.createQuery("FROM Produto", Produto.class);
		return query.getResultList();
	}
	
	public List<Produto> porCategoria(Categoria categoria) {
		TypedQuery<Produto> query = manager.createQuery("FROM Produto p WHERE p.categoria = :categoria", Produto.class);
		query.setParameter("categoria", categoria);
		return query.getResultList();
	}
	
	public List<Produto> porData(Date data) {
		TypedQuery<Produto> query = manager.createQuery("FROM Produto p WHERE p.dataDeValidade = :data", Produto.class);
		query.setParameter("data", data);
		return query.getResultList();
	}
	
	public List<Produto> vencidos(Date data) {
		TypedQuery<Produto> query = manager.createQuery("FROM Produto p WHERE p.dataDeValidade > :data", Produto.class);
		query.setParameter("data", data);
		return query.getResultList();
	}


}
