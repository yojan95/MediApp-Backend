package com.alexis.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexis.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente, Integer>{
	
	Page<Paciente> listarPageable(Pageable page);
	
	String buscarDni(String dni);

}
