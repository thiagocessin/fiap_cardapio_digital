package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@SequenceGenerator(name="pedido", sequenceName = "sq_tb_pedido", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ip_pedido")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido")
	private Calendar dataHoraPedido;
	
	@Column(name = "ds_status", nullable = false, length = 100)
	private String status;
	
	@Column(name = "ds_detalhes")
	private String detalhes;
	
	@Column(name = "nm_mesa", nullable = false, length = 100)
	private String mesa;
	
	@OneToMany(mappedBy = "pedido")
	private List<Refeicao> refeicoes;
	
	@OneToMany(mappedBy = "pedido")
	private List<Bebida> bebidas;
	
	@OneToMany(mappedBy = "pedido")
	private List<Sobremesa> sobremesas;
	

	public Pedido() {
		super();
	}

	public Pedido(int id, Calendar dataHoraPedido, String status, String detalhes, String mesa,
			List<Refeicao> refeicoes, List<Bebida> bebidas, List<Sobremesa> sobremesas) {
		super();
		this.id = id;
		this.dataHoraPedido = dataHoraPedido;
		this.status = status;
		this.detalhes = detalhes;
		this.mesa = mesa;
		this.refeicoes = refeicoes;
		this.bebidas = bebidas;
		this.sobremesas = sobremesas;
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

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public List<Sobremesa> getSobremesas() {
		return sobremesas;
	}

	public void setSobremesas(List<Sobremesa> sobremesas) {
		this.sobremesas = sobremesas;
	}
	
	
	
	
	
	
	
	
}
