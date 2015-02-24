package edu.fae.model;

/**
 * 
 * @author 
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Tutoria implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos **************************
	 */
	
	private Long id;
	private Integer numero;
	private String assunto;
	private Boolean status;
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="tutoria")
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

		
	/**
	 * ************************* Metodos *****************************
	 */

}
