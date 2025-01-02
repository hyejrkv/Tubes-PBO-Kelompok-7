package com.tubespbo.carDealer.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tubespbo.carDealer.models.Penjualan;
import com.tubespbo.carDealer.models.User;
import com.tubespbo.carDealer.services.MobilService;
import com.tubespbo.carDealer.services.PenjualanService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/penjualan")
public class PenjualanController {

    @Autowired
    private PenjualanService penjualanService;
    
    @Autowired
    private MobilService mobilService;
    
    @GetMapping("")
    public String index(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser ==null) {
            return "redirect:/access-denied";
        }
        model.addAttribute("penjualanList", penjualanService.getAllPenjualan());
        return "penjualan/index";
    }
    
    @GetMapping("/create")
    public String create(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        model.addAttribute("penjualan", new Penjualan());
        model.addAttribute("mobilList", mobilService.getAllMobil());
        return "penjualan/form";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute Penjualan penjualan, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        penjualanService.savePenjualan(penjualan);
        return "redirect:/penjualan";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        
        model.addAttribute("penjualan", penjualanService.getPenjualanById(id).orElseThrow());
        model.addAttribute("mobilList", mobilService.getAllMobil());
        return "penjualan/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Penjualan penjualan, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        Penjualan existingPenjualan = penjualanService.getPenjualanById(penjualan.getIdPenjualan()).orElseThrow();
        penjualan.setTanggalPenjualan(existingPenjualan.getTanggalPenjualan());
        penjualanService.savePenjualan(penjualan);
        return "redirect:/penjualan";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        try {
            penjualanService.deletePenjualan(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/penjualan?error=constraint"; 
        }
        
        return "redirect:/penjualan";
    }
    
    @GetMapping("/rekap")
    public String rekapForm(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        return "penjualan/rekap-form";
    }
    
    @PostMapping("/rekap")
    public String rekap(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime endDate,
            Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser !=null && "PETUGAS".equalsIgnoreCase(currentUser.getRole())) {
            return "redirect:/penjualan/accessDenied";
        }
        List<Penjualan> penjualanList = penjualanService.getPenjualanBetweenDates(startDate, endDate);
        double totalAmount = penjualanService.getTotalPenjualanAmount(startDate, endDate);
        long totalCount = penjualanService.getTotalPenjualanCount(startDate, endDate);
        
        model.addAttribute("penjualanList", penjualanList);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        
        return "penjualan/rekap-result";
    }

    @GetMapping("/accessDenied") 
    public String accessDenied(){
        return "redirect:/penjualan";
    }
}
