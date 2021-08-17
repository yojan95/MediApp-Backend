package com.alexis.repo;

import com.alexis.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//from usuario where username = ?
	Usuario findOneByUsername(String username);	
}
