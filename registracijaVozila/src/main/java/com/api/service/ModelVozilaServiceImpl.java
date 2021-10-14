package com.api.service;

import java.util.ArrayList;
import java.util.List;

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
	public ModelVozilaDto createModelVozila(ModelVozilaDto modelVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelVozilaDto updateModelVozila(Integer id, ModelVozilaDto vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModelVozila(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
