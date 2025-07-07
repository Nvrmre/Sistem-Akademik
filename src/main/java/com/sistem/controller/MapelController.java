package com.sistem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sistem.model.MapelModel;
import com.sistem.service.MapelService;

@Controller
@RequestMapping("/mapel")
public class MapelController {
    @Autowired
    private MapelService mapelService;

    @GetMapping
    public String showAll(Model model){
        List<MapelModel> mapel = mapelService.getMapelAll();
        model.addAttribute("mapel", mapel);
        return "mapel/index";

    }

    @GetMapping("/add-mapel")
    public String showForm(Model model){
        model.addAttribute("mapel", new MapelModel());
        return "mapel/add-mapel";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute MapelModel mapel){
      mapelService.addMapel(mapel);
      return "redirect:/mapel";
    }

    @GetMapping("/delete")
    public String hapusMapel(@PathVariable Long id){
        mapelService.deleteMapel(id);
        return "redirect:/mapel";
    }
}
