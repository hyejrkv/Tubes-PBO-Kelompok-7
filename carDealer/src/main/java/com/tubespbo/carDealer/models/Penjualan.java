package com.tubespbo.carDealer.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="penjualan")
public class Penjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPenjualan;

    @CreationTimestamp
    private LocalDateTime tanggalPenjualan;

    @ManyToOne
    @JoinColumn(name = "id_mobil", nullable = false)
    private Mobil mobil;
    
    public Penjualan() {
    }
    
    public Penjualan(int idPenjualan, LocalDateTime tanggalPenjualan, Mobil mobil) {
        this.idPenjualan = idPenjualan;
        this.tanggalPenjualan = tanggalPenjualan;
        this.mobil = mobil;
    }

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public LocalDateTime getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(LocalDateTime tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    
}
