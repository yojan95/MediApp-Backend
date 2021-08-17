package com.alexis.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.alexis.model.Consulta;
import com.alexis.model.Examen;

public class ConsultaListaExamenDTO {
	
	@NotNull
	private Consulta consulta;
	
	@NotNull
	private List<Examen> listExamen;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getListExamen() {
		return listExamen;
	}

	public void setListExamen(List<Examen> listExamen) {
		this.listExamen = listExamen;
	}
	
	
	
}
