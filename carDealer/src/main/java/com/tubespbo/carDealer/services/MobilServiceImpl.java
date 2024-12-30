package com.tubespbo.carDealer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.Mobil;
import com.tubespbo.carDealer.repositories.MobilRepository;

@Service
public class MobilServiceImpl implements MobilService {
    
    @Autowired
    private MobilRepository mobilRepository;
    
    @Override
    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }
    
    @Override
    public Optional<Mobil> getMobilById(int id) {
        return mobilRepository.findById(id);
    }
    
    @Override
    public void saveMobil(Mobil mobil) {
        mobilRepository.save(mobil);
    }
    
    @Override
    public void deleteMobil(int id) {
        mobilRepository.deleteById(id);
    }
    
    @Override
    public List<Mobil> searchMobilByNama(String nama) {
        return mobilRepository.findByNamaContainingIgnoreCase(nama);
    }
    
    @Override
    public List<Mobil> searchMobilByPabrikan(String namaPabrikan) {
        return mobilRepository.findByPabrikanNamaContainingIgnoreCase(namaPabrikan);
    }
}
