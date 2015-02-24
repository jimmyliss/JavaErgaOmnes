package edu.fae.model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Funcionario extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private String emailCorporativo;
	private String cargo;
	private String funcao;
	private Date dataContratacao;
	
	/**
	 * *************************Getters e Setters*****************************
	 */
	
	public String getEmailCorporativo() {
		return emailCorporativo;
	}
	public void setEmailCorporativo(String emailCorporativo) {
		this.emailCorporativo = emailCorporativo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
