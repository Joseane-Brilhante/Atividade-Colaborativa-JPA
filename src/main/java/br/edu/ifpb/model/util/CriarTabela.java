package br.edu.ifpb.model.util;

import javax.persistence.Persistence;

public class CriarTabela {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("atividadePU");

	}

}