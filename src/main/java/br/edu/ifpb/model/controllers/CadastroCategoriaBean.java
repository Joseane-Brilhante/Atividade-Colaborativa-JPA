package br.edu.ifpb.model.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifpb.model.dao.CategoriaDAO;
import br.edu.ifpb.model.entities.Categoria;
import br.edu.ifpb.model.service.CategoriaService;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class CadastroCategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Categoria categoria = new Categoria();
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void salvar() {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();

			CategoriaService categoriaService = new CategoriaService(new CategoriaDAO(manager));
			categoriaService.salvar(categoria);

			this.categoria = new Categoria();

			context.addMessage(null, new FacesMessage("Categoria criada com sucesso!"));

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


}
