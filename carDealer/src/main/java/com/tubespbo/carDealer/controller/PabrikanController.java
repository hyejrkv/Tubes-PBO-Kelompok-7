package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tubespbo.carDealer.services.PabrikanService;

import jakarta.servlet.http.HttpSession;

import com.tubespbo.carDealer.models.Pabrikan;
import com.tubespbo.carDealer.models.User;

@Controller
@RequestMapping("/pabrikan")
public class PabrikanController {

    @Autowired
    private PabrikanService pabrikanService;
    
    @GetMapping("")
    public String index(Model model, 
                       @RequestParam(required = false) String searchNama,
                       @RequestParam(required = false) String searchAlamat,
                       HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/access-denied";
        }        
        model.addAttribute("pabrikan", pabrikanService.getAllPabrikan());
        return "pabrikan/index";
    }
    
    @GetMapping("/create")
    public String create(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "SALES".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/pabrikan/accessDenied";
        }
        model.addAttribute("pabrikan", new Pabrikan());
        return "pabrikan/form";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute Pabrikan pabrikan, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "SALES".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/pabrikan/accessDenied";
        }
        pabrikanService.savePabrikan(pabrikan);
        return "redirect:/pabrikan";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "SALES".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/pabrikan/accessDenied";
        }
        model.addAttribute("pabrikan", pabrikanService.getPabrikanById(id).orElseThrow());
        return "pabrikan/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Pabrikan pabrikan, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "SALES".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/pabrikan/accessDenied";
        }
        pabrikanService.savePabrikan(pabrikan);
        return "redirect:/pabrikan";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id, HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "SALES".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/pabrikan/accessDenied";
        }

        try {
            pabrikanService.deletePabrikan(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/pabrikan?error=constraint"; 
        }
        return "redirect:/pabrikan";
    }

    @GetMapping("/accessDenied") 
    public String accessDenied(){
        return "redirect:/pabrikan";
    }
}