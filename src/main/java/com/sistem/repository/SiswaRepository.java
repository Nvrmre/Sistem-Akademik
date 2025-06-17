package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.SiswaModel;

@Repository
public interface SiswaRepository extends JpaRepository <SiswaModel,Long>{
    
}
