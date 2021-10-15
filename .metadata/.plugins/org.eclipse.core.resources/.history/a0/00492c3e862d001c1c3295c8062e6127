package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.KarakteristikeVozilaDao;
import com.api.dto.KarakteristikeVozilaDto;
import com.api.repository.KarakteristikeVozilaRepository;

@Service
public class KarakteristikeVozilaServiceImpl implements KarakteristikeVozilaService {
	
	@Autowired
	KarakteristikeVozilaRepository karakteristikeVozilaRepository;

	@Override
	public List<KarakteristikeVozilaDto> sveKarakteristikeVozila() {
		
		List<KarakteristikeVozilaDao> empList = karakteristikeVozilaRepository.findAll();
		List<KarakteristikeVozilaDto> karakteristikeVozilaResult = new ArrayList<KarakteristikeVozilaDto>();
		
		if(empList.isEmpty()) {
			return karakteristikeVozilaResult;
		}
		
		for (KarakteristikeVozilaDao karakteristikeVozilaDao : empList) {
			KarakteristikeVozilaDto karakteristikeVozilaDto = new KarakteristikeVozilaDto();
			karakteristikeVozilaDto.setId(karakteristikeVozilaDao.getId());
			karakteristikeVozilaDto.setBoja(karakteristikeVozilaDao.getBoja());
			karakteristikeVozilaDto.setBrojSasije(karakteristikeVozilaDao.getBrojSasije());
			karakteristikeVozilaDto.setSnagaMotora(karakteristikeVozilaDao.getSnagaMotora());
			karakteristikeVozilaDto.setTipVozila(karakteristikeVozilaDao.getTipVozila());
			
			karakteristikeVozilaResult.add(karakteristikeVozilaDto);
			
		}
		
		return karakteristikeVozilaResult;
	}

	@Override
	public KarakteristikeVozilaDto createKarakteristikeVozila(KarakteristikeVozilaDto karakteristikeVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KarakteristikeVozilaDto updateKarakteristikeVozila(Integer id,
			KarakteristikeVozilaDto karakteristikeVozila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteKarakteristikeVozila(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
