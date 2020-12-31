package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.Sobremesa;

public class BebidasDAO extends GenericDAO<Bebida, Integer>{

	public BebidasDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Bebida buscarPorNome(String nome) {
		return em.createQuery("from Bebida b where nomeBebida = :nome", Bebida.class)
				.setParameter("nome", nome).getSingleResult();
	}

}
