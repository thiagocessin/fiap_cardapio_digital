package br.com.fiap.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
			
			//criarProdutos();
			//criarClientes();
			
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
				clientesDao.buscarPorNome("Rebeca"));
		
		List<Produto> listaProd = new ArrayList<Produto>();
		listaProd.add(produtosDao.buscar(1));
		listaProd.add(produtosDao.buscar(1));
		listaProd.add(produtosDao.buscar(3));
		listaProd.add(produtosDao.buscar(4));
		
		pedido.setProdutos(listaProd);

		pedidosDAO.cadastrar(pedido);
		pedidosDAO.commit();
	}

	public static void criarProdutos() throws Exception {

		ProdutosDAO dao = new ProdutosDAO(em);
		String[] produtos = { "Spaguetti", "Lasanha", "Gnocchi", "Pizza" };

		
		for(String s : produtos) {
			Produto p = new Produto(s,10.00,"Descricao - "+ s);
			dao.cadastrar(p);
		}

		dao.commit();

	}

	public static void criarClientes() throws Exception {
		ClientesDAO dao = new ClientesDAO(em);

		String[] clientes = { "José", "Maria", "Julia", "Rebeca" };

		for(String s : clientes) {
			Cliente cliente = new Cliente(s);
			dao.cadastrar(cliente);
		}
		dao.commit();
	}

}
