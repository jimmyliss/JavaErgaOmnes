package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Aluno extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private String profissao;
	private GrauEscolaridade grauEscolaridade;
	private Integer quantidadeCursos;
	private List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
	private Personagem personagem;
	private List<Compra> compras = new ArrayList<Compra>();
	private List<AreaEnsino> areasInteresse = new ArrayList<AreaEnsino>();
	
	/**
	 * *************************Getters e Setters*****************************
	 */
	
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public GrauEscolaridade getGrauEscolaridade() {
		return grauEscolaridade;
	}
	public void setGrauEscolaridade(GrauEscolaridade grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	
	public Integer getQuantidadeCursos() {
		return quantidadeCursos;
	}
	public void setQuantidadeCursos(Integer quantidadeCursos) {
		this.quantidadeCursos = quantidadeCursos;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="aluno")
	public List<Relacionamento> getRelacionamentos() {
		return relacionamentos;
	}
	public void setRelacionamentos(List<Relacionamento> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
		
	@ManyToOne(fetch=FetchType.LAZY)
	public Personagem getPersonagem() {
		return personagem;
	}
	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="aluno")
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(catalog = "ErgaOmnes", name = "AreaInteresse",
	joinColumns = { @JoinColumn(name = "idAluno", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "idAreaEnsino", referencedColumnName = "id")},
	uniqueConstraints = @UniqueConstraint(columnNames = {"idAluno", "idAreaEnsino"}))
	public List<AreaEnsino> getAreasInteresse() {
		return areasInteresse;
	}
	public void setAreasInteresse(List<AreaEnsino> areasInteresse) {
		this.areasInteresse = areasInteresse;
	}
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
