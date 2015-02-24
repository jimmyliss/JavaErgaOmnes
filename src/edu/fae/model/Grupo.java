package edu.fae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
public class Grupo implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String nome;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
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

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="grupos")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@ManyToMany(fetch=FetchType.EAGER)
	public List<Acao> getAcoes() {
		return acoes;
	}


	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	@Transient
	public boolean isTemAcesso(String pagina) {
		for(Acao acao: getAcoes()) {
			if(pagina.equals(acao.getRecurso().getPagina())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 ********************************Métodos******************************* 
	 */
	
	@Transient
	public boolean isTemAcesso(String pagina, String codigoAcao) {
		for(Acao acao: getAcoes()) {
			if(pagina.equals(acao.getRecurso().getPagina()) && codigoAcao.equals(acao.getCodigo())) {
				return true;
			}
		}
		return false;
	}	

}
