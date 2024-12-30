package com.tubespbo.carDealer.models;

import jakarta.persistence.*;

@Entity 
@Table(name="pabrikan")
public class Pabrikan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPabrikan;

    private String nama;
    private String noTelp;
    private String alamat;

    public Pabrikan() {
    }
    
    public Pabrikan(int idPabrikan, String nama, String noTelp, String alamat) {
        this.idPabrikan = idPabrikan;
        this.nama = nama;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public int getIdPabrikan() {
        return idPabrikan;
    }
    public void setIdPabrikan(int idPabrikan) {
        this.idPabrikan = idPabrikan;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

