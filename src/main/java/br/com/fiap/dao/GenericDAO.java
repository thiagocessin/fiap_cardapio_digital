package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T, K> {

	protected EntityManager em;

	private Class<T> clazz;

	public GenericDAO(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T entity) {
		em.persist(entity);
	}

	public void atualizar(T entity) {
		em.merge(entity);
	}

	public T buscar(K chave) {
		return em.find(clazz, chave);
	}

	public void remover(K chave) throws Exception {

		T entidade = buscar(chave);
		if (entidade == null) {
			throw new Exception("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	public List<T> listar() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw new Exception("Erro no commit");
		}

	}

}
