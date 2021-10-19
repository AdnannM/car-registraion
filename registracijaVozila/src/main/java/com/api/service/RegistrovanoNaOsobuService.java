package com.api.service;

import java.sql.Date;
import java.util.List;


import com.api.dto.RegistrovanoNaOsobuDto;



public interface RegistrovanoNaOsobuService {

	List<RegistrovanoNaOsobuDto> sveRegistrovaneOsobe();

	RegistrovanoNaOsobuDto createRegistrovanuOsobu(RegistrovanoNaOsobuDto registrovanoNaOsobu);

	RegistrovanoNaOsobuDto updateRegistrovanuOsobu(Integer id, RegistrovanoNaOsobuDto registrovanoNaOsobu);
	
	RegistrovanoNaOsobuDto checkAge(Date godine);
	
	void deleteRegistrovanuOsobu(Integer id);

}
