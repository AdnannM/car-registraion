package com.api.service;

import java.util.List;

import com.api.dto.ModelVozilaDto;


public interface ModelVozilaService {

	List<ModelVozilaDto> sviModeliVozila();

	ModelVozilaDto createModelVozila(ModelVozilaDto modelVozila);

	ModelVozilaDto updateModelVozila(Integer id, ModelVozilaDto voziloModel);

	
//	 Optional <List<ModelVozilaDao>> findByModel(String model);
//	 Optional <List<ModelVozilaDao>> findByProizdvodjac(String proizdvodjac);
	
	void deleteModelVozila(Integer id);
}
