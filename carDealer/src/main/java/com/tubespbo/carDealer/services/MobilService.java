package com.tubespbo.carDealer.services;

import java.util.List;
import java.util.Optional;

import com.tubespbo.carDealer.models.Mobil;


public interface MobilService {
    List<Mobil> getAllMobil();
    Optional<Mobil> getMobilById(int id);
    void saveMobil(Mobil mobil);
    void deleteMobil(int id);
    List<Mobil> searchMobilByNama(String nama);
    List<Mobil> searchMobilByPabrikan(String namaPabrikan);
}
