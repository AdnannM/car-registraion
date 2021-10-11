package com.api.registracijaVozila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.registracijaVozila.dao.RegistrovanoNaOsobuDao;

@Repository
public interface RegistrovanoNaOsobuRepository extends JpaRepository <RegistrovanoNaOsobuDao, Integer> {

}
