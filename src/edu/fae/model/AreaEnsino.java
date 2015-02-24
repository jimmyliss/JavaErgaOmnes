package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;


@Entity
public class AreaEnsino implements Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Long id;
	private String nome;
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="areaEnsino")
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(catalog = "ErgaOmnes", name = "AreaInteresse",
	joinColumns = { @JoinColumn(name = "idAreaEnsino", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "idAluno", referencedColumnName = "id")},
	uniqueConstraints = @UniqueConstraint(columnNames = {"idAluno", "idAreaEnsino"}))
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
