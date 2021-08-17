package com.alexis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Paciente Model")
@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementable
	private Integer idPaciente;
	
	@Schema(description = "nombre del paciente")
	@Size(min = 3, message = "{nombres.size}")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@Schema(description = "apellidos del paciente")
	@Size(min = 3, message = "{apellidos.size}")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Size(min = 3, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;
	
	@Size(min = 3,max = 150, message = "Apellidos debe ser minimo 3")
	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;
	
	@Size(min = 9,max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@Email(message = "Email formato incorrecto")
	@Column(name = "email", nullable = false, length = 55)
	private String email;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
