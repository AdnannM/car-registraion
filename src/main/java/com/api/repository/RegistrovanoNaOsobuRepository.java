package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dao.RegistrovanoNaOsobuDao;
import com.api.dto.RegistrovanoNaOsobuDto;

@Repository
	
public interface RegistrovanoNaOsobuRepository extends JpaRepository <RegistrovanoNaOsobuDao, Integer> {
	@Query(value = "select * from registrovanoNaOsobuDao where registrovanoNaOsobuDao = :registrovano", nativeQuery = true)
	 Optional<RegistrovanoNaOsobuDto> getRegistrovano(String registrovano);
	
	 Optional<RegistrovanoNaOsobuDao> findByJmbg(Long jmbg);
	 Optional<RegistrovanoNaOsobuDao> findByIme(String ime);
	 Optional<RegistrovanoNaOsobuDao> findByPrezime(String prezime);

}
