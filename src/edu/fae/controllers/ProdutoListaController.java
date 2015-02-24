package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.ProdutoDao;
import edu.fae.model.CarrinhoCompra;
import edu.fae.model.ItemCarrinho;
import edu.fae.model.Produto;

@ViewScoped
@ManagedBean(name="produtoListaController")
public class ProdutoListaController extends AbstractListaController<Produto, ProdutoDao> {
	
	/**
	 * Método herdado do ProdutoListaController
	 */
	@PostConstruct
	public void iniciar() {
		String idCategoria = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("categoria_id");
		if (idCategoria != null) {
			setModels(getDao().listaPorCategoria(new Long(idCategoria)));
		}else {
			super.buscaTodos();
		}
	}
	
	/**
	 * M�todo que exclui um produto
	 */
	
	public void excluir() {
		super.excluir();
	}
	
	/**
	 * Carrinho de Compras
	 */
	
	private CarrinhoCompra carrinhoCompra = new CarrinhoCompra();
	
/*	public void adicionarItem(){
		String idProduto = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");

		carrinhoCompra.adicionarProduto(getDao().findById(new Long(idProduto)));
	}*/
	
}
