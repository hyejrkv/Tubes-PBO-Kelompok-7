package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tubespbo.carDealer.models.Penjualan;
import com.tubespbo.carDealer.services.PenjualanService;

import java.util.List;

@RestController
@RequestMapping("/api/penjualan")
public class PenjualanController {

    @Autowired
    private PenjualanService penjualanService;

    // Get all Penjualan
    @GetMapping
    public List<Penjualan> getAllPenjualan() {
        return penjualanService.getAllPenjualan();
    }

    // Get Penjualan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Penjualan> getPenjualanById(@PathVariable int id) {
        return penjualanService.getPenjualanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new Penjualan
    @PostMapping
    public Penjualan createPenjualan(@RequestBody Penjualan penjualan) {
        return penjualanService.savePenjualan(penjualan);
    }

    // Update Penjualan
    @PutMapping("/{id}")
    public ResponseEntity<Penjualan> updatePenjualan(@PathVariable int id, @RequestBody Penjualan penjualanDetails) {
        try {
            Penjualan updatedPenjualan = penjualanService.updatePenjualan(id, penjualanDetails);
            return ResponseEntity.ok(updatedPenjualan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Penjualan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePenjualan(@PathVariable int id) {
        try {
            penjualanService.deletePenjualan(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
