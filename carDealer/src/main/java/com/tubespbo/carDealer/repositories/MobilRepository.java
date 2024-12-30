package com.tubespbo.carDealer.repositories;

import com.tubespbo.carDealer.models.Mobil;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Integer> {
    List<Mobil> findByNamaContainingIgnoreCase(String nama);
    List<Mobil> findByPabrikanNamaContainingIgnoreCase(String namaPabrikan);
}
