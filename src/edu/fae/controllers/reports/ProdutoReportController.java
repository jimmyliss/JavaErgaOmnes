package edu.fae.controllers.reports;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ViewScoped
@ManagedBean(name="produtoReportController")
public class ProdutoReportController extends AbstractReportController {
	private String categoria;
	
	
	public void gerar() {
		
		if(StringUtils.isNotEmpty(categoria))
			addParam("nome_categoria", "%"+categoria+"%");
		else
			addParam("nome_categoria", "%");
		
		super.gerar("relatorio_produto.jasper");
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	
}
