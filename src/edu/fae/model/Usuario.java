package edu.fae.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import edu.fae.util.Util;

/**
 * 
 * @author Jimmy Hardy Liss
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * **********************Atributos***********************
	 */
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String rg;
	private String sexo;
	private EstadoCivil estadoCivil;
	private Date dtNasc;
	private String username;
	private String senha;
	private Boolean situacao;
	private List<Grupo> grupos = new ArrayList<Grupo>();
	private List<Tutoria> tutorias = new ArrayList<Tutoria>();
	private List<Log> logs = new ArrayList<Log>();
	
	/*
	 * Contato
	 */
	private String telFixo;
	private String telCelular;
	private String telRecado;
	private String facebook;
	private String twitter;
	private String skype;
	
	/*
	 * Endereco 
	 */
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String cep;
	private UnidadeFederativa unidadeFederativa;
	
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
	public String getEmail() {
		return email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setSenhaUsuario(String senha) {
		if(senha!=null && senha.trim().length() > 0)
			setSenha(Util.gerarMD5(senha));
	}
	
	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
	public List<Tutoria> getTutorias() {
		return tutorias;
	}
	
	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="usuarios")
	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}


	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getTelRecado() {
		return telRecado;
	}

	public void setTelRecado(String telRecado) {
		this.telRecado = telRecado;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	/**
	 ********************************Métodos******************************* 
	 */
	
	@Transient
	public String getSenhaUsuario() {
		return this.senha;
	}


	@Transient
	public boolean isTemAcesso(String pagina, String codigoAcao) {
		for(Grupo grupo: getGrupos()) {
			if(grupo.isTemAcesso(pagina, codigoAcao)) {
				return true;
			}
		}
		return false;
	}
	
	@Transient
	public boolean isTemAcesso(String pagina) {
		for(Grupo grupo: getGrupos()) {
			if(grupo.isTemAcesso(pagina)) {
				return true;
			}
		}
		return false;		
	}
	
}
