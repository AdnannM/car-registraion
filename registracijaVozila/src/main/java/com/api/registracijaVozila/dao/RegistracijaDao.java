package com.api.registracijaVozila.dao;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registracija")
public class RegistracijaDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "trajanjeRegistracijeOd")
	private Date trajanjeRegistracijeOd;
	
	@Column(name = "trajanjeRegistracijeDo")
	private Date trajanjeRegistracijeDo;
	
	@Column(name = "isteklaRegistracija")
	private Boolean isteklaRegistracija;
	
	public RegistracijaDao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTrajanjeRegistracijeOd() {
		return trajanjeRegistracijeOd;
	}

	public void setTrajanjeRegistracijeOd(Date trajanjeRegistracijeOd) {
		this.trajanjeRegistracijeOd = trajanjeRegistracijeOd;
	}

	public Date getTrajanjeRegistracijeDo() {
		return trajanjeRegistracijeDo;
	}

	public void setTrajanjeRegistracijeDo(Date trajanjeRegistracijeDo) {
		this.trajanjeRegistracijeDo = trajanjeRegistracijeDo;
	}

	public Boolean getIsteklaRegistracija() {
		return isteklaRegistracija;
	}

	public void setIsteklaRegistracija(Boolean isteklaRegistracija) {
		this.isteklaRegistracija = isteklaRegistracija;
	}

	@Override
	public String toString() {
		return "RegistracijaDao [id=" + id + ", trajanjeRegistracijeOd=" + trajanjeRegistracijeOd
				+ ", trajanjeRegistracijeDo=" + trajanjeRegistracijeDo + ", isteklaRegistracija=" + isteklaRegistracija
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isteklaRegistracija, trajanjeRegistracijeDo, trajanjeRegistracijeOd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistracijaDao other = (RegistracijaDao) obj;
		return Objects.equals(id, other.id) && Objects.equals(isteklaRegistracija, other.isteklaRegistracija)
				&& Objects.equals(trajanjeRegistracijeDo, other.trajanjeRegistracijeDo)
				&& Objects.equals(trajanjeRegistracijeOd, other.trajanjeRegistracijeOd);
	}
	
	
	
}
