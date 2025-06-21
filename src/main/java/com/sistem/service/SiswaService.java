package com.sistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.sistem.model.SiswaModel;
import com.sistem.repository.SiswaRepository;

@Service
public class SiswaService {
    
    @Autowired
    private SiswaRepository siswaRepository;


    public List<SiswaModel> getAllSiswa(){
        return siswaRepository.findAll();
    }

     public Optional <SiswaModel> getSiswaById(Long id){
        return siswaRepository.findById(id);
    }

    public SiswaModel deleteSiswa(Long id){
        SiswaModel siswa = siswaRepository.findById(id).orElse(null);
        if (siswa != null){
            siswaRepository.deleteById(id);
        }
        return siswa;
    }

    public SiswaModel addSiswa(SiswaModel siswa){
        return siswaRepository.save(siswa);
    }

  

    public SiswaModel update(SiswaModel siswa){
        return siswaRepository.save(siswa);
    }
}
