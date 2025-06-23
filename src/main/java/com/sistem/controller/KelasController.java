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

import com.sistem.model.KelasModel;
import com.sistem.service.KelasService;

@Controller
@RequestMapping("/kelas")
public class KelasController {
   
    @Autowired
    private KelasService kelasService;

   @GetMapping
   public String getKelasList(Model model){
        List<KelasModel> kelas = kelasService.getAllKelas();
        model.addAttribute("kelas", kelas);
        return "kelas/index";
   }

   @GetMapping("/add-kelas")
   public String showForm(Model model){
        model.addAttribute("kelas",new KelasModel());
        return "kelas/add-kelas";
   }

   @PostMapping("/simpan")
   public String simpan(@ModelAttribute KelasModel kelas){
        kelasService.addKelas(kelas);
        return "redirect:/kelas";
   }

   @GetMapping("/edit/{id}")
   public String editKelas(@PathVariable Long id, Model model){
        KelasModel kelas = kelasService.getKelasByID(id)
            .orElseThrow(() -> new RuntimeException("Kelas tidak ditemukan"));
            model.addAttribute(kelas);
        return "kelas/edit-kelas";
   }

   @GetMapping("/delete/{id}")
   public String deleteKelas(@PathVariable Long id){
        kelasService.deleteKelas(id);
        return "redirect:/kelas";
   }






}
