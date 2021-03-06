package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.KarakteristikeVozilaDao;
import com.api.dao.ModelVozilaDao;

import com.api.dto.KarakteristikeVozilaDto;
import com.api.dto.ModelVozilaDto;
import com.api.repository.KarakteristikeVozilaRepository;
import com.api.repository.ModelVozilaRepository;

@Service
public class ModelVozilaServiceImpl implements ModelVozilaService {

	
	@Autowired
	ModelVozilaRepository modelVozilaRepository;
	
	@Autowired
	KarakteristikeVozilaRepository karakteristikeVozilaRepository;
	
	@Override
	/*
	 *  GET
	 */
	public List<ModelVozilaDto> sviModeliVozila() {
		List<ModelVozilaDao> empList = modelVozilaRepository.findAll();
		List<ModelVozilaDto> modelVozilaResult = new ArrayList<ModelVozilaDto>();
		
		
		if(empList.isEmpty()) {
			return modelVozilaResult;
		}
		
		for (ModelVozilaDao modelVozilaDao : empList) {
			ModelVozilaDto modelVozilaDto = new ModelVozilaDto();
			modelVozilaDto.setId(modelVozilaDao.getId());
			modelVozilaDto.setModel(modelVozilaDao.getModel());
			modelVozilaDto.setGodina(modelVozilaDao.getGodina());
			modelVozilaDto.setProizdvodjac(modelVozilaDao.getProizdvodjac());
			modelVozilaResult.add(modelVozilaDto);
			
			if(modelVozilaDao.getKarakteristikeVozilaDao() != null) {
				KarakteristikeVozilaDto karakteristikeVozilaDto = new KarakteristikeVozilaDto();
				karakteristikeVozilaDto.setId(modelVozilaDao.getKarakteristikeVozilaDao().getId());
				karakteristikeVozilaDto.setBoja(modelVozilaDao.getKarakteristikeVozilaDao().getBoja());
				karakteristikeVozilaDto.setBrojSasije(modelVozilaDao.getKarakteristikeVozilaDao().getBrojSasije());
				karakteristikeVozilaDto.setSnagaMotora(modelVozilaDao.getKarakteristikeVozilaDao().getSnagaMotora());
				karakteristikeVozilaDto.setTipVozila(modelVozilaDao.getKarakteristikeVozilaDao().getTipVozila());
				
				modelVozilaDto.setKarakteristikeVozilaDto(karakteristikeVozilaDto);
			}
			
		}
		
		return modelVozilaResult;
	}

	@Override
	/*
	 *  CREATE
	 */
	public ModelVozilaDto createModelVozila(ModelVozilaDto modelVozila) {
		
		ModelVozilaDao noviModelVozila = new ModelVozilaDao();
		noviModelVozila.setId(modelVozila.getId());
		noviModelVozila.setGodina(modelVozila.getGodina());
		noviModelVozila.setModel(modelVozila.getModel());
		noviModelVozila.setProizdvodjac(modelVozila.getModel());

		KarakteristikeVozilaDto karakteristikeVozilaDto = modelVozila.getKarakteristikeVozilaDto();
		
		if(karakteristikeVozilaDto!= null) {
			KarakteristikeVozilaDao karakteristikeVozilaDao = new KarakteristikeVozilaDao();
			karakteristikeVozilaDao.setId(karakteristikeVozilaDto.getId());
			karakteristikeVozilaDao.setBoja(karakteristikeVozilaDto.getBoja());
			karakteristikeVozilaDao.setBrojSasije(karakteristikeVozilaDto.getBrojSasije());
			karakteristikeVozilaDao.setSnagaMotora(karakteristikeVozilaDto.getSnagaMotora());
			karakteristikeVozilaDao.setTipVozila(karakteristikeVozilaDto.getTipVozila());
			noviModelVozila.setKarakteristikeVozilaDao(karakteristikeVozilaDao);
		}

		
		ModelVozilaDao saveNoviModel = modelVozilaRepository.save(noviModelVozila);
		ModelVozilaDto modelVozilaDto = new ModelVozilaDto();
		modelVozilaDto.setId(saveNoviModel.getId());
		modelVozilaDto.setGodina(saveNoviModel.getGodina());
		modelVozilaDto.setModel(noviModelVozila.getModel());
		modelVozilaDto.setProizdvodjac(noviModelVozila.getProizdvodjac());
		
		
		KarakteristikeVozilaDao novakarakteristikeVozilaDao = saveNoviModel.getKarakteristikeVozilaDao();
		
		if(novakarakteristikeVozilaDao!= null) {
			KarakteristikeVozilaDto novakarakteristikeVozilaDto = new KarakteristikeVozilaDto();
			novakarakteristikeVozilaDto.setId(novakarakteristikeVozilaDao.getId());
			novakarakteristikeVozilaDto.setBoja(novakarakteristikeVozilaDao.getBoja());
			novakarakteristikeVozilaDto.setBrojSasije(novakarakteristikeVozilaDao.getBrojSasije());
			novakarakteristikeVozilaDto.setSnagaMotora(novakarakteristikeVozilaDao.getSnagaMotora());
			novakarakteristikeVozilaDto.setTipVozila(novakarakteristikeVozilaDao.getTipVozila());
			
			modelVozilaDto.setKarakteristikeVozilaDto(novakarakteristikeVozilaDto);
			
		}
		
		return modelVozilaDto;
	}

	/*
	 *  UPDATE
	 */
	@Override
	public ModelVozilaDto updateModelVozila(Integer id, ModelVozilaDto voziloModel) {
		
		Optional<ModelVozilaDao> noviModelIzBazeResult = Optional.of(modelVozilaRepository.findById(id))
				.orElseThrow(() -> new IllegalStateException("New Car with this id " + id + "does not exist"));
		
		ModelVozilaDao noviModelIzBaze = noviModelIzBazeResult.get();
		
		noviModelIzBaze.setGodina(voziloModel.getId());
		noviModelIzBaze.setGodina(voziloModel.getGodina());
		noviModelIzBaze.setModel(voziloModel.getModel());
		noviModelIzBaze.setProizdvodjac(voziloModel.getProizdvodjac());
		
		ModelVozilaDao saveNoviModel = modelVozilaRepository.save(noviModelIzBaze);
		
		Optional<KarakteristikeVozilaDao> karakteristikeVozilaIzBazeResult = Optional.of(karakteristikeVozilaRepository.findById(id))
				.orElseThrow(() -> new IllegalStateException("Vozilo with id " + id + "does not exist"));
		
		KarakteristikeVozilaDao karakteristikeIzBaze = karakteristikeVozilaIzBazeResult.get();
		
		karakteristikeIzBaze.setBoja(voziloModel.getKarakteristikeVozilaDto().getBoja());
		karakteristikeIzBaze.setBrojSasije(voziloModel.getKarakteristikeVozilaDto().getBrojSasije());
		karakteristikeIzBaze.setSnagaMotora(voziloModel.getKarakteristikeVozilaDto().getSnagaMotora());
		karakteristikeIzBaze.setTipVozila(voziloModel.getKarakteristikeVozilaDto().getTipVozila());
		
		noviModelIzBaze.setKarakteristikeVozilaDao(karakteristikeIzBaze);
		
	
		
		ModelVozilaDto noviModelDto = new ModelVozilaDto();
		noviModelDto.setId(saveNoviModel.getId());
		noviModelDto.setGodina(saveNoviModel.getGodina());
		noviModelDto.setModel(saveNoviModel.getModel());
		noviModelDto.setProizdvodjac(saveNoviModel.getProizdvodjac());
		
		if(voziloModel.getKarakteristikeVozilaDto() != null) {
			KarakteristikeVozilaDto karakteristikeVozilaDto = new KarakteristikeVozilaDto();
			karakteristikeVozilaDto.setId(voziloModel.getKarakteristikeVozilaDto().getId());
			karakteristikeVozilaDto.setBoja(voziloModel.getKarakteristikeVozilaDto().getBoja());
			karakteristikeVozilaDto.setBrojSasije(voziloModel.getKarakteristikeVozilaDto().getBrojSasije());
			karakteristikeVozilaDto.setSnagaMotora(voziloModel.getKarakteristikeVozilaDto().getSnagaMotora());
			karakteristikeVozilaDto.setTipVozila(voziloModel.getKarakteristikeVozilaDto().getTipVozila());
			
			noviModelDto.setKarakteristikeVozilaDto(karakteristikeVozilaDto);
		}
		
		return noviModelDto;
	}

	/*
	 *  DELETE
	 */
	@Override
	public void deleteModelVozila(Integer id) {
		if(modelVozilaRepository.getById(id).getId().equals(id)) {
			boolean exist = modelVozilaRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("New Car with this id " + id + "does not exist");
			}
			
			modelVozilaRepository.deleteById(id);
		}
		
		if(karakteristikeVozilaRepository.getById(id).getId().equals(id)) {
			boolean exist = karakteristikeVozilaRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Specs for this Car with this id " + id + "does not exist");
			}
			
			karakteristikeVozilaRepository.deleteById(id);
		}
	}
}
