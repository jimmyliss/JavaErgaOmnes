package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Recurso implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String nome;
	private String pagina;
	private List<Acao> acoes = new ArrayList<Acao>();
	
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
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="recurso")
	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}

}
