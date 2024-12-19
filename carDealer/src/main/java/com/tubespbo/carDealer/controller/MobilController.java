package com.tubespbo.carDealer.controller;

import com.tubespbo.carDealer.models.Mobil;
import com.tubespbo.carDealer.services.MobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobil")

public class MobilController {
    @Autowired
    private MobilService mobilService;

    @PostMapping
    public Mobil createMobil(@RequestBody Mobil mobil) {
        return mobilService.createMobil(mobil);
    }

    @GetMapping
    public List<Mobil> getAllMobil() {
        return mobilService.getAllMobil();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobil> getMobilById(@PathVariable int id) {
        Mobil mobil = mobilService.getMobilById(id)
                .orElseThrow(() -> new RuntimeException("Mobil not found"));
        return ResponseEntity.ok(mobil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mobil> updateMobil(@PathVariable int id, @RequestBody Mobil mobilDetails) {
        Mobil updatedMobil = mobilService.updateMobil(id, mobilDetails);
        return ResponseEntity.ok(updatedMobil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMobil(@PathVariable int id) {
        mobilService.deleteMobil(id);
        return ResponseEntity.ok("Mobil deleted successfully!");
    }
}
