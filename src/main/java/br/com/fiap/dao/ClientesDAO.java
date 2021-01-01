package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Cliente;

public class ClientesDAO extends GenericDAO<Cliente, Integer>{

	public ClientesDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	
	public Cliente buscarPorNome(String nome) {
		return em.createQuery("from Cliente c where nome = :nome", Cliente.class)
				.setParameter("nome", nome).getSingleResult();
	}
	

}
