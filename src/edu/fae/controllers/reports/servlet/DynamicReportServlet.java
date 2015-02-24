package edu.fae.controllers.reports.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.commons.lang.StringUtils;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import edu.fae.controllers.reports.ReportRequest;
import edu.fae.dao.hibernate.HibernateUtil;

/**
 * Servlet que gera os relat�rios em PDF
 * 
 * @author Robson J. P.
 * 
 */
public class DynamicReportServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			String reportSessionId = request.getParameter("reportSessionId");
			if (StringUtils.isNotEmpty(reportSessionId)) {
				// Procura o objeto reportRequest enviado pelo controller JSF
				ReportRequest reportRequest = (ReportRequest) request.getSession().getAttribute("report_" + reportSessionId);
				if (reportRequest != null) {

					// Seta o tipo de retorno para PDF
					response.setContentType("application/pdf");

					FastReportBuilder drb = reportRequest.getDrb();

					DynamicReport dr = drb.build();

					
					Map<String, Object> params = reportRequest.getParams();

					
					JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
					

					JasperPrint print = JasperFillManager.fillReport(jr,
							params, HibernateUtil.getSession().connection());
					JasperExportManager.exportReportToPdfStream(print,
							response.getOutputStream());
				}
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
