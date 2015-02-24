package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Visitante implements Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * *************************Atributos**************************
	 */
	
	private Long id;
	private String email;
	private String dataCadastro;
	private Integer situacao;
	private List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Integer getSituacao() {
		return situacao;
	}
	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="visitante")
	public List<Relacionamento> getRelacionamentos() {
		return relacionamentos;
	}
	public void setRelacionamentos(List<Relacionamento> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
	
	
	/**
	 * *************************Métodos***********************************
	 */

	
}
