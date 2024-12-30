package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tubespbo.carDealer.services.PabrikanService;
import com.tubespbo.carDealer.models.Pabrikan;

@Controller
@RequestMapping("/pabrikan")
public class PabrikanController {

    @Autowired
    private PabrikanService pabrikanService;
    
    @GetMapping("")
    public String index(Model model, 
                       @RequestParam(required = false) String searchNama,
                       @RequestParam(required = false) String searchAlamat) {
        model.addAttribute("pabrikan", pabrikanService.getAllPabrikan());
        return "pabrikan/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pabrikan", new Pabrikan());
        return "pabrikan/form";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute Pabrikan pabrikan) {
        pabrikanService.savePabrikan(pabrikan);
        return "redirect:/pabrikan";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("pabrikan", pabrikanService.getPabrikanById(id).orElseThrow());
        return "pabrikan/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Pabrikan pabrikan) {
        pabrikanService.savePabrikan(pabrikan);
        return "redirect:/pabrikan";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        pabrikanService.deletePabrikan(id);
        return "redirect:/pabrikan";
    }
}