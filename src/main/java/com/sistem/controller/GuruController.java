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

import com.sistem.model.GuruModel;
import com.sistem.service.GuruService;

@Controller
@RequestMapping("/guru")
public class GuruController {
    
    @Autowired
    private GuruService guruService;

    @GetMapping
    public String getAllGuru(Model model){
        List<GuruModel> guru = guruService.getGuru();
        model.addAttribute("guru", guru);
        return "guru/index";
    }

    @GetMapping("/add-guru")
    public String addGuru(Model model){
        model.addAttribute("guru", new GuruModel());
        return "guru/add-guru";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute GuruModel guru){
        guruService.addGuru(guru);
        return "redirect:/guru";
    }

    @GetMapping("/edit/{id}")
    public String updateGuru(@PathVariable Long id, Model model){
        GuruModel guru = guruService.getGuruById(id)
            .orElseThrow(() -> new RuntimeException("Guru tidak ditemukan"));
            model.addAttribute(guru);
        return "guru/edit-guru";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        guruService.deleteGuru(id);
        return "redirect:/guru";
    }



}
