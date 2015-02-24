package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.AlunoDao;
import edu.fae.model.Aluno;

@ViewScoped
@ManagedBean(name="alunoListaController")
public class AlunoListaController extends AbstractListaController<Aluno, AlunoDao> {
	private Long id;
	private Boolean situacaoAlt;
	
	public void iniciar(){
		super.buscaTodos();
	}
	
	public void alteraSituacao() {
		if(id!=null) {
			Aluno aluno = getDao().findById(id);
			if(aluno!=null) {
				aluno.setSituacao(situacaoAlt);
				getDao().save(aluno);
			}
		}
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getSituacaoAlt() {
		return situacaoAlt;
	}

	public void setSituacaoAlt(Boolean situacaoAlt) {
		this.situacaoAlt = situacaoAlt;
	}
	
	
}
