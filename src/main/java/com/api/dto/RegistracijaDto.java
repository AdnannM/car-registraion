package com.api.dto;

import java.sql.Date;

public class RegistracijaDto {

	private Integer id;
	private Date trajanjeRegistracijeOd;
	private Date trajanjeRegistracijeDo;
	private Boolean isteklaRegistracija;
	
	VoziloDto voziloDto;
	
	
	public void setVoziloDto(VoziloDto voziloDto) {
		this.voziloDto = voziloDto;
	}
	
	public VoziloDto getVoziloDto() {
		return voziloDto;
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
}
