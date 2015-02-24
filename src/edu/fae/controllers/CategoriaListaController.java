package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.CategoriaDao;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaListaController")
public class CategoriaListaController extends AbstractListaController<Categoria, CategoriaDao> {
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
