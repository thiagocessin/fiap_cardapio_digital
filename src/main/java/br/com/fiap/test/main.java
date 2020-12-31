package br.com.fiap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.BebidasDAO;
import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.dao.RefeicaoDAO;
import br.com.fiap.dao.SobremesasDAO;
import br.com.fiap.entity.Bebida;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Refeicao;
import br.com.fiap.entity.Sobremesa;

public class main {

	private static EntityManagerFactory fabrica;
	private static EntityManager em;

	public static void main(String[] args) {

		fabrica = Persistence.createEntityManagerFactory("cardapioDigital");
		em = fabrica.createEntityManager();

		// em.close();
		// fabrica.close();

		try {
			
			Refeicao refeicao = criarRefeicao("Lasanha", "Lasanha 4 queijos");
			System.out.println("Refeicao - " + refeicao.getNomeRefeicao());
			
			
			Bebida bebida = criarBebida("Coca cola", "Coca cola 500ml");
			System.out.println("Bebida - " + bebida.getNomeBebida());
			
			Sobremesa sobremesa = criarSobremesa("Sorvete de baunilha", "Sorvete de baunilha caseiro");
			System.out.println("Sobremsa - " + sobremesa.getNomeSobremesa());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Pedido criarDaoPedidos() {
		return new Pedido();
	}

	public static Refeicao criarRefeicao(String nome, String descricao) throws Exception {
		RefeicaoDAO dao = new RefeicaoDAO(em);
		Refeicao refeicao = new Refeicao(nome, descricao);
		dao.cadastrar(refeicao);
		dao.commit();

		return dao.buscarPorNome(nome);
	}

	public static Sobremesa criarSobremesa(String nome, String descricao) throws Exception {

		SobremesasDAO dao = new SobremesasDAO(em);
		Sobremesa sobremesa = new Sobremesa(nome, descricao);
		dao.cadastrar(sobremesa);
		dao.commit();

		return dao.buscarPorNome(nome);
	}

	public static Bebida criarBebida(String nome, String descricao) throws Exception {
		BebidasDAO dao = new BebidasDAO(em);
		Bebida bebida = new Bebida(nome, descricao);
		dao.cadastrar(bebida);
		dao.commit();

		return dao.buscarPorNome(nome);
	}
}
