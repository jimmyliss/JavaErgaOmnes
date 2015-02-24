package edu.fae.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.PedidoDao;
import edu.fae.model.Pedido;
import edu.fae.util.VelocityParser;

/**
 * 
 * @author JimmyLiss
 * 
 */
@RequestScoped
@ManagedBean(name = "emailPedidoController")
public class EmailPedidoController {
//	private PedidoDao pedidoDao = new DaoFactory().getPedidoDao();
	private Pedido pedido;
	
	String id = FacesContext.getCurrentInstance().getExternalContext()
			.getRequestParameterMap().get("id");

	/*public PedidoDao getPedidoDao() {
		return pedidoDao;
	}*/

	/*public void getPedido(){
		pedido = pedidoDao.findById(new Long(id));
	}*/
	

	public void enviar() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", pedido.getNomeCliente());
		params.put("email", pedido.getEmailCliente());
		params.put("itens", pedido.getItensPedido());
		params.put("totalPedido", pedido.getValorTotal());
		
		//Carrega o template indique_amigo_template.html substituindo as vari�veis
		String mensagem = VelocityParser.loadTemplate("/email_pedido_template.html", params);

		try {
			HtmlEmail emailSender = new HtmlEmail();

			// Setar o ip ou dns do servidor de e-mail
			emailSender.setHostName("smtp.gmail.com");

			emailSender.addTo(pedido.getNomeCliente());
			emailSender.setFrom(pedido.getEmailCliente());
			emailSender.setSubject("Confirmação de Pedido");

			// Seta o texto da mensagem que veio do template
			emailSender.setMsg(mensagem);

			// Adicionando autentica��o no e-mail
			 emailSender.setAuthentication("tenhardy", "senha");
			 emailSender.setSmtpPort(465);
			 emailSender.setSSL(true);
			 emailSender.setTLS(true);

			emailSender.send();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso!", null));
		} catch (EmailException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}

	}


}
