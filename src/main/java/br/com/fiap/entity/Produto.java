package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@SequenceGenerator(name="produto", sequenceName = "sq_tb_produto", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_produto")
	private int id;
	
	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;
	
	@Column(name="vl_preco")
	private double preco;
	
	@Column(name = "ds_descricao", nullable = false, length = 100)
	private String descricao;
	
	
	@Column(name = "qt_quantidade", nullable = false, length = 100)
	private int quantidade;
	
	
	@Formula("vl_preco*quantidade")
	private double precoTotal;
	
	
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;
	
	public Produto() {
		super();
	}
	

	public Produto(String nome, double preco, String descricao, int quantidade, double precoTotal) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
	

	
	
	

}
