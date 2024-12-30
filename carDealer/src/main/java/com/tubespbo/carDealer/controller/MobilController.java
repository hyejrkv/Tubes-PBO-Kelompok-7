package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tubespbo.carDealer.services.MobilService;
import com.tubespbo.carDealer.services.PabrikanService;
import com.tubespbo.carDealer.models.Mobil;

@Controller
@RequestMapping("/mobil")
public class MobilController {

    @Autowired
    private MobilService mobilService;
    
    @Autowired
    private PabrikanService pabrikanService;
    
    @GetMapping("")
    public String index(Model model, 
                       @RequestParam(required = false) String searchM,
                       @RequestParam(required = false) String searchP) {
        if (searchM != null && !searchM.isEmpty()) {
            model.addAttribute("mobil", mobilService.searchMobilByNama(searchM));
        } else if (searchP != null && !searchP.isEmpty()) {
            model.addAttribute("mobil", mobilService.searchMobilByPabrikan(searchP));
        } else if (searchP == null || searchM.isEmpty()){
            model.addAttribute("mobil", mobilService.getAllMobil());
        } else {
            model.addAttribute("mobil", mobilService.getAllMobil());
        }
        return "mobil/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("mobil", new Mobil());
        model.addAttribute("pabrikans", pabrikanService.getAllPabrikan());
        return "mobil/form";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute Mobil mobil) {
        mobilService.saveMobil(mobil);
        return "redirect:/mobil";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("mobil", mobilService.getMobilById(id).orElseThrow());
        model.addAttribute("pabrikans", pabrikanService.getAllPabrikan());
        return "mobil/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Mobil mobil) {
        mobilService.saveMobil(mobil);
        return "redirect:/mobil";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        mobilService.deleteMobil(id);
        return "redirect:/mobil";
    }
}

