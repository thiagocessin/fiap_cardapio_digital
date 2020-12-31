package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_refeicao")
public class Refeicao {

	@Id
	@SequenceGenerator(name = "refeicao", sequenceName = "sq_tb_refeicao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_refeicao")
	private int id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ip_pedido")
	private Pedido pedido;

	@Column(name = "nm_refeicao", nullable = false, length = 100)
	private String nomeRefeicao;

	@Column(name = "ds_descricao", nullable = false, length = 100)
	private String descricao;

	public Refeicao(String nomeRefeicao, String descricao) {
		super();
		this.nomeRefeicao = nomeRefeicao;
		this.descricao = descricao;
	}

	public Refeicao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getNomeRefeicao() {
		return nomeRefeicao;
	}

	public void setNomeRefeicao(String nomeRefeicao) {
		this.nomeRefeicao = nomeRefeicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
