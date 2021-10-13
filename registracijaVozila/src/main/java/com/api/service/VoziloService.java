package com.api.service;

import java.util.List;

import com.api.dto.VoziloDto;



public interface VoziloService {

	List<VoziloDto> sveVozila();

	VoziloDto createVozilo(VoziloDto vozilo);

	VoziloDto updateVozilo(Integer id, VoziloDto vozilo);

	void deleteVozilo(Integer id);

}