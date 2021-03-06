package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		KarakteristikeVozilaDao noveKarakteristikeVozila = new KarakteristikeVozilaDao();
		noveKarakteristikeVozila.setId(karakteristikeVozila.getId());
		noveKarakteristikeVozila.setBoja(karakteristikeVozila.getBoja());
		noveKarakteristikeVozila.setBrojSasije(karakteristikeVozila.getBrojSasije());
		noveKarakteristikeVozila.setSnagaMotora(karakteristikeVozila.getSnagaMotora());
		noveKarakteristikeVozila.setTipVozila(karakteristikeVozila.getTipVozila());
		
		KarakteristikeVozilaDao spremiKarakteristikeVozila = karakteristikeVozilaRepository.save(noveKarakteristikeVozila);
		
		KarakteristikeVozilaDto karakteristikeVozilaDto = new KarakteristikeVozilaDto();
		karakteristikeVozilaDto.setId(spremiKarakteristikeVozila.getId());
		karakteristikeVozilaDto.setBoja(spremiKarakteristikeVozila.getBoja());
		karakteristikeVozilaDto.setBrojSasije(spremiKarakteristikeVozila.getBrojSasije());
		karakteristikeVozilaDto.setSnagaMotora(spremiKarakteristikeVozila.getSnagaMotora());
		karakteristikeVozilaDto.setTipVozila(spremiKarakteristikeVozila.getTipVozila());
		
		return karakteristikeVozilaDto;
	}

	@Override
	public KarakteristikeVozilaDto updateKarakteristikeVozila(Integer id,KarakteristikeVozilaDto karakteristikeVozila) {
		
		Optional<KarakteristikeVozilaDao> noveKarakteristikeIzBazeResult = Optional.of(karakteristikeVozilaRepository.findById(id))
				.orElseThrow(() -> new IllegalStateException("New Specs with this id " + id + "does not exist"));
		
		KarakteristikeVozilaDao noveKarakteristikeIzBaze = noveKarakteristikeIzBazeResult.get();
		noveKarakteristikeIzBaze.setId(karakteristikeVozila.getId());
		noveKarakteristikeIzBaze.setBoja(karakteristikeVozila.getBoja());
		noveKarakteristikeIzBaze.setBrojSasije(karakteristikeVozila.getBrojSasije());
		noveKarakteristikeIzBaze.setSnagaMotora(karakteristikeVozila.getSnagaMotora());
		noveKarakteristikeIzBaze.setTipVozila(karakteristikeVozila.getTipVozila());
		
		
		KarakteristikeVozilaDao saveKarakteristikeVozila = karakteristikeVozilaRepository.save(noveKarakteristikeIzBaze);
		
		KarakteristikeVozilaDto karakteristikeVozilaDto = new KarakteristikeVozilaDto();
		karakteristikeVozilaDto.setId(saveKarakteristikeVozila.getId());
		karakteristikeVozilaDto.setBoja(saveKarakteristikeVozila.getBoja());
		karakteristikeVozilaDto.setBrojSasije(saveKarakteristikeVozila.getBrojSasije());
		karakteristikeVozilaDto.setSnagaMotora(saveKarakteristikeVozila.getSnagaMotora());
		karakteristikeVozilaDto.setTipVozila(saveKarakteristikeVozila.getTipVozila());
		
		return karakteristikeVozilaDto;
	}

	@Override
	public void deleteKarakteristikeVozila(Integer id) {
		if(karakteristikeVozilaRepository.getById(id).getId().equals(id)) {
			boolean exist = karakteristikeVozilaRepository.existsById(id);
			
			if(!exist) {
				throw new IllegalStateException("Spec with this id " + id + "does not exist");
			}
			
			karakteristikeVozilaRepository.deleteById(id);
		}
	}
}
