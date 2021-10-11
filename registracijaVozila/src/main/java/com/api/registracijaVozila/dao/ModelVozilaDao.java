package com.api.registracijaVozila.dao;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelVozila")
public class ModelVozilaDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "godina")
	private Integer godina;
	
	// Add Karakteristike Vozila
	
	public ModelVozilaDao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	@Override
	public String toString() {
		return "ModelVozilaDao [id=" + id + ", model=" + model + ", godina=" + godina + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(godina, id, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelVozilaDao other = (ModelVozilaDao) obj;
		return Objects.equals(godina, other.godina) && Objects.equals(id, other.id)
				&& Objects.equals(model, other.model);
	}
}
