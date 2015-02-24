package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

@ViewScoped
@ManagedBean(name="usuarioListaController")
public class UsuarioListaController extends AbstractListaController<Usuario, UsuarioDao> {
	public void iniciar(){
		super.buscaTodos();
	}
}
