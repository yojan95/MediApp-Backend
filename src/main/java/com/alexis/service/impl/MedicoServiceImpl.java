package com.alexis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.model.Medico;
import com.alexis.repo.IGenericRepo;
import com.alexis.repo.IMedicoRepo;
import com.alexis.service.IMedicoService;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer> implements IMedicoService{
	
	@Autowired
	private IMedicoRepo repo;

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		
		return repo;
	}

}
