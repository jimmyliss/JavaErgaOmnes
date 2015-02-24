package edu.fae.model;

import javax.persistence.Entity;


@Entity
public class SugerirQuestao extends Game{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Integer enunciado;
	private Integer resposta;
	private Boolean aprovado;
	private String justificativa;
	
	/**
	 * *************************Getters e Setters*****************************
	 */
	
	public Integer getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(Integer enunciado) {
		this.enunciado = enunciado;
	}
	public Integer getResposta() {
		return resposta;
	}
	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}
	public Boolean getAprovado() {
		return aprovado;
	}
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
		
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
