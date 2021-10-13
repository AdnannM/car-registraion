package com.api.registracijaVozila.service;

import java.util.List;

import com.api.registracijaVozila.dao.VoziloDao;
import com.api.registracijaVozila.dto.VoziloDto;
import com.api.registracijaVozila.response.MessageResponse;

public interface VoziloService {

	List<VoziloDao> sveVozila();

	MessageResponse createVozilo(VoziloDto vozilo);

	MessageResponse updateVozilo(Integer id, VoziloDao vozilo);

	void deleteVozilo(Integer id);

}
