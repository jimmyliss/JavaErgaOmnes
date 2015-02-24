package edu.fae.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Certificado implements Model {

	private Long id;
	private Date dtEmissao;
	private String codVerificador;
	private Curso curso;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public String getCodVerificador() {
		return codVerificador;
	}

	public void setCodVerificador(String codVerificador) {
		this.codVerificador = codVerificador;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
}
