package edu.fae.controllers.reports;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

@ViewScoped
@ManagedBean(name="pedidoClienteReportController")
public class PedidoClienteReportController extends AbstractReportController {
	private String nomeCliente;
	
	
	public void gerar() {
		
		if(StringUtils.isNotEmpty(nomeCliente))
			addParam("nome_cliente", "%"+nomeCliente+"%");
		else
			addParam("nome_cliente", "%");
		
		super.gerar("relatorio_pedido.jasper");
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	
}
