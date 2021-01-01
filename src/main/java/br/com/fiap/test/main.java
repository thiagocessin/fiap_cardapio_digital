package br.com.fiap.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClientesDAO;
import br.com.fiap.dao.PedidosDAO;
import br.com.fiap.dao.ProdutosDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;

public class main {

	private static EntityManagerFactory fabrica;
	private static EntityManager em;

	public static void main(String[] args) {

		fabrica = Persistence.createEntityManagerFactory("cardapioDigital");
		em = fabrica.createEntityManager();

		// em.close();
		// fabrica.close();

		try {
			
			for (int i = 0; i < 10; i++) criarProduto();
			for (int i = 0; i < 10; i++) criarCliente();
			
			criarPedido();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Pedido criarDaoPedidos() {
		return new Pedido();
	}

	public static void criarPedido() throws Exception {
		ClientesDAO clientesDao = new ClientesDAO(em);
		ProdutosDAO produtosDao = new ProdutosDAO(em);
		PedidosDAO pedidosDAO = new PedidosDAO(em);

		GregorianCalendar dataHoraPedido = new GregorianCalendar(2017, Calendar.DECEMBER, 10, 23, 0);

		Pedido pedido = new Pedido(dataHoraPedido, "em andamento", "Detalhes do pedido", "mesa 1",
				clientesDao.buscar(11));
		pedido.setProdutos(produtosDao.listar());

		pedidosDAO.cadastrar(pedido);
		pedidosDAO.commit();
	}

	public static void criarProduto() throws Exception {

		ProdutosDAO dao = new ProdutosDAO(em);

		String[] produtos = { "Spaguetti", "Lasanha", "Gnocchi", "Pizza" };

		String nome = produtos[new Random().nextInt(4)];
		String format = new DecimalFormat("#.##").format(new Random().nextDouble() * 100);

		Produto produto = new Produto(nome, Double.valueOf(format.replace(",", ".")), "Descricao produto",
				new Random().nextInt((10 - 1) + 1) + 1);

		dao.cadastrar(produto);
		dao.commit();

	}

	public static void criarCliente() throws Exception {
		ClientesDAO dao = new ClientesDAO(em);

		String[] clientes = { "José", "Maria", "Julia", "Rebeca" };

		Cliente cliente = new Cliente(clientes[new Random().nextInt(4)]);

		dao.cadastrar(cliente);
		dao.commit();
	}

}
