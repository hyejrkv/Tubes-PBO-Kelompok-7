package com.tubespbo.carDealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.Pabrikan;
import com.tubespbo.carDealer.repositories.PabrikanRepository;
import com.tubespbo.carDealer.services.PabrikanService;
import java.util.List;
import java.util.Optional;

@Service
public class PabrikanService {

    @Autowired
    private PabrikanRepository pabrikanRepository;

    // Get all Pabrikan
    public List<Pabrikan> getAllPabrikan() {
        return pabrikanRepository.findAll();
    }

    // Get Pabrikan by ID
    public Optional<Pabrikan> getPabrikanById(int id) {
        return pabrikanRepository.findById(id);
    }

    // Save Pabrikan
    public Pabrikan savePabrikan(Pabrikan pabrikan) {
        return pabrikanRepository.save(pabrikan);
    }

    // Update Pabrikan
    public Pabrikan updatePabrikan(int id, Pabrikan pabrikanDetails) {
        Pabrikan pabrikan = pabrikanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pabrikan not found"));
        pabrikan.setNama(pabrikanDetails.getNama());
        pabrikan.setNoTelp(pabrikanDetails.getNoTelp());
        pabrikan.setAlamat(pabrikanDetails.getAlamat());
        return pabrikanRepository.save(pabrikan);
    }

    // Delete Pabrikan
    public void deletePabrikan(int id) {
        Pabrikan pabrikan = pabrikanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pabrikan not found"));
        pabrikanRepository.delete(pabrikan);
    }
}