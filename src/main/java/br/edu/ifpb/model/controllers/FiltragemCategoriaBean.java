package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.CategoriaDAO;
import br.edu.ifpb.model.dao.ProdutoDAO;
import br.edu.ifpb.model.entities.Categoria;
import br.edu.ifpb.model.entities.Produto;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class FiltragemCategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Categoria categoriaSelecionada;
	private List<Categoria> categorias;
	private List<Produto> produtos;

	public void filtrar() {
		EntityManager manager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(manager);
		this.produtos = produtoDAO.porCategoria(categoriaSelecionada);
		
		manager.close();
	}
	
	public void preparaListaDeCategorias() {
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			CategoriaDAO categoriasDAO = new CategoriaDAO(manager);
			categorias = categoriasDAO.todas();
		} finally {
			manager.close();
		}
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

}
