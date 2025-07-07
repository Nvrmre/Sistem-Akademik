package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.JadwalModel;

@Repository
public interface JadwalRepository extends JpaRepository<JadwalModel, Long> {
    
}
