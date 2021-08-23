package com.alexis.repo;



import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.alexis.model.Paciente;

public interface IPacienteRepo extends IGenericRepo<Paciente, Integer>{
	
	
	@Query(value = "select p.id_paciente from paciente p where p.dni = :dni", nativeQuery = true)
	Object buscarDni(String dni);
	
}
