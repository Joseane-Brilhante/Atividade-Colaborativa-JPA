package br.edu.ifpb.model.service;

import java.io.Serializable;

import br.edu.ifpb.model.dao.ProdutoDAO;
import br.edu.ifpb.model.entities.Produto;

public class ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDAO produtoDAO;

	public ProdutoService(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
	public void salvar(Produto produto) {
		this.produtoDAO.addProduto(produto);
	}

}
