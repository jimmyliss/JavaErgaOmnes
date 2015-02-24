package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class GrauEscolaridade implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String descricao;
	private String sigla;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="grauEscolaridade")
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
