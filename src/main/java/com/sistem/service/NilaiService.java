package com.sistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistem.model.NilaiModel;
import com.sistem.repository.NilaiRepository;

@Service
public class NilaiService {

    @Autowired
    private NilaiRepository nilaiRepository;

    public List <NilaiModel> getAllNilai(){
        return nilaiRepository.findAll();
    }

    public Optional<NilaiModel> getNilaiById(Long id){
      return nilaiRepository.findById(id);
    }

    public NilaiModel delete(Long id){
        NilaiModel nilai = nilaiRepository.findById(id).orElse(null);
        if (nilai != null) {
            nilaiRepository.delete(nilai);
        }return nilai;
    }

    public NilaiModel addNilai(NilaiModel nilai){
     return nilaiRepository.save(nilai);
    }

   public NilaiModel update(NilaiModel nilai){
    return nilaiRepository.save(nilai);
   }

}
