package com.alexis.service;

import com.alexis.model.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario);
	void cambiarClave(String clave, String nombre);
}
