package edu.fae.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import edu.fae.dao.PedidoDao;
import edu.fae.model.ItemCarrinho;
import edu.fae.model.ItemPedido;
import edu.fae.model.Pedido;
import edu.fae.util.VelocityParser;


@ViewScoped
@ManagedBean(name="pedidoFormController")
public class PedidoFormController extends AbstractFormController<Pedido, PedidoDao> {

	
	
	/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
	
	@PostConstruct
	public void iniciar() {
		super.iniciar();
		/*if (getModel().getValorTotal() == null) {
			getItensCarrinhoPedido();
			
		}*/
	}
	
	/*public void getItensCarrinhoPedido(){
		for (ItemCarrinho itemCarrinho : getCarrinhoSession().getItensCarrinho()) {
			ItemPedido novoItemPedido = new ItemPedido();
			novoItemPedido.setProduto(itemCarrinho.getProduto());
			novoItemPedido.setQuantidade(itemCarrinho.getQuantidade());
			novoItemPedido.setValor(itemCarrinho.getValor());
			novoItemPedido.setValorTotal(itemCarrinho.getValorTotal());
			novoItemPedido.setPedido(getModel());
			getModel().getItensPedido().add(novoItemPedido);
		}
		getModel().setValorTotal(getCarrinhoSession().getValorTotal());
	}
	 */		
	
	
	private ItemPedido itemParaRemover;
	
	public void adicionarItem() {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(getModel());
		
		getModel().getItensPedido().add(itemPedido);
	}
	
	public void removerItem() {
		if(itemParaRemover!=null) {
			getModel().getItensPedido().remove(itemParaRemover);
		}
	}


	
	/*#############################Getters e Setters############################## */	

	public ItemPedido getItemParaRemover() {
		return itemParaRemover;
	}
	
	public void setItemParaRemover(ItemPedido itemParaRemover) {
		this.itemParaRemover = itemParaRemover;
	}

	@Override
	public void salvar() {
		
		super.salvar();
		
		enviar();
		
		getSession().remove("carrinho");
	}

	public void enviar() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", getModel().getNomeCliente());
		params.put("email", getModel().getEmailCliente());
		params.put("itens", getModel().getItensPedido());
		params.put("totalPedido", getModel().getValorTotal());
		
		//Carrega o template indique_amigo_template.html substituindo as vari�veis
		String mensagem = VelocityParser.loadTemplate("/email_pedido_template.html", params);

		try {
			HtmlEmail emailSender = new HtmlEmail();

			// Setar o ip ou dns do servidor de e-mail
			emailSender.setHostName("smtp.gmail.com");

			emailSender.addTo(getModel().getEmailCliente());
			emailSender.setFrom("tenhardy@gmail.com");
			emailSender.setSubject("Confirma��o de Pedido");

			// Seta o texto da mensagem que veio do template
			emailSender.setMsg(mensagem);

			// Adicionando autentica��o no e-mail
			 emailSender.setAuthentication("tenhardy", "brad3127");
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
