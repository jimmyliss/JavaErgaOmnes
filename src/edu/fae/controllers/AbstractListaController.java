package edu.fae.controllers;

import java.util.List;

import edu.fae.dao.Dao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Model;

public abstract class AbstractListaController<MODEL extends Model, DAO extends Dao<MODEL>> extends AbstractController {
	private DAO dao = getDao();//DaoFactory.getCategoriaDao();
	
	public AbstractListaController() {
		buscaTodos();
	}
	
	
	protected DAO getDao() {
		String name = this.getClass().getSimpleName();
		if(name.endsWith("ListaController")) {
			name = name.substring(0, name.length() - 15);
			return (DAO) DaoFactory.getDaoByModelClassName(name);
		}
		return null;
	}
	
	/**
	 * Armazena os categorias mostrados na view
	 */
	private List<MODEL> models;
	
	/**
	 * Recebe o id do categoria para ser exclu�do
	 */
	private Long id;
	
	/**
	 * M�todo que � chamado quando a view � aberta
	 * pela primeira vez
	 */
	public void buscaTodos() {
//		carregaMenu();
		models = dao.findAll();
	}

	/**
	 * M�todo que exclui um categoria
	 */
	public void excluir() {
		if(id!=null) {
			MODEL model = dao.findById(id);
			if(model!=null) {
				dao.remove(model);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<MODEL> getModels() {
		return models;
	}


	public void setModels(List<MODEL> models) {
		this.models = models;
	}

}
