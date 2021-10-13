package com.api.service;

import java.util.ArrayList;
import java.util.List;

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
	public RegistrovanoNaOsobuDto createVozilo(RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrovanoNaOsobuDto updateVozilo(Integer id, RegistrovanoNaOsobuDto registrovanoNaOsobu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVozilo(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
