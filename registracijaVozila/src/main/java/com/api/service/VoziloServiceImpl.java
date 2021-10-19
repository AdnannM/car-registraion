package com.api.service;


import java.sql.Date;
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
	public List<VoziloDto> createVozilo(VoziloDto vozilo) {
		
		//upis
		VoziloDao novoVozilo = new VoziloDao();
		novoVozilo.setRegistracijskaOznaka(vozilo.getRegistracijskaOznaka());
		
		upisNapravljenihVozila(vozilo, novoVozilo);
		
		VoziloDao spremiVozilo = voziloRepositroy.save(novoVozilo);
		
		// Model:
		ModelVozilaDto modelDto = vozilo.getModelVozilaDto();
		
		if(modelDto != null) {
			ModelVozilaDao modelDao = new ModelVozilaDao();
			modelDao.setGodina(vozilo.getModelVozilaDto().getGodina());
			modelDao.setModel(vozilo.getModelVozilaDto().getModel());
			modelDao.setProizdvodjac(vozilo.getModelVozilaDto().getProizdvodjac());
			
			novoVozilo.setModelVozila(modelDao);
		}
		
		//ispis
		List<VoziloDto> voziloDto = createVozilo(spremiVozilo);
		
		ModelVozilaDao noviModelDao = spremiVozilo.getModelVozila();
		
		if(noviModelDao != null) {
			ModelVozilaDto noviModelDto = new ModelVozilaDto();
			noviModelDto.setGodina(noviModelDao.getGodina());
			noviModelDto.setModel(noviModelDao.getModel());
			noviModelDto.setProizdvodjac(noviModelDao.getProizdvodjac());
			
			((VoziloDto) voziloDto).setModelVozilaDto(modelDto);
		}
		
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
	@SuppressWarnings("unchecked")
	private List<VoziloDto> createVozilo(VoziloDao spremiVozilo) {
		VoziloDto voziloDto = new VoziloDto();
		voziloDto.setId(spremiVozilo.getId());
		voziloDto.setRegistracijskaOznaka(spremiVozilo.getRegistracijskaOznaka());
		
		return ((List<VoziloDto>) voziloDto);
	}
	
	@Override
	/*
	 * - MARK: PUT
	 */
	public List<VoziloDto> updateVozilo(Integer id, VoziloDto vozilo) {
		
		VoziloDao voziloIzBaze = updateVoziloRepo(id, vozilo);
		
		// RegistrovanoNaOsobu update
		updateRigistrovanuOsobuRepo(id, vozilo, voziloIzBaze);
		
		VoziloDao spremiVozilo = voziloRepositroy.save(voziloIzBaze);
		
		List<VoziloDto> voziloDto = createVozilo(spremiVozilo);
		
		getRegisterPerson(vozilo, voziloDto);
		
		return (List<VoziloDto>) voziloDto;
	}


	private void getRegisterPerson(VoziloDto vozilo, List<VoziloDto> voziloDto) {
		if(vozilo.getRegistrovanoNaOsobuDto() != null) {
			
			RegistrovanoNaOsobuDto regNaOsobuDto = new RegistrovanoNaOsobuDto();
			regNaOsobuDto.setId(vozilo.getId());
			regNaOsobuDto.setIme(vozilo.getRegistrovanoNaOsobuDto().getIme());
			regNaOsobuDto.setPrezime(vozilo.getRegistrovanoNaOsobuDto().getPrezime());
			regNaOsobuDto.setGrad(vozilo.getRegistrovanoNaOsobuDto().getGrad());
			regNaOsobuDto.setJmbg(vozilo.getRegistrovanoNaOsobuDto().getJmbg());
			regNaOsobuDto.setDatumRodjenja(vozilo.getRegistrovanoNaOsobuDto().getDatumRodjenja());
			
			((VoziloDto) voziloDto).setRegistrovanoNaOsobuDto(regNaOsobuDto);
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
	private void registrujNovuOsobu(VoziloDao spremiVozilo, List<VoziloDto> voziloDto) {
		if(spremiVozilo.getRegistrovano() != null) {
			
			RegistrovanoNaOsobuDto registovanoNaOsobuDto = new RegistrovanoNaOsobuDto();
			RegistrovanoNaOsobuDao novaRegOsobaDao = spremiVozilo.getRegistrovano();
			registovanoNaOsobuDto.setId(novaRegOsobaDao.getId());
			registovanoNaOsobuDto.setIme(novaRegOsobaDao.getIme());
			registovanoNaOsobuDto.setPrezime(novaRegOsobaDao.getPrezime());
			registovanoNaOsobuDto.setGrad(novaRegOsobaDao.getGrad());
			registovanoNaOsobuDto.setJmbg(novaRegOsobaDao.getJmbg());
			registovanoNaOsobuDto.setDatumRodjenja(novaRegOsobaDao.getDatumRodjenja());

			((VoziloDto) voziloDto).setRegistrovanoNaOsobuDto(registovanoNaOsobuDto);
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

	/*
	 * -- FindBy Person:
	 */

	@Override
	public Optional<RegistrovanoNaOsobuDao> checkAge(Date datumRodjenja) {
		//LocalDate date = LocalDate.now();
		if(datumRodjenja.compareTo(datumRodjenja) <= 18) {
			throw new IllegalStateException("You must have 18 years to Register Car");
		}
		return checkAge(datumRodjenja);
	}

	@Override
	public Optional<RegistrovanoNaOsobuDao> findByIme(String ime) {
		if(ime.isEmpty()) {
			throw new IllegalStateException("Name " + ime + "does not exist");
		}
		return registrovanoNaOsobuRepository.findByIme(ime);
	}




	@Override
	public Optional<RegistrovanoNaOsobuDao> findByPrezime(String prezime) {
		if(prezime.isEmpty()) {
			throw new IllegalStateException("Lastname " + prezime + "does not exist");
		}
		return registrovanoNaOsobuRepository.findByPrezime(prezime);
	}




	@Override
	public Optional<RegistrovanoNaOsobuDao> findByJmbg(long jmbg) {
		if(Long.valueOf(jmbg) != null) {
			throw new IllegalStateException("Jmbg " + jmbg + "does not exist");
		}
		return registrovanoNaOsobuRepository.findByJmbg(jmbg);
	}



	@Override
	public List<RegistrovanoNaOsobuDao> findByRegistrovanoAll() {
		return registrovanoNaOsobuRepository.findAll();
	}
	
	/*
	 * - FindBy Car
	 */
	
	@Override
	public Optional<ModelVozilaDao> findByModel(String model) {
		if(model.isEmpty()) {
			throw new IllegalStateException("Model " + model + " does not exist");
		}
		return modelVozilaRepositorty.findByModel(model);
	}


	@Override
	public Optional<ModelVozilaDao> findByproizdvodjac(String proizdvodjac) {
		if(proizdvodjac.isEmpty()) {
			throw new IllegalStateException("Proizvodjac " + proizdvodjac + " does not exist");
		}
		return modelVozilaRepositorty.findByProizdvodjac(proizdvodjac);
	}




	@Override
	public List<ModelVozilaDao> findByModelAll() {
		
		return modelVozilaRepositorty.findAll();
	}

	/*
	 * - Registration
	 */
	@Override
	public Optional<RegistracijaDao> findByRegistration(boolean isteklaRegistracija) {
		if(isteklaRegistracija == false ) {
			throw new IllegalStateException("Your registration is expired");
		}
		return registracijaRepository.findByRegistration(isteklaRegistracija);
	}
}
