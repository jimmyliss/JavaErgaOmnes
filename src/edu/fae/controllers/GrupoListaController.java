package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.GrupoDao;
import edu.fae.model.Grupo;

@ViewScoped
@ManagedBean(name="grupoListaController")
public class GrupoListaController extends AbstractListaController<Grupo, GrupoDao> {

	@PostConstruct
	public void iniciar() {
		super.buscaTodos();
	}	

}
