package com.alexis.service;

import java.util.List;



//INTERFAZ GENERICA
public interface ICRUD <T,ID>{
	

	T registrar(T t) throws Exception;
	
	T modificar(T t) throws Exception;
	
	List<T> listar() throws Exception;
	
	T listarPorId(Integer ID)throws Exception;
	
	void eliminar(Integer ID)throws Exception;

}
