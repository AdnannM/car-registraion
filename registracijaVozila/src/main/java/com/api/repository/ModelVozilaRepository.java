package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dao.ModelVozilaDao;


@Repository
public interface ModelVozilaRepository extends JpaRepository <ModelVozilaDao, Integer> {

	@Query(value = "select * from modelVozilaDao where modelVozilaDao = :modelVozila", nativeQuery = true)
	 Optional<ModelVozilaDao> getRegOsobu(String modelVozila);
	// Find model Querry?
}
