package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class UnidadeFederativa implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String nome;
	private String sigla;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
