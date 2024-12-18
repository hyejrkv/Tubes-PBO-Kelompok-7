package com.tubespbo.carDealer.services;

import com.tubespbo.carDealer.models.Mobil;
import com.tubespbo.carDealer.repositories.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobilService {
    @Autowired
    private MobilRepository mobilRepository;

    
    public Mobil createMobil(Mobil mobil) {
        return mobilRepository.save(mobil);
    }

    
    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

    
    public Optional<Mobil> getMobilById(int id) {
        return mobilRepository.findById(id);
    }

    
    public Mobil updateMobil(int id, Mobil mobilDetails) {
        Mobil mobil = mobilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobil not found"));

        mobil.setNoRangka(mobilDetails.getNoRangka());
        mobil.setNoMesin(mobilDetails.getNoMesin());
        mobil.setPlatNomor(mobilDetails.getPlatNomor());
        mobil.setKapasitasMesin(mobilDetails.getKapasitasMesin());
        mobil.setJenis(mobilDetails.getJenis());

        return mobilRepository.save(mobil);
    }

    
    public void deleteMobil(int id) {
        Mobil mobil = mobilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobil not found"));
        mobilRepository.delete(mobil);
    }

}
