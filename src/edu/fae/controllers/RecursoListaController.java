package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.RecursoDao;
import edu.fae.model.Recurso;

@ViewScoped
@ManagedBean(name="recursoListaController")
public class RecursoListaController extends AbstractListaController<Recurso, RecursoDao> {

	@PostConstruct
	public void iniciar() {
		super.buscaTodos();
	}	

}
