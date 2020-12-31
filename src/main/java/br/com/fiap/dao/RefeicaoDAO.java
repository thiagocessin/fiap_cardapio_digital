package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Refeicao;

public class RefeicaoDAO extends GenericDAO<Refeicao, Integer>{

	public RefeicaoDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public Refeicao buscarPorNome(String nome) {
		return em.createQuery("from Refeicao r where nomeRefeicao = :nome", Refeicao.class)
				.setParameter("nome", nome).getSingleResult();
	}

}
