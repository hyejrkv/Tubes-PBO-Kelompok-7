package com.tubespbo.carDealer.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.tubespbo.carDealer.models.Penjualan;

public interface PenjualanService {
    List<Penjualan> getAllPenjualan();
    Optional<Penjualan> getPenjualanById(int id);
    void savePenjualan(Penjualan penjualan);
    void deletePenjualan(int id);
    List<Penjualan> getPenjualanBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    double getTotalPenjualanAmount(LocalDateTime startDate, LocalDateTime endDate);
    long getTotalPenjualanCount(LocalDateTime startDate, LocalDateTime endDate);
}