package edu.fae.model;

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
public class Personagem implements Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Long id;
	private String nome;
	private String imagem;
	private Integer pontuacaoInicial;
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Integer getPontuacaoInicial() {
		return pontuacaoInicial;
	}
	public void setPontuacaoInicial(Integer pontuacaoInicial) {
		this.pontuacaoInicial = pontuacaoInicial;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="personagem")
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
