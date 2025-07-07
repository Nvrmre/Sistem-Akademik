package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.AbsenModel;

@Repository
public interface AbsenRepository extends JpaRepository<AbsenModel,Long> {
    
}
