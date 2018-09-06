package com.asesoftware.pruebapiloto.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;


import com.asesoftware.pruebapiloto.negocio.NegocioReportesEJB;

@ViewScoped
@ManagedBean
public class ReporteMB {
	
	@EJB
	private NegocioReportesEJB negocioReporteEJB;;
	
	private BarChartModel barModel;
	private List<Object[]> listaReporte;
	
	@PostConstruct
	public void init() {
		crearBarModel();
	}
	
	
	
	public void crearBarModel() {
		barModel = new BarChartModel();
		
		ChartSeries serieProcedimientos = new ChartSeries();
		serieProcedimientos.setLabel("Procedimiento");
		
		listaReporte = new ArrayList<>();
		listaReporte  = negocioReporteEJB.reporteCitasPorProcedimiento();
		
		for (Object[] a: listaReporte) {
			System.out.println(" Procedimiento "+a[0]+" "+a[1]);
			serieProcedimientos.set(a[0], (Number) a[1]);
		}
		
		barModel.addSeries(serieProcedimientos);
	}



	public BarChartModel getBarModel() {
		return barModel;
	}



	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}



	public List<Object[]> getListaReporte() {
		return listaReporte;
	}



	public void setListaReporte(List<Object[]> listaReporte) {
		this.listaReporte = listaReporte;
	}
	
	

}
