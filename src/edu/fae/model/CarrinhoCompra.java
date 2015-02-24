package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {
	
	private List<ItemCarrinho> itensCarrinho = new ArrayList<ItemCarrinho>();
	

	public Double getValorTotal(){
		Double valorTotal = 0.0;
		for (ItemCarrinho itemCarrinho : itensCarrinho) {
			valorTotal += itemCarrinho.getValorTotal();
		}
		return valorTotal;
	}
	
	public void adicionarProduto(Produto produto){
		boolean itemExiste = false;
		
//		if (itensCarrinho.size() > 0) {
			for (ItemCarrinho itemCarrinho : itensCarrinho) {
				if (produto.getId().equals(itemCarrinho.getProduto().getId())) {
					itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + 1);
					itemExiste = true;
				}
				
			}
			if (itemExiste == false) {
					ItemCarrinho itemNovo = new ItemCarrinho();
					itemNovo.setProduto(produto);
					itemNovo.setCarrinho(this);
					itemNovo.setId(new Long(itensCarrinho.size() + 1L));
					itemNovo.setQuantidade(1);
					itemNovo.setValor(produto.getValor());
					itensCarrinho.add(itemNovo);
					
					System.out.println(itemNovo.getProduto().getNome());
				}
//		}else {
//			ItemCarrinho itemNovo = new ItemCarrinho();
//			itemNovo.setProduto(produto);
//			itemNovo.setId(new Long(itensCarrinho.size() + 1L));
//			itemNovo.setQuantidade(1);
//			itemNovo.setValor(produto.getValor());
//			itensCarrinho.add(itemNovo);
//			
//			System.out.println(itemNovo.getProduto().getNome());
//		}
		
	}
	
	public void removerItem(ItemCarrinho itemCarrinho){
		itensCarrinho.remove(itemCarrinho);
	}
	/*public void alterarQtdeItem(int quantidade){
		for (ItemCarrinho itemCarrinho : itensCarrinho) {
			
		}
	}*/
	
	public List<ItemCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}
	
	public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}

}
