/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;

/**
 *
 * @author Icha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pabrikan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPabrikan;
    private String nama;
    private String noTelp;
    private String alamat;
    
    
}
