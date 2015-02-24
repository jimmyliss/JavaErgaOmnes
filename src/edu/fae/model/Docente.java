package edu.fae.model;

import javax.persistence.Entity;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Docente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private String emailCorporativo;
	private String area;
	private String titulacao;
	
	/**
	 * *************************Getters e Setters*****************************
	 */
	
	public String getEmailCorporativo() {
		return emailCorporativo;
	}
	public void setEmailCorporativo(String emailCorporativo) {
		this.emailCorporativo = emailCorporativo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
