package com.api.registracijaVozila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.registracijaVozila.dao.VoziloDao;

@Repository
public interface VoziloRepository extends JpaRepository <VoziloDao, Integer> {

}
