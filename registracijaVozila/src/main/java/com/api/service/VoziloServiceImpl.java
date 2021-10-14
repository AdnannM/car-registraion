package com.api.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.RegistrovanoNaOsobuDao;
import com.api.dao.VoziloDao;
import com.api.dto.RegistrovanoNaOsobuDto;
import com.api.dto.VoziloDto;
import com.api.repository.RegistrovanoNaOsobuRepository;
import com.api.repository.VoziloRepository;


@Service
public class VoziloServiceImpl implements VoziloService {

	@Autowired
	VoziloRepository voziloRepositroy;

	@Autowired
	RegistrovanoNaOsobuRepository registrovanoNaOsobuRepository;
	
	@Override
	public List<VoziloDto> sveVozila() {
		
		List<VoziloDao> empListDb = voziloRepositroy.findAll();
		List<VoziloDto> resultList = new ArrayList<VoziloDto>();
		
		if (empListDb.isEmpty()) {
			return resultList;
		}
		
		for (VoziloDao voziloDao : empListDb) {
			VoziloDto novoVoziloDto = new VoziloDto();
			novoVoziloDto.setId(voziloDao.getId());
			novoVoziloDto.setRegistracijskaOznaka(voziloDao.getRegistracijskaOznaka());
			
			
			if(voziloDao.getRegistrovano()!= null) {
				  RegistrovanoNaOsobuDto dtoRegistrovano = new RegistrovanoNaOsobuDto();
				  dtoRegistrovano.setId(voziloDao.getRegistrovano().getId());
				  dtoRegistrovano.setIme(voziloDao.getRegistrovano().getIme());
				  dtoRegistrovano.setPrezime(voziloDao.getRegistrovano().getPrezime());
				  dtoRegistrovano.setGrad(voziloDao.getRegistrovano().getPrezime());
				  dtoRegistrovano.setJmbg(voziloDao.getRegistrovano().getJmbg());
				  dtoRegistrovano.setDatumRodjenja(voziloDao.getRegistrovano().getDatumRodjenja());
				  novoVoziloDto.setRegistrovanoNaOsobuDto(dtoRegistrovano);
			}
			
			resultList.add(novoVoziloDto);
		}
		
		return resultList;
	}

	@Override
	public VoziloDto createVozilo(VoziloDto vozilo) {
		
		VoziloDao novoVozilo = new VoziloDao();
		novoVozilo.setRegistracijskaOznaka(vozilo.getRegistracijskaOznaka());
		
		RegistrovanoNaOsobuDto regNaOsobuDto = vozilo.getRegistrovanoNaOsobuDto();
		
		Optional<RegistrovanoNaOsobuDao> regNaOsobuResult = Optional.of(registrovanoNaOsobuRepository.findById(regNaOsobuDto.getId()))
				.orElseThrow(() -> new IllegalStateException("Register Person with id " + regNaOsobuDto + "does not exist"));
		
		novoVozilo.setRegistrovano(regNaOsobuResult.get());
		
		VoziloDao spremiVozilo = voziloRepositroy.save(novoVozilo);
		
		VoziloDto voziloDto = createVozilo(spremiVozilo);
		
		if(spremiVozilo.getRegistrovano() != null) {
			RegistrovanoNaOsobuDto registovanoNaOsobuDto = new RegistrovanoNaOsobuDto();
			regNaOsobuDto.setId(vozilo.getRegistrovanoNaOsobuDto().getId());
			regNaOsobuDto.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
			regNaOsobuDto.setPrezime(vozilo.getRegistrovanoNaOsobuDto().getPrezime());
			regNaOsobuDto.setGrad(vozilo.getRegistrovanoNaOsobuDto().getGrad());
			regNaOsobuDto.setJmbg(vozilo.getRegistrovanoNaOsobuDto().getJmbg());
			regNaOsobuDto.setDatumRodjenja(vozilo.getRegistrovanoNaOsobuDto().getDatumRodjenja());
			
			voziloDto.setRegistrovanoNaOsobuDto(registovanoNaOsobuDto);
		}
		
		
		return voziloDto;
	}
	
	/*
	 * - MARK: 
	 * 	- CreateVozilo
	 */
	private VoziloDto createVozilo(VoziloDao spremiVozilo) {
		VoziloDto voziloDto = new VoziloDto();
		voziloDto.setId(spremiVozilo.getId());
		voziloDto.setRegistracijskaOznaka(spremiVozilo.getRegistracijskaOznaka());
		
		return voziloDto;
	}

	@Override
	public VoziloDto updateVozilo(Integer id, VoziloDto vozilo) {
		Optional<VoziloDao> vozilaIzBazeResult = Optional.of(voziloRepositroy.findById(id))
				.orElseThrow(() -> new IllegalStateException("Vozilo with id " + id + "does not exist"));
		
		VoziloDao voziloIzBaze = vozilaIzBazeResult.get();
		voziloIzBaze.setId(vozilo.getId());
		voziloIzBaze.setRegistracijskaOznaka(vozilo.getRegistracijskaOznaka());
		
		// RegistrovanoNaOsobu update
		
		VoziloDao spremiVozilo = voziloRepositroy.save(voziloIzBaze);
		
		VoziloDto voziloDto = createVozilo(spremiVozilo);
		
		return voziloDto;
	}

	@Override
	public void deleteVozilo(Integer id) {
		if (voziloRepositroy.getById(id).getId().equals(id)) {
			boolean exist = voziloRepositroy.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Vozilo with id " + id + "does not exist");
			}
			
			voziloRepositroy.deleteById(id);
		}
		
		if(registrovanoNaOsobuRepository.getById(id) != null) {
			boolean exist = registrovanoNaOsobuRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Register Person with id  " + id + "does not Exist");
			}
		}
	}
}
