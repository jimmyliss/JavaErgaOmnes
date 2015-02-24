package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaFormController")
public class CategoriaFormController extends AbstractFormController<Categoria, CategoriaDao>{
	
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
