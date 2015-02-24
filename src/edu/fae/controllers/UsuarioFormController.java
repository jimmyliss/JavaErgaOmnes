package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.GrupoDao;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Grupo;
import edu.fae.model.Usuario;
import edu.fae.util.DualListModelDiff;

@ViewScoped
@ManagedBean(name="usuarioFormController")
public class UsuarioFormController extends AbstractFormController<Usuario, UsuarioDao>{
	private GrupoDao grupoDao = DaoFactory.getGrupoDao();


	public Usuario getUsuario() {
		return getModel();
	}
	
	public DualListModel<Grupo> getGrupos() {
		return new DualListModelDiff<Grupo>(grupoDao.findAll(), getUsuario().getGrupos());
	}	
	public void setGrupos(DualListModel<Grupo> grupos) {
		getUsuario().setGrupos(grupos.getTarget());
	}	
	
}
