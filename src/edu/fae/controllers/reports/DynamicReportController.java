package edu.fae.controllers.reports;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import ar.com.fdvs.dj.core.DJConstants;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

@ViewScoped
@ManagedBean(name="dynamicReportController")
public class DynamicReportController extends AbstractReportController {
	private String nome;
	
	
	public void gerar() throws Exception {
		reportRequest = new ReportRequest();
		
		if(StringUtils.isNotEmpty(nome))
			addParam("nome", "%"+nome+"%");
		else
			addParam("nome", "%");
		
		
		FastReportBuilder drb = new FastReportBuilder();
		drb.addColumn("Nome", "nome", String.class.getName(), 30)
			.addColumn("E-mail", "email", String.class.getName(), 30)
			
			.setQuery("select * from usuario where nome like $P{nome} order by nome", DJConstants.QUERY_LANGUAGE_SQL)
			
			.setTitle("Relação de Usuários")
			.setSubtitle("Relatório gerado em " + new Date())
			.setPrintBackgroundOnOddRows(true)
			.setUseFullPageWidth(true);		
		
		
		super.gerar(drb);
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
