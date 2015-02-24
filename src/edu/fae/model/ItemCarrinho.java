package edu.fae.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class ItemCarrinho {
	private Long id;
	private Integer quantidade;
	private Double valor;
	private Produto produto;
	private CarrinhoCompra carrinho;
	


	public Double getValorTotal(){
		return valor * quantidade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		if(this.quantidade <=0 && this.carrinho!=null) {
			this.carrinho.getItensCarrinho().remove(this);
		}
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	public CarrinhoCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoCompra carrinho) {
		this.carrinho = carrinho;
	}	
}
