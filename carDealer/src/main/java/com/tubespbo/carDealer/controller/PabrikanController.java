package com.tubespbo.carDealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tubespbo.carDealer.models.Pabrikan;
import com.tubespbo.carDealer.services.PabrikanService;

import java.util.List;

@RestController
@RequestMapping("/api/pabrikan")
public class PabrikanController {

    @Autowired
    private PabrikanService pabrikanService;

    // Get all Pabrikan
    @GetMapping
    public List<Pabrikan> getAllPabrikan() {
        return pabrikanService.getAllPabrikan();
    }

    // Get Pabrikan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pabrikan> getPabrikanById(@PathVariable int id) {
        return pabrikanService.getPabrikanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new Pabrikan
    @PostMapping
    public Pabrikan createPabrikan(@RequestBody Pabrikan pabrikan) {
        return pabrikanService.savePabrikan(pabrikan);
    }

    // Update Pabrikan
    @PutMapping("/{id}")
    public ResponseEntity<Pabrikan> updatePabrikan(@PathVariable int id, @RequestBody Pabrikan pabrikanDetails) {
        try {
            Pabrikan updatedPabrikan = pabrikanService.updatePabrikan(id, pabrikanDetails);
            return ResponseEntity.ok(updatedPabrikan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Pabrikan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePabrikan(@PathVariable int id) {
        try {
            pabrikanService.deletePabrikan(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

