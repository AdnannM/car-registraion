package com.api.service;

import java.util.List;

import com.api.dto.RegistrovanoNaOsobuDto;



public interface RegistrovanoNaOsobuService {

	List<RegistrovanoNaOsobuDto> sveRegistrovaneOsobe();

	RegistrovanoNaOsobuDto createVozilo(RegistrovanoNaOsobuDto registrovanoNaOsobu);

	RegistrovanoNaOsobuDto updateVozilo(Integer id, RegistrovanoNaOsobuDto registrovanoNaOsobu);

	void deleteVozilo(Integer id);

}
