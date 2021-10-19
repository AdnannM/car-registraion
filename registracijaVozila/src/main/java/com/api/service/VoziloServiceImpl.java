package com.api.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.ModelVozilaDao;
import com.api.dao.RegistracijaDao;
import com.api.dao.RegistrovanoNaOsobuDao;
import com.api.dao.VoziloDao;
import com.api.dto.KarakteristikeVozilaDto;
import com.api.dto.ModelVozilaDto;
import com.api.dto.RegistracijaDto;
import com.api.dto.RegistrovanoNaOsobuDto;
import com.api.dto.VoziloDto;
import com.api.repository.KarakteristikeVozilaRepository;
import com.api.repository.ModelVozilaRepository;
import com.api.repository.RegistracijaRepository;
import com.api.repository.RegistrovanoNaOsobuRepository;
import com.api.repository.VoziloRepository;


@Service
public class VoziloServiceImpl implements VoziloService {

	@Autowired
	VoziloRepository voziloRepositroy;

	@Autowired
	RegistrovanoNaOsobuRepository registrovanoNaOsobuRepository;
	
	@Autowired
	ModelVozilaRepository modelVozilaRepositorty;
	
	@Autowired
	KarakteristikeVozilaRepository karakteristikeVozilaRepository;
	
	@Autowired
	RegistracijaRepository registracijaRepository;
	
	@Override
	/*
	 * - MARK: - GET
	 */
	

//	private void getAllFromList(List<VoziloDao> empListDb, List<VoziloDto> resultList) {
//		
//	}
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
				  dtoRegistrovano.setGrad(voziloDao.getRegistrovano().getGrad());
				  dtoRegistrovano.setJmbg(voziloDao.getRegistrovano().getJmbg());
				  dtoRegistrovano.setDatumRodjenja(voziloDao.getRegistrovano().getDatumRodjenja());
				  novoVoziloDto.setRegistrovanoNaOsobuDto(dtoRegistrovano);
			}
			
			
			List<ModelVozilaDao> modelListDb = modelVozilaRepositorty.findAll();
			List<ModelVozilaDto> modelVozilaResultList = new ArrayList<ModelVozilaDto>();
			
			
			for (ModelVozilaDao modelVozilaDao : modelListDb) {
				ModelVozilaDto modelVozilaDto = new ModelVozilaDto();
				modelVozilaDto.setId(modelVozilaDao.getId());
				modelVozilaDto.setGodina(modelVozilaDao.getGodina());
				modelVozilaDto.setModel(modelVozilaDao.getModel());
				modelVozilaDto.setProizdvodjac(modelVozilaDao.getProizdvodjac());
				modelVozilaResultList.add(modelVozilaDto);
				
				if(modelVozilaDao.getModel()!=null) {
					ModelVozilaDto modelDto = new ModelVozilaDto();
					modelDto.setGodina(modelVozilaDao.getGodina());
					modelDto.setProizdvodjac(modelVozilaDao.getProizdvodjac());
					modelDto.setId(modelVozilaDao.getId());
					novoVoziloDto.setModelVozilaDto(modelVozilaDto);
				}
				
				if(modelVozilaDao.getKarakteristikeVozilaDao()!=null) {
					KarakteristikeVozilaDto karakteristikeDto = new KarakteristikeVozilaDto();
					karakteristikeDto.setBoja(modelVozilaDao.getKarakteristikeVozilaDao().getBoja());
					karakteristikeDto.setBrojSasije(modelVozilaDao.getKarakteristikeVozilaDao().getBrojSasije());
					karakteristikeDto.setSnagaMotora(modelVozilaDao.getKarakteristikeVozilaDao().getSnagaMotora());
					karakteristikeDto.setId(modelVozilaDao.getKarakteristikeVozilaDao().getId());
					karakteristikeDto.setTipVozila(modelVozilaDao.getKarakteristikeVozilaDao().getTipVozila());
					novoVoziloDto.setKarakteristikeVozila(karakteristikeDto);
				}
			}
			
			
			List<RegistracijaDao> registracijaListDb = registracijaRepository.findAll();
			List<RegistracijaDto> registracijaResultList = new ArrayList<RegistracijaDto>();
			
			for (RegistracijaDao registracijaDao : registracijaListDb) {
				RegistracijaDto registracijaDto = new RegistracijaDto();
				registracijaDto.setId(registracijaDao.getId());
				registracijaDto.setIsteklaRegistracija(registracijaDao.getIsteklaRegistracija());
				registracijaDto.setTrajanjeRegistracijeOd(registracijaDao.getTrajanjeRegistracijeOd());
				registracijaDto.setTrajanjeRegistracijeDo(registracijaDao.getTrajanjeRegistracijeDo());
				registracijaResultList.add(registracijaDto);
				
				if(voziloDao.getRegistracija()!=null) {
					RegistracijaDto dtoRegistracija = new RegistracijaDto();
					dtoRegistracija.setId(voziloDao.getRegistracija().getId());
					dtoRegistracija.setIsteklaRegistracija(voziloDao.getRegistracija().getIsteklaRegistracija());
					dtoRegistracija.setTrajanjeRegistracijeOd(voziloDao.getRegistracija().getTrajanjeRegistracijeOd());
					dtoRegistracija.setTrajanjeRegistracijeDo(voziloDao.getRegistracija().getTrajanjeRegistracijeDo());
					novoVoziloDto.setRegistracija(dtoRegistracija);
				}
			}
			
			resultList.add(novoVoziloDto);
		}
		
		return resultList;
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
	/*
	 * - MARK: PUT
	 */
	public VoziloDto updateVozilo(Integer id, VoziloDto vozilo) {
		
		VoziloDao voziloIzBaze = updateVoziloRepo(id, vozilo);
		
		// RegistrovanoNaOsobu update
		updateRigistrovanuOsobuRepo(id, vozilo, voziloIzBaze);
		
		VoziloDao spremiVozilo = voziloRepositroy.save(voziloIzBaze);
		
		VoziloDto voziloDto = createVozilo(spremiVozilo);
		
		getRegisterPerson(vozilo, voziloDto);
		
		return voziloDto;
	}


	private void getRegisterPerson(VoziloDto vozilo, VoziloDto voziloDto) {
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
	}


	private void updateRigistrovanuOsobuRepo(Integer id, VoziloDto vozilo, VoziloDao voziloIzBaze) {
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
	}


	private VoziloDao updateVoziloRepo(Integer id, VoziloDto vozilo) {
		Optional<VoziloDao> vozilaIzBazeResult = Optional.of(voziloRepositroy.findById(id))
				.orElseThrow(() -> new IllegalStateException("Vozilo with id " + id + "does not exist"));
		
		VoziloDao voziloIzBaze = vozilaIzBazeResult.get();
		voziloIzBaze.setId(vozilo.getId());
		voziloIzBaze.setRegistracijskaOznaka(vozilo.getRegistracijskaOznaka());
		return voziloIzBaze;
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
	
	/*
	 * - MARK: DELETE
	 */
	public void deleteVozilo(Integer id) {
		deletVoziloIzBaze(id);
		
		deleteOsobuIzBaze(id);
	}


	private void deleteOsobuIzBaze(Integer id) {
		if(registrovanoNaOsobuRepository.getById(id) != null) {
			boolean exist = registrovanoNaOsobuRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Register Person with id  " + id + "does not Exist");
			}
			
			registrovanoNaOsobuRepository.deleteById(id);
		}
	}


	private void deletVoziloIzBaze(Integer id) {
		if (voziloRepositroy.getById(id).getId().equals(id)) {
			boolean exist = voziloRepositroy.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Vozilo with id " + id + "does not exist");
			}
			
			voziloRepositroy.deleteById(id);
		}
	}
	
	// Query
}
