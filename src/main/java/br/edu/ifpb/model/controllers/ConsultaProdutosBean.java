package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.ProdutoDAO;
import br.edu.ifpb.model.entities.Produto;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class ConsultaProdutosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;

	public void consultar() {
		EntityManager manager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(manager);
		this.produtos = produtoDAO.todos();
		manager.close();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
