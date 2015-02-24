package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.GrauEscolaridadeDao;
import edu.fae.model.GrauEscolaridade;

@ViewScoped
@ManagedBean(name="grauEscolaridadeFormController")
public class GrauEscolaridadeFormController extends AbstractFormController<GrauEscolaridade, GrauEscolaridadeDao>{
	
	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	@PostConstruct
	public void iniciar() {
		super.iniciar();
	}
	
	public void salvar() {
		super.salvar();
	}
	

}
