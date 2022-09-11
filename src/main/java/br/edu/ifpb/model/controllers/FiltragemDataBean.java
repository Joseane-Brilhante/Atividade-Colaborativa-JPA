package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.ProdutoDAO;
import br.edu.ifpb.model.entities.Produto;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class FiltragemDataBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date dataSelecionada;
	private List<Produto> produtos;

	public void filtrar() {
		EntityManager manager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(manager);
		this.produtos = produtoDAO.porData(dataSelecionada);
		
		manager.close();
	}
	

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public Date getDataSelecionada() {
		return dataSelecionada;
	}


	public void setDataSelecionada(Date dataSelecionada) {
		this.dataSelecionada = dataSelecionada;
	}	

}
