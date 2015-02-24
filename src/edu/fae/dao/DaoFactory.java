package edu.fae.dao;

import edu.fae.dao.hibernate.AlunoDaoHibernate;
import edu.fae.dao.hibernate.AnotacaoDaoHibernate;
import edu.fae.dao.hibernate.AreaEnsinoDaoHibernate;
import edu.fae.dao.hibernate.AvaliacaoDaoHibernate;
import edu.fae.dao.hibernate.CategoriaDaoHibernate;
import edu.fae.dao.hibernate.CertificadoDaoHibernate;
import edu.fae.dao.hibernate.CompraDaoHibernate;
import edu.fae.dao.hibernate.ContraOTempoDaoHibernate;
import edu.fae.dao.hibernate.CursoDaoHibernate;
import edu.fae.dao.hibernate.DesafioDaoHibernate;
import edu.fae.dao.hibernate.EstadoCivilDaoHibernate;
import edu.fae.dao.hibernate.FinanceiroDaoHibernate;
import edu.fae.dao.hibernate.FuncionarioDaoHibernate;
import edu.fae.dao.hibernate.GameDaoHibernate;
import edu.fae.dao.hibernate.GrauEscolaridadeDaoHibernate;
import edu.fae.dao.hibernate.GrupoDaoHibernate;
import edu.fae.dao.hibernate.ImagemDaoHibernate;
import edu.fae.dao.hibernate.ItemDaoHibernate;
import edu.fae.dao.hibernate.LogDaoHibernate;
import edu.fae.dao.hibernate.MatriculaDaoHibernate;
import edu.fae.dao.hibernate.PagSeguroDaoHibernate;
import edu.fae.dao.hibernate.PedidoDaoHibernate;
import edu.fae.dao.hibernate.PersonagemDaoHibernate;
import edu.fae.dao.hibernate.ProdutoDaoHibernate;
import edu.fae.dao.hibernate.RecursoDaoHibernate;
import edu.fae.dao.hibernate.RelacionamentoDaoHibernate;
import edu.fae.dao.hibernate.SugerirQuestaoDaoHibernate;
import edu.fae.dao.hibernate.TutoriaDaoHibernate;
import edu.fae.dao.hibernate.UnidadeEstudoDaoHibernate;
import edu.fae.dao.hibernate.UnidadeFederativaDaoHibernate;
import edu.fae.dao.hibernate.UsuarioDaoHibernate;
import edu.fae.dao.hibernate.VisitanteDaoHibernate;


/**
 * Factory de Dao
 * @author JimmyLiss
 * @since 1.0
 */
public class DaoFactory {
	
	public static Dao<?> getDaoByModelClassName(String modelClassName) {
		
//		String className = model.getClass().getSimpleName();
//		String pkg = model.getClass().getPackage().getName();
		
		String daoName = "edu.fae.dao.hibernate."+modelClassName+"DaoHibernate";
		try { 
			return (Dao<?>) Class.forName(daoName).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public static UsuarioDao getUsuarioDao() {
		return new UsuarioDaoHibernate();
	}
	
	public static GrupoDao getGrupoDao() {
		return new GrupoDaoHibernate();
	}
	
	public static RecursoDao getRecursoDao() {
		return new RecursoDaoHibernate();
	}	
	
	public static AlunoDao getAlunoDao() {
		return new AlunoDaoHibernate();
	}
	
	public static FuncionarioDao getFuncionarioDao() {
		return new FuncionarioDaoHibernate();
	}
	
	public static AnotacaoDao getAnotacaoDao() {
		return new AnotacaoDaoHibernate();
	}

	public static AvaliacaoDao getAvaliacaoDao() {
		return new AvaliacaoDaoHibernate();
	}

	public static CertificadoDao getCertificadoDao() {
		return new CertificadoDaoHibernate();
	}

	public static CompraDao getCompraDao() {
		return new CompraDaoHibernate();
	}

	public static ContraOTempoDao getContraOTempoDao() {
		return new ContraOTempoDaoHibernate();
	}

	public static CursoDao getCursoDao() {
		return new CursoDaoHibernate();
	}

	public static DesafioDao getDesafioDao() {
		return new DesafioDaoHibernate();
	}

	public static FinanceiroDao getFinanceiroDao() {
		return new FinanceiroDaoHibernate();
	}

	public static GameDao getGameDao() {
		return new GameDaoHibernate();
	}

	public static LogDao getLogDao() {
		return new LogDaoHibernate();
	}

	public static MatriculaDao getMatriculaDao() {
		return new MatriculaDaoHibernate();
	}

	public static PagSeguroDao getPagSeguroDao() {
		return new PagSeguroDaoHibernate();
	}

	public static PersonagemDao getPersonagemDao() {
		return new PersonagemDaoHibernate();
	}

	public static RelacionamentoDao getRelacionamentoDao() {
		return new RelacionamentoDaoHibernate();
	}

	public static SugerirQuestaoDao getSugerirQuestaoDao() {
		return new SugerirQuestaoDaoHibernate();
	}

	public static TutoriaDao getTutoriaDao() {
		return new TutoriaDaoHibernate();
	}

	public static UnidadeEstudoDao getUnidadeEstudoDao() {
		return new UnidadeEstudoDaoHibernate();
	}

	public static VisitanteDao getVisitanteDao() {
		return new VisitanteDaoHibernate();
	}
	
	public static GrauEscolaridadeDao getGrauEscolaridadeDao() {
		return new GrauEscolaridadeDaoHibernate();
	}
	
	public static UnidadeFederativaDao getUnidadeFederativaDao() {
		return new UnidadeFederativaDaoHibernate();
	}
	
	public static AreaEnsinoDao getAreaEnsinoDao() {
		return new AreaEnsinoDaoHibernate();
	}
	
	public static EstadoCivilDao getEstadoCivilDao() {
		return new EstadoCivilDaoHibernate();
	}
	
	
	public static ProdutoDao getProdutoDao() {
		return new ProdutoDaoHibernate();
	}	
	
	public static CategoriaDao getCategoriaDao() {
		return new CategoriaDaoHibernate();
	}
	
	public static ImagemDao getImagemDao() {
		return new ImagemDaoHibernate();
	}
	
	public static ItemDao getItemDao() {
		return new ItemDaoHibernate();
	}
	
	public static PedidoDao getPedidoDao(){
		return new PedidoDaoHibernate();
	}
}
