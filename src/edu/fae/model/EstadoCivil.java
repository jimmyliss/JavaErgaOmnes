package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class EstadoCivil implements Model {
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
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
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
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="estadoCivil")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
