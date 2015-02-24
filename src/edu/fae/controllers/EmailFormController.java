package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@RequestScoped
@ManagedBean(name = "emailFormController")
public class EmailFormController {
	private String de;
	private String para;
	private String assunto;
	private String mensagem;

	public void enviar() {
		try {
			HtmlEmail email = new HtmlEmail();
			
			//Setar o ip ou dns do servidor de e-mail
			email.setHostName("smtp.gmail.com");
			
			email.addTo(para);
			email.setFrom(de); 
			email.setSubject(assunto); 
			email.setMsg(mensagem); 
	
//			Adicionando autentica��o no e-mail
			email.setAuthentication("tenhardy@gmail.com", "senha");
			email.setSmtpPort(465);
			email.setSSL(true);
			email.setTLS(true);
			
			email.send();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso!", null));
		} catch (EmailException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public String getDe() {
		return de;
	}

	public String getPara() {
		return para;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
