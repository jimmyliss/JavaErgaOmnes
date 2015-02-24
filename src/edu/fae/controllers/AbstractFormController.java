package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.fae.dao.Dao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Model;

public abstract class AbstractFormController<MODEL extends Model, DAO extends Dao<MODEL>> extends AbstractController {
	protected DAO dao = getDao();

	public AbstractFormController() {
		iniciar();
	}
	
	protected DAO getDao() {
		if(dao==null) {
			String name = this.getClass().getSimpleName();
			if(name.endsWith("FormController")) {
				name = name.substring(0, name.length() - 14);
				return (DAO) DaoFactory.getDaoByModelClassName(name);
			}
		}
		return dao;
	}

	/**
	 * Objeto categoria que � editado no formul�rio
	 */
	private MODEL model;

	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	
	public void iniciar() {
		// Pegando o par�metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id == null) {// Quando o id est� null, abrimos o formul�rio para
							// inser��o
			model = getNewModel();
		} else {// Quando o id � passado como par�metro abrimos o formul�rio
				// para edi��o
			model = dao.findById(new Long(id));
			System.out.println(model);
		}
	}

	//protected abstract MODEL getNewModel();
	protected MODEL getNewModel() {
		return getDao().getNewModel();
	}
	
	public MODEL getModel() {
		return model;
	}

	public void salvar() {
		// Pegamos uma referencia para o FacesContext, para mandar mensagens
		// para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();

		dao.save(model);

		// Mandando uma mensagem para a tela
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Registro salvo com sucesso!", null));
	}

}
