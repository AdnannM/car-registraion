package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dao.KarakteristikeVozilaDao;

@Repository
public interface KarakteristikeVozilaRepository extends JpaRepository <KarakteristikeVozilaDao, Integer>{

}
