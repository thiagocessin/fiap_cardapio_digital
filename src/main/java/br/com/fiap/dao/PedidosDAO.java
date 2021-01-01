package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Pedido;

public class PedidosDAO extends GenericDAO<Pedido, Integer>{

	public PedidosDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	public Pedido buscarPorNome(String nome) {
		return em.createQuery("from Pedido p where nomeRefeicao = :nome", Refeicao.class)
				.setParameter("nome", nome).getSingleResult();
	}
	*/
	
	

}
