package edu.fae.controllers.reports;

import javax.faces.context.FacesContext;

import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

import edu.fae.controllers.AbstractController;

/**
 * 
 * @author Robson J. P.
 *
 */
public class AbstractReportController extends AbstractController {

	protected ReportRequest reportRequest = new ReportRequest();
	private String reportSessionId;
	private String reportURL = "about:blank";
	
	public void gerar(String reportName) {
		reportRequest.setReportName(reportName);
		reportSessionId = String.valueOf(Math.random());
		getSession().put("report_"+reportSessionId, reportRequest);
		String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		reportURL = path + "/report?reportSessionId=" + reportSessionId;
	}
	
	public void gerar(FastReportBuilder drb){
		reportRequest.setDrb(drb);
		reportSessionId = String.valueOf(Math.random());
		getSession().put("report_"+reportSessionId, reportRequest);
		String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		reportURL = path + "/dynamicReport?reportSessionId=" + reportSessionId;
		
	}
	
	public void addParam(String name, Object value) {
		reportRequest.addParam(name, value);
	}
	
	public String getReportURL() {
		return reportURL;
	}
		
}
