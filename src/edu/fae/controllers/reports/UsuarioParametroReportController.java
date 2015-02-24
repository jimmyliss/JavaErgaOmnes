package edu.fae.controllers.reports;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ViewScoped
@ManagedBean(name="usuarioParametroReportController")
public class UsuarioParametroReportController extends AbstractReportController {
	private String nome;
	
	
	public void gerar() {
		
		if(StringUtils.isNotEmpty(nome))
			addParam("nome", "%"+nome+"%");
		else
			addParam("nome", "%");
		
		super.gerar("usuariosComParametro.jasper");
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
