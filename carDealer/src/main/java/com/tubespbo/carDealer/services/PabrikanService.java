package com.tubespbo.carDealer.services;

import java.util.List;
import java.util.Optional;

import com.tubespbo.carDealer.models.Pabrikan;

public interface PabrikanService {
    List<Pabrikan> getAllPabrikan();
    Optional<Pabrikan> getPabrikanById(int id);
    void savePabrikan(Pabrikan pabrikan);
    void deletePabrikan(int id);
}
