package com.alexis.service;

import java.time.LocalDateTime;
import java.util.List;

import com.alexis.dto.ConsultaListaExamenDTO;
import com.alexis.dto.ConsultaResumenDTO;
import com.alexis.dto.FiltroConsultaDTO;
import com.alexis.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer>{
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto) throws Exception;
	
	List<Consulta> buscar(FiltroConsultaDTO filtro);
	
	List<Consulta> buscarFecha(LocalDateTime fecha);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
	
	
}
