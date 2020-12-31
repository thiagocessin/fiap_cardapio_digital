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
@Table(name = "tb_sobremesa")
public class Sobremesa {

	@Id
	@SequenceGenerator(name = "sobremesa", sequenceName = "sq_tb_sobremesa", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_sobremesa")
	private int id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ip_pedido")
	private Pedido pedido;

	@Column(name = "nm_sobremesa", nullable = false, length = 100)
	private String nomeSobremesa;

	@Column(name = "ds_descricao", nullable = false, length = 100)
	private String descricao;

	public Sobremesa() {
		super();
	}

	public Sobremesa(String nomeSobremesa, String descricao) {
		super();
		this.nomeSobremesa = nomeSobremesa;
		this.descricao = descricao;
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

	public String getNomeSobremesa() {
		return nomeSobremesa;
	}

	public void setNomeSobremesa(String nomeSobremesa) {
		this.nomeSobremesa = nomeSobremesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
