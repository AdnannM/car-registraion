package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dao.RegistracijaDao;

@Repository
public interface RegistracijaRepository extends JpaRepository<RegistracijaDao, Integer> {

}
