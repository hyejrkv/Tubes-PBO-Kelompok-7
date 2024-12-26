/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tubespbo.carDealer.models;
/**
 *
 * @author Icha
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Strategi Single Table
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING) // Kolom untuk tipe user
public class User implements Loginable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String username;
    private String password;
    private String nama;
    private String noTelp;

    @Override
    public boolean login(String username, String password) {
        // Logika untuk memverifikasi username dan password
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void logout() {
        // Logika untuk logout, misalnya menghapus sesi pengguna
        System.out.println("User  " + username + " has logged out.");
    }
}
