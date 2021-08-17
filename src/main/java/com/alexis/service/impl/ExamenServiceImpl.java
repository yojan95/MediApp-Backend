package com.alexis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.model.Examen;
import com.alexis.repo.IGenericRepo;
import com.alexis.repo.IExamenRepo;
import com.alexis.service.IExamenService;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService{
	
	@Autowired
	private IExamenRepo repo;

	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		
		return repo;
	}

}
