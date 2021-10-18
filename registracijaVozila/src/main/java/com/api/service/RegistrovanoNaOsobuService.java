package com.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.api.dto.RegistrovanoNaOsobuDto;



public interface RegistrovanoNaOsobuService {

	List<RegistrovanoNaOsobuDto> sveRegistrovaneOsobe();

	RegistrovanoNaOsobuDto createRegistrovanuOsobu(RegistrovanoNaOsobuDto registrovanoNaOsobu);

	RegistrovanoNaOsobuDto updateRegistrovanuOsobu(Integer id, RegistrovanoNaOsobuDto registrovanoNaOsobu);
	
	RegistrovanoNaOsobuDto checkAge(Date godine);
	
	Optional <RegistrovanoNaOsobuDto> findByJmbg(Long jmbg);

	void deleteRegistrovanuOsobu(Integer id);

}
