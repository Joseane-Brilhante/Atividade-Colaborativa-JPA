package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifpb.model.dao.CategoriaDAO;
import br.edu.ifpb.model.dao.ProdutoDAO;
import br.edu.ifpb.model.entities.Categoria;
import br.edu.ifpb.model.entities.Produto;
import br.edu.ifpb.model.service.ProdutoService;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();
	private List<Categoria> categorias;

	public void preparaListaDeCategorias() {
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			CategoriaDAO categoriasDAO = new CategoriaDAO(manager);
			categorias = categoriasDAO.todas();
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();

			ProdutoService livroService = new ProdutoService(new ProdutoDAO(manager));
			livroService.salvar(produto);

			this.produto = new Produto();

			context.addMessage(null, new FacesMessage("Produto salvo com sucesso!"));

			trx.commit();
		} catch (Exception e) {
			trx.rollback();

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
