package com.api.registracijaVozila.dao;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "vozilo")
public class VoziloDao {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Integer Id;
	
	@Column(name = "registracijskaOznaka")
	private String registracijskaOznaka;
	
	public VoziloDao() {
		
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getRegistracijskaOznaka() {
		return registracijskaOznaka;
	}

	public void setRegistracijskaOznaka(String registracijskaOznaka) {
		this.registracijskaOznaka = registracijskaOznaka;
	}

	@Override
	public String toString() {
		return "VoziloDao [Id=" + Id + ", registracijskaOznaka=" + registracijskaOznaka + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, registracijskaOznaka);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoziloDao other = (VoziloDao) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(registracijskaOznaka, other.registracijskaOznaka);
	}
}
