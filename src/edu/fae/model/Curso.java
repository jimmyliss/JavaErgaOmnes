package edu.fae.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author 
 * 
 */





import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curso implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Long id;
	private String nomeCurso;
	private Boolean status;
	private Boolean situacao;
	private String descricaoCurso;
	private String cadastrador;
	private Date dataCadastro;
	private Date dataMatricula;
	private Date dataInicio;
	private Date dataPrevistaFim;
	private Date dataConclusao;
	private Boolean resultadoFinal;
	
	private Docente docente;
	private Tutoria tutoria;
	private Aluno aluno;
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	private List<Certificado> certificados = new ArrayList<Certificado>();
	private List<UnidadeEstudo> unidadesEstudo = new ArrayList<UnidadeEstudo>();
	private AreaEnsino areaEnsino;
	private List<Game> games = new ArrayList<Game>();

	/**
	 * *************************Getters e Setters*****************************
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Boolean getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	public String getDescricaoCurso() {
		return descricaoCurso;
	}
	
	public void setDescricaoCurso(String descricaoCurso) {
		this.descricaoCurso = descricaoCurso;
	}
	
	public String getCadastrador() {
		return cadastrador;
	}
	
	public void setCadastrador(String cadastrador) {
		this.cadastrador = cadastrador;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Date getDataMatricula() {
		return dataMatricula;
	}
	
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataPrevistaFim() {
		return dataPrevistaFim;
	}
	
	public void setDataPrevistaFim(Date dataPrevistaFim) {
		this.dataPrevistaFim = dataPrevistaFim;
	}
	
	public Date getDataConclusao() {
		return dataConclusao;
	}
	
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
	public Boolean getResultadoFinal() {
		return resultadoFinal;
	}
	
	public void setResultadoFinal(Boolean resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Tutoria getTutoria() {
		return tutoria;
	}

	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
	public List<UnidadeEstudo> getUnidadesEstudo() {
		return unidadesEstudo;
	}

	public void setUnidadesEstudo(List<UnidadeEstudo> unidadesEstudo) {
		this.unidadesEstudo = unidadesEstudo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public AreaEnsino getAreaEnsino() {
		return areaEnsino;
	}

	public void setAreaEnsino(AreaEnsino areaEnsino) {
		this.areaEnsino = areaEnsino;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	
	/**
	 * ************************* Metodos *****************************
	 */

}
