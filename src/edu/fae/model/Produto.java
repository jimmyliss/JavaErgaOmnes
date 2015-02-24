package edu.fae.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

@SuppressWarnings("serial")
@Entity
public class Produto implements Model {
	private Long id;
	private String nome;
	private String marca;
	private Date data;
	private String descricao;
	private Categoria categoria;
	private Double valor;
	private List<Item> itens = new ArrayList<Item>();
	private String imagemChamada;
	private List<Imagem> imagens = new ArrayList<Imagem>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 14)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Size(min = 2, max = 14, message="A marca deve ter entre 2 e 14 carateres")
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull(message="Informe a categoria do produto")
	@ManyToOne(fetch=FetchType.LAZY)
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name="produto")
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public String getImagemChamada() {
		return imagemChamada;
	}
	public void setImagemChamada(String imagemChamada) {
		this.imagemChamada = imagemChamada;
	}
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name="produto")
	public List<Imagem> getImagens() {
		return imagens;
	}
	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	
}
