package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.RegistrovanoNaOsobuDao;
import com.api.dao.VoziloDao;
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
//		Optional<VoziloDao> vozilaIzBazeResult = Optional.of(registrovanoNaOsobuRepository.findById(id))
//				.orElseThrow(() -> new IllegalStateException("Vozilo with id " + id + "does not exist"));
		
		return null;
	}

	@Override
	public void deleteRegistrovanuOsobu(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
