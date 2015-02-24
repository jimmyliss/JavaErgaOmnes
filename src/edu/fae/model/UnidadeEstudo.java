package edu.fae.model;

/**
 * 
 * @author 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UnidadeEstudo implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos **************************
	 */
	
	private Long	id;
	private String 	tituloUnidade;
	private String 	tipo;
	private Boolean status;
	private Boolean situacao;
	private String 	resumo;
	private String	conteudo;
	private String	nomeArquivo;
	
	private Curso curso;
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	private List<Anotacao> anotacoes = new ArrayList<Anotacao>();

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

	public String getTituloUnidade() {
		return tituloUnidade;
	}

	public void setTituloUnidade(String tituloUnidade) {
		this.tituloUnidade = tituloUnidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="unidadeEstudo")
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="unidadeEstudo")
	public List<Anotacao> getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(List<Anotacao> anotacoes) {
		this.anotacoes = anotacoes;
	}

	
	
	/**
	 * ************************* Metodos *****************************
	 */

}
