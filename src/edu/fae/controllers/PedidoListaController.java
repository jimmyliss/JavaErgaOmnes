package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.PedidoDao;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.CarrinhoCompra;
import edu.fae.model.ItemCarrinho;
import edu.fae.model.Pedido;
import edu.fae.model.Produto;

@ViewScoped
@ManagedBean(name="pedidoListaController")
public class PedidoListaController extends AbstractListaController<Pedido, PedidoDao> {
	
	/**
	 * Método herdado do ProdutoListaController
	 */
	@PostConstruct
	public void iniciar() {
		super.buscaTodos();
	}
	
	/**
	 * M�todo que exclui um produto
	 */
	
	public void excluir() {
		super.excluir();
	}
	
}
