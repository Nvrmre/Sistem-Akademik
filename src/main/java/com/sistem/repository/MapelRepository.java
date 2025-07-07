package com.sistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistem.model.MapelModel;

@Repository
public interface MapelRepository extends JpaRepository <MapelModel,Long>{
    
}
