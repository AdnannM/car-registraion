package com.api.dto;

public class KarakteristikeVozilaDto {
	
	private Integer id;
	private Integer brojSasije;
	private String boja;
	private String tipVozila;
	private Integer SnagaMotora;
	
	
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
		return SnagaMotora;
	}
	public void setSnagaMotora(Integer snagaMotora) {
		SnagaMotora = snagaMotora;
	}
}
