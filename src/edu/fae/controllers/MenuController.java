package edu.fae.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Acao;
import edu.fae.model.Grupo;
import edu.fae.model.Usuario;


@RequestScoped
@ManagedBean(name="menuController")
public class MenuController extends AbstractController {

	private Usuario usuario = getUsuarioLogado();

	private UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
	
	public Usuario getUsuarioMenu() {
		return usuarioDao.findById(usuario.getId());
	}
	/**
	 * Menu dinâmico
	 */
	
	private MenuModel menu;

	public MenuModel getMenu() {
		
		menu = new DefaultMenuModel();
        
		List<DefaultSubMenu> submenus = new ArrayList<DefaultSubMenu>();
		DefaultMenuItem item = new DefaultMenuItem();
		
		for(Grupo grupo: getUsuarioMenu().getGrupos()) {
			//First submenu
			submenus.add(new DefaultSubMenu(grupo.getNome()));
			
		}
		
		for (DefaultSubMenu defaultSubMenu : submenus) {
			for(Grupo grupo: getUsuarioMenu().getGrupos()) {
				for(Acao acao: grupo.getAcoes()) {
					item = new DefaultMenuItem(acao.getRecurso().getNome());
					item.setUrl("../" + acao.getRecurso().getPagina());
					item.setIcon("ui-icon-folder-collapsed");
					defaultSubMenu.addElement(item);
				}
			}
			menu.addElement(defaultSubMenu);
			
		}
		
		return menu;
	}

/*	public void carregaMenuAdmin() {
		menu = new DefaultMenuModel();
        
		List<DefaultSubMenu> submenus = new ArrayList<DefaultSubMenu>();
		DefaultMenuItem item = new DefaultMenuItem();
		
		for(Grupo grupo: getUsuarioMenu().getGrupos()) {
			//First submenu
			submenus.add(new DefaultSubMenu(grupo.getNome()));
			
		}
		
		for (DefaultSubMenu defaultSubMenu : submenus) {
			for(Grupo grupo: getUsuarioMenu().getGrupos()) {
				for(Acao acao: grupo.getAcoes()) {
					item = new DefaultMenuItem(acao.getRecurso().getNome());
					item.setUrl("../" + acao.getRecurso().getPagina());
					item.setIcon("ui-icon-folder-collapsed");
					defaultSubMenu.addElement(item);
				}
			}
			menu.addElement(defaultSubMenu);
			
		}
		    
	}*/
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
