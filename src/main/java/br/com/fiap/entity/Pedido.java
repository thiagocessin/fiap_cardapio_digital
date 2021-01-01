package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@SequenceGenerator(name = "pedido", sequenceName = "sq_tb_pedido", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_pedido")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_pedido")
	private Calendar dataHoraPedido;

	@Column(name = "ds_status", nullable = false, length = 100)
	private String status;

	@Column(name = "ds_detalhes")
	private String detalhes;

	@Column(name = "nm_mesa", nullable = false, length = 100)
	private String mesa;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto"), name = "tb_pedido_produto")
	private List<Produto> produtos;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Calendar dataHoraPedido, String status, String detalhes, String mesa, Cliente cliente) {
		super();
		this.dataHoraPedido = dataHoraPedido;
		this.status = status;
		this.detalhes = detalhes;
		this.mesa = mesa;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataHoraPedido() {
		return dataHoraPedido;
	}

	public void setDataHoraPedido(Calendar dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
