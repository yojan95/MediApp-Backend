package com.alexis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.model.ConsultaExamen;
import com.alexis.repo.IConsultaExamenRepo;
import com.alexis.service.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService{
	
	@Autowired
	private IConsultaExamenRepo repo;

	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta) {
		
		return repo.listarExamenesPorConsulta(idConsulta);
	}

}
