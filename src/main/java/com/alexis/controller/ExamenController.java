package com.alexis.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.alexis.model.Examen;
import com.alexis.service.IExamenService;

@RestController
@RequestMapping("/examenes") //endPoint
public class ExamenController {
	
	@Autowired
	private IExamenService service;
	
	
	/*
	 * ResponseEntity permite controlar
	 * las peticiones http
	 */
	@GetMapping
	public ResponseEntity<List<Examen>>  listar()throws Exception{
		return new ResponseEntity<>( service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Examen> listarPorId(@PathVariable("id") Integer id)throws Exception{
		Examen obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Examen> listarHateoasPorId(@PathVariable("id") Integer id)throws Exception{
		Examen obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		EntityModel<Examen> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarHateoasPorId(id));
		recurso.add(link1.withRel("medico-recurso"));
		return recurso;
	}
	
	
	@PostMapping
	public  ResponseEntity<Examen> registrar(@Valid @RequestBody Examen e)throws Exception{
		//return new ResponseEntity<>(service.registrar(medico),HttpStatus.CREATED);//status 201
		Examen obj  = service.registrar(e);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExamen()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Examen> modificar(@Valid @RequestBody Examen examen) throws Exception{
		return new ResponseEntity<>(service.modificar(examen),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
		 service.eliminar(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
