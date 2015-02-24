package edu.fae.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Marcelo Machado
 * 
 */

@Entity
public class Matricula implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos *****************************
	 */
	
	private Long id;
	private Date dt_matricula;
	private String situacao;
	private Date dt_inicial;
	private Date dt_final;
	
	private List<Compra> compras = new ArrayList<Compra>();
	private Curso curso;
	
	/**
	 * *************************Getters e Setters*****************************
	 */
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDt_matricula() {
		return dt_matricula;
	}

	public void setDt_matricula(Date dt_matricula) {
		this.dt_matricula = dt_matricula;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDt_inicial() {
		return dt_inicial;
	}

	public void setDt_inicial(Date dt_inicial) {
		this.dt_inicial = dt_inicial;
	}

	public Date getDt_final() {
		return dt_final;
	}

	public void setDt_final(Date dt_final) {
		this.dt_final = dt_final;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	/**
	 * ************************* Metodos *****************************
	 */

	
}
