package br.edu.ifpb.model.service;

import java.io.Serializable;

import br.edu.ifpb.model.dao.CategoriaDAO;
import br.edu.ifpb.model.entities.Categoria;


public class CategoriaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private CategoriaDAO categoriaDAO;

	public CategoriaService(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
	
	public void salvar(Categoria categoria) {
		this.categoriaDAO.addCategoria(categoria);
	}

}
