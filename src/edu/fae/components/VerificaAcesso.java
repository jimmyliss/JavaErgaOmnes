package edu.fae.components;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import edu.fae.model.Usuario;

/**
 * 
 * @author Robson J. P.
 *
 */
@FacesComponent(value = "verificaAcesso")
public class VerificaAcesso extends UIComponentBase {
	
	@Override
	public void encodeChildren(FacesContext arg0) throws IOException {
	}
	
	@Override
	public String getFamily() {
		return "verificaAcesso";
	}


	@Override
	public boolean getRendersChildren() {
		
		String pagina = (String) getAttributes().get("pagina");
		String acao = (String) getAttributes().get("acao");
		System.out.println("passou por aqui" + pagina);
		
		System.out.println("child");
		boolean mostrar = false;
		Usuario usuario = (Usuario) getSession().get("usuarioLogado");
		if(usuario!=null) {
			if(usuario.isTemAcesso(pagina, acao)) {
				mostrar = true;
			}
		}
		
		return !mostrar;
	}


	/**
	 * Retorna um map que representa as vari�veis guardadas
	 * a sess�o
	 */
	private Map<String, Object> getSession() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}	


}
