package com.alexis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alexis.model.Paciente;
import com.alexis.repo.IGenericRepo;
import com.alexis.repo.IPacienteRepo;
import com.alexis.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService{
	
	@Autowired
	private IPacienteRepo repo;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public Page<Paciente> listarPageable(Pageable page) {
		
		return repo.findAll(page);
	}

	@Override
	public String buscarDni(String dni) {
		Object obj = (Object) new Object();
		obj = repo.buscarDni(dni);
		String dnis = String.valueOf(obj);
		return dnis;
		
	}

}
