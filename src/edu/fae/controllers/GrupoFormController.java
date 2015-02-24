package edu.fae.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.GrupoDao;
import edu.fae.dao.RecursoDao;
import edu.fae.model.Acao;
import edu.fae.model.Grupo;
import edu.fae.model.Recurso;

@ViewScoped
@ManagedBean(name="grupoFormController")
public class GrupoFormController extends AbstractFormController<Grupo, GrupoDao>{
	private RecursoDao recursoDao = DaoFactory.getRecursoDao();
	
	private List<SelectItem> acoes;
	
	
	public List<Acao> getAcoesDoGrupo() {
		List<Acao> acoesDoGrupo = new LinkedList<Acao>();
		acoesDoGrupo.addAll(getGrupo().getAcoes());
		return acoesDoGrupo;
	}
	
	public void setAcoesDoGrupo(List<Acao> acoes) {
		getGrupo().setAcoes(acoes);
	}
	
	public List<SelectItem> getAcoes() {
		if(acoes==null) {
			acoes = new ArrayList<SelectItem>();
			
			List<Recurso> recursos = recursoDao.findAll();
			for (Recurso recurso : recursos) {
				SelectItemGroup g = new SelectItemGroup(recurso.getNome());
				List<SelectItem> itens = new ArrayList<SelectItem>();
				
				for(Acao acao: recurso.getAcoes()) {
					itens.add(new SelectItem(acao, acao.getNome()));
				}
				g.setSelectItems(itens.toArray(new SelectItem[itens.size()]));
				acoes.add(g);
			}
			
		}
		return acoes;
	}
	

	
	public void iniciar() {
		super.iniciar();
		System.out.println(getGrupo().getAcoes().size());
	}
	

	public Grupo getGrupo() {
		return getModel();
	}


	
}
