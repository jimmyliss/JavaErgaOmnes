package edu.fae.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

import edu.fae.model.Usuario;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(precisaLogin((HttpServletRequest) request)) {
			
			//Verifica se est� logado
			HttpSession session = ((HttpServletRequest) request).getSession();
			
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			if(usuario==null) {
				//N�o processa a p�gina e faz o redirect para o login.jsf
				((HttpServletResponse) response).sendRedirect("../login.jsf");	
			}else{
				
				
				//Pega a p�gina que est� sendo acessada
				String paginaAcessada = ((HttpServletRequest)request).getRequestURI();
				String contextPath = ((HttpServletRequest) request).getContextPath();
				if(!contextPath.endsWith("/")) {
					contextPath = contextPath + "/admin/";
				}
				paginaAcessada = paginaAcessada.substring(contextPath.length());
				
				
				if (usuario.isTemAcesso(paginaAcessada) || paginaAcessada.equals("")) {
				
					//Faz o processamento da p�gina
					chain.doFilter(request, response);
				} else {
					
//					response.getWriter().println("Acesso negado");
					((HttpServletResponse) response).sendRedirect("../acessonegado.jsf");
					
				}

				//Verifica se o usu�rio tem acesso � p�gina
				System.out.println("O usuario " + usuario.getNome() + " tem acesso à página " + paginaAcessada + "?: " + usuario.isTemAcesso(paginaAcessada));
				
				/*				
				//Faz o processamento da p�gina
				chain.doFilter(request, response);*/
			}
			
		}else{
			
			//Faz o processamento da p�gina
			chain.doFilter(request, response);	
		}
		
	}

	
	
	
	private boolean precisaLogin(HttpServletRequest request) {
		String paginaAcessada = request.getRequestURI();
		
		String contextPath = ((HttpServletRequest) request).getContextPath();
		if(!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
			
		}
		
		if(paginaAcessada.startsWith(contextPath+"javax.faces.resource/")) {
			//Nao Precisa de login
			return false;
		}
		
		if(paginaAcessada.equals(contextPath+"login.jsf")) {
			//Nao Precisa de login
			return false;
		}
		
		//Precisa de login
		return true;
	}
	
	public void init(FilterConfig config) throws ServletException {
	}

}
