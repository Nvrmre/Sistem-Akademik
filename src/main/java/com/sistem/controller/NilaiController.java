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

import com.sistem.model.NilaiModel;
import com.sistem.service.KelasService;
import com.sistem.service.NilaiService;
import com.sistem.service.SiswaService;

@Controller
@RequestMapping("/nilai")
public class NilaiController {

    @Autowired
    private NilaiService nilaiService;

    // @Autowired
    // private GuruService guruService;

    @Autowired
    private SiswaService siswaService;

    @Autowired
    private KelasService kelasService;

    @GetMapping
    public String getNilai(Model model){
        List<NilaiModel> nilai = nilaiService.getAllNilai();
        model.addAttribute("nilai", nilai);
        return "nilai/index";
    }

    @GetMapping("/add-nilai")
    public String showForm(Model model){
        model.addAttribute("nilai", new NilaiModel());
        model.addAttribute("siswa", siswaService.getAllSiswa());
        model.addAttribute("kelas", kelasService.getAllKelas());
        return "nilai/add-nilai";
    }

    @PostMapping("/simpan")
    public String simpanNilai(@ModelAttribute NilaiModel nilai){
        nilaiService.addNilai(nilai);
        return "redirect:/nilai";
    }
  
    @GetMapping("/edit/{id}")
    public String editNilai(@PathVariable Long id, Model model){
        NilaiModel nilai = nilaiService.getNilaiById(id)
            .orElseThrow(() -> new RuntimeException("Nilai belum diinput"));
            model.addAttribute("nilai", nilai);
            model.addAttribute("kelas", kelasService.getAllKelas());
            model.addAttribute("siswa", siswaService.getAllSiswa());
            return "nilai/edit-nilai";
    }



}
