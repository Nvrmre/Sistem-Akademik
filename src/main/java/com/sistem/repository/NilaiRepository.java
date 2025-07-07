package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.NilaiModel;

@Repository
public interface NilaiRepository extends JpaRepository<NilaiModel,Long> {

    
}
