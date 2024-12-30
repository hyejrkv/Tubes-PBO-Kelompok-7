/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;

import jakarta.persistence.*;

@Entity
@Table(name="mobil")
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMobil;
    
    private String nama;
    private String noRangka;
    private String noMesin;
    private String platNomor;
    private int kapasitasMesin;
    private String jenis;
    private Double harga;
    
    @ManyToOne
    @JoinColumn(name = "idPabrikan")
    private Pabrikan pabrikan;

    public Mobil(){

    }
    
    public Mobil(int idMobil, String nama, String noRangka, String noMesin, String platNomor, int kapasitasMesin,
            String jenis, Double harga, Pabrikan pabrikan) {
        this.idMobil = idMobil;
        this.nama = nama;
        this.noRangka = noRangka;
        this.noMesin = noMesin;
        this.platNomor = platNomor;
        this.kapasitasMesin = kapasitasMesin;
        this.jenis = jenis;
        this.harga = harga;
        this.pabrikan = pabrikan;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoRangka() {
        return noRangka;
    }

    public void setNoRangka(String noRangka) {
        this.noRangka = noRangka;
    }

    public String getNoMesin() {
        return noMesin;
    }

    public void setNoMesin(String noMesin) {
        this.noMesin = noMesin;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public int getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(int kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Pabrikan getPabrikan() {
        return pabrikan;
    }

    public void setPabrikan(Pabrikan pabrikan) {
        this.pabrikan = pabrikan;
    }

    
}
