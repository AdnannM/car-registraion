package com.api.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.RegistrovanoNaOsobuDao;
import com.api.dto.RegistrovanoNaOsobuDto;
import com.api.repository.RegistrovanoNaOsobuRepository;

@Service
public class RegistrovanoNaOsobuServiceImpl implements RegistrovanoNaOsobuService {

	@Autowired
	RegistrovanoNaOsobuRepository registrovanoNaOsobuRepository;
	
	@Override
	public List<RegistrovanoNaOsobuDto> sveRegistrovaneOsobe() {
		List<RegistrovanoNaOsobuDao> empList = registrovanoNaOsobuRepository.findAll();
		List<RegistrovanoNaOsobuDto> resultList = new ArrayList<RegistrovanoNaOsobuDto>();
		
		if (empList.isEmpty()) {
			return resultList;
		}
		
		for (RegistrovanoNaOsobuDao registrovanoNaOsobuDao : empList) {
			RegistrovanoNaOsobuDto registrovanoOsobadto = new RegistrovanoNaOsobuDto();
			registrovanoOsobadto.setId(registrovanoNaOsobuDao.getId());
			registrovanoOsobadto.setIme(registrovanoNaOsobuDao.getIme());
			registrovanoOsobadto.setPrezime(registrovanoNaOsobuDao.getPrezime());
			registrovanoOsobadto.setGrad(registrovanoNaOsobuDao.getGrad());
			registrovanoOsobadto.setJmbg(registrovanoNaOsobuDao.getJmbg());
			registrovanoOsobadto.setDatumRodjenja(registrovanoNaOsobuDao.getDatumRodjenja());
			
			resultList.add(registrovanoOsobadto);
		}
		
		return resultList;

}

	@Override
	public RegistrovanoNaOsobuDto createRegistrovanuOsobu(RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		RegistrovanoNaOsobuDao novaRegOsoba = new RegistrovanoNaOsobuDao();
		novaRegOsoba.setId(registrovanoNaOsobu.getId());
		novaRegOsoba.setIme(registrovanoNaOsobu.getIme());
		novaRegOsoba.setPrezime(registrovanoNaOsobu.getPrezime());
		novaRegOsoba.setJmbg(registrovanoNaOsobu.getJmbg());
		novaRegOsoba.setGrad(registrovanoNaOsobu.getGrad());
		novaRegOsoba.setDatumRodjenja(registrovanoNaOsobu.getDatumRodjenja());
		
		RegistrovanoNaOsobuDao saveRegOsobu = registrovanoNaOsobuRepository.save(novaRegOsoba);
		
		RegistrovanoNaOsobuDto novaRegOsobaDto = new RegistrovanoNaOsobuDto();
		novaRegOsobaDto.setId(saveRegOsobu.getId());
		novaRegOsobaDto.setIme(saveRegOsobu.getIme());
		novaRegOsobaDto.setPrezime(saveRegOsobu.getPrezime());
		novaRegOsobaDto.setGrad(saveRegOsobu.getGrad());
		novaRegOsobaDto.setDatumRodjenja(saveRegOsobu.getDatumRodjenja());
		
		
		return novaRegOsobaDto;
	}

	@Override
	public RegistrovanoNaOsobuDto updateRegistrovanuOsobu(Integer id, RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		Optional<RegistrovanoNaOsobuDao> regOsobaIzBazeResult = Optional.of(registrovanoNaOsobuRepository.findById(id))
				.orElseThrow(() -> new IllegalStateException("Register Person with id " + id + "does not exist"));
		
		RegistrovanoNaOsobuDao regOsobaIzBaze = regOsobaIzBazeResult.get();
		
		regOsobaIzBaze.setId(registrovanoNaOsobu.getId());
		regOsobaIzBaze.setIme(registrovanoNaOsobu.getIme());
		regOsobaIzBaze.setPrezime(registrovanoNaOsobu.getPrezime());
		regOsobaIzBaze.setGrad(registrovanoNaOsobu.getGrad());
		regOsobaIzBaze.setJmbg(registrovanoNaOsobu.getJmbg());
		regOsobaIzBaze.setDatumRodjenja(registrovanoNaOsobu.getDatumRodjenja());
		
		RegistrovanoNaOsobuDao spremiRegOsobu  = registrovanoNaOsobuRepository.save(regOsobaIzBaze);
		
		RegistrovanoNaOsobuDto spremiRegOsobuDto = new RegistrovanoNaOsobuDto();
		
		spremiRegOsobuDto.setId(spremiRegOsobu.getId());
		spremiRegOsobuDto.setIme(spremiRegOsobu.getIme());
		spremiRegOsobuDto.setPrezime(spremiRegOsobu.getPrezime());
		spremiRegOsobuDto.setGrad(spremiRegOsobu.getGrad());
		spremiRegOsobuDto.setJmbg(spremiRegOsobu.getJmbg());
		spremiRegOsobuDto.setDatumRodjenja(spremiRegOsobu.getDatumRodjenja());
		
		return spremiRegOsobuDto;
	}

	@Override
	public void deleteRegistrovanuOsobu(Integer id) {
		if(registrovanoNaOsobuRepository.getById(id).getId().equals(id)) {
			boolean exist = registrovanoNaOsobuRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Register Perseon wiht id " + id + "does not exist");
			}
			
			registrovanoNaOsobuRepository.deleteById(id);
		}
	}

	@Override
	public RegistrovanoNaOsobuDto checkAge(Date godine) {
		return null;
	}
}
