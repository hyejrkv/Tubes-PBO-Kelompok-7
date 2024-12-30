package com.tubespbo.carDealer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.Pabrikan;
import com.tubespbo.carDealer.repositories.PabrikanRepository;

@Service
public class PabrikanServiceImpl implements PabrikanService{
    
    @Autowired
    private PabrikanRepository pabrikanRepository;
    
    @Override
    public List<Pabrikan> getAllPabrikan() {
        return pabrikanRepository.findAll();
    }
    
    @Override
    public Optional<Pabrikan> getPabrikanById(int id) {
        return pabrikanRepository.findById(id);
    }
    
    @Override
    public void savePabrikan(Pabrikan pabrikan) {
        pabrikanRepository.save(pabrikan);
    }
    
    @Override
    public void deletePabrikan(int id) {
        pabrikanRepository.deleteById(id);
    }
}
