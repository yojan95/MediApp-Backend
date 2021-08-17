package com.alexis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.model.Especialidad;
import com.alexis.model.Examen;
import com.alexis.repo.IGenericRepo;
import com.alexis.repo.IEspecialidadRepo;
import com.alexis.repo.IExamenRepo;
import com.alexis.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad, Integer> implements IEspecialidadService{
	
	@Autowired
	private IEspecialidadRepo repo;

	@Override
	protected IGenericRepo<Especialidad, Integer> getRepo() {
		
		return repo;
	}

}
