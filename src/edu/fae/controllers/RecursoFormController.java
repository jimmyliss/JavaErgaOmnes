package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.RecursoDao;
import edu.fae.model.Acao;
import edu.fae.model.Recurso;

@ViewScoped
@ManagedBean(name="recursoFormController")
public class RecursoFormController extends AbstractFormController<Recurso, RecursoDao>{

	//private List<Acao> acoesParaRemover = new LinkedList<Acao>();
	//private GenericDataModel<Acao> acoes;

	private Acao acaoParaRemover;
	
	public void adicionarAcao() {
		Acao acao = new Acao();
		acao.setRecurso(getRecurso());
		
		getRecurso().getAcoes().add(acao);
	}
	
	public void removerAcao() {
		if(acaoParaRemover!=null) {
			getRecurso().getAcoes().remove(acaoParaRemover);
		}
	}
	
//	public GenericDataModel<Acao> getAcoes() {
//		if(acoes==null) {
//			acoes = new GenericDataModel<Acao>(getRecurso().getAcoes());
//		}
//		return acoes;
//	}
	

	public Acao getAcaoParaRemover() {
		return acaoParaRemover;
	}

	public void setAcaoParaRemover(Acao acaoParaRemover) {
		this.acaoParaRemover = acaoParaRemover;
	}


	public Recurso getRecurso() {
		return getModel();
	}
	@Override
	protected Recurso getNewModel() {
		return new Recurso();
	}
	@PostConstruct
	public void iniciar() {
		super.iniciar();
	}
	
}
