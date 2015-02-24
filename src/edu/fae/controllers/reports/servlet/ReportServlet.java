package edu.fae.controllers.reports.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.lang.StringUtils;

import edu.fae.controllers.reports.ReportRequest;
import edu.fae.dao.hibernate.HibernateUtil;

/**
 * Servlet que gera os relat�rios em PDF
 * @author Robson J. P.
 *
 */
public class ReportServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reportSessionId = request.getParameter("reportSessionId");
		if(StringUtils.isNotEmpty(reportSessionId)) {
			//Procura o objeto reportRequest enviado pelo controller JSF
			ReportRequest reportRequest = (ReportRequest) request.getSession().getAttribute("report_"+reportSessionId);
			if(reportRequest!=null) {

				//Seta o tipo de retorno para PDF
				response.setContentType("application/pdf");
				
				
				//Pega o caminho completo do relat�rio no servidor
				String caminhoRelatorio = request.getSession().getServletContext().getRealPath("/WEB-INF/relatorios/"+reportRequest.getReportName());
				
				try {
					//Chama o Jasper para rodar o relat�rio e gerar o PDF
					JasperPrint print = JasperFillManager.fillReport(caminhoRelatorio, reportRequest.getParams(), HibernateUtil.getSession().connection());
					JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());

				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
		}
	}
	
}
