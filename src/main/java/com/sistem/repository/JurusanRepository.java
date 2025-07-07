package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.JurusanModel;

@Repository
public interface JurusanRepository extends JpaRepository <JurusanModel, Long> {
    
}
