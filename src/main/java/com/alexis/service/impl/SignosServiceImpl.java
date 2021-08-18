package com.alexis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexis.model.Signos;
import com.alexis.repo.IGenericRepo;
import com.alexis.repo.ISignosRepo;
import com.alexis.service.ISignosService;

public class SignosServiceImpl  extends CRUDImpl<Signos, Integer> implements ISignosService{
	
	@Autowired
	private ISignosRepo repo;

	@Override
	protected IGenericRepo<Signos, Integer> getRepo() {
		return repo;
	}

}
