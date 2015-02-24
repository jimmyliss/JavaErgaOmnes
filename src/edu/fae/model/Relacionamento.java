package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Relacionamento implements Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Long id;
	private String nome;
	private Aluno aluno;
	private Visitante visitante;
	
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Visitante getVisitante() {
		return visitante;
	}
	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
