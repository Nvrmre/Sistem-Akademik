package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.SemesterModel;

@Repository
public interface SemesterRepository extends JpaRepository<SemesterModel, Long> {
    
}
