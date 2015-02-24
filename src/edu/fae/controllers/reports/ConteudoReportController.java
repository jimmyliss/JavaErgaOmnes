package edu.fae.controllers.reports;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;
import edu.fae.util.Util;

/**
 * 
 * @author Robson J. P.
 *
 */
@ViewScoped
@ManagedBean(name="conteudoReportController")
public class ConteudoReportController extends AbstractReportController {
//	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
	
	private String titulo;
	private Date dataInicial;
	private Date dataFinal;	
	private Categoria categoriaSelecionada;
	
	
	public void gerar() {
		
		if(StringUtils.isNotEmpty(titulo))
			addParam("titulo", "%"+titulo+"%");
		else
			addParam("titulo", "%");		
		
		addParam("dataInicial", dataInicial!=null ? dataInicial : Util.getDate(31, 12, 1900));
		addParam("dataFinal", dataFinal!=null ? dataFinal : Util.getDate(31, 12, 3000));
		
		//caso tenho alguma �rea seleciona envia o id da �rea
		//caso contr�rio envia null
		if(categoriaSelecionada!=null) {
			addParam("categoria", categoriaSelecionada.getId());
		}else{
			addParam("categoria", null);
		}
		super.gerar("conteudos.jasper");
	}
	
	/*public List<Categoria> getCategorias() {
		return categoriaDao.findAll();		
	}*/

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}
	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
