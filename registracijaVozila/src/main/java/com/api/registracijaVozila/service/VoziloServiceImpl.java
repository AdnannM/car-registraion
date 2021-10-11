package com.api.registracijaVozila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.registracijaVozila.dao.VoziloDao;
import com.api.registracijaVozila.dto.VoziloDto;
import com.api.registracijaVozila.repository.VoziloRepository;
import com.api.registracijaVozila.response.MessageResponse;

@Service
public class VoziloServiceImpl implements VoziloService {

	@Autowired
	VoziloRepository voziloRepositroy;

	@Override
	public List<VoziloDao> sveVozila() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse createVozilo(VoziloDto vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageResponse updateVozilo(Integer id, VoziloDao vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVozilo(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
