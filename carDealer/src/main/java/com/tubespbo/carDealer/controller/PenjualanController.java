package com.tubespbo.carDealer.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tubespbo.carDealer.models.Penjualan;
import com.tubespbo.carDealer.services.MobilService;
import com.tubespbo.carDealer.services.PenjualanService;

@Controller
@RequestMapping("/penjualan")
public class PenjualanController {

    @Autowired
    private PenjualanService penjualanService;
    
    @Autowired
    private MobilService mobilService;
    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("penjualanList", penjualanService.getAllPenjualan());
        return "penjualan/index";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("penjualan", new Penjualan());
        model.addAttribute("mobilList", mobilService.getAllMobil());
        return "penjualan/form";
    }
    
    @PostMapping("/store")
    public String store(@ModelAttribute Penjualan penjualan) {
        penjualanService.savePenjualan(penjualan);
        return "redirect:/penjualan";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("penjualan", penjualanService.getPenjualanById(id).orElseThrow());
        model.addAttribute("mobilList", mobilService.getAllMobil());
        return "penjualan/form";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Penjualan penjualan) {
        penjualanService.savePenjualan(penjualan);
        return "redirect:/penjualan";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        penjualanService.deletePenjualan(id);
        return "redirect:/penjualan";
    }
    
    @GetMapping("/rekap")
    public String rekapForm() {
        return "penjualan/rekap-form";
    }
    
    @PostMapping("/rekap")
    public String rekap(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime endDate,
            Model model) {
        
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
}
