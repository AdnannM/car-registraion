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
	
	@Column(name = "proizdvodjac")
	private String proizdvodjac;
	
	// Add Karakteristike Vozila
	
	@OneToOne
    @JoinColumn(name = "karakteristikeVozilaId", referencedColumnName = "id")
	private KarakteristikeVozilaDao karakteristikeVozilaDao;
	
	
	
	public KarakteristikeVozilaDao getKarakteristikeVozilaDao() {
		return karakteristikeVozilaDao;
	}

	public void setKarakteristikeVozilaDao(KarakteristikeVozilaDao karakteristikeVozilaDao) {
		this.karakteristikeVozilaDao = karakteristikeVozilaDao;
	}

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

	public String getProizdvodjac() {
		return proizdvodjac;
	}

	public void setProizdvodjac(String proizdvodjac) {
		this.proizdvodjac = proizdvodjac;
	}

	@Override
	public String toString() {
		return "ModelVozilaDao [id=" + id + ", model=" + model + ", godina=" + godina + ", proizdvodjac=" + proizdvodjac
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(godina, id, model, proizdvodjac);
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
				&& Objects.equals(model, other.model) && Objects.equals(proizdvodjac, other.proizdvodjac);
	}
}