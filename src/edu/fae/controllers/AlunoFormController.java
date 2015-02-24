package edu.fae.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

import edu.fae.dao.AlunoDao;
import edu.fae.dao.AreaEnsinoDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.EstadoCivilDao;
import edu.fae.dao.GrauEscolaridadeDao;
import edu.fae.dao.GrupoDao;
import edu.fae.dao.UnidadeFederativaDao;
import edu.fae.model.Aluno;
import edu.fae.model.AreaEnsino;
import edu.fae.model.EstadoCivil;
import edu.fae.model.GrauEscolaridade;
import edu.fae.model.Grupo;
import edu.fae.model.UnidadeFederativa;
import edu.fae.util.DualListModelDiff;

@ViewScoped
@ManagedBean(name="alunoFormController")
public class AlunoFormController extends AbstractFormController<Aluno, AlunoDao>{
	private GrupoDao grupoDao = DaoFactory.getGrupoDao();
	private GrauEscolaridadeDao escolaridadeDao = DaoFactory.getGrauEscolaridadeDao();
	private UnidadeFederativaDao unidadeFederativaDao = DaoFactory.getUnidadeFederativaDao();
	private AreaEnsinoDao areaEnsinoDao = DaoFactory.getAreaEnsinoDao();
	private EstadoCivilDao estadoCivilDao = DaoFactory.getEstadoCivilDao();
	
	
	public Aluno getAluno() {
		return getModel();
	}
	
	public void salvar() {
		
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id == null && !StringUtils.isNotBlank(getAluno().getSenhaUsuario())) {
			
			FacesContext ctx = FacesContext.getCurrentInstance();

				// Mandando uma mensagem para a tela
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"A Senha deve ser preenchida!", null));
		} else {
			
			super.salvar();
		}
	}
	
	public void validaSenha() {
			RequestContext.getCurrentInstance().execute("PF('dlgSenha').hide();");
	}
	
	public DualListModel<AreaEnsino> getAreasInteresse() {
		return new DualListModelDiff<AreaEnsino>(areaEnsinoDao.findAll(), getAluno().getAreasInteresse());
	}	
	public void setAreasInteresse(DualListModel<AreaEnsino> areasInteresse) {
		getAluno().setAreasInteresse(areasInteresse.getTarget());
	}	
	
	
	public List<GrauEscolaridade> getEscolaridades() {
		return escolaridadeDao.findAll();
	}
	
	public List<UnidadeFederativa> getUnidadesFederativas() {
		return unidadeFederativaDao.findAll();
	}
	
	public List<EstadoCivil> getEstadosCivis() {
		return estadoCivilDao.findAll();
	}
}
