package com.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dao.KarakteristikeVozilaDao;


@Repository
public interface KarakteristikeVozilaRepository extends JpaRepository <KarakteristikeVozilaDao, Integer>{

	@Query(value = "select * from karakteristikeVozilaDao where karakteristikeVozilaDao = :karakteristikeVozila", nativeQuery = true)
	 Optional<KarakteristikeVozilaDao> getKarakteristike(String karakteristikeVozila);

	 Optional<KarakteristikeVozilaDao> findByBrojSasije(Integer brojSasije);

	 Optional<KarakteristikeVozilaDao> findByBojaAndTipVozila(String boja, String tipVozila);


}
