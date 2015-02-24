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
 * @author Marcelo Machado
 * 
 */

@Entity
public class PagSeguro implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos *****************************
	 */
	
	private Long id;
	private String token;
	private String email;
	private String usuario;
	private String retorno;
	private List<Compra> compras = new ArrayList<Compra>();
	
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="pagSeguro")
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	/**
	 * ************************* Metodos *****************************
	 */
	

}
