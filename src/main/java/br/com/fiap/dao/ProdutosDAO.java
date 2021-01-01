package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Produto;

public class ProdutosDAO extends GenericDAO<Produto, Integer>{

	public ProdutosDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
