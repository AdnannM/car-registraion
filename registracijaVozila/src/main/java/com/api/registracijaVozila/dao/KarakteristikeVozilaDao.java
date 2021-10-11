package com.api.registracijaVozila.dao;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "karakteristikeVozila")
public class KarakteristikeVozilaDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "brojSasije",
			unique = true)
	private Integer brojSasije;
	
	@Column(name = "boja")
	private String boja;
	
	@Column(name = "tipVozila")
	private String tipVozila;
	
	@Column(name = "snagaMotora")
	private Integer snagaMotora;
	
	public KarakteristikeVozilaDao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrojSasije() {
		return brojSasije;
	}

	public void setBrojSasije(Integer brojSasije) {
		this.brojSasije = brojSasije;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(String tipVozila) {
		this.tipVozila = tipVozila;
	}

	public Integer getSnagaMotora() {
		return snagaMotora;
	}

	public void setSnagaMotora(Integer snagaMotora) {
		this.snagaMotora = snagaMotora;
	}

	@Override
	public String toString() {
		return "KarakteristikeVozilaDao [id=" + id + ", brojSasije=" + brojSasije + ", boja=" + boja + ", tipVozila="
				+ tipVozila + ", snagaMotora=" + snagaMotora + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boja, brojSasije, id, snagaMotora, tipVozila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KarakteristikeVozilaDao other = (KarakteristikeVozilaDao) obj;
		return Objects.equals(boja, other.boja) && Objects.equals(brojSasije, other.brojSasije)
				&& Objects.equals(id, other.id) && Objects.equals(snagaMotora, other.snagaMotora)
				&& Objects.equals(tipVozila, other.tipVozila);
	}	
}
