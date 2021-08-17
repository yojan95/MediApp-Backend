package com.alexis.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.alexis.exception.ModeloNotFoundException;
import com.alexis.model.Paciente;
import com.alexis.service.IPacienteService;

@RestController
@RequestMapping("/pacientes") //endPoint
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	
	/*
	 * ResponseEntity permite controlar
	 * las peticiones http
	 */
	@GetMapping
	public ResponseEntity<List<Paciente>>  listar()throws Exception{
		return new ResponseEntity<>( service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id)throws Exception{
		Paciente obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Paciente> listarHateoasPorId(@PathVariable("id") Integer id)throws Exception{
		Paciente obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		EntityModel<Paciente> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarHateoasPorId(id));
		recurso.add(link1.withRel("paciente-recurso"));
		return recurso;
	}
	
	
	@PostMapping
	public  ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente p)throws Exception{
		//return new ResponseEntity<>(service.registrar(paciente),HttpStatus.CREATED);//status 201
		Paciente obj  = service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) throws Exception{
		return new ResponseEntity<>(service.modificar(paciente),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
		 service.eliminar(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	//http://localhost:8080/pacientes/pageable?page=0&size=10&sort=apellidos
	@GetMapping("/pageable")
	public ResponseEntity<Page<Paciente>> listarPageable(Pageable pageable)throws Exception{
		Page<Paciente> pacientes = service.listarPageable(pageable);
		return new ResponseEntity<Page<Paciente>>(pacientes, HttpStatus.OK);
	}

}
