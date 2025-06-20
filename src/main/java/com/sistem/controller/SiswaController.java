package com.sistem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistem.model.SiswaModel;
import com.sistem.service.SiswaService;

@Controller
@RequestMapping("/siswa")
public class SiswaController {

    @Autowired
    private SiswaService siswaService;
    
    @GetMapping
    public String ListSiswa(Model model){
        List<SiswaModel> listSiswa = siswaService.getAllSiswa();
        model.addAttribute("siswa", listSiswa);
        return "siswa/index";
    }


    @GetMapping("/add-siswa")
    public String addSiswa(Model model){
        model.addAttribute("siswa",new SiswaModel());
        return "siswa/add-siswa";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute SiswaModel siswa){
        siswaService.addSiswa(siswa);
        return "redirect:/siswa";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        siswaService.deleteSiswa(id);
        return "redirect:/siswa";
    }

    @GetMapping("/edit-siswa/{id}")
     public String showFormEdit(@PathVariable Long id, Model model){
        SiswaModel siswa = siswaService.getSiswaById(id)
            .orElseThrow(() -> new RuntimeException("siswa tidak ditemukan"));
        model.addAttribute("siswa", siswa);
        return "siswa/edit-siswa";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SiswaModel siswa){
        siswaService.update(siswa);
        return "redirect:/siswa";
    }

   
}
