package edu.fae.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Acao implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String nome;
	private String codigo;
	private Recurso recurso;
	
	/**
	 * ********************Getters e Setters**********************
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	public Recurso getRecurso() {
		return recurso;
	}


	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	/**
	 ********************************Métodos******************************* 
	 */
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj instanceof Acao) {
			Acao that = (Acao) obj;
			if(that.getId()!=null) 
				return that.getId().equals(this.getId());
		}
		return false;
	}
	
	
}
