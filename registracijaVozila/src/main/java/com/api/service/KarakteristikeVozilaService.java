package com.api.service;

import java.util.List;

import com.api.dto.KarakteristikeVozilaDto;

public interface KarakteristikeVozilaService {

	List<KarakteristikeVozilaDto> sveKarakteristikeVozila();

	KarakteristikeVozilaDto createKarakteristikeVozila(KarakteristikeVozilaDto karakteristikeVozila);

	KarakteristikeVozilaDto updateKarakteristikeVozila(Integer id, KarakteristikeVozilaDto karakteristikeVozila);

	void deleteKarakteristikeVozila(Integer id);

}
