package com.alexis.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.alexis.model.Medico;
import com.alexis.service.IMedicoService;

@RestController
@RequestMapping("/medico") //endPoint
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	
	/*
	 * ResponseEntity permite controlar
	 * las peticiones http
	 */
	@PreAuthorize("@authServiceImpl.tieneAcceso('')")
	@GetMapping
	public ResponseEntity<List<Medico>>  listar()throws Exception{
		return new ResponseEntity<>( service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id)throws Exception{
		Medico obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Medico> listarHateoasPorId(@PathVariable("id") Integer id)throws Exception{
		Medico obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID No encontrado"+id);
		}
		EntityModel<Medico> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarHateoasPorId(id));
		recurso.add(link1.withRel("medico-recurso"));
		return recurso;
	}
	
	
	@PostMapping
	public  ResponseEntity<Medico> registrar(@Valid @RequestBody Medico m)throws Exception{
		//return new ResponseEntity<>(service.registrar(medico),HttpStatus.CREATED);//status 201
		Medico obj  = service.registrar(m);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico medico) throws Exception{
		return new ResponseEntity<>(service.modificar(medico),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
		 service.eliminar(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
