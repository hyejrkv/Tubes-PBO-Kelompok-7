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
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMobil;
    private String noRangka;
    private String noMesin;
    private String platNomor;
    private int kapasitasMesin;
    private String jenis;
}
