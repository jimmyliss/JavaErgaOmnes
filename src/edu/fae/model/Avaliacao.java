package edu.fae.model;

/**
 * 
 * @author 
 * 
 */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos **************************
	 */
	
	private Long	id;
	private String	nomeAvaliacao;
	private Integer	quantidadeQuestoes;
	private Double	notaFinal;
	private Boolean statusAvaliacao;
	private Date	dataRealizacao;
	private Boolean	situacaoAvaliacao;
	
	private UnidadeEstudo unidadeEstudo;

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

	public String getNomeAvaliacao() {
		return nomeAvaliacao;
	}

	public void setNomeAvaliacao(String nomeAvaliacao) {
		this.nomeAvaliacao = nomeAvaliacao;
	}

	public Integer getQuantidadeQuestoes() {
		return quantidadeQuestoes;
	}

	public void setQuantidadeQuestoes(Integer quantidadeQuestoes) {
		this.quantidadeQuestoes = quantidadeQuestoes;
	}

	public Double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Boolean getStatusAvaliacao() {
		return statusAvaliacao;
	}

	public void setStatusAvaliacao(Boolean statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public Boolean getSituacaoAvaliacao() {
		return situacaoAvaliacao;
	}

	public void setSituacaoAvaliacao(Boolean situacaoAvaliacao) {
		this.situacaoAvaliacao = situacaoAvaliacao;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public UnidadeEstudo getUnidadeEstudo() {
		return unidadeEstudo;
	}

	public void setUnidadeEstudo(UnidadeEstudo unidadeEstudo) {
		this.unidadeEstudo = unidadeEstudo;
	}

	
	
	/**
	 * ************************* Metodos *****************************
	 */

}
