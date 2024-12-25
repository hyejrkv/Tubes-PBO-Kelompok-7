package com.tubespbo.carDealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.Penjualan;
import com.tubespbo.carDealer.repositories.PenjualanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PenjualanService {

    @Autowired
    private PenjualanRepository penjualanRepository;

    // Get all Penjualan
    public List<Penjualan> getAllPenjualan() {
        return penjualanRepository.findAll();
    }

    // Get Penjualan by ID
    public Optional<Penjualan> getPenjualanById(int id) {
        return penjualanRepository.findById(id);
    }

    // Save Penjualan
    public Penjualan savePenjualan(Penjualan penjualan) {
        return penjualanRepository.save(penjualan);
    }

    // Update Penjualan
    public Penjualan updatePenjualan(int id, Penjualan penjualanDetails) {
        Penjualan penjualan = penjualanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penjualan not found"));

        penjualan.setMobil(penjualanDetails.getMobil());
        return penjualanRepository.save(penjualan);
    }

    // Delete Penjualan
    public void deletePenjualan(int id) {
        Penjualan penjualan = penjualanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penjualan not found"));
        penjualanRepository.delete(penjualan);
    }
}

