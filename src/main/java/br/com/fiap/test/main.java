package br.com.fiap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pedido;

public class main {

	private static EntityManagerFactory fabrica;
	private static EntityManager em;

	public static void main(String[] args) {

		fabrica = Persistence.createEntityManagerFactory("cardapioDigital");
		em = fabrica.createEntityManager();

		// em.close();
		// fabrica.close();

		try {
			
			/*
			criarRefeicao("Macarrão com frango", "Macarrão com frango para dois");
			criarRefeicao("Pizza", "Pizza grande");
			criarRefeicao("Strogonoff", "Strogonoff de carne");
			
			criarBebida("Suco de limão", "Suco 350 ml");
			criarBebida("Vinho tinto", "vinho do porto");
			criarBebida("Guaraná zero", "Guaraná zero 200 ml");
			
			criarSobremesa("Torta de morango", "torta de morangos silvestres");
			criarSobremesa("Bolo de laranja", "Bolo de laranja individual");
			criarSobremesa("Pudim", "Pudim de leite condensado");*/
			
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Pedido criarDaoPedidos() {
		return new Pedido();
	}

	public static void criarPedido() throws Exception {
		
		
		
	}
	
}
