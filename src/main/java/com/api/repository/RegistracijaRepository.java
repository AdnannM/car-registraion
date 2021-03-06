package com.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dao.RegistracijaDao;


@Repository
public interface RegistracijaRepository extends JpaRepository<RegistracijaDao, Integer> {

	@Query(value = "select * from registracijaDao where registracijaDao = :registracija", nativeQuery = true)
	 Optional<RegistracijaDao> getRegistracija(String registracija);

	 Optional<RegistracijaDao> findByIsteklaRegistracija(boolean isteklaRegistracija);

	
}
