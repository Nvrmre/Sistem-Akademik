package com.sistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.model.GuruModel;
import com.sistem.repository.GuruRepository;

@Service
public class GuruService {

    @Autowired
    private GuruRepository guruRepository;

    public List<GuruModel> getGuru(){
        return guruRepository.findAll();
    }
    
    public Optional <GuruModel> getGuruById(Long id){
        return guruRepository.findById(id);
    }


    public GuruModel addGuru(GuruModel guru){
        return guruRepository.save(guru);
    }

    public GuruModel deleteGuru(Long id){
        GuruModel guru = guruRepository.findById(id).orElse(null);
        if(guru != null){
            guruRepository.deleteById(id);
        }
        return guru;
    }

    public GuruModel updatGuru(GuruModel guru){
        return guruRepository.save(guru);
    }
}
