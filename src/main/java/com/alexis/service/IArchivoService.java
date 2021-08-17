package com.alexis.service;

import com.alexis.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
