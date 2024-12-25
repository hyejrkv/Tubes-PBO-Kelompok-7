package com.tubespbo.carDealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tubespbo.carDealer.models.Penjualan;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan, Integer> {
}

