package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dao.ModelVozilaDao;

@Repository
public interface ModelVozilaRepository extends JpaRepository <ModelVozilaDao, Integer> {

}
