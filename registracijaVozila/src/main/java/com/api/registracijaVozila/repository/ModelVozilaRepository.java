package com.api.registracijaVozila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.registracijaVozila.dao.ModelVozilaDao;

@Repository
public interface ModelVozilaRepository extends JpaRepository <ModelVozilaDao, Integer> {

}
