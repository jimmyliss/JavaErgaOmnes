package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.GrauEscolaridadeDao;
import edu.fae.model.GrauEscolaridade;

@ViewScoped
@ManagedBean(name="grauEscolaridadeListaController")
public class GrauEscolaridadeListaController extends AbstractListaController<GrauEscolaridade, GrauEscolaridadeDao> {
	/**
	 * M�todo que � chamado quando a view � aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		super.buscaTodos();
	}

	/**
	 * M�todo que exclui um categoria
	 */
	public void excluir() {
		super.excluir();
	}
	
}
