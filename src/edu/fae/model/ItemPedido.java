package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	private Long id;
	private Integer quantidade;
	private Double valor;
	private Double valorTotal;
	private Produto produto;
	private Pedido pedido;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
