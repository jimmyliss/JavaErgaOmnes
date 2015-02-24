package edu.fae.controllers;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.fae.model.CarrinhoCompra;
import edu.fae.model.Usuario;


@SessionScoped
@ManagedBean(name="mainController")
public class MainController extends AbstractController {
	
//	private CarrinhoCompra carrinho = new CarrinhoCompra();
	
	/*public void criarCarrinho(){
		getSession().put("carrinho", carrinho);
	}
*/	
	public Usuario getUsuarioLogado() {
		return (Usuario) getSession().get("usuarioLogado");
	}
	
	/**
	 * Retorna um map que representa as vari�veis guardadas
	 * a sess�o
	 */
/*	private Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}*/	
}
