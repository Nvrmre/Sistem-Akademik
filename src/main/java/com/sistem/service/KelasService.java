package com.sistem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistem.model.KelasModel;
import com.sistem.repository.KelasRepository;

@Service
public class KelasService {
    

    @Autowired
    private KelasRepository kelasRepository;


    public List<KelasModel> getAllKelas(){
        return kelasRepository.findAll();
    }


    public Optional<KelasModel> getKelasByID(Long id){
        return kelasRepository.findById(id);
    }

    public KelasModel deleteKelas(Long id){
        KelasModel kelas = kelasRepository.findById(id).orElse(null);
        if (kelas != null) {
            kelasRepository.deleteById(id);;
        }
        return kelas;
    }

    public KelasModel addKelas(KelasModel kelas){
        return kelasRepository.save(kelas);
    }

    public KelasModel updateKelas(KelasModel kelas){
        return kelasRepository.save(kelas);
    }

}
