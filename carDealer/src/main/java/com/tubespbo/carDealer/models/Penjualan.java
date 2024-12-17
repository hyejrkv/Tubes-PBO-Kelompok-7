/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import java.time.LocalDateTime;
/**
 *
 * @author Icha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Penjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPenjualan;
    @CreationTimestamp
    private LocalDateTime tanggalPenjualan;
    private int harga;
    private int jumlah;
    
    
}
