package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.CategoriaDAO;
import br.edu.ifpb.model.entities.Categoria;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class ConsultaCategoriaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Categoria> categoria;

	public void consultar() {
		EntityManager manager = JPAUtil.getEntityManager();
		CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
		this.categoria = categoriaDAO.todas();
		manager.close();
	}

	public List<Categoria> getCategorias() {
		return categoria;
	}

}
