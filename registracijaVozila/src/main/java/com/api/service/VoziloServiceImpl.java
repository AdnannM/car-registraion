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
	/*
	 * - MARK: - GET
	 */
	public List<VoziloDto> sveVozila() {
		
		List<VoziloDao> empListDb = voziloRepositroy.findAll();
		List<VoziloDto> resultList = new ArrayList<VoziloDto>();
		
		if (empListDb.isEmpty()) {
			return resultList;
		}
		
		getAllFromList(empListDb, resultList);
		
		return resultList;
	}


	private void getAllFromList(List<VoziloDao> empListDb, List<VoziloDto> resultList) {
		for (VoziloDao voziloDao : empListDb) {
			VoziloDto novoVoziloDto = new VoziloDto();
			novoVoziloDto.setId(voziloDao.getId());
			novoVoziloDto.setRegistracijskaOznaka(voziloDao.getRegistracijskaOznaka());
			
			
			if(voziloDao.getRegistrovano()!= null) {
				  RegistrovanoNaOsobuDto dtoRegistrovano = new RegistrovanoNaOsobuDto();
				  dtoRegistrovano.setId(voziloDao.getRegistrovano().getId());
				  dtoRegistrovano.setIme(voziloDao.getRegistrovano().getIme());
				  dtoRegistrovano.setPrezime(voziloDao.getRegistrovano().getPrezime());
				  dtoRegistrovano.setGrad(voziloDao.getRegistrovano().getGrad());
				  dtoRegistrovano.setJmbg(voziloDao.getRegistrovano().getJmbg());
				  dtoRegistrovano.setDatumRodjenja(voziloDao.getRegistrovano().getDatumRodjenja());
				  novoVoziloDto.setRegistrovanoNaOsobuDto(dtoRegistrovano);
			}
			
			resultList.add(novoVoziloDto);
		}
	}
	

	@Override
	/*
	 * - MARK: - POST
	 */
	public VoziloDto createVozilo(VoziloDto vozilo) {
		
		//upis
		VoziloDao novoVozilo = new VoziloDao();
		novoVozilo.setRegistracijskaOznaka(vozilo.getRegistracijskaOznaka());
		
		upisNapravljenihVozila(vozilo, novoVozilo);
		
		VoziloDao spremiVozilo = voziloRepositroy.save(novoVozilo);
		
		//ispis
		VoziloDto voziloDto = createVozilo(spremiVozilo);
		
		registrujNovuOsobu(spremiVozilo, voziloDto);
		
		
		return voziloDto;
	}


	private void upisNapravljenihVozila(VoziloDto vozilo, VoziloDao novoVozilo) {
		RegistrovanoNaOsobuDto regNaOsobuDto = vozilo.getRegistrovanoNaOsobuDto();
		
		
		if(regNaOsobuDto != null) {
			RegistrovanoNaOsobuDao regNaOsobuDao = new RegistrovanoNaOsobuDao();
			regNaOsobuDao.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
			regNaOsobuDao.setPrezime(vozilo.getRegistrovanoNaOsobuDto().getPrezime());
			regNaOsobuDao.setGrad(vozilo.getRegistrovanoNaOsobuDto().getGrad());
			regNaOsobuDao.setJmbg(vozilo.getRegistrovanoNaOsobuDto().getJmbg());
			regNaOsobuDao.setDatumRodjenja(vozilo.getRegistrovanoNaOsobuDto().getDatumRodjenja());
			
			novoVozilo.setRegistrovano(regNaOsobuDao);
		}
	}



	/*
	 * - MARK: 
	 * 	- CreateVozilo method
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

		Optional<RegistrovanoNaOsobuDao> regOsobeIzBazeResult = Optional.of(registrovanoNaOsobuRepository.findById(id))
				.orElseThrow(() -> new IllegalStateException("Register Person with id " + id + "does not exist"));
		
		RegistrovanoNaOsobuDao regOsobaIzBaze = regOsobeIzBazeResult.get();
		
		regOsobaIzBaze.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
		regOsobaIzBaze.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
		regOsobaIzBaze.setPrezime(vozilo.getRegistrovanoNaOsobuDto().getPrezime());
		regOsobaIzBaze.setGrad(vozilo.getRegistrovanoNaOsobuDto().getGrad());
		regOsobaIzBaze.setJmbg(vozilo.getRegistrovanoNaOsobuDto().getJmbg());
		regOsobaIzBaze.setDatumRodjenja(vozilo.getRegistrovanoNaOsobuDto().getDatumRodjenja());
		
		voziloIzBaze.setRegistrovano(regOsobaIzBaze);
		
		VoziloDao spremiVozilo = voziloRepositroy.save(voziloIzBaze);
		
		VoziloDto voziloDto = createVozilo(spremiVozilo);
		
		if(vozilo.getRegistrovanoNaOsobuDto() != null) {
			
			RegistrovanoNaOsobuDto regNaOsobuDto = new RegistrovanoNaOsobuDto();
			regNaOsobuDto.setId(vozilo.getId());
			regNaOsobuDto.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
			regNaOsobuDto.setPrezime(vozilo.getRegistrovanoNaOsobuDto().getPrezime());
			regNaOsobuDto.setGrad(vozilo.getRegistrovanoNaOsobuDto().getGrad());
			regNaOsobuDto.setJmbg(vozilo.getRegistrovanoNaOsobuDto().getJmbg());
			regNaOsobuDto.setDatumRodjenja(vozilo.getRegistrovanoNaOsobuDto().getDatumRodjenja());
			
			voziloDto.setRegistrovanoNaOsobuDto(regNaOsobuDto);
		}
		
		return voziloDto;
	}
	

	/*
	 * - MARK: Register New Person
	 */
	private void registrujNovuOsobu(VoziloDao spremiVozilo, VoziloDto voziloDto) {
		if(spremiVozilo.getRegistrovano() != null) {
			
			RegistrovanoNaOsobuDto registovanoNaOsobuDto = new RegistrovanoNaOsobuDto();
			RegistrovanoNaOsobuDao novaRegOsobaDao = spremiVozilo.getRegistrovano();
			registovanoNaOsobuDto.setId(novaRegOsobaDao.getId());
			registovanoNaOsobuDto.setIme(novaRegOsobaDao.getIme());
			registovanoNaOsobuDto.setPrezime(novaRegOsobaDao.getPrezime());
			registovanoNaOsobuDto.setGrad(novaRegOsobaDao.getGrad());
			registovanoNaOsobuDto.setJmbg(novaRegOsobaDao.getJmbg());
			registovanoNaOsobuDto.setDatumRodjenja(novaRegOsobaDao.getDatumRodjenja());

			voziloDto.setRegistrovanoNaOsobuDto(registovanoNaOsobuDto);
		}
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
			
			registrovanoNaOsobuRepository.deleteById(id);
		}
	}
}
