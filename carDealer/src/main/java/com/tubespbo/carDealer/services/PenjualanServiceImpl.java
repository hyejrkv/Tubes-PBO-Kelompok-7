package com.tubespbo.carDealer.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tubespbo.carDealer.models.Penjualan;
import com.tubespbo.carDealer.repositories.PenjualanRepository;

@Service
public class PenjualanServiceImpl implements PenjualanService {
    
    @Autowired
    private PenjualanRepository penjualanRepository;
    
    @Override
    public List<Penjualan> getAllPenjualan() {
        return penjualanRepository.findAll();
    }
    
    @Override
    public Optional<Penjualan> getPenjualanById(int id) {
        return penjualanRepository.findById(id);
    }
    
    @Override
    public void savePenjualan(Penjualan penjualan) {
        penjualanRepository.save(penjualan);
    }
    
    @Override
    public void deletePenjualan(int id) {
        penjualanRepository.deleteById(id);
    }
    
    @Override
    public List<Penjualan> getPenjualanBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return penjualanRepository.findByTanggalPenjualanBetween(startDate, endDate);
    }
    
    @Override
    public double getTotalPenjualanAmount(LocalDateTime startDate, LocalDateTime endDate) {
        List<Penjualan> penjualanList = getPenjualanBetweenDates(startDate, endDate);
        return penjualanList.stream()
                .mapToDouble(p -> p.getMobil().getHarga())
                .sum();
    }
    
    @Override
    public long getTotalPenjualanCount(LocalDateTime startDate, LocalDateTime endDate) {
        return getPenjualanBetweenDates(startDate, endDate).size();
    }
}
