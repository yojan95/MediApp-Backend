package com.alexis.service;

import java.util.List;

import com.alexis.model.ConsultaExamen;

public interface IConsultaExamenService {
	
	List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta);

}
