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
import javax.persistence.OneToMany;

/**
 * 
 * @author Marcelo Machado
 * 
 */

@Entity
public class Compra implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ************************* Atributos *****************************
	 */	
	
	private Long id;
	private Double valorPago;
	private String situacao;
	private Date dtCompra;
	private Date dtPagamento;
	private String tipoPagamento;

	private Aluno aluno;
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	private Financeiro financeiro;
	private PagSeguro pagSeguro;
	
	
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

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDtCompra() {
		return dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="compras")
		public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Financeiro getFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public PagSeguro getPagSeguro() {
		return pagSeguro;
	}

	public void setPagSeguro(PagSeguro pagSeguro) {
		this.pagSeguro = pagSeguro;
	}
	
	/**
	 * ************************* Metodos *****************************
	 */

}
