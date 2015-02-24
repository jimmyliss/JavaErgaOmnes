package edu.fae.model;

import javax.persistence.Entity;


@Entity
public class ContraOTempo extends Game{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Integer acertos;
	private Integer erros;
	private String tempoInicio;
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
	public Integer getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}
	public void setQuantidadeQuestoes(Integer quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}
	public String getTempoInicio() {
		return tempoInicio;
	}
	public void setTempoInicio(String tempoInicio) {
		this.tempoInicio = tempoInicio;
	}
		
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
