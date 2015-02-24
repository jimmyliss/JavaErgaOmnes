package edu.fae.controllers.reports;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="usuarioReportController")
public class UsuarioReportController extends AbstractReportController {
	public void gerar() {
		super.gerar("usuarios.jasper");
	}
}
