/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Icha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "")
public class Penjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPenjualan;
    private LocalDateTime tanggalPenjualan;
    private int harga;
    private int jumlah;
    
    
}
