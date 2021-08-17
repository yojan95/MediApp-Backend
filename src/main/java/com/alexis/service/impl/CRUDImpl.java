package com.alexis.service.impl;

import java.util.List;

import com.alexis.repo.IGenericRepo;
import com.alexis.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo<T, ID> getRepo();
	
	
	@Override
	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
	
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	
	public T listarPorId(ID id) throws Exception {	
		return getRepo().findById(id).orElse(null);
	}


	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
		
	}

}
