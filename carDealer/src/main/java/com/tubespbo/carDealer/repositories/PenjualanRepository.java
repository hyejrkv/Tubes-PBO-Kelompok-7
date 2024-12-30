package com.tubespbo.carDealer.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tubespbo.carDealer.models.Penjualan;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan, Integer> {
    List<Penjualan> findByTanggalPenjualanBetween(LocalDateTime startDate, LocalDateTime endDate);
}

