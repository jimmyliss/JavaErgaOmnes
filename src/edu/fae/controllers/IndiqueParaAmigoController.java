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
import edu.fae.model.Imagem;
import edu.fae.model.Item;
import edu.fae.model.Produto;
import edu.fae.util.VelocityParser;

/**
 * 
 * @author Robson J. P.
 * 
 */
@RequestScoped
@ManagedBean(name = "indiqueParaAmigoController")
public class IndiqueParaAmigoController {
	private String nome;
	private String email;
	private String nomeAmigo;
	private String emailAmigo;
	private Produto produto;

	public void enviar() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", nome);
		params.put("email", email);
		params.put("nomeAmigo", nomeAmigo);
		params.put("emailAmigo", emailAmigo);


		params.put("produto", produto);


		params.put("emailAmigo", emailAmigo);

		//Carrega o template indique_amigo_template.html substituindo as vari�veis
		String mensagem = VelocityParser.loadTemplate("/indique_amigo_template.html", params);

		try {
			HtmlEmail emailSender = new HtmlEmail();

			// Setar o ip ou dns do servidor de e-mail
			emailSender.setHostName("smtp.gmail.com");
			emailSender.setAuthentication("tenhardy", "senha");
			emailSender.setSmtpPort(465);
			emailSender.setSSL(true);
			emailSender.setTLS(true);
			
			emailSender.addTo(emailAmigo);
			emailSender.setFrom(email);
			emailSender.setSubject("Indicacao de site");

			// Seta o texto da mensagem que veio do template
			emailSender.setMsg(mensagem);

			// Adicionando autentica��o no e-mail
			// email.setAuthentication("usuario", "senha");
			// email.setSmtpPort(465);
			// email.setSSL(true);
			// email.setTLS(true);

			emailSender.send();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso!", null));
		} catch (EmailException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getNomeAmigo() {
		return nomeAmigo;
	}

	public String getEmailAmigo() {
		return emailAmigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNomeAmigo(String nomeAmigo) {
		this.nomeAmigo = nomeAmigo;
	}

	public void setEmailAmigo(String emailAmigo) {
		this.emailAmigo = emailAmigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
