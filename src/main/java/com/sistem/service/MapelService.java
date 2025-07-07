package com.sistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.model.MapelModel;
import com.sistem.repository.MapelRepository;

@Service
public class MapelService {
    
    @Autowired
    private MapelRepository mapelRepository;

    public List<MapelModel> getMapelAll(){
        return mapelRepository.findAll();
    }

    public Optional<MapelModel> getMapelById(Long id){
        return mapelRepository.findById(id);
    }

    public MapelModel deleteMapel(Long id){
        MapelModel mapel = mapelRepository.findById(id).orElse(null);

        if (mapel != null){
            mapelRepository.deleteById(id);
        }

        return mapel;
    }

    public MapelModel addMapel(MapelModel mapel){
        return mapelRepository.save(mapel);
    }

    public MapelModel update(MapelModel mapel){
        return mapelRepository.save(mapel);
    }


}
