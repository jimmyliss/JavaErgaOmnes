package edu.fae.controllers.reports;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ar.com.fdvs.dj.domain.builders.FastReportBuilder;

/**
 * Armazena as informações do relatório a ser gerado
 * 
 * @author Robson J. P.
 *
 */
public class ReportRequest implements Serializable {
	private String reportName;
	private Map<String, Object> params = new HashMap<String, Object>();
	private FastReportBuilder drb;
	
	public ReportRequest() {
	}
	
	public ReportRequest(String reportName) {
		this.reportName = reportName;
	}
	
	public void addParam(String name, Object value) {
		params.put(name, value);
	}
	
	public String getReportName() {
		return reportName;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public FastReportBuilder getDrb() {
		return drb;
	}

	public void setDrb(FastReportBuilder drb) {
		this.drb = drb;
	}
	
}
