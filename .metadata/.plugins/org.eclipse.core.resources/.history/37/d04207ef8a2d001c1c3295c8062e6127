package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.ModelVozilaDao;

import com.api.dto.ModelVozilaDto;
import com.api.repository.ModelVozilaRepository;

@Service
public class ModelVozilaServiceImpl implements ModelVozilaService {

	
	@Autowired
	ModelVozilaRepository modelVozilaRepository;
	
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
			
			modelVozilaResult.add(modelVozilaDto);		}
		
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
		
		ModelVozilaDao saveNoviModel = modelVozilaRepository.save(noviModelVozila);
		
		ModelVozilaDto modelVozilaDto = new ModelVozilaDto();
		modelVozilaDto.setId(saveNoviModel.getId());
		modelVozilaDto.setGodina(saveNoviModel.getGodina());
		modelVozilaDto.setModel(noviModelVozila.getModel());
		modelVozilaDto.setProizdvodjac(noviModelVozila.getProizdvodjac());
		
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
		
		ModelVozilaDto noviModelDto = new ModelVozilaDto();
		noviModelDto.setId(saveNoviModel.getId());
		noviModelDto.setGodina(saveNoviModel.getGodina());
		noviModelDto.setModel(saveNoviModel.getModel());
		noviModelDto.setProizdvodjac(saveNoviModel.getProizdvodjac());
		
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
	}

}
