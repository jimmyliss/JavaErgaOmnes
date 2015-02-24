package edu.fae.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author 
 * 
 */

@Entity
public class Anotacao implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos **************************
	 */
	
	private Long	id;
	private String	tituloAnotacao;
	private Date	dataAnotacao;
	private String	descricao;
	
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

	public String getTituloAnotacao() {
		return tituloAnotacao;
	}

	public void setTituloAnotacao(String tituloAnotacao) {
		this.tituloAnotacao = tituloAnotacao;
	}

	public Date getDataAnotacao() {
		return dataAnotacao;
	}

	public void setDataAnotacao(Date dataAnotacao) {
		this.dataAnotacao = dataAnotacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
