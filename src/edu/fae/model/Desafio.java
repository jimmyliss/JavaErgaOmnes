package edu.fae.model;

import javax.persistence.Entity;


@Entity
public class Desafio extends Game{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Integer acertos;
	private Integer erros;
	private String tempoTermino;
	private Integer quantidadeQuestoes;
	
	/**
	 * *************************Getters e Setters*****************************
	 */
	
	public Integer getAcertos() {
		return acertos;
	}
	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}
	public Integer getErros() {
		return erros;
	}
	public void setErros(Integer erros) {
		this.erros = erros;
	}
	public String getTempoTermino() {
		return tempoTermino;
	}
	public void setTempoTermino(String tempoTermino) {
		this.tempoTermino = tempoTermino;
	}
	public Integer getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}
	public void setQuantidadeQuestoes(Integer quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}
		
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
