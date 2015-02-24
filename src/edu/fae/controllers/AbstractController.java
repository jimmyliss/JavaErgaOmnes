package edu.fae.controllers;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.CarrinhoCompra;
import edu.fae.model.Categoria;
import edu.fae.model.Usuario;

public abstract class AbstractController {
	
	public Usuario getUsuarioLogado() {
		return (Usuario) getSession().get("usuarioLogado");
	}

	/**
	 * Retorna um map que representa as vari�veis guardadas a sess�o
	 */
	protected Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
	}

	/**
	 * Menu dinâmico das Categorias
	 */
	/*private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();

	public List<Categoria> getCategorias() {
		return categoriaDao.findAll();
	}

	private MenuModel menu;

	public MenuModel getMenu() {
		return menu;
	}

	public void carregaMenu() {
		menu = new DefaultMenuModel();
         
	        //First submenu
	        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Produtos");
	        
	        DefaultMenuItem item = new DefaultMenuItem();
	        
	        item = new DefaultMenuItem("Todos");
    		item.setUrl("produto.jsf");
			item.setIcon("ui-icon-folder-collapsed");
			firstSubmenu.addElement(item);
	        
	        for (Categoria categoria : getCategorias()) {
	        	item = new DefaultMenuItem(categoria.getNome());
        		item.setUrl("produto.jsf?categoria_id=" + categoria.getId());
				item.setIcon("ui-icon-newwin");
				firstSubmenu.addElement(item);
			}
	         
	        menu.addElement(firstSubmenu);
	         
	        //Second submenu
	        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Envio de E-mail");
	 
	        item = new DefaultMenuItem("Envio de e-mail");
	        item.setIcon("ui-icon-mail-open");
	        item.setUrl("/emailFormulario.jsf");
	        secondSubmenu.addElement(item);
	        
	        item = new DefaultMenuItem("E-mail com Template");
	        item.setIcon("ui-icon-mail-open");
	        item.setUrl("/indiqueAmigo.jsf");
	        secondSubmenu.addElement(item);
	        
	        menu.addElement(secondSubmenu);
	}*/
	
	
	public CarrinhoCompra getCarrinhoSession() {
		if(getSession().get("carrinho") == null) {
			getSession().put("carrinho", new CarrinhoCompra());
		}
		
		return (CarrinhoCompra) getSession().get("carrinho");
	}
}


