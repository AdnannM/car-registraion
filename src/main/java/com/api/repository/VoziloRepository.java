package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dao.VoziloDao;


@Repository
public interface VoziloRepository extends JpaRepository <VoziloDao, Integer> {

	@Query(value = "select * from voziloDao where voziloDao = :vozilo", nativeQuery = true)
	 Optional<VoziloDao> getVozilo(String vozilo);
	
	 Optional<VoziloDao> findByRegistracijskaOznaka(String registracijskaOznaka);
	
}
