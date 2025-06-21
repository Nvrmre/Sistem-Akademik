package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.GuruModel;

@Repository
public interface GuruRepository extends JpaRepository<GuruModel, Long> {
    
}
