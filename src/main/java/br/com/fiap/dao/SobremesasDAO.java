package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Sobremesa;

public class SobremesasDAO extends GenericDAO<Sobremesa, Integer>{

	public SobremesasDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Sobremesa buscarPorNome(String nome) {
		return em.createQuery("from Sobremesa s where nomeSobremesa = :nome", Sobremesa.class)
				.setParameter("nome", nome).getSingleResult();
	}

}
