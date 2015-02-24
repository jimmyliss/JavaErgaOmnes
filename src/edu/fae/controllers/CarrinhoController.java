package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.fae.model.ItemCarrinho;


@SessionScoped
@ManagedBean(name="carrinhoController")
public class CarrinhoController extends AbstractController {
	private ItemCarrinho itemSelecionado;
	
	

	@PostConstruct
	public void init(){
		
	}
	
	public String fecharCarrinho() {
		getSession().remove("carrinho");
		return "main.xhtml?faces-redirect=true";
	}
	
	/*public void removerItemSelecionado(){
		getCarrinhoSession().removerItem(itemSelecionado);
	}*/

	//Getters e Setters
	
	public ItemCarrinho getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(ItemCarrinho itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	
}
