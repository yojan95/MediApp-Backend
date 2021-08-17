package com.alexis.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signos")
public class Signos {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSignos")
	private Integer idSignos;
	

	@Column(name = "temperatura", length = 50)
	private String temperatura;

	@Column(name = "pulso", length = 50)
	private String pulso;
	

	@Column(name = "ritmo", length = 50)
	private String ritmo;
	

	@Column(name = "fecha",nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_paciente", nullable = false,  foreignKey = @ForeignKey(name = "FK_signos_paciente"))
	private Paciente paciente;


	public Integer getIdSignos() {
		return idSignos;
	}


	public void setIdSignos(Integer idSignos) {
		this.idSignos = idSignos;
	}


	public String getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}


	public String getPulso() {
		return pulso;
	}


	public void setPulso(String pulso) {
		this.pulso = pulso;
	}


	public String getRitmo() {
		return ritmo;
	}


	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSignos == null) ? 0 : idSignos.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Signos other = (Signos) obj;
		if (idSignos == null) {
			if (other.idSignos != null)
				return false;
		} else if (!idSignos.equals(other.idSignos))
			return false;
		return true;
	}
	
	


}
