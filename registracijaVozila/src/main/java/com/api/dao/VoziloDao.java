package com.api.dao;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "vozilo")
public class VoziloDao {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "registracijskaOznaka")
	private String registracijskaOznaka;
	
	@OneToOne
    @JoinColumn(name = "registrovanoId", referencedColumnName = "id")
	private RegistrovanoNaOsobuDao registrovano; 
	

	public VoziloDao() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRegistracijskaOznaka() {
		return registracijskaOznaka;
	}


	public void setRegistracijskaOznaka(String registracijskaOznaka) {
		this.registracijskaOznaka = registracijskaOznaka;
	}


	public RegistrovanoNaOsobuDao getRegistrovano() {
		return registrovano;
	}


	public void setRegistrovano(RegistrovanoNaOsobuDao registrovano) {
		this.registrovano = registrovano;
	}


	@Override
	public String toString() {
		return "VoziloDao [id=" + id + ", registracijskaOznaka=" + registracijskaOznaka + ", registrovano="
				+ registrovano + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, registracijskaOznaka, registrovano);
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
		return Objects.equals(id, other.id) && Objects.equals(registracijskaOznaka, other.registracijskaOznaka)
				&& Objects.equals(registrovano, other.registrovano);
	}
	
	

}